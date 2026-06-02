package Event.attendeemanagement.core.service;
import java.util.*;

import Event.attendeemanagement.core.model.AttendeeManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AttendeeManagementService {
	AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody);
	HashMap<String, Object> getAttendeeManagement(String idStr);
    HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllAttendeeManagement();
    List<HashMap<String,Object>> deleteAttendeeManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<AttendeeManagement> List);
}
