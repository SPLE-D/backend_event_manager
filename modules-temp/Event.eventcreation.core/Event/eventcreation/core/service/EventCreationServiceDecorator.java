package Event.eventcreation.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.eventcreation.core.model.EventCreation;

public abstract class EventCreationServiceDecorator extends EventCreationServiceComponent{
	protected EventCreationServiceComponent record;

    public EventCreationServiceDecorator(EventCreationServiceComponent record) {
        this.record = record;
    }

	public EventCreation createEventCreation(Map<String, Object> requestBody){
		return record.createEventCreation(requestBody);
	}
	
	public EventCreation createEventCreation(Map<String, Object> requestBody, int id){
		return record.createEventCreation(requestBody, id);
	}

	public HashMap<String, Object> getEventCreation(String idStr){
		return record.getEventCreation(idStr);
	}

	public List<HashMap<String,Object>> getAllEventCreation(){
		return record.getAllEventCreation();
	}

    public HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody){
		return record.updateEventCreation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<EventCreation> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteEventCreation(Map<String, Object> requestBody){
		return record.deleteEventCreation(requestBody);
	}

	public HashMap<String, Object> getEventCreationById(int id){
        return record.getEventCreationById(id);
    }

}
