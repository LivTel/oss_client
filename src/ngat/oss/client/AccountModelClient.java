package ngat.oss.client;

import java.util.List;

import ngat.jibxsoap.DoubleTypeParameter;
import ngat.jibxsoap.LongTypeParameter;
import ngat.jibxsoap.NullTypeParameter;
import ngat.jibxsoap.Request;
import ngat.jibxsoap.Response;
import ngat.jibxsoap.StringTypeParameter;
import ngat.oss.client.transport.PingableModelClient;
import ngat.oss.client.transport.RequestPusher;
import ngat.oss.exception.Phase2Exception;
import ngat.phase2.IAccount;
import ngat.phase2.ISemester;
import ngat.phase2.ISemesterPeriod;
import ngat.phase2.ITransaction;

import org.apache.log4j.Logger;

/**
 * Uses different Const. integer to indicate service
 * @author nrc
 *
 */
public class AccountModelClient implements PingableModelClient {

	static Logger logger = Logger.getLogger(AccountModelClient.class);
	
	/* one of 
	 	Const.PROPOSAL_ACCOUNT_SERVICE;
		Const.TAG_ACCOUNT_SERVICE
	*/
	private String accountModelInstanceName;
	
	public AccountModelClient(String accountModelInstanceName) {
		this.accountModelInstanceName = accountModelInstanceName;
	}
	
	public void ping() throws Phase2Exception{
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public String getURLOfService() throws Phase2Exception {
		try {
			return RequestPusher.getInstance().getURLOfService(accountModelInstanceName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new Phase2Exception(e);
		}
	}
	
	public long addAccount(long ownerId, long semesterId, IAccount account) throws Phase2Exception {
		logger.info("invoking addAccount(" + ownerId + "," + semesterId + "," + account + ")");
		
		Request request = new Request();
		request.setMethodName("addAccount");
		request.addRequestParameter(new LongTypeParameter(ownerId));
		request.addRequestParameter(new LongTypeParameter(semesterId));
		request.addRequestParameter(account);

		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void addAllAccountsBetweenSemesters(long ownerId, long startSemesterId, long endSemesterId) throws Phase2Exception {
		logger.info("invoking addAllAccountsBetweenSemesters(" + ownerId + "," + startSemesterId + "," + endSemesterId + ")");
		
		Request request = new Request();
		request.setMethodName("addAllAccountsBetweenSemesters");
		request.addRequestParameter(new LongTypeParameter(ownerId));
		request.addRequestParameter(new LongTypeParameter(startSemesterId));
		request.addRequestParameter(new LongTypeParameter(endSemesterId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}	
	}
	
	public void deleteAccount(long id) throws Phase2Exception {
		logger.info("invoking deleteAccount(" + id + ")");
		
		Request request = new Request();
		request.setMethodName("deleteAccount");
		request.addRequestParameter(new LongTypeParameter(id));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}	
	}

	public void deleteAccountsOfOwner(long arg0) throws Phase2Exception {
		throw new Phase2Exception("Unimplemented method");
	}

	public void deleteSemester(long arg0) throws Phase2Exception {
		throw new Phase2Exception("Unimplemented method");
	}

	public void deleteAccountTransactions(long arg0) throws Phase2Exception {
		throw new Phase2Exception("Unimplemented method");
	}

	public void deleteTransaction(long arg0) throws Phase2Exception {
		throw new Phase2Exception("Unimplemented method");
	}
	
	public long modifyAllocation(long accountID, double amount, String comment, String clientRef) throws Phase2Exception {
		logger.info("invoking modifyAllocation(" + accountID + "," + amount + "," + comment + "," + clientRef);
		
		Request request = new Request();
		request.setMethodName("modifyAllocation");
		request.addRequestParameter(new LongTypeParameter(accountID));
		request.addRequestParameter(new DoubleTypeParameter(amount));
		request.addRequestParameter(new StringTypeParameter(comment));
		request.addRequestParameter(new StringTypeParameter(clientRef));

		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long modifyConsumed(long accountID, double amount, String comment, String clientRef) throws Phase2Exception {
		logger.info("invoking modifyConsumed(" + accountID + "," + amount + "," + comment + "," + clientRef);
		
		Request request = new Request();
		request.setMethodName("modifyConsumed");
		request.addRequestParameter(new LongTypeParameter(accountID));
		request.addRequestParameter(new DoubleTypeParameter(amount));
		request.addRequestParameter(new StringTypeParameter(comment));
		request.addRequestParameter(new StringTypeParameter(clientRef));

		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public IAccount getAccount(long accountID) throws Phase2Exception {
		logger.info("invoking getAccount(" + accountID + ")");
		
		Request request = new Request();
		request.setMethodName("getAccount");
		request.addRequestParameter(new LongTypeParameter(accountID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IAccount)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long getAccountOwnerID(long accountID) throws Phase2Exception {
		logger.info("invoking getAccountOwnerID(" + accountID + ")");
		
		Request request = new Request();
		request.setMethodName("getAccountOwnerID");
		request.addRequestParameter(new LongTypeParameter(accountID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ISemester getSemester(long semesterId) throws Phase2Exception {
		logger.info("invoking getSemester(" + semesterId + ")");
		
		Request request = new Request();
		request.setMethodName("getSemester");
		request.addRequestParameter(new LongTypeParameter(semesterId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ISemester)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public ITransaction getTransaction(long transID) throws Phase2Exception {
		logger.info("invoking getTransaction(" + transID +")");
		
		Request request = new Request();
		request.setMethodName("getTransaction");
		request.addRequestParameter(new LongTypeParameter(transID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITransaction)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public ISemesterPeriod getSemesterPeriodOfDate(long date) throws Phase2Exception {
		logger.info("invoking getSemesterPeriodOfDate(" + date +")");
		
		Request request = new Request();
		request.setMethodName("getSemesterPeriodOfDate");
		request.addRequestParameter(new LongTypeParameter(date));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ISemesterPeriod)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IAccount findAccount(long ownerId, long semesterId) throws Phase2Exception {
		logger.info("invoking findAccount("+ownerId + "," + semesterId +")");
		
		Request request = new Request();
		request.setMethodName("findAccount");
		request.addRequestParameter(new LongTypeParameter(ownerId));
		request.addRequestParameter(new LongTypeParameter(semesterId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IAccount)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ISemester findSemester(String name) throws Phase2Exception {
		logger.info("invoking findSemester("+name + ")");
		
		Request request = new Request();
		request.setMethodName("findSemester");
		request.addRequestParameter(new StringTypeParameter(name));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ISemester)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listTransactions(long accountID) throws Phase2Exception {
		logger.info("invoking listTransactions(" + accountID + ")");
		
		Request request = new Request();
		request.setMethodName("listTransactions");
		request.addRequestParameter(new LongTypeParameter(accountID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listAccountsOfSemester(long semesterId) throws Phase2Exception {
		logger.info("invoking listAccountsOfSemester(" + semesterId +")");
		
		Request request = new Request();
		request.setMethodName("listAccountsOfSemester");
		request.addRequestParameter(new LongTypeParameter(semesterId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listSemestersFromDate(long dateTime) throws Phase2Exception {
		logger.info("invoking listSemestersFromDate(" + dateTime +")");
		
		Request request = new Request();
		request.setMethodName("listSemestersFromDate");
		request.addRequestParameter(new LongTypeParameter(dateTime));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listAccountEntriesOfSemester(long semesterId) throws Phase2Exception {
		logger.info("invoking listAccountEntriesOfSemester(" + semesterId +")");
		
		Request request = new Request();
		request.setMethodName("listAccountEntriesOfSemester");
		request.addRequestParameter(new LongTypeParameter(semesterId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listSemestersForWhichOwnerHasAccounts(long ownerId) throws Phase2Exception {
		logger.info("invoking listSemestersForWhichOwnerHasAccounts(" + ownerId +")");
		
		Request request = new Request();
		request.setMethodName("listSemestersForWhichOwnerHasAccounts");
		request.addRequestParameter(new LongTypeParameter(ownerId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long addSemester(ISemester semester) throws Phase2Exception {
		logger.info("invoking addSemester(" + semester + ")");
		
		Request request = new Request();
		request.setMethodName("addSemester");
		request.addRequestParameter(semester);

		Response response = RequestPusher.getInstance().pushRequest(request, accountModelInstanceName);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

}
