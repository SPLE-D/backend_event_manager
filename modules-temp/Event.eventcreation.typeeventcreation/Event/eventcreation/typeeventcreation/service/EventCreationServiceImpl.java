package Event.eventcreation.typeeventcreation.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.eventcreation.core.service.EventCreationServiceDecorator;
import Event.eventcreation.core.model.EventCreationImpl;
import Event.eventcreation.core.service.EventCreationServiceComponent;
import Event.eventcreation.core.model.EventCreation;
import Event.eventcreation.core.model.EventCreationDecorator;
import Event.eventcreation.EventCreationFactory;

public class EventCreationServiceImpl extends EventCreationServiceDecorator {
    public EventCreationServiceImpl (EventCreationServiceComponent record) {
        super(record);
    }

 	public EventCreation createEventCreation(Map<String, Object> requestBody){
		String capacityStr = (String) requestBody.get("capacity");
		int capacity = Integer.parseInt(capacityStr);
		String name = (String) requestBody.get("name");
		String location = (String) requestBody.get("location");
		EventCreation eventcreationtypeeventcreation = record.createEventCreation(requestBody);
		EventCreation eventcreationtypeeventcreationdeco = EventCreationFactory.createEventCreation("Event.eventcreation.typeeventcreation.model.EventCreationImpl", eventcreationtypeeventcreation, eventType);
		Repository.saveObject(eventcreationtypeeventcreationdeco);
		return eventcreationtypeeventcreationdeco;
	}

	public EventCreation createEventCreation(Map<String, Object> requestBody, int id){
		EventCreation savedEventCreation = Repository.getObject(id);
		UUID recordEventCreationEventId = ((EventCreationDecorator) savedEventCreation).getEventId();
		EventCreation eventcreation = record.createEventCreation(requestBody, recordEventCreationEventId);
		EventCreation eventcreationtypeeventcreation = EventCreationFactory.createEventCreation("Event.eventcreation.typeeventcreation.EventCreationImpl", eventcreation, eventType);
		return eventcreationtypeeventcreation;
	}

    public HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("eventId");
		
		EventCreation eventcreationtypeeventcreation = Repository.getObject(id);
		eventcreationtypeeventcreation = createEventCreation(requestBody, id);
		
		Repository.updateObject(eventcreationtypeeventcreation);
		eventcreationtypeeventcreation = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return eventcreationtypeeventcreation.toHashMap();
	}

	public HashMap<String, Object> getEventCreation(String idStr){
		int id = Integer.parseInt(idStr);
		EventCreation eventcreationtypeeventcreation = Repository.getObject(id);
		return eventcreationtypeeventcreation.toHashMap();
	}

	public HashMap<String, Object> getEventCreationById(int id){
		List<HashMap<String, Object>> eventcreationList = getAllEventCreation();
		for (HashMap<String, Object> eventcreation : eventcreationList){
			int eventcreation_id = ((Double) eventcreation.get("eventid")).intValue();
			if (eventcreation_id == id){
				return eventcreation;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllEventCreation(){
		List<EventCreation> List = Repository.getAllObject("eventcreation_typeeventcreation");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<EventCreation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteEventCreation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("eventId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllEventCreation();
	}

	
}
