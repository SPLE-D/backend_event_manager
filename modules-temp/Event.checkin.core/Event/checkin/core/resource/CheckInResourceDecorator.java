package Event.checkin.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.checkin.core.model.CheckIn;

public abstract class CheckInResourceDecorator extends CheckInResourceComponent{
	protected CheckInResourceComponent record;

    public CheckInResourceDecorator(CheckInResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange){
		return record.saveCheckIn(vmjExchange);
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange){
		return record.createCheckIn(vmjExchange);
	}
	
	public CheckIn createCheckIn(VMJExchange vmjExchange, int id){
		return record.createCheckIn(vmjExchange, id);
	}

    public HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange){
		return record.updateCheckIn(vmjExchange);
	}

    public HashMap<String, Object> getCheckIn(VMJExchange vmjExchange){
		return record.getCheckIn(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange){
		return record.getAllCheckIn(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange){
		return record.deleteCheckIn(vmjExchange);
	}

	public boolean checkIn() {
		return record.checkIn();
	}
}
