package Event.eventcreation.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.eventcreation.core.model.EventCreation;
//add other required packages

public abstract class EventCreationResourceComponent implements EventCreationResource{
	
	public EventCreationResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveEventCreation(VMJExchange vmjExchange);
    public abstract EventCreation createEventCreation(VMJExchange vmjExchange);
	public abstract EventCreation createEventCreation(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateEventCreation(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getEventCreation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllEventCreation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteEventCreation(VMJExchange vmjExchange);

}
