package Event.eventcreation.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface EventCreation {
	    public int getEventId();
	    public void setEventId(int eventId);
	    public EDate getStartDate();
	    public void setStartDate(EDate startDate);
	    public EDate getEndDate();
	    public void setEndDate(EDate endDate);
	    public int getCapacity();
	    public void setCapacity(int capacity);
	    public String getName();
	    public void setName(String name);
	    public String getLocation();
	    public void setLocation(String location);
	HashMap<String, Object> toHashMap();
}
