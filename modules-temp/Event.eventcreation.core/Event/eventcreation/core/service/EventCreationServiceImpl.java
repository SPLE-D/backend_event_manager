package Event.eventcreation.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.eventcreation.EventCreationFactory;
import Event.eventcreation.core.model.EventCreation;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class EventCreationServiceImpl extends EventCreationServiceComponent{

    public EventCreation createEventCreation(Map<String, Object> requestBody){
		String capacityStr = (String) requestBody.get("capacity");
		int capacity = Integer.parseInt(capacityStr);
		String name = (String) requestBody.get("name");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		
		EventCreation eventcreation = EventCreationFactory.createEventCreation("Event.eventcreation.core.model.EventCreationImpl", startDate, endDate, capacity, name, location);
		Repository.saveObject(eventcreation);
		return eventcreation;
	}

	public EventCreation createEventCreation(Map<String, Object> requestBody, int id){
		int eventId = id;
		String capacityStr = (String) requestBody.get("capacity");
		int capacity = Integer.parseInt(capacityStr);
		String name = (String) requestBody.get("name");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		EventCreation eventcreation = EventCreationFactory.createEventCreation("Event.eventcreation.core.model.EventCreationImpl",eventId, startDate, endDate, capacity, name, location);
		Repository.saveObject(eventcreation);
		return eventcreation;
	}

    public HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("eventId");
		int id = Integer.parseInt(idStr);
		EventCreation eventcreation = Repository.getObject(id);
		
		String capacityStr = (String) requestBody.get("capacity");
		eventcreation.setCapacity(Integer.parseInt(capacityStr));
		
		eventcreation.setName((String) requestBody.get("name"));
		eventcreation.setLocation((String) requestBody.get("location"));
		
		Repository.updateObject(eventcreation);
		
		//to do: fix association attributes
		
		return eventcreation.toHashMap();
		
	}

    public HashMap<String, Object> getEventCreation(String idStr){
		int id = Integer.parseInt(idStr);
		EventCreation eventcreation = Repository.getObject(id);
		return eventcreation.toHashMap();
	}

	public HashMap<String, Object> getEventCreationById(int id){
		List<HashMap<String, Object>> eventcreationList = getAllEventCreation();
		for (HashMap<String, Object> eventcreation : eventcreationList){
			int record_id = ((Double) eventcreation.get("eventId")).intValue();
			if (record_id == id){
				return eventcreation;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllEventCreation(){
		List<EventCreation> List = Repository.getAllObject("eventcreation_impl");
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
