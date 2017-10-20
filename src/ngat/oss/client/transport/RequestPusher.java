package ngat.oss.client.transport;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.jibxsoap.StringTypeParameter;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.reference.Const;

import org.apache.log4j.Logger;
import org.jibx.runtime.JiBXException;
import org.jibx.soap.SOAPException;
import org.jibx.soap.client.SOAPClient;

public class RequestPusher {
	
	static Logger logger = Logger.getLogger(RequestPusher.class);
	
	private static RequestPusher instance;
	
	public static RequestPusher getInstance() {
		if (instance == null) {
			instance = new RequestPusher();
		}
		return instance;
	}
	
	private RequestPusher() {}
	
	public String getURLOfService(String serviceName) throws JiBXException {
		return SOAPClientPool.getInstance().getURLStringOfService(serviceName);
	}
	
	public Response pushRequest(Request request, String serviceName) throws Phase2Exception {
		
		String requestString = hideSecureDetailsForLogging(request);
		logger.info("pushRequest(" + requestString +"," + serviceName + ")");
		
		Response response = null;
		try {
			SOAPClient soapClient = SOAPClientPool.getInstance().getSOAPClient(serviceName);
			
			if (soapClient == null) {
				throw new Phase2Exception("SOAPClient was null");
			}
			
			//invoke the request
			Object responseObject = soapClient.call(request);
			response = (Response)responseObject;
			
			//garbage collect
			soapClient=null;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Phase2Exception(e);
		} catch (SOAPException e) {
			e.printStackTrace();
			throw new Phase2Exception(e);
		} catch (JiBXException e) {
			e.printStackTrace();
			throw new Phase2Exception(e);
		} 
		
		if (response.isError()) {
			throw new Phase2Exception("Received error response from server: " + response.getErrorMessage());
		}
		
		return response;
	}
	

	/**
	 * 
	 * @param request
	 * @return
	 */
	private String hideSecureDetailsForLogging(Request request) {
		
		String rtnStr = "";
		if (request.getMethodName().equals("authenticate")) {
			rtnStr = "ngat.jibxsoap.Request[authenticate, ";
			Iterator i = request.getRequestParameters().iterator();
			if (i == null) {
				return null;
			}
			Object userNameObject = i.next();
			rtnStr += userNameObject + ",";
			//Object passwordObject = i.next(); // << password would be this
			rtnStr += "," + "ngat.jibxsoap.StringTypeParameter[stringReqParam=USER_PASSWORD]";	
		} else {
			rtnStr = request.toString();
		}
		
		return rtnStr;
	}
	
	/**
	 * Tests invocations and responses from 
	 * AccessRequestHandler.handleRequest(Request request)
	 * on the web server
	 * @param args
	 */
	public static void main(String args[]) {
		
		try {
			Request request = new Request();
			request.setMethodName("testing");
			request.addRequestParameter(new StringTypeParameter("this is a param"));
			request.addRequestParameter(new StringTypeParameter("this is also a param"));
			
			Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
			if (!response.isError()) {
				List responseParameters = response.getResponseParameters();
				if (responseParameters != null) {
					Object parameter = responseParameters.get(0);
					if (parameter != null) {
						logger.info(parameter);
					}
				}
			} else {
				throw new Phase2Exception(response.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
