package Event.attendeemanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.attendeemanagement.core.model.AttendeeManagement;

public abstract class AttendeeManagementServiceDecorator extends AttendeeManagementServiceComponent{
	protected AttendeeManagementServiceComponent record;

    public AttendeeManagementServiceDecorator(AttendeeManagementServiceComponent record) {
        this.record = record;
    }

	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody){
		return record.createAttendeeManagement(requestBody);
	}
	
	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody, int id){
		return record.createAttendeeManagement(requestBody, id);
	}

	public HashMap<String, Object> getAttendeeManagement(String idStr){
		return record.getAttendeeManagement(idStr);
	}

	public List<HashMap<String,Object>> getAllAttendeeManagement(){
		return record.getAllAttendeeManagement();
	}

    public HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody){
		return record.updateAttendeeManagement(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AttendeeManagement> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAttendeeManagement(Map<String, Object> requestBody){
		return record.deleteAttendeeManagement(requestBody);
	}

	public HashMap<String, Object> getAttendeeManagementById(int id){
        return record.getAttendeeManagementById(id);
    }

}
