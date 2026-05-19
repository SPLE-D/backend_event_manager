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

	    boolean attended = parseBooleanValue(requestBody.get("attended"));

	    CheckIn checkin = CheckInFactory.createCheckIn(
	        "Event.checkin.core.model.CheckInImpl",
	        checkInId,
	        attended
	    );

	    Repository.saveObject(checkin);
	    return checkin;
	}

	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
	    int checkInId = id;
	    boolean attended = parseBooleanValue(requestBody.get("attended"));

	    CheckIn checkin = CheckInFactory.createCheckIn(
	        "Event.checkin.core.model.CheckInImpl",
	        checkInId,
	        attended
	    );

	    Repository.saveObject(checkin);
	    return checkin;
	}

	public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
	    String idStr = (String) requestBody.get("checkInId");
	    int id = Integer.parseInt(idStr);
	    CheckIn checkin = Repository.getObject(id);

	    checkin.setAttended(parseBooleanValue(requestBody.get("attended")));

	    Repository.updateObject(checkin);

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
	
	private boolean parseBooleanValue(Object value) {
	    if (value instanceof Boolean) {
	        return (Boolean) value;
	    }

	    if (value instanceof String) {
	        return Boolean.parseBoolean((String) value);
	    }

	    throw new IllegalArgumentException("Invalid boolean value for attended: " + value);
	}
	
}
