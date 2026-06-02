package Event.checkin.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.checkin.core.model.CheckIn;

public abstract class CheckInServiceDecorator extends CheckInServiceComponent{
	protected CheckInServiceComponent record;

    public CheckInServiceDecorator(CheckInServiceComponent record) {
        this.record = record;
    }

	public CheckIn createCheckIn(Map<String, Object> requestBody){
		return record.createCheckIn(requestBody);
	}
	
	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
		return record.createCheckIn(requestBody, id);
	}

	public HashMap<String, Object> getCheckIn(String idStr){
		return record.getCheckIn(idStr);
	}

	public List<HashMap<String,Object>> getAllCheckIn(){
		return record.getAllCheckIn();
	}

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
		return record.updateCheckIn(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CheckIn> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody){
		return record.deleteCheckIn(requestBody);
	}

	public HashMap<String, Object> getCheckInById(int id){
        return record.getCheckInById(id);
    }

	public boolean checkIn() {
		return record.checkIn();
	}
}
