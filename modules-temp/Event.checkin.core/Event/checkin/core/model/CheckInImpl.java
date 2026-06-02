package Event.checkin.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="checkin_impl")
@Table(name="checkin_impl")
public class CheckInImpl extends CheckInComponent {

	public CheckInImpl(int checkInId, boolean attended) {
	    this.checkInId = checkInId;
	    this.attended = attended;
	}

	public CheckInImpl() { }

	public int getCheckInId() {
		return this.checkInId;
	}

	public void setCheckInId(int checkInId) {
		this.checkInId = checkInId;
	}
	public boolean getAttended() {
		return this.attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public boolean checkIn() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> checkinMap = new HashMap<String,Object>();
		checkinMap.put("checkInId",getCheckInId());
		checkinMap.put("attended",getAttended());

        return checkinMap;
    }

}
