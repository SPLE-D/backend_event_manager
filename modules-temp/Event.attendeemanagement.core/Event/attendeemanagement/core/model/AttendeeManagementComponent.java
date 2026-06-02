package Event.attendeemanagement.core.model;

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
@Table(name="attendeemanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AttendeeManagementComponent implements AttendeeManagement{
	@Id
	protected int attendeeId; 
	protected int attendeeId;
	protected String phoneNumber;
	protected String email;
	protected int eventId;
	protected String objectName = AttendeeManagementComponent.class.getName();

	public AttendeeManagementComponent() {

	} 

	public AttendeeManagementComponent(
        int attendeeId, String phoneNumber, String email, int eventId
    ) {
        this.attendeeId = attendeeId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.eventId = eventId;
    }

	public int getAttendeeId() {
		return this.attendeeId;
	}

	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
 

	@Override
    public String toString() {
        return "{" +
            " attendeeId='" + getAttendeeId() + "'" +
            " phoneNumber='" + getPhoneNumber() + "'" +
            " email='" + getEmail() + "'" +
            " eventId='" + getEventId() + "'" +
            "}";
    }
	
}
