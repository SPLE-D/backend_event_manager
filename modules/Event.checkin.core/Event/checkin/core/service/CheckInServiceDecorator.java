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
	
	public CheckIn createTimeStampCheckIn(Map<String, Object> requestBody){
		return record.createTimeStampCheckIn(requestBody);
	}
	
	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
		return record.createCheckIn(requestBody, id);
	}

	public HashMap<String, Object> getCheckIn(String idStr){
		return record.getCheckIn(idStr);
	}

	public HashMap<String, Object> getTimeStampCheckIn(String idStr){
		return record.getTimeStampCheckIn(idStr);
	}

	public List<HashMap<String,Object>> getAllCheckIn(){
		return record.getAllCheckIn();
	}

	public List<HashMap<String,Object>> getAllTimeStampCheckIn(){
		return record.getAllTimeStampCheckIn();
	}

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
		return record.updateCheckIn(requestBody);
	}

    public HashMap<String, Object> updateTimeStampCheckIn(Map<String, Object> requestBody){
		return record.updateTimeStampCheckIn(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CheckIn> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody){
		return record.deleteCheckIn(requestBody);
	}

    public List<HashMap<String,Object>> deleteTimeStampCheckIn(Map<String, Object> requestBody){
		return record.deleteTimeStampCheckIn(requestBody);
	}

	public HashMap<String, Object> getCheckInById(int id){
        return record.getCheckInById(id);
    }

	public boolean checkIn() {
		return record.checkIn();
	}
}
