package Event.eventcreation.core.model;

import java.util.*;
import java.lang.*;
import java.util.Date;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="eventcreation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EventCreationComponent implements EventCreation{
	@Id
	protected int eventId; 
	protected Date startDate;
	protected Date endDate;
	protected int capacity;
	protected String name;
	protected String location;
	protected String objectName = EventCreationComponent.class.getName();

	public EventCreationComponent() {

	} 

	public EventCreationComponent(
        int eventId, Date startDate, Date endDate, int capacity, String name, String location
    ) {
        this.eventId = eventId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.name = name;
        this.location = location;
    }

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
 

	@Override
    public String toString() {
        return "{" +
            " eventId='" + getEventId() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " capacity='" + getCapacity() + "'" +
            " name='" + getName() + "'" +
            " location='" + getLocation() + "'" +
            "}";
    }
	
}
