package Event.report.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Report {
	    public int getReportId();
	    public void setReportId(int reportId);
	    public int getEventId();
	    public void setEventId(int eventId);
	    public int getTotalAttendee();
	    public void setTotalAttendee(int totalAttendee);
	    public int getTotalRevenue();
	    public void setTotalRevenue(int totalRevenue);
	    public String getSummary();
	    public void setSummary(String summary);
	HashMap<String, Object> toHashMap();
}
