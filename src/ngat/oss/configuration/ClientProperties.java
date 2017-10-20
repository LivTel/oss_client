package ngat.oss.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * USES THE /client.properties IN THE JAR OF THIS CLASS
 * @author nrc
 *
 */
public class ClientProperties extends Properties{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8160086401741970778L;

	private static Logger logger = Logger.getLogger(ClientProperties.class);
	
	private static final String PROPERTIES_FILE_PATH 						= "/client.properties";
	
	public static final String SOAP_WEBAPPNAME 							= "soap.webappname";
	public static final String SOAP_PORT 											= "soap.port";
	public static final String SOAP_HOSTNAME 									= "soap.hostname";
	
	public static final String PHASE2_SOAP_SERVICENAME				= "phase2.soap.servicename";
	public static final String ACCESS_SOAP_SERVICENAME				= "accessmodel.soap.servicename";
	public static final String GATEKEEPER_SOAP_SERVICENAME	= "gatekeeper.soap.servicename";
	
	public static final String TRUE 														= new Boolean(true).toString();
	public static final String FALSE 													= new Boolean(false).toString();
	
	public static ClientProperties instance;
	
	public static ClientProperties getInstance() {
		if (instance == null) {
			try {
				instance = new ClientProperties();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("IOException in loading " + PROPERTIES_FILE_PATH + " no properties loaded!!!");
			}
		}
		return instance;
	}
	
	private ClientProperties() throws IOException {
		super(getPropertiesFromFile(PROPERTIES_FILE_PATH));
	}
	
	private static Properties getPropertiesFromFile(String sfp) throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = ClientProperties.class.getResourceAsStream(PROPERTIES_FILE_PATH);
		if (inputStream == null) {
			throw new IOException("InputStream for " + PROPERTIES_FILE_PATH + " was null");
		} 
		properties.load(inputStream);
		logger.info("using properties: " + properties);
		return properties;
	}
	
	public void debugShowProperties() {
		Enumeration keysE = defaults.keys();
		String s = this.getClass().getName() +"[";
		
		while (keysE.hasMoreElements()) {
			Object key = keysE.nextElement();
			Object value = defaults.get(key);
			s = key + ":" + value;
		}
		s += "]";
		System.out.println(s);
	}
}
