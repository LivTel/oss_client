package ngat.oss.client;

import java.util.List;

import ngat.jibxsoap.LongTypeParameter;
import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.oss.client.transport.PingableModelClient;
import ngat.oss.client.transport.RequestPusher;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.reference.Const;

import org.apache.log4j.Logger;

public class HistoryModelClient implements PingableModelClient {

	static Logger logger = Logger.getLogger(HistoryModelClient.class);
	
	private static HistoryModelClient instance;
	
	public static HistoryModelClient getInstance() {
		if (instance == null) {
			instance = new HistoryModelClient();
		}
		return instance;
	}
	
	private HistoryModelClient() {}
	
	public void ping() throws Phase2Exception{
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.HISTORY_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public String getURLOfService() throws Exception {
		try {
			return RequestPusher.getInstance().getURLOfService(Const.HISTORY_MODEL_SERVICE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new Phase2Exception(e);
		}
	}
	
	public List listHistoryItems(long groupId) throws Phase2Exception {
		logger.info("invoking listHistoryItems(" + groupId + ")");
		
		Request request = new Request();
		request.setMethodName("listHistoryItems");
		request.addRequestParameter(new LongTypeParameter(groupId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.HISTORY_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

}
