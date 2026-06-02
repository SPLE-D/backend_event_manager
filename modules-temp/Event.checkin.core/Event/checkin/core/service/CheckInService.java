package Event.checkin.core.service;
import java.util.*;

import Event.checkin.core.model.CheckIn;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CheckInService {
	CheckIn createCheckIn(Map<String, Object> requestBody);
	HashMap<String, Object> getCheckIn(String idStr);
    HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllCheckIn();
    List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<CheckIn> List);
}
