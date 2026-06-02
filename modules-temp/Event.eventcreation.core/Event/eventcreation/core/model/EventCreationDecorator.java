package Event.eventcreation.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class EventCreationDecorator extends EventCreationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected EventCreationComponent record;

	public EventCreationDecorator () {
		super();
		Random r = new Random();
		this.eventId = Math.abs(r.nextInt());
	}

	public EventCreationDecorator (int eventId, EventCreationComponent record) {
		this.eventId =  eventId;
		this.record = record;
	}
	
	public EventCreationDecorator (EventCreationComponent record, String objectName) {
		Random r = new Random();
		this.eventId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getEventId() {
		return record.getEventId();
	}
	public void setEventId(int eventId) {
		record.setEventId(eventId);
	}
	public EDate getStartDate() {
		return record.getStartDate();
	}
	public void setStartDate(EDate startDate) {
		record.setStartDate(startDate);
	}
	public EDate getEndDate() {
		return record.getEndDate();
	}
	public void setEndDate(EDate endDate) {
		record.setEndDate(endDate);
	}
	public int getCapacity() {
		return record.getCapacity();
	}
	public void setCapacity(int capacity) {
		record.setCapacity(capacity);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public String getLocation() {
		return record.getLocation();
	}
	public void setLocation(String location) {
		record.setLocation(location);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
