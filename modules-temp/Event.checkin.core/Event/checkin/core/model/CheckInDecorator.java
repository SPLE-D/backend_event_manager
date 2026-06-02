package Event.checkin.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CheckInDecorator extends CheckInComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CheckInComponent record;

	public CheckInDecorator () {
		super();
		Random r = new Random();
		this.checkInId = Math.abs(r.nextInt());
	}

	public CheckInDecorator (int checkInId, CheckInComponent record) {
		this.checkInId =  checkInId;
		this.record = record;
	}
	
	public CheckInDecorator (CheckInComponent record, String objectName) {
		Random r = new Random();
		this.checkInId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getCheckInId() {
		return record.getCheckInId();
	}
	public void setCheckInId(int checkInId) {
		record.setCheckInId(checkInId);
	}
	public boolean getAttended() {
		return record.getAttended();
	}
	public void setAttended(boolean attended) {
		record.setAttended(attended);
	}

	public boolean checkIn() {
		return record.checkIn();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
