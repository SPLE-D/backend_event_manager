package Event.eventcreation.typeeventcreation.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import Event.eventcreation.core.model.EventCreationDecorator;
import Event.eventcreation.core.model.EventCreationComponent;

@Entity(name="eventcreation_typeeventcreation")
@Table(name="eventcreation_typeeventcreation")
public class EventCreationImpl extends EventCreationDecorator {

    @Enumerated(EnumType.STRING)
    @Column(name = "eventtype")
    protected EventType eventType;

    public EventCreationImpl() {
        super();
        this.objectName = EventCreationImpl.class.getName();
    }

    public EventCreationImpl(EventCreationComponent record, EventType eventType) {
        super(record, EventCreationImpl.class.getName());
        this.eventType = eventType;
        this.objectName = EventCreationImpl.class.getName();
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("eventType", getEventType());
        return map;
    }
}