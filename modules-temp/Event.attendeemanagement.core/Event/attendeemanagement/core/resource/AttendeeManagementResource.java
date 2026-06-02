package Event.attendeemanagement.core.resource;
import java.util.*;

import Event.attendeemanagement.core.model.AttendeeManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AttendeeManagementResource {
    List<HashMap<String,Object>> saveAttendeeManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateAttendeeManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getAttendeeManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAttendeeManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAttendeeManagement(VMJExchange vmjExchange);
}
