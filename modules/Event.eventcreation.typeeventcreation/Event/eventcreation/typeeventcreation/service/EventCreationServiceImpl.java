package Event.eventcreation.typeeventcreation.service;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import Event.eventcreation.core.service.EventCreationServiceDecorator;
import Event.eventcreation.core.service.EventCreationServiceComponent;
import Event.eventcreation.core.model.EventCreation;
import Event.eventcreation.core.model.EventCreationComponent;
import Event.eventcreation.EventCreationFactory;

import Event.eventcreation.typeeventcreation.model.EventType;
import Event.eventcreation.typeeventcreation.model.EventCreationImpl;

public class EventCreationServiceImpl extends EventCreationServiceDecorator {

    public EventCreationServiceImpl(EventCreationServiceComponent record) {
        super(record);
    }

    @Override
    public EventCreation createEventCreation(Map<String, Object> requestBody) {
        EventType eventType = parseEventType(requestBody.get("eventType"));

        EventCreation baseEventCreation = record.createEventCreation(requestBody);

        EventCreation decoratedEventCreation = EventCreationFactory.createEventCreation(
            "Event.eventcreation.typeeventcreation.model.EventCreationImpl",
            (EventCreationComponent) baseEventCreation,
            eventType
        );

        Repository.saveObject(decoratedEventCreation);
        return decoratedEventCreation;
    }

    @Override
    public EventCreation createEventCreation(Map<String, Object> requestBody, int id) {
        EventType eventType = parseEventType(requestBody.get("eventType"));

        EventCreation baseEventCreation = record.createEventCreation(requestBody, id);

        EventCreation decoratedEventCreation = EventCreationFactory.createEventCreation(
            "Event.eventcreation.typeeventcreation.model.EventCreationImpl",
            (EventCreationComponent) baseEventCreation,
            eventType
        );

        Repository.saveObject(decoratedEventCreation);
        return decoratedEventCreation;
    }

    @Override
    public HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("eventId");
        int id = Integer.parseInt(idStr);

        EventCreationImpl eventCreation = getTypeEventCreationObjectById(id);

        Date startDate = parseDate(requestBody.get("startDate"));
        Date endDate = parseDate(requestBody.get("endDate"));

        String capacityStr = (String) requestBody.get("capacity");
        int capacity = Integer.parseInt(capacityStr);

        validateEventCreationInput(startDate, endDate, capacity);

        eventCreation.setStartDate(startDate);
        eventCreation.setEndDate(endDate);
        eventCreation.setCapacity(capacity);

        eventCreation.setName((String) requestBody.get("name"));
        eventCreation.setLocation((String) requestBody.get("location"));

        EventType eventType = parseEventType(requestBody.get("eventType"));
        eventCreation.setEventType(eventType);

        Repository.updateObject(eventCreation);

        return eventCreation.toHashMap();
    }

    @Override
    public HashMap<String, Object> getEventCreation(String idStr) {
        int id = Integer.parseInt(idStr);
        EventCreationImpl eventCreation = getTypeEventCreationObjectById(id);
        return eventCreation.toHashMap();
    }

    @Override
    public HashMap<String, Object> getEventCreationById(int id) {
        List<HashMap<String, Object>> eventCreationList = getAllEventCreation();

        for (HashMap<String, Object> eventCreation : eventCreationList) {
            int recordId = ((Number) eventCreation.get("eventId")).intValue();

            if (recordId == id) {
                return eventCreation;
            }
        }

        return null;
    }

    @Override
    public List<HashMap<String, Object>> getAllEventCreation() {
        List<EventCreation> list = Repository.getAllObject("eventcreation_typeeventcreation");
        return transformListToHashMap(list);
    }

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<EventCreation> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();

        for (EventCreation eventCreation : list) {
            resultList.add(eventCreation.toHashMap());
        }

        return resultList;
    }

    @Override
    public List<HashMap<String, Object>> deleteEventCreation(Map<String, Object> requestBody) {
        /*
         * Dengan FK ON DELETE CASCADE, cukup delete core.
         * Child/delta row akan ikut terhapus.
         */
        record.deleteEventCreation(requestBody);

        return getAllEventCreation();
    }

    private EventCreationImpl getTypeEventCreationObjectById(int id) {
        List<EventCreation> list = Repository.getAllObject("eventcreation_typeeventcreation");

        for (EventCreation eventCreation : list) {
            if (eventCreation.getEventId() == id) {
                return (EventCreationImpl) eventCreation;
            }
        }

        throw new IllegalArgumentException("TypeEventCreation not found for eventId: " + id);
    }

    private EventType parseEventType(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("eventType is required");
        }

        if (value instanceof EventType) {
            return (EventType) value;
        }

        if (value instanceof String) {
            return EventType.valueOf(((String) value).toUpperCase());
        }

        throw new IllegalArgumentException("Invalid eventType value: " + value);
    }

    private Date parseDate(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Date value is required");
        }

        if (value instanceof Date) {
            return (Date) value;
        }

        if (value instanceof String) {
            String dateStr = (String) value;

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                formatter.setLenient(false);
                return formatter.parse(dateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd");
            }
        }

        throw new IllegalArgumentException("Invalid date value: " + value);
    }

    private void validateEventCreationInput(Date startDate, Date endDate, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be greater than or equal to 0");
        }

        if (!startDate.before(endDate)) {
            throw new IllegalArgumentException("startDate must be before endDate");
        }
       }
    }