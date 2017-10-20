package ngat.oss.client;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

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
import ngat.oss.reference.Const;
import ngat.phase2.IGroup;
import ngat.phase2.IInstrumentConfig;
import ngat.phase2.IProgram;
import ngat.phase2.IProposal;
import ngat.phase2.IRevision;
import ngat.phase2.ISequenceComponent;
import ngat.phase2.ITag;
import ngat.phase2.ITarget;

import org.apache.log4j.Logger;

public class Phase2ModelClient implements PingableModelClient { // , IPhase2Model {  //uncomment to get method list

	static Logger logger = Logger.getLogger(Phase2ModelClient.class);
	
	private static Phase2ModelClient instance;
	
	public static Phase2ModelClient getInstance() {
		if (instance == null) {
			instance = new Phase2ModelClient();
		}
		return instance;
	}
	
	private Phase2ModelClient() {}
	
	public void ping() throws Phase2Exception{
		logger.info("invoking ping()");
		
		Request request = new Request();
		request.setMethodName("ping");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
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
	
	// ADD METHODS ********************************************************************
	
	public long addGroup(long propID, IGroup group) throws Phase2Exception {
		logger.info("invoking addGroup(" + propID + "," + group + ")");
		
		Request request = new Request();
		request.setMethodName("addGroup");
		request.addRequestParameter(new LongTypeParameter(propID));
		request.addRequestParameter(group);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long addTarget(long propID, ITarget target) throws Phase2Exception {
		logger.info("invoking addTarget(" + propID + "," + target + ")");
		
		Request request = new Request();
		request.setMethodName("addTarget");
		request.addRequestParameter(new LongTypeParameter(propID));
		request.addRequestParameter(target);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long addInstrumentConfig(long progId, IInstrumentConfig config) throws Phase2Exception {
		logger.info("invoking addInstrumentConfig(" + progId + "," + config + ")");
		
		Request request = new Request();
		request.setMethodName("addInstrumentConfig");
		request.addRequestParameter(new LongTypeParameter(progId));
		request.addRequestParameter(config);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void addRevision(long propID, IRevision revision) throws Phase2Exception {
		logger.info("invoking addRevision(" + propID + "," + revision + ")");
		
		Request request = new Request();
		request.setMethodName("addRevision");
		request.addRequestParameter(new LongTypeParameter(propID));
		request.addRequestParameter(revision);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	// CHANGE METHODS *******************************************************************

	public void changeProgrammeOfProposal(long proposalId, long progId) throws Phase2Exception {
		logger.info("invoking changeProgrammeOfProposal(" + proposalId + "," + progId + ")");
		
		Request request = new Request();
		request.setMethodName("changeProgrammeOfProposal");
		request.addRequestParameter(new LongTypeParameter(proposalId));
		request.addRequestParameter(new LongTypeParameter(progId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void changeTagOfProposal(long proposalId, long tagId) throws Phase2Exception {
		logger.info("invoking changeTagOfProposal(" + proposalId + "," + tagId + ")");
		
		Request request = new Request();
		request.setMethodName("changeTagOfProposal");
		request.addRequestParameter(new LongTypeParameter(proposalId));
		request.addRequestParameter(new LongTypeParameter(tagId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	
	
	// DELETE METHODS ********************************************************************
	
	public void deleteGroup(long groupID) throws Phase2Exception {
		logger.info("invoking deleteGroup(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("deleteGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void deleteObservationSequenceOfGroup(long groupID) throws Phase2Exception {
		logger.info("invoking deleteObservationSequenceOfGroup(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("deleteObservationSequenceOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void deleteProposal(long propID) throws Phase2Exception {
		logger.info("invoking deleteProposal(" + propID + ")");
		
		Request request = new Request();
		request.setMethodName("deleteProposal");
		request.addRequestParameter(new LongTypeParameter(propID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void deleteTarget(long targetID) throws Phase2Exception {
		logger.info("invoking deleteTarget(" + targetID + ")");
		
		Request request = new Request();
		request.setMethodName("deleteTarget");
		request.addRequestParameter(new LongTypeParameter(targetID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void deleteConfig(long configID) throws Phase2Exception {
		logger.info("invoking deleteConfig(" + configID + ")");
		
		Request request = new Request();
		request.setMethodName("deleteConfig");
		request.addRequestParameter(new LongTypeParameter(configID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			logger.info("... returned " + responseParameter);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// GET METHODS ********************************************************************
	
	public int getNumberOfGroups(long proposalID, boolean active) throws Phase2Exception {
		logger.info("invoking getNumberOfGroups(" + proposalID + ","  +active + ")");
		
		Request request = new Request();
		request.setMethodName("getNumberOfGroups");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		request.addRequestParameter(new BooleanTypeParameter(active));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			IntTypeParameter responseParam = (IntTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getIntValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IGroup getGroup(long groupID) throws Phase2Exception {
		logger.info("invoking getGroup(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("getGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IGroup)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IInstrumentConfig getInstrumentConfig(long configID) throws Phase2Exception {
		logger.info("invoking getInstrumentConfig(" + configID + ")");
		
		Request request = new Request();
		request.setMethodName("getInstrumentConfig");
		request.addRequestParameter(new LongTypeParameter(configID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IInstrumentConfig)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ISequenceComponent getObservationSequence(long sequenceID) throws Phase2Exception {
		logger.info("invoking getObservationSequence(" + sequenceID + ")");
		
		Request request = new Request();
		request.setMethodName("getObservationSequence");
		request.addRequestParameter(new LongTypeParameter(sequenceID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ISequenceComponent)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ISequenceComponent getObservationSequenceOfGroup(long groupID) throws Phase2Exception {
		logger.info("invoking getObservationSequenceOfGroup(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("getObservationSequenceOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ISequenceComponent)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IProposal getProposal(long propID) throws Phase2Exception {
		logger.info("invoking getProposal(" + propID + ")");
		
		Request request = new Request();
		request.setMethodName("getProposal");
		request.addRequestParameter(new LongTypeParameter(propID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProposal)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IProposal getProposalOfGroup(long groupID) throws Phase2Exception {
		logger.info("invoking getProposalOfGroup(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("getProposalOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProposal)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ITarget getTarget(long targetID) throws Phase2Exception {
		logger.info("invoking getTarget(" + targetID + ")");
		
		Request request = new Request();
		request.setMethodName("getTarget");
		request.addRequestParameter(new LongTypeParameter(targetID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITarget)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ITarget getTargetForObservation(long observationID) throws Phase2Exception {
		logger.info("invoking getTargetForObservation(" + observationID + ")");
		
		Request request = new Request();
		request.setMethodName("getTargetForObservation");
		request.addRequestParameter(new LongTypeParameter(observationID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITarget)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IInstrumentConfig getConfigForObservation(long observationID) throws Phase2Exception {
		logger.info("invoking getConfigForObservation(" + observationID + ")");
		
		Request request = new Request();
		request.setMethodName("getConfigForObservation");
		request.addRequestParameter(new LongTypeParameter(observationID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IInstrumentConfig)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// LIST METHODS ********************************************************************
	
	public List listGroups(long propID, boolean includeInactiveGroups) throws Phase2Exception {
		logger.info("invoking listGroups(" + propID + "," + includeInactiveGroups + ")");
		
		Request request = new Request();
		request.setMethodName("listGroups");
		request.addRequestParameter(new LongTypeParameter(propID));
		request.addRequestParameter(new BooleanTypeParameter(includeInactiveGroups));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listActiveFixedGroups() throws Phase2Exception {
		logger.info("invoking listActiveFixedGroups()");
		
		Request request = new Request();
		request.setMethodName("listActiveFixedGroups");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listGroupsUsingTarget(ITarget target) throws Phase2Exception {
		logger.info("invoking listGroupsUsingTarget(" + target + ")");
		
		Request request = new Request();
		request.setMethodName("listGroupsUsingTarget");
		request.addRequestParameter(target);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listGroupsUsingInstrumentConfig(IInstrumentConfig instrumentConfig) throws Phase2Exception {
		logger.info("invoking listGroupsUsingInstrumentConfig(" + instrumentConfig + ")");
		
		Request request = new Request();
		request.setMethodName("listGroupsUsingInstrumentConfig");
		request.addRequestParameter(instrumentConfig);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listConfigHeaders(long propID) throws Phase2Exception {
		logger.info("invoking listConfigHeaders(" + propID + ")");
		
		Request request = new Request();
		request.setMethodName("listConfigHeaders");
		request.addRequestParameter(new LongTypeParameter(propID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listRevisionHeaders(long propID) throws Phase2Exception {
		logger.info("invoking listRevisionHeaders(" + propID + ")");
		
		Request request = new Request();
		request.setMethodName("listRevisionHeaders");
		request.addRequestParameter(new LongTypeParameter(propID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	
	// UPDATE METHODS ********************************************************************
	
	public void updateGroup(IGroup group, long keyID) throws Phase2Exception {
		logger.info("invoking updateGroup(" + group + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateGroup");
		request.addRequestParameter(group);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateGroupUrgency(long groupId, boolean isUrgent, long keyID) throws Phase2Exception {
		logger.info("invoking updateGroupUrgency(" + groupId + "," + isUrgent + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateGroupUrgency");
		request.addRequestParameter(new LongTypeParameter(groupId));
		request.addRequestParameter(new BooleanTypeParameter(isUrgent));
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateDetectorConfig(IInstrumentConfig config, long keyId) throws Phase2Exception {
		logger.info("invoking updateDetectorConfig(" + config + "," + keyId + ")");
		
		Request request = new Request();
		request.setMethodName("updateDetectorConfig");
		request.addRequestParameter(config);
		request.addRequestParameter(new LongTypeParameter(keyId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateProposal(IProposal proposal, long keyID) throws Phase2Exception {
		logger.info("invoking updateProposal(" + proposal + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateProposal");
		request.addRequestParameter(proposal);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateTarget(ITarget target, long keyID) throws Phase2Exception {
		logger.info("invoking updateTarget(" + target + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateTarget");
		request.addRequestParameter(target);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	// SET METHODS ********************************************************************
	
	public void setTargetForObservation(long observationID, long targetID) throws Phase2Exception {
		logger.info("invoking setTargetForObservation(" + observationID + "," + targetID + ")");
		
		Request request = new Request();
		request.setMethodName("setTargetForObservation");
		request.addRequestParameter(new LongTypeParameter(observationID));
		request.addRequestParameter(new LongTypeParameter(targetID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void setConfigForObservation(long observationID, long configID) throws Phase2Exception {
		logger.info("invoking setConfigForObservation(" + observationID + "," + configID + ")");
		
		Request request = new Request();
		request.setMethodName("setConfigForObservation");
		request.addRequestParameter(new LongTypeParameter(observationID));
		request.addRequestParameter(new LongTypeParameter(configID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	
	/****************************************************************************************************************************/
	
	public long addObservationSequence(long groupID, ISequenceComponent sequenceComponent) throws Phase2Exception {
		logger.info("invoking addObservationSequence(" + groupID + "," +sequenceComponent + ")");
		
		Request request = new Request();
		request.setMethodName("addObservationSequence");
		request.addRequestParameter(new LongTypeParameter(groupID));
		request.addRequestParameter(sequenceComponent);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public long addProgramme(IProgram programme) throws Phase2Exception {
		logger.info("invoking addProgramme(" + programme + ")");
		
		Request request = new Request();
		request.setMethodName("addProgramme");
		request.addRequestParameter(programme);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long addProposal(long tagId, long progId, IProposal proposal) throws Phase2Exception {
		logger.info("invoking addProposal(" + tagId  +"," +progId + "," +proposal  + ")");
		
		Request request = new Request();
		request.setMethodName("addProposal");
		request.addRequestParameter(new LongTypeParameter(tagId));
		request.addRequestParameter(new LongTypeParameter(progId));
		request.addRequestParameter(proposal);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long addTag(ITag tag) throws Phase2Exception {
		logger.info("invoking addTag(" + tag  +")");
		
		Request request = new Request();
		request.setMethodName("addTag");
		request.addRequestParameter(tag);
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void deleteProgramme(long progId) throws Phase2Exception {
		logger.info("invoking deleteProgramme(" + progId + ")");
		
		Request request = new Request();
		request.setMethodName("deleteProgramme");
		request.addRequestParameter(new LongTypeParameter(progId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void deleteTag(long tagId) throws Phase2Exception {
		logger.info("invoking deleteTag(" + tagId + ")");
		
		Request request = new Request();
		request.setMethodName("deleteTag");
		request.addRequestParameter(new LongTypeParameter(tagId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void deleteInstrumentConfig(long configId) throws Phase2Exception {
		logger.info("invoking deleteInstrumentConfig(" + configId + ")");
		
		Request request = new Request();
		request.setMethodName("deleteInstrumentConfig");
		request.addRequestParameter(new LongTypeParameter(configId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public long findIdOfGroupInProposal(String name, long proposalId) throws Phase2Exception {
		logger.info("invoking findIdOfGroupInProposal(" + name +"," + proposalId + ")");
		
		Request request = new Request();
		request.setMethodName("findIdOfGroupInProposal");
		request.addRequestParameter(new StringTypeParameter(name));
		request.addRequestParameter(new LongTypeParameter(proposalId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ITag findTag(String tagName) throws Phase2Exception {
		logger.info("invoking findTag(" + tagName + ")");
		
		Request request = new Request();
		request.setMethodName("findTag");
		request.addRequestParameter(new StringTypeParameter(tagName));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITag)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public ITarget findTarget(long programId, String targetName) throws Phase2Exception {
		logger.info("invoking findTarget(" + programId + "," + targetName + ")");
		
		Request request = new Request();
		request.setMethodName("findTarget");
		request.addRequestParameter(new LongTypeParameter(programId));
		request.addRequestParameter(new StringTypeParameter(targetName));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITarget)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	public long findProposalIdOfGroup(long groupId) throws Phase2Exception {
		logger.info("invoking findProposalIdOfGroup(" + groupId  +")");
		
		Request request = new Request();
		request.setMethodName("findProposalIdOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			LongTypeParameter responseParam = (LongTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getLongValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public IProgram findProgram(String progName) throws Phase2Exception {
		logger.info("invoking findProgram(" + progName + ")");
		
		Request request = new Request();
		request.setMethodName("findProgram");
		request.addRequestParameter(new StringTypeParameter(progName));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProgram)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public IProposal findProposal(String name) throws Phase2Exception {
		logger.info("invoking findProposal(" + name + ")");
		
		Request request = new Request();
		request.setMethodName("findProposal");
		request.addRequestParameter(new StringTypeParameter(name));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProposal)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean groupHasObservationSequence(long groupID) throws RemoteException{
		logger.info("invoking groupHasObservationSequence(" + groupID + ")");
		
		Request request = new Request();
		request.setMethodName("groupHasObservationSequence");
		request.addRequestParameter(new LongTypeParameter(groupID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean proposalExists(String proposalName, long progId) throws Phase2Exception {
		logger.info("invoking proposalExists(" + proposalName + "," + progId + ")");
		
		Request request = new Request();
		request.setMethodName("proposalExists");
		request.addRequestParameter(new StringTypeParameter(proposalName));
		request.addRequestParameter(new LongTypeParameter(progId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public boolean groupExists(String groupName, long proposalId) throws Phase2Exception {
		logger.info("invoking groupExists(" + groupName + "," + proposalId + ")");
		
		Request request = new Request();
		request.setMethodName("groupExists");
		request.addRequestParameter(new StringTypeParameter(groupName));
		request.addRequestParameter(new LongTypeParameter(proposalId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			BooleanTypeParameter responseParam = (BooleanTypeParameter)response.getResponseParameters().get(0);
			return responseParam.getBooleanValue();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public IProgram getProgramme(long progId) throws Phase2Exception {
		logger.info("invoking getProgramme(" + progId + ")");
		
		Request request = new Request();
		request.setMethodName("getProgramme");
		request.addRequestParameter(new LongTypeParameter(progId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProgram)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public IProgram getProgrammeOfProposal(long proposalId) throws Phase2Exception {
		logger.info("invoking getProgrammeOfProposal(" + proposalId + ")");
		
		Request request = new Request();
		request.setMethodName("getProgrammeOfProposal");
		request.addRequestParameter(new LongTypeParameter(proposalId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProgram)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public IProgram getProgrammeOfGroup(long groupId) throws Phase2Exception {
		logger.info("invoking getProgrammeOfGroup(" + groupId + ")");
		
		Request request = new Request();
		request.setMethodName("getProgrammeOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (IProgram)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public ITag getTag(long tagId) throws Phase2Exception {
		logger.info("invoking getTag(" + tagId + ")");
		
		Request request = new Request();
		request.setMethodName("getTag");
		request.addRequestParameter(new LongTypeParameter(tagId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITag)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public ITag getTagOfProposal(long proposalId) throws Phase2Exception {
		logger.info("invoking getTagOfProposal(" + proposalId + ")");
		
		Request request = new Request();
		request.setMethodName("getTagOfProposal");
		request.addRequestParameter(new LongTypeParameter(proposalId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			Object responseParameter = response.getResponseParameters().get(0);
			if (responseParameter instanceof NullTypeParameter) {
				return null;
			}
			return (ITag)responseParameter;
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listRevisions(long propId) throws Phase2Exception {
		logger.info("invoking listRevisions(" + propId + ")");
		
		Request request = new Request();
		request.setMethodName("listRevisions");
		request.addRequestParameter(new LongTypeParameter(propId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listProposalsOfProgramme(long progId) throws Phase2Exception {
		logger.info("invoking listProposalsOfProgramme(" + progId + ")");
		
		Request request = new Request();
		request.setMethodName("listProposalsOfProgramme");
		request.addRequestParameter(new LongTypeParameter(progId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listProposalNames(boolean limitToProposalsWithoutPIs) throws Phase2Exception {
		logger.info("invoking listProposalNames()");
		
		Request request = new Request();
		request.setMethodName("listProposalNames");
		request.addRequestParameter(new BooleanTypeParameter(limitToProposalsWithoutPIs));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listProposalsOfTag(long tagId) throws Phase2Exception {
		logger.info("invoking listProposalsOfTag(" + tagId + ")");
		
		Request request = new Request();
		request.setMethodName("listProposalsOfTag");
		request.addRequestParameter(new LongTypeParameter(tagId));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listProgrammes() throws Phase2Exception {
		logger.info("invoking listProgrammes()");
		
		Request request = new Request();
		request.setMethodName("listProgrammes");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listProgrammesOfUser(long uid) throws Phase2Exception {
		logger.info("invoking listProgrammesOfUser()");
		
		Request request = new Request();
		request.setMethodName("listProgrammesOfUser");
		request.addRequestParameter(new LongTypeParameter(uid));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public List listTags() throws Phase2Exception {
		logger.info("invoking listTags()");
		
		Request request = new Request();
		request.setMethodName("listTags");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listTargets(long progID) throws Phase2Exception {
		logger.info("invoking listTargets()");
		
		Request request = new Request();
		request.setMethodName("listTargets");
		request.addRequestParameter(new LongTypeParameter(progID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listGroupsWithTimingConstraintOfType(int timingConstraintType) throws Phase2Exception {
		logger.info("invoking listGroupsWithTimingConstraintOfType()");
		
		Request request = new Request();
		request.setMethodName("listGroupsWithTimingConstraintOfType");
		request.addRequestParameter(new IntTypeParameter(timingConstraintType));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listTimingConstraints() throws Phase2Exception {
		logger.info("invoking listTimingConstraints()");
		
		Request request = new Request();
		request.setMethodName("listTimingConstraints");
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listTimingConstraintsOfType(int type) throws Phase2Exception {
		logger.info("invoking listTimingConstraintsOfType()");
		
		Request request = new Request();
		request.setMethodName("listTimingConstraintsOfType");
		request.addRequestParameter(new IntTypeParameter(type));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listTimingConstraintsOfTypeEndingAfter(int type, long cutOffTime) throws Phase2Exception {
		logger.info("invoking listTimingConstraintsOfTypeEndingAfter(type, cutOffTime)");
		
		Request request = new Request();
		request.setMethodName("listTimingConstraintsOfTypeEndingAfter");
		request.addRequestParameter(new IntTypeParameter(type));
		request.addRequestParameter(new LongTypeParameter(cutOffTime));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	public void updateInstrumentConfig(IInstrumentConfig instrumentConfig, long keyID) throws Phase2Exception {
		logger.info("invoking updateInstrumentConfig(" + instrumentConfig + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateInstrumentConfig");
		request.addRequestParameter(instrumentConfig);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void updateProgramme(IProgram program, long keyID) throws Phase2Exception {
		logger.info("invoking updateProgramme(" + program + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateProgramme");
		request.addRequestParameter(program);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void updateTag(ITag tag, long keyID) throws Phase2Exception {
		logger.info("invoking updateTag(" + tag + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateTag");
		request.addRequestParameter(tag);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public List listLinkages(long proposalID) throws Phase2Exception {
		logger.info("invoking listLinkages()");
		
		Request request = new Request();
		request.setMethodName("listLinkages");
		request.addRequestParameter(new LongTypeParameter(proposalID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	/*
	public ISemester getSemester(long dateTime) throws Phase2Exception {
		logger.info("invoking getSemester(" + dateTime + ")");
		
		Request request = new Request();
		request.setMethodName("getSemester");
		request.addRequestParameter(new LongTypeParameter(date));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return (ISemester)response.getResponseParameters().get(0);
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	*/
	
	public List listInstrumentConfigs(long progID) throws Phase2Exception {
		logger.info("invoking listInstrumentConfigs()");
		
		Request request = new Request();
		request.setMethodName("listInstrumentConfigs");
		request.addRequestParameter(new LongTypeParameter(progID));
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			return response.getResponseParameters();
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}

	public void updateObservationSequenceOfGroup(long groupID, ISequenceComponent sequence, long keyID) throws Phase2Exception {
		logger.info("invoking updateObservationSequenceOfGroup(" + groupID +"," + sequence + "," + keyID + ")");
		
		Request request = new Request();
		request.setMethodName("updateObservationSequenceOfGroup");
		request.addRequestParameter(new LongTypeParameter(groupID));
		request.addRequestParameter(sequence);
		request.addRequestParameter(new LongTypeParameter(keyID));
		
		Response response = RequestPusher.getInstance().pushRequest(request, Const.PHASE2_MODEL_SERVICE);
		if (!response.isError()) {
			logger.info("... returned " + response.getResponseParameters().get(0));
		} else {
			throw new Phase2Exception(response.getErrorMessage());
		}
	}
	
	/******************************************************************************************************************************/
	
	// TEST METHOD *********************************************************************
	
	public static void main(String args[]) {	
		try {
			Iterator i = Phase2ModelClient.getInstance().listGroups(33, true).iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		} catch (Phase2Exception e) {
			e.printStackTrace();
		}
	}


	/********************************************************************************************************************************/
}
