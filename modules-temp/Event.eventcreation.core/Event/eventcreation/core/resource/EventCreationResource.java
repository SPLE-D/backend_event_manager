package Event.eventcreation.core.resource;
import java.util.*;

import Event.eventcreation.core.model.EventCreation;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface EventCreationResource {
    List<HashMap<String,Object>> saveEventCreation(VMJExchange vmjExchange);
    HashMap<String, Object> updateEventCreation(VMJExchange vmjExchange);
    HashMap<String, Object> getEventCreation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllEventCreation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteEventCreation(VMJExchange vmjExchange);
}
