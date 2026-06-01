package Event.checkin.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface CheckIn {
	    public int getCheckInId();
	    public void setCheckInId(int checkInId);
	    public boolean getAttended();
	    public void setAttended(boolean attended);
	    public Integer getAttendeeId();
	    public void setAttendeeId(Integer attendeeId);
	    public String getTimestamp();
	    public void setTimestamp(String timestamp);
	HashMap<String, Object> toHashMap();
}
