package Event.eventcreation.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;
import java.util.Date;

public interface EventCreation {
	    public int getEventId();
	    public void setEventId(int eventId);
	    public Date getStartDate();
	    public void setStartDate(Date startDate);
	    public Date getEndDate();
	    public void setEndDate(Date endDate);
	    public int getCapacity();
	    public void setCapacity(int capacity);
	    public String getName();
	    public void setName(String name);
	    public String getLocation();
	    public void setLocation(String location);
	HashMap<String, Object> toHashMap();
}
