package Event.attendeemanagement.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AttendeeManagementDecorator extends AttendeeManagementComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AttendeeManagementComponent record;

	public AttendeeManagementDecorator () {
		super();
		Random r = new Random();
		this.attendeeId = Math.abs(r.nextInt());
	}

	public AttendeeManagementDecorator (int attendeeId, AttendeeManagementComponent record) {
		this.attendeeId =  attendeeId;
		this.record = record;
	}
	
	public AttendeeManagementDecorator (AttendeeManagementComponent record, String objectName) {
		Random r = new Random();
		this.attendeeId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getAttendeeId() {
		return record.getAttendeeId();
	}
	public void setAttendeeId(int attendeeId) {
		record.setAttendeeId(attendeeId);
	}
	public String getPhoneNumber() {
		return record.getPhoneNumber();
	}
	public void setPhoneNumber(String phoneNumber) {
		record.setPhoneNumber(phoneNumber);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
