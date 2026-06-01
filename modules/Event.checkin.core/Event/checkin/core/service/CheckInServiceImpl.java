package Event.checkin.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.checkin.CheckInFactory;
import Event.checkin.core.model.CheckIn;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class CheckInServiceImpl extends CheckInServiceComponent{

	public CheckIn createCheckIn(Map<String, Object> requestBody){
	    Random r = new Random();
	    int checkInId = Math.abs(r.nextInt());

	    boolean attended = false;
	    if (requestBody.get("attended") != null) {
	        if (requestBody.get("attended") instanceof Boolean) {
	            attended = (boolean) requestBody.get("attended");
	        } else {
	            attended = Boolean.parseBoolean(requestBody.get("attended").toString());
	        }
	    }

	    Integer attendeeId = null;
	    if (requestBody.get("attendeeId") != null) {
	        try {
	            if (requestBody.get("attendeeId") instanceof Number) {
	                attendeeId = ((Number) requestBody.get("attendeeId")).intValue();
	            } else {
	                attendeeId = Integer.parseInt(requestBody.get("attendeeId").toString());
	            }
	        } catch (Exception e) {
	            // Ignore
	        }
	    }

	    String timestamp = requestBody.get("timestamp") != null ? requestBody.get("timestamp").toString() : null;

	    CheckIn checkin = CheckInFactory.createCheckIn(
	        "Event.checkin.core.model.CheckInImpl",
	        checkInId,
	        attended,
	        attendeeId,
	        timestamp
	    );

	    Repository.saveObject(checkin);
	    return checkin;
	}

	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
		int checkInId = id;
		boolean attended = false;
	    if (requestBody.get("attended") != null) {
	        if (requestBody.get("attended") instanceof Boolean) {
	            attended = (boolean) requestBody.get("attended");
	        } else {
	            attended = Boolean.parseBoolean(requestBody.get("attended").toString());
	        }
	    }
		
		Integer attendeeId = null;
	    if (requestBody.get("attendeeId") != null) {
	        try {
	            if (requestBody.get("attendeeId") instanceof Number) {
	                attendeeId = ((Number) requestBody.get("attendeeId")).intValue();
	            } else {
	                attendeeId = Integer.parseInt(requestBody.get("attendeeId").toString());
	            }
	        } catch (Exception e) {
	            // Ignore
	        }
	    }

	    String timestamp = requestBody.get("timestamp") != null ? requestBody.get("timestamp").toString() : null;
		
		//to do: fix association attributes
		CheckIn checkin = CheckInFactory.createCheckIn("Event.checkin.core.model.CheckInImpl",checkInId, attended, attendeeId, timestamp);
		Repository.saveObject(checkin);
		return checkin;
	}

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("checkInId");
		int id = Integer.parseInt(idStr);
		CheckIn checkin = Repository.getObject(id);
		
		boolean attended = false;
	    if (requestBody.get("attended") != null) {
	        if (requestBody.get("attended") instanceof Boolean) {
	            attended = (boolean) requestBody.get("attended");
	        } else {
	            attended = Boolean.parseBoolean(requestBody.get("attended").toString());
	        }
	    }
		checkin.setAttended(attended);

		Integer attendeeId = null;
	    if (requestBody.get("attendeeId") != null) {
	        try {
	            if (requestBody.get("attendeeId") instanceof Number) {
	                attendeeId = ((Number) requestBody.get("attendeeId")).intValue();
	            } else {
	                attendeeId = Integer.parseInt(requestBody.get("attendeeId").toString());
	            }
	        } catch (Exception e) {
	            // Ignore
	        }
	    }
	    checkin.setAttendeeId(attendeeId);

	    String timestamp = requestBody.get("timestamp") != null ? requestBody.get("timestamp").toString() : null;
	    checkin.setTimestamp(timestamp);
		
		Repository.updateObject(checkin);
		
		//to do: fix association attributes
		
		return checkin.toHashMap();
		
	}

    public HashMap<String, Object> getCheckIn(String idStr){
		int id = Integer.parseInt(idStr);
		CheckIn checkin = Repository.getObject(id);
		return checkin.toHashMap();
	}

	public HashMap<String, Object> getCheckInById(int id){
		List<HashMap<String, Object>> checkinList = getAllCheckIn();
		for (HashMap<String, Object> checkin : checkinList){
			int record_id = ((Number) checkin.get("checkInId")).intValue();
			if (record_id == id){
				return checkin;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCheckIn(){
		List<CheckIn> List = Repository.getAllObject("checkin_impl");
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

	public boolean checkIn() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
