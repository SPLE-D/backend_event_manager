package Event.checkin.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.checkin.core.model.CheckIn;
//add other required packages

public abstract class CheckInResourceComponent implements CheckInResource{
	
	public CheckInResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange);
    public abstract CheckIn createCheckIn(VMJExchange vmjExchange);
	public abstract CheckIn createCheckIn(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCheckIn(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange);

	public abstract boolean checkIn();
}
