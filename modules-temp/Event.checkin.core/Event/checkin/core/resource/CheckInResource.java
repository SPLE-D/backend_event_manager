package Event.checkin.core.resource;
import java.util.*;

import Event.checkin.core.model.CheckIn;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CheckInResource {
    List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange);
    HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange);
    HashMap<String, Object> getCheckIn(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange);
}
