package Event.eventcreation.typeeventcreation.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.eventcreation.core.resource.EventCreationResourceDecorator;
import Event.eventcreation.core.resource.EventCreationResourceComponent;
import Event.eventcreation.core.model.EventCreation;
import Event.eventcreation.core.model.EventCreationImpl;
import Event.eventcreation.core.service.EventCreationServiceComponent;
import Event.eventcreation.typeeventcreation.service.EventCreationServiceImpl;

public class EventCreationResourceImpl extends EventCreationResourceDecorator {
	private EventCreationServiceComponent eventcreationtypeeventcreationServiceImpl;

    public EventCreationResourceImpl (EventCreationResourceComponent record, EventCreationServiceComponent recordService) {
        super(record);
		this.eventcreationtypeeventcreationServiceImpl = new EventCreationServiceImpl(recordService);
    }

    
    @Route(url="call/typeeventcreation/save")
    public List<HashMap<String,Object>> saveEventCreation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EventCreation eventcreationtypeeventcreation = createEventCreation(vmjExchange);
		return getAllEventCreation(vmjExchange);
	}

    public EventCreation createEventCreation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EventCreation result = eventcreationtypeeventcreationServiceImpl.createEventCreation(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public EventCreation createEventCreation(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EventCreation result = eventcreationtypeeventcreationServiceImpl.createEventCreation(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/typeeventcreation/update")
    public HashMap<String, Object> updateEventCreation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return eventcreationtypeeventcreationServiceImpl.updateEventCreation(requestBody);
	}

	
    @Route(url="call/typeeventcreation/detail")
    public HashMap<String, Object> getEventCreation(VMJExchange vmjExchange){
		return record.getEventCreation(vmjExchange);
	}

	
    @Route(url="call/typeeventcreation/list")
    public List<HashMap<String,Object>> getAllEventCreation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return eventcreationtypeeventcreationServiceImpl.getAllEventCreation();
	}

    public List<HashMap<String,Object>> transformEventCreationListToHashMap(List<EventCreation> EventCreationTypeEventCreationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EventCreationTypeEventCreationList.size(); i++) {
            resultList.add(EventCreationTypeEventCreationList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/typeeventcreation/delete")
    public List<HashMap<String,Object>> deleteEventCreation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return eventcreationtypeeventcreationServiceImpl.deleteEventCreation(requestBody);
	}

	
}
