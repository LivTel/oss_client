package ngat.oss.client;

import ngat.jibxsoap.NullTypeParameter;
import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.oss.client.transport.PingableModelClient;
import ngat.oss.client.transport.RequestPusher;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.reference.Const;
import ngat.phase2.IPublishedSystemProperties;

import org.apache.log4j.Logger;

public class StatusModelClient implements PingableModelClient { // , IPhase2Model {  //uncomment to get method list

	static Logger logger = Logger.getLogger(StatusModelClient.class);
	
	private static StatusModelClient instance;
	
	public static StatusModelClient getInstance() {
		if (instance == null) {
			instance = new StatusModelClient();
		}
		return instance;
	}
	
	private StatusModelClient() {}
	
	public void ping() throws Phase2Exception{
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.STATUS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	
	public IPublishedSystemProperties getPublishedSystemProperties() throws Phase2Exception {
		logger.info("invoking getPublishedSystemProperties()");
		
		Request request = new Request();
		request.setMethodName("getPublishedSystemProperties");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.STATUS_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IPublishedSystemProperties)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public String getURLOfService() throws Exception {
		try {
			return RequestPusher.getInstance().getURLOfService(Const.PHASE2_MODEL_SERVICE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new Phase2Exception(e);
		}
	}
	
}
