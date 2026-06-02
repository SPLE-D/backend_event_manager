package Event.attendeemanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.attendeemanagement.core.model.AttendeeManagement;
//add other required packages

public abstract class AttendeeManagementResourceComponent implements AttendeeManagementResource{
	
	public AttendeeManagementResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveAttendeeManagement(VMJExchange vmjExchange);
    public abstract AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange);
	public abstract AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateAttendeeManagement(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAttendeeManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAttendeeManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAttendeeManagement(VMJExchange vmjExchange);

}
