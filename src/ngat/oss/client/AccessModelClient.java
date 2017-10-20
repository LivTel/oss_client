package ngat.oss.client;

import java.rmi.RemoteException;
import java.util.List;

import ngat.jibxsoap.BooleanTypeParameter;
import ngat.jibxsoap.LongTypeParameter;
import ngat.jibxsoap.NullTypeParameter;
import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.jibxsoap.StringTypeParameter;
import ngat.oss.client.transport.PingableModelClient;
import ngat.oss.client.transport.RequestPusher;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.model.IAccessModel;
import ngat.oss.reference.Const;
import ngat.phase2.IAccessPermission;
import ngat.phase2.ILoginRecord;
import ngat.phase2.IUser;
import ngat.phase2.IVersion;

import org.apache.log4j.Logger;


public class AccessModelClient implements IAccessModel, PingableModelClient {

	static Logger logger = Logger.getLogger(AccessModelClient.class);
	
	private static AccessModelClient instance;
	
	public static AccessModelClient getInstance() {
		if (instance == null) {
			instance = new AccessModelClient();
		}
		return instance;
	}
	
	private AccessModelClient() {}
	
	public void ping() throws Phase2Exception {
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IVersion getMinimumClientVersionNumber() throws Phase2Exception {
		logger.info("invoking getMinimumClientVersionNumber()");
		
		Request request = new Request();
		request.setMethodName("getMinimumClientVersionNumber");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IVersion)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void receiveLoginRecord(ILoginRecord loginRecord) throws Phase2Exception {
		logger.info("invoking receiveLoginRecord(" + loginRecord + ")");
		
		Request request = new Request();
		request.setMethodName("receiveLoginRecord");
		request.addRequestParameter(loginRecord);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public String getURLOfService() throws Exception {
		try {
			return RequestPusher.getInstance().getURLOfService(Const.ACCESS_MODEL_SERVICE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new Phase2Exception(e);
		}
	}
	
	// ADD METHODS ********************************************************************
	
	public long addPermission(IAccessPermission perm) throws Phase2Exception {
		logger.info("invoking addPermission(" + perm + ")");
		
		Request request = new Request();
		request.setMethodName("addPermission");
		request.addRequestParameter(perm);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long addUser(IUser user) throws Phase2Exception {
		logger.info("invoking addUser(" + user + ")");
		
		Request request = new Request();
		request.setMethodName("addUser");
		request.addRequestParameter(user);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// DELETE / REVOKE METHODS ********************************************************************
	
	public void revokePermission(long aid) throws Phase2Exception {
		logger.info("invoking revokePermission(" + aid +")");
		
		Request request = new Request();
		request.setMethodName("revokePermission");
		request.addRequestParameter(new LongTypeParameter(aid));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void deleteUser(long uid) throws Phase2Exception {
		logger.info("invoking deleteUser(" + uid + ")");
		
		Request request = new Request();
		request.setMethodName("deleteUser");
		request.addRequestParameter(new LongTypeParameter(uid));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	// GET METHODS ********************************************************************
	
	public IUser getUser(long userID) throws Phase2Exception {
		logger.info("invoking getUser(" + userID + ")");
		
		Request request = new Request();
		request.setMethodName("getUser");
		request.addRequestParameter(new LongTypeParameter(userID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IUser)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IAccessPermission getAccessPermission(long userID, long proposalID) throws Phase2Exception {
		logger.info("invoking getAccessPermission(" + userID + "," + proposalID + ")");
		
		Request request = new Request();
		request.setMethodName("getAccessPermission");
		request.addRequestParameter(new LongTypeParameter(userID));
		request.addRequestParameter(new LongTypeParameter(proposalID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IAccessPermission)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long getProposalPI(long proposalID) throws Phase2Exception {
		logger.info("invoking getProposalPI(" + proposalID + ")");
		
		Request request = new Request();
		request.setMethodName("getProposalPI");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long getUserOwner(long proposalID) throws Phase2Exception {
		logger.info("invoking getUserOwner(" + proposalID + ")");
		
		Request request = new Request();
		request.setMethodName("getUserOwner");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	//New method definition so that old users cannot use the system
	public IUser authenticate(String username, String password, String ignoreThis) throws Phase2Exception {
		logger.info("invoking authenticate(" + username + ", USER_PASSWORD, " + ignoreThis + ")");
		
		//this is likely to be the first service call, we'll therefore trap lower exceptions just in case
		try {
			Request request = new Request();
			request.setMethodName("authenticate");
			request.addRequestParameter(new StringTypeParameter(username));
			request.addRequestParameter(new StringTypeParameter(password));
			request.addRequestParameter(new StringTypeParameter(ignoreThis));
			
			Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
			if (!response.isError()) {
				List responseParameters = response.getResponseParameters();
				if (responseParameters != null) {
					Object parameter = responseParameters.get(0);
					if (parameter != null) {
						IUser user = (IUser)parameter;
						return user;
					}
				}
				return null;
			} else {
				throw new Phase2Exception(response.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Phase2Exception(e);
		}
	} 
	
	/*
	//the rpc call has changed so that old clients get kicked off
	 * 
	public IUser authenticate(String username, String password) throws Phase2Exception {
		logger.info("invoking authenticate(" + username + ", USER_PASSWORD)");
		
		//this is likely to be the first service call, we'll therefore trap lower exceptions just in case
		try {
			Request request = new Request();
			request.setMethodName("authenticate");
			request.addRequestParameter(new StringTypeParameter(username));
			request.addRequestParameter(new StringTypeParameter(password));
			
			Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
			if (!response.isError()) {
				List responseParameters = response.getResponseParameters();
				if (responseParameters != null) {
					Object parameter = responseParameters.get(0);
					if (parameter != null) {
						IUser user = (IUser)parameter;
						return user;
					}
				}
				return null;
			} else {
				throw new Phase2Exception(response.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Phase2Exception(e);
		}
	} 
	*/
	
	// LIST METHODS ********************************************************************
	
	public List listAccessPermissionsOnProposal(long proposalID) throws Phase2Exception {
		logger.info("invoking listAccessPermissionsOnProposal(" + proposalID + ")");
		
		Request request = new Request();
		request.setMethodName("listAccessPermissionsOnProposal");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listAccessPermissionsOfUser(long userID) throws Phase2Exception {
		logger.info("invoking listAccessPermissionsOfUser(" + userID + ")");
		
		Request request = new Request();
		request.setMethodName("listAccessPermissionsOfUser");
		request.addRequestParameter(new LongTypeParameter(userID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listUsers() throws Phase2Exception {
		logger.info("invoking listUsers()");
		
		Request request = new Request();
		request.setMethodName("listUsers");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	// UPDATE METHODS ********************************************************************
	
	public void updatePermission(IAccessPermission perm) throws Phase2Exception {
		logger.info("invoking updatePermission(" + perm + ")");
		
		Request request = new Request();
		request.setMethodName("updatePermission");
		request.addRequestParameter(perm);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateUser(IUser user) throws Phase2Exception {
		logger.info("invoking updateUser(" + user + ")");
		
		Request request = new Request();
		request.setMethodName("updateUser");
		request.addRequestParameter(user);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// FIND METHODS ********************************************************************
	
	public boolean userExists(String name) throws Phase2Exception {
		
		logger.info("invoking userExists(" + name + ")");
		
		Request request = new Request();
		request.setMethodName("userExists");
		request.addRequestParameter(new StringTypeParameter(name));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IUser findUser(String name) throws Phase2Exception {
		
		logger.info("invoking findUser(" + name + ")");
		
		Request request = new Request();
		request.setMethodName("findUser");
		request.addRequestParameter(new StringTypeParameter(name));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.ACCESS_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IUser)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
}