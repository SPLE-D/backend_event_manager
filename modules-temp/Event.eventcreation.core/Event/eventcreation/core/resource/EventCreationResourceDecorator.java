package Event.eventcreation.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.eventcreation.core.model.EventCreation;

public abstract class EventCreationResourceDecorator extends EventCreationResourceComponent{
	protected EventCreationResourceComponent record;

    public EventCreationResourceDecorator(EventCreationResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveEventCreation(VMJExchange vmjExchange){
		return record.saveEventCreation(vmjExchange);
	}

    public EventCreation createEventCreation(VMJExchange vmjExchange){
		return record.createEventCreation(vmjExchange);
	}
	
	public EventCreation createEventCreation(VMJExchange vmjExchange, int id){
		return record.createEventCreation(vmjExchange, id);
	}

    public HashMap<String, Object> updateEventCreation(VMJExchange vmjExchange){
		return record.updateEventCreation(vmjExchange);
	}

    public HashMap<String, Object> getEventCreation(VMJExchange vmjExchange){
		return record.getEventCreation(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllEventCreation(VMJExchange vmjExchange){
		return record.getAllEventCreation(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteEventCreation(VMJExchange vmjExchange){
		return record.deleteEventCreation(vmjExchange);
	}

}
