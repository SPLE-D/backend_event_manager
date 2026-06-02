package Event.checkin.timestampcheckin.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.checkin.core.service.CheckInServiceDecorator;
import Event.checkin.core.model.CheckInImpl;
import Event.checkin.core.service.CheckInServiceComponent;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInDecorator;
import Event.checkin.CheckInFactory;

public class CheckInServiceImpl extends CheckInServiceDecorator {
    public CheckInServiceImpl (CheckInServiceComponent record) {
        super(record);
    }

 	public CheckIn createCheckIn(Map<String, Object> requestBody){
		boolean attended = (boolean) requestBody.get("attended");
		String attendeeIdStr = (String) requestBody.get("attendeeId");
		int attendeeId = Integer.parseInt(attendeeIdStr);
		CheckIn checkintimestampcheckin = record.createCheckIn(requestBody);
		CheckIn checkintimestampcheckindeco = CheckInFactory.createCheckIn("Event.checkin.timestampcheckin.model.CheckInImpl", checkintimestampcheckin, timestamp);
		Repository.saveObject(checkintimestampcheckindeco);
		return checkintimestampcheckindeco;
	}

	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
		CheckIn savedCheckIn = Repository.getObject(id);
		UUID recordCheckInCheckInId = ((CheckInDecorator) savedCheckIn).getCheckInId();
		CheckIn checkin = record.createCheckIn(requestBody, recordCheckInCheckInId);
		CheckIn checkintimestampcheckin = CheckInFactory.createCheckIn("Event.checkin.timestampcheckin.CheckInImpl", checkin, timestamp);
		return checkintimestampcheckin;
	}

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("checkInId");
		
		CheckIn checkintimestampcheckin = Repository.getObject(id);
		checkintimestampcheckin = createCheckIn(requestBody, id);
		
		Repository.updateObject(checkintimestampcheckin);
		checkintimestampcheckin = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return checkintimestampcheckin.toHashMap();
	}

	public HashMap<String, Object> getCheckIn(String idStr){
		int id = Integer.parseInt(idStr);
		CheckIn checkintimestampcheckin = Repository.getObject(id);
		return checkintimestampcheckin.toHashMap();
	}

	public HashMap<String, Object> getCheckInById(int id){
		List<HashMap<String, Object>> checkinList = getAllCheckIn();
		for (HashMap<String, Object> checkin : checkinList){
			int checkin_id = ((Double) checkin.get("checkinid")).intValue();
			if (checkin_id == id){
				return checkin;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCheckIn(){
		List<CheckIn> List = Repository.getAllObject("checkin_timestampcheckin");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CheckIn> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("checkInId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCheckIn();
	}

	
}
