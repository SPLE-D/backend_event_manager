package Event.attendeemanagement.classattendeemanagement.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.attendeemanagement.core.model.AttendeeManagementDecorator;
import Event.attendeemanagement.core.model.AttendeeManagementComponent;

@Entity(name="attendeemanagement_classattendeemanagement")
@Table(name="attendeemanagement_classattendeemanagement")
public class AttendeeManagementImpl extends AttendeeManagementDecorator {

	protected String attendeeClass;
	public AttendeeManagementImpl() {
        super();
        this.objectName = AttendeeManagementImpl.class.getName();
    }

	public AttendeeManagementImpl(AttendeeManagementComponent record, String attendeeClass) {
		super(record, AttendeeManagementImpl.class.getName());
		this.attendeeClass = attendeeClass;
		this.objectName = AttendeeManagementImpl.class.getName();
	}

	public String getAttendeeClass() {
		return this.attendeeClass;
	}

	public void setAttendeeClass(String attendeeClass) {
		this.attendeeClass = attendeeClass;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
		map.put("attendeeClass", getAttendeeClass());

        return map;
    }

}
