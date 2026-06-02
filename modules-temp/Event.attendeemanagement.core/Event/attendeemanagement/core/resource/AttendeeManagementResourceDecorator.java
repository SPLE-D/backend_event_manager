package Event.attendeemanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.attendeemanagement.core.model.AttendeeManagement;

public abstract class AttendeeManagementResourceDecorator extends AttendeeManagementResourceComponent{
	protected AttendeeManagementResourceComponent record;

    public AttendeeManagementResourceDecorator(AttendeeManagementResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveAttendeeManagement(VMJExchange vmjExchange){
		return record.saveAttendeeManagement(vmjExchange);
	}

    public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange){
		return record.createAttendeeManagement(vmjExchange);
	}
	
	public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange, int id){
		return record.createAttendeeManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateAttendeeManagement(VMJExchange vmjExchange){
		return record.updateAttendeeManagement(vmjExchange);
	}

    public HashMap<String, Object> getAttendeeManagement(VMJExchange vmjExchange){
		return record.getAttendeeManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAttendeeManagement(VMJExchange vmjExchange){
		return record.getAllAttendeeManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAttendeeManagement(VMJExchange vmjExchange){
		return record.deleteAttendeeManagement(vmjExchange);
	}

}
