package ngat.oss.client;

import ngat.jibxsoap.BooleanTypeParameter;
import ngat.jibxsoap.IntTypeParameter;
import ngat.jibxsoap.LongTypeParameter;
import ngat.jibxsoap.NullTypeParameter;
import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.jibxsoap.StringTypeParameter;
import ngat.oss.client.transport.PingableModelClient;
import ngat.oss.client.transport.RequestPusher;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.model.ILockingModel;
import ngat.oss.reference.Const;
import ngat.phase2.ILock;

import org.apache.log4j.Logger;
import org.jibx.runtime.JiBXException;

public class LockingModelClient implements ILockingModel, PingableModelClient {

	static Logger logger = Logger.getLogger(LockingModelClient.class);
	
	private static LockingModelClient instance;
	
	public static LockingModelClient getInstance() {
		if (instance == null) {
			instance = new LockingModelClient();
		}
		return instance;
	}
	
	private LockingModelClient() {}
	
	public void ping() throws Phase2Exception{
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public String getURLOfService() throws Exception {
		try {
			return RequestPusher.getInstance().getURLOfService(Const.LOCKING_MODEL_SERVICE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new Phase2Exception(e);
		}
	}
	
	// FETCH METHODS ********************************************************************
	
	private ILock fetchLock(int objType, long objID) throws Phase2Exception {
		logger.info("invoking fetchLock(" + objType + "," + objID + ")");
		
		Request request = new Request();
		request.setMethodName("fetchLock");
		request.addRequestParameter(new IntTypeParameter(objType));
		request.addRequestParameter(new LongTypeParameter(objID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// CREATE METHODS ********************************************************************
	
	private long createLock(int objType, long objID) throws Phase2Exception {
		logger.info("invoking createLock(" + objType + "," + objID + ")");
		
		Request request = new Request();
		request.setMethodName("createLock");
		request.addRequestParameter(new IntTypeParameter(objType));
		request.addRequestParameter(new LongTypeParameter(objID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	// SET METHODS ********************************************************************
	
	private long setLock(int objType, long objID, String clientRef) throws Phase2Exception {
		logger.info("invoking setLock(" + objType + "," + objID + "," + clientRef + ")");
		
		Request request = new Request();
		request.setMethodName("setLock");
		request.addRequestParameter(new IntTypeParameter(objType));
		request.addRequestParameter(new LongTypeParameter(objID));
		request.addRequestParameter(new StringTypeParameter(clientRef));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// GET METHODS ********************************************************************
	
	public ILock getConfigLock(long id) throws Phase2Exception {
		logger.info("invoking getConfigLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getConfigLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getGroupLock(long id) throws Phase2Exception {
		logger.info("invoking getGroupLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getGroupLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getObsLock(long id) throws Phase2Exception {
		logger.info("invoking getObsLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getObsLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getProposalLock(long id) throws Phase2Exception {
		logger.info("invoking getProposalLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getProposalLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getTagLock(long id) throws Phase2Exception {
		logger.info("invoking getTagLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getTagLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getTargetLock(long id) throws Phase2Exception {
		logger.info("invoking getTargetLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getTargetLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ILock getUserLock(long id) throws Phase2Exception {
		logger.info("invoking getUserLock(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("getUserLock");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ILock)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// LOCK METHODS ********************************************************************
	
	public long lockConfig(long configID, String clientID) throws Phase2Exception {
		logger.info("invoking lockConfig(" + configID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockConfig");
		request.addRequestParameter(new LongTypeParameter(configID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long lockGroup(long groupID, String clientID) throws Phase2Exception {
		logger.info("invoking lockGroup(" + groupID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long lockObservation(long obsID, String clientID) throws Phase2Exception {
		logger.info("invoking lockObservation(" + obsID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockObservation");
		request.addRequestParameter(new LongTypeParameter(obsID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}	

	public long lockProposal(long proposalID, String clientID) throws Phase2Exception {
		logger.info("invoking lockProposal(" + proposalID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockProposal");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long lockTag(long tagID, String clientID) throws Phase2Exception {
		logger.info("invoking lockTag(" + tagID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockTag");
		request.addRequestParameter(new LongTypeParameter(tagID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long lockTarget(long targetID, String clientID) throws Phase2Exception {
		logger.info("invoking lockTarget(" + targetID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockTarget");
		request.addRequestParameter(new LongTypeParameter(targetID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long lockUser(long userID, String clientID) throws Phase2Exception {
		logger.info("invoking lockUser(" + userID + "," + clientID + ")");
		
		Request request = new Request();
		request.setMethodName("lockUser");
		request.addRequestParameter(new LongTypeParameter(userID));
		request.addRequestParameter(new StringTypeParameter(clientID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// UNLOCK METHODS ********************************************************************
	
	public boolean unlockConfig(long configID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockConfig(" + configID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockConfig");
		request.addRequestParameter(new LongTypeParameter(configID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean unlockGroup(long groupID, int keyID) throws Phase2Exception {
		logger.info("invoking unlockGroup(" + groupID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		request.addRequestParameter(new IntTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean unlockObservation(long obsID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockObservation(" + obsID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockObservation");
		request.addRequestParameter(new LongTypeParameter(obsID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean unlockProposal(long proposalID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockProposal(" + proposalID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockProposal");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public boolean unlockTag(long tagID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockTag(" + tagID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockTag");
		request.addRequestParameter(new LongTypeParameter(tagID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public boolean unlockTarget(long targetID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockTarget(" + targetID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockTarget");
		request.addRequestParameter(new LongTypeParameter(targetID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean unlockUser(long userID, long keyID) throws Phase2Exception {
		logger.info("invoking unlockUser(" + userID + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("unlockUser");
		request.addRequestParameter(new LongTypeParameter(userID));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.LOCKING_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// TEST METHOD *********************************************************************
	
	public static void main(String args[]) {
		
	}
	
}
