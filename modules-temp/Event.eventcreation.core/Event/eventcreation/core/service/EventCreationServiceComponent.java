package Event.eventcreation.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.eventcreation.core.model.EventCreation;
//add other required packages

public abstract class EventCreationServiceComponent implements EventCreationService{
	protected RepositoryUtil<EventCreation> Repository;

    public EventCreationServiceComponent(){
        this.Repository = new RepositoryUtil<EventCreation>(Event.eventcreation.core.model.EventCreationComponent.class);
    }	

    public abstract EventCreation createEventCreation(Map<String, Object> requestBody);
	public abstract EventCreation createEventCreation(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getEventCreation(String idStr);
    public abstract List<HashMap<String,Object>> getAllEventCreation();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<EventCreation> List);
    public abstract List<HashMap<String,Object>> deleteEventCreation(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getEventCreationById(int id);

}
