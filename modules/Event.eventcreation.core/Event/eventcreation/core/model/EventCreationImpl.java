package Event.eventcreation.core.model;

import java.util.HashMap;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="eventcreation_impl")
@Table(name="eventcreation_impl")
public class EventCreationImpl extends EventCreationComponent {

    public EventCreationImpl(
        int eventId,
        Date startDate,
        Date endDate,
        int capacity,
        String name,
        String location
    ) {
        this.eventId = eventId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.name = name;
        this.location = location;
    }

    public EventCreationImpl() { }

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

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> eventcreationMap = new HashMap<String,Object>();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

        eventcreationMap.put("eventId", getEventId());
        eventcreationMap.put("startDate", getStartDate() != null ? formatter.format(getStartDate()) : null);
        eventcreationMap.put("endDate", getEndDate() != null ? formatter.format(getEndDate()) : null);
        eventcreationMap.put("capacity", getCapacity());
        eventcreationMap.put("name", getName());
        eventcreationMap.put("location", getLocation());

        return eventcreationMap;
    }
}