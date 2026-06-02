package Event.attendeemanagement.core.service;
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
import Event.attendeemanagement.AttendeeManagementFactory;
import Event.attendeemanagement.core.model.AttendeeManagement;
//add other required packages

public class AttendeeManagementServiceImpl extends AttendeeManagementServiceComponent{

	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody){
	    Random r = new Random();
	    int attendeeId = Math.abs(r.nextInt());

	    String phoneNumber = (String) requestBody.get("phoneNumber");
	    String email = (String) requestBody.get("email");

	    AttendeeManagement attendeemanagement = AttendeeManagementFactory.createAttendeeManagement(
	        "Event.attendeemanagement.core.model.AttendeeManagementImpl",
	        attendeeId,
	        phoneNumber,
	        email
	    );

	    Repository.saveObject(attendeemanagement);
	    return attendeemanagement;
	}

	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody, int id){
		int attendeeId = id;
		String phoneNumber = (String) requestBody.get("phoneNumber");
		String email = (String) requestBody.get("email");
		
		//to do: fix association attributes
		AttendeeManagement attendeemanagement = AttendeeManagementFactory.createAttendeeManagement("Event.attendeemanagement.core.model.AttendeeManagementImpl",attendeeId, phoneNumber, email);
		Repository.saveObject(attendeemanagement);
		return attendeemanagement;
	}

    public HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("attendeeId");
		int id = Integer.parseInt(idStr);
		AttendeeManagement attendeemanagement = Repository.getObject(id);
		
		attendeemanagement.setPhoneNumber((String) requestBody.get("phoneNumber"));
		attendeemanagement.setEmail((String) requestBody.get("email"));
		
		Repository.updateObject(attendeemanagement);
		
		//to do: fix association attributes
		
		return attendeemanagement.toHashMap();
		
	}

    public HashMap<String, Object> getAttendeeManagement(String idStr){
		int id = Integer.parseInt(idStr);
		AttendeeManagement attendeemanagement = Repository.getObject(id);
		return attendeemanagement.toHashMap();
	}

	public HashMap<String, Object> getAttendeeManagementById(int id){
		List<HashMap<String, Object>> attendeemanagementList = getAllAttendeeManagement();
		for (HashMap<String, Object> attendeemanagement : attendeemanagementList){
			int record_id = ((Number) attendeemanagement.get("attendeeId")).intValue();
			if (record_id == id){
				return attendeemanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAttendeeManagement(){
		List<AttendeeManagement> List = Repository.getAllObject("attendeemanagement_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AttendeeManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAttendeeManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("attendeeId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllAttendeeManagement();
	}

}
