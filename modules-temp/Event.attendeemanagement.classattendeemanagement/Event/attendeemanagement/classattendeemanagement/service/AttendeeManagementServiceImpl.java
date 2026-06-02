package Event.attendeemanagement.classattendeemanagement.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.attendeemanagement.core.service.AttendeeManagementServiceDecorator;
import Event.attendeemanagement.core.model.AttendeeManagementImpl;
import Event.attendeemanagement.core.service.AttendeeManagementServiceComponent;
import Event.attendeemanagement.core.model.AttendeeManagement;
import Event.attendeemanagement.core.model.AttendeeManagementDecorator;
import Event.attendeemanagement.AttendeeManagementFactory;

public class AttendeeManagementServiceImpl extends AttendeeManagementServiceDecorator {
    public AttendeeManagementServiceImpl (AttendeeManagementServiceComponent record) {
        super(record);
    }

 	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody){
		String attendeeClass = (String) requestBody.get("attendeeClass");
		String phoneNumber = (String) requestBody.get("phoneNumber");
		String email = (String) requestBody.get("email");
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		AttendeeManagement attendeemanagementclassattendeemanagement = record.createAttendeeManagement(requestBody);
		AttendeeManagement attendeemanagementclassattendeemanagementdeco = AttendeeManagementFactory.createAttendeeManagement("Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl", attendeemanagementclassattendeemanagement, attendeeClass);
		Repository.saveObject(attendeemanagementclassattendeemanagementdeco);
		return attendeemanagementclassattendeemanagementdeco;
	}

	public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody, int id){
		AttendeeManagement savedAttendeeManagement = Repository.getObject(id);
		String attendeeClass = (String) requestBody.get("attendeeClass");
		UUID recordAttendeeManagementAttendeeId = ((AttendeeManagementDecorator) savedAttendeeManagement).getAttendeeId();
		AttendeeManagement attendeemanagement = record.createAttendeeManagement(requestBody, recordAttendeeManagementAttendeeId);
		AttendeeManagement attendeemanagementclassattendeemanagement = AttendeeManagementFactory.createAttendeeManagement("Event.attendeemanagement.classattendeemanagement.AttendeeManagementImpl", attendeemanagement, attendeeClass);
		return attendeemanagementclassattendeemanagement;
	}

    public HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("attendeeId");
		
		AttendeeManagement attendeemanagementclassattendeemanagement = Repository.getObject(id);
		attendeemanagementclassattendeemanagement = createAttendeeManagement(requestBody, id);
		
		Repository.updateObject(attendeemanagementclassattendeemanagement);
		attendeemanagementclassattendeemanagement = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return attendeemanagementclassattendeemanagement.toHashMap();
	}

	public HashMap<String, Object> getAttendeeManagement(String idStr){
		int id = Integer.parseInt(idStr);
		AttendeeManagement attendeemanagementclassattendeemanagement = Repository.getObject(id);
		return attendeemanagementclassattendeemanagement.toHashMap();
	}

	public HashMap<String, Object> getAttendeeManagementById(int id){
		List<HashMap<String, Object>> attendeemanagementList = getAllAttendeeManagement();
		for (HashMap<String, Object> attendeemanagement : attendeemanagementList){
			int attendeemanagement_id = ((Double) attendeemanagement.get("attendeeid")).intValue();
			if (attendeemanagement_id == id){
				return attendeemanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAttendeeManagement(){
		List<AttendeeManagement> List = Repository.getAllObject("attendeemanagement_classattendeemanagement");
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
