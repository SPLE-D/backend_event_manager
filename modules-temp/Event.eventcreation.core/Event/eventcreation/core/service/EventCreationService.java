package Event.eventcreation.core.service;
import java.util.*;

import Event.eventcreation.core.model.EventCreation;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface EventCreationService {
	EventCreation createEventCreation(Map<String, Object> requestBody);
	HashMap<String, Object> getEventCreation(String idStr);
    HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllEventCreation();
    List<HashMap<String,Object>> deleteEventCreation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<EventCreation> List);
}
