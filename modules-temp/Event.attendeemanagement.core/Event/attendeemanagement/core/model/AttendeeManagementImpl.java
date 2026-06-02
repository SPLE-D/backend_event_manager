package Event.attendeemanagement.core.model;

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


@Entity(name="attendeemanagement_impl")
@Table(name="attendeemanagement_impl")
public class AttendeeManagementImpl extends AttendeeManagementComponent {

	public AttendeeManagementImpl(int attendeeId, String phoneNumber, String email) {
	    this.attendeeId = attendeeId;
	    this.phoneNumber = phoneNumber;
	    this.email = email;
	}

	public AttendeeManagementImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> attendeemanagementMap = new HashMap<String,Object>();
		attendeemanagementMap.put("attendeeId",getAttendeeId());
		attendeemanagementMap.put("phoneNumber",getPhoneNumber());
		attendeemanagementMap.put("email",getEmail());

        return attendeemanagementMap;
    }

}
