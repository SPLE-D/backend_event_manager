package Event.checkin.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="checkin_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CheckInComponent implements CheckIn{
	@Id
	protected int checkInId; 
	protected int checkInId;
	protected boolean attended;
	protected int attendeeId;
	protected String objectName = CheckInComponent.class.getName();

	public CheckInComponent() {

	} 

	public CheckInComponent(
        int checkInId, boolean attended, int attendeeId
    ) {
        this.checkInId = checkInId;
        this.attended = attended;
        this.attendeeId = attendeeId;
    }

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
	public int getAttendeeId() {
		return this.attendeeId;
	}

	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
 
	public abstract boolean checkIn();

	@Override
    public String toString() {
        return "{" +
            " checkInId='" + getCheckInId() + "'" +
            " attended='" + getAttended() + "'" +
            " attendeeId='" + getAttendeeId() + "'" +
            "}";
    }
	
}
