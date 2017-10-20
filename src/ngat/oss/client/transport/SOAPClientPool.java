package ngat.oss.client.transport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

import ngat.jibxsoap.Request;
import ngat.oss.configuration.ClientProperties;

import org.apache.log4j.Logger;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.JiBXException;
import org.jibx.soap.client.SOAPClient;

/**
 * The purpose of this class is to hold references to SOAPClient objects
 * that are used frequently. If a SOAPClient has not been used for a period of <LIFE_SPAN> mS
 * then a new instance of the  SOAPClient object is created and this is used to invoke the
 * SOAP service.
 * @author nrc
 */
public class SOAPClientPool {

	static Logger logger = Logger.getLogger(SOAPClientPool.class);
	
	private static final int LIFE_SPAN = 60000;
	private static SOAPClientPool instance;
	
	private HashMap mapStorage = new HashMap();
	private HashMap mapFingerTime = new HashMap();
	
	private String soapWebAppName, soapPort, soapHostName;
	private IBindingFactory bindingFactory;
	
	private SOAPClientPool() throws JiBXException {
		
		bindingFactory = BindingDirectory.getFactory(Request.class);
		
		ClientProperties properties = ClientProperties.getInstance();

		soapWebAppName 	= properties.getProperty(ClientProperties.SOAP_WEBAPPNAME);
		soapPort 					= properties.getProperty(ClientProperties.SOAP_PORT);
		soapHostName 			= properties.getProperty(ClientProperties.SOAP_HOSTNAME);
		
		logger.info("Instantiating new SOAPClientPool() [webappname=" +soapWebAppName + ", port=" + soapPort + ", hostname=" + soapHostName + "]");
	}
	
	public static SOAPClientPool getInstance() throws JiBXException {
		if (instance == null) {
			instance = new SOAPClientPool();
		}
		return instance;
	}
	
	public String getURLStringOfService(String serviceName) {
		return "http://" + soapHostName + ":" + soapPort +"/" + soapWebAppName + "/" +serviceName;
	}
	
	public SOAPClient getSOAPClient(String serviceName) throws MalformedURLException, JiBXException {
		logger.info("getSOAPClient(" +serviceName + ")" );
		
		//look up the SOAPClient from the mapNameClient HashMap
		long timeNow = new Date().getTime();
		SOAPClient soapClient = (SOAPClient)mapStorage.get(serviceName);
		
		if (soapClient == null) {
			logger.info("... soapClient==null");
			//SOAPClient not found in the map
			//it may be the first invocation
			//instantiate the required SOAPClient
			//update the HashMaps and return it
			soapClient = createSoapClient(serviceName, timeNow);
			logger.info("... returning new reference");
			return soapClient;
		} else {
			//SOAPClient found
			//check the last usage time of the client, if it's older than LIFE_SPAN
			//dump it and instantiate a new one, otherwise return it
			Long lastFingerTime = getLastFingerTime(serviceName);
			if (lastFingerTime != null) {
				if (lastFingerTime.longValue() < (timeNow - LIFE_SPAN) ) {
					//reference is too old, create and return a new one
					logger.info("... reference is too old, creating new one");
					soapClient = createSoapClient(serviceName, timeNow);
					logger.info("... returning new reference");
					return soapClient;
				} else {
					//reference is still valid, update the finger-time and return the reference
					finger(serviceName, timeNow);
					return (SOAPClient)mapStorage.get(serviceName);
				}
			} 
		}
		return null;
	}
	
	private void finger(String soapClientName, long fingerTime) {
		mapFingerTime.put(soapClientName, new Long(fingerTime));
	}
	
	private Long getLastFingerTime(String soapClientName) {
		return (Long)mapFingerTime.get(soapClientName);
	}
	
	private SOAPClient createSoapClient (String serviceName, long timeNow) throws MalformedURLException, JiBXException {
		logger.info("... createSoapClient(" +serviceName + "," + timeNow +")");
		
		//bind to SOAP service client
		URL serviceURL = new URL(getURLStringOfService(serviceName));
		logger.info("... connecting to service at " + serviceURL);
		SOAPClient soapClient = new SOAPClient(serviceURL, bindingFactory);
		logger.info("... connected, instantiated new " + SOAPClient.class.getName() + " for service: " + serviceName);
		
		//store the new service in a map so it can be found using only it's name 
		mapStorage.put(serviceName, soapClient);
		finger(serviceName, timeNow);
		return soapClient;
	}
}
