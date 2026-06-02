package Event.eventcreation.core.service;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.google.gson.Gson;

import Event.eventcreation.EventCreationFactory;
import Event.eventcreation.core.model.EventCreation;
import java.util.Date;

public class EventCreationServiceImpl extends EventCreationServiceComponent {

    public EventCreation createEventCreation(Map<String, Object> requestBody) {
        Random r = new Random();
        int eventId = Math.abs(r.nextInt());

        Date startDate = parseDate(requestBody.get("startDate"));
        Date endDate = parseDate(requestBody.get("endDate"));

        String capacityStr = (String) requestBody.get("capacity");
        int capacity = Integer.parseInt(capacityStr);

        String name = (String) requestBody.get("name");
        String location = (String) requestBody.get("location");

        validateEventCreationInput(startDate, endDate, capacity);

        EventCreation eventcreation = EventCreationFactory.createEventCreation(
            "Event.eventcreation.core.model.EventCreationImpl",
            eventId,
            startDate,
            endDate,
            capacity,
            name,
            location
        );

        Repository.saveObject(eventcreation);
        return eventcreation;
    }

    public EventCreation createEventCreation(Map<String, Object> requestBody, int id) {
        int eventId = id;

        Date startDate = parseDate(requestBody.get("startDate"));
        Date endDate = parseDate(requestBody.get("endDate"));

        String capacityStr = (String) requestBody.get("capacity");
        int capacity = Integer.parseInt(capacityStr);

        String name = (String) requestBody.get("name");
        String location = (String) requestBody.get("location");

        validateEventCreationInput(startDate, endDate, capacity);

        EventCreation eventcreation = EventCreationFactory.createEventCreation(
            "Event.eventcreation.core.model.EventCreationImpl",
            eventId,
            startDate,
            endDate,
            capacity,
            name,
            location
        );

        Repository.saveObject(eventcreation);
        return eventcreation;
    }

    public HashMap<String, Object> updateEventCreation(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("eventId");
        int id = Integer.parseInt(idStr);

        EventCreation eventcreation = Repository.getObject(id);

        Date startDate = parseDate(requestBody.get("startDate"));
        Date endDate = parseDate(requestBody.get("endDate"));

        String capacityStr = (String) requestBody.get("capacity");
        int capacity = Integer.parseInt(capacityStr);

        validateEventCreationInput(startDate, endDate, capacity);

        eventcreation.setStartDate(startDate);
        eventcreation.setEndDate(endDate);
        eventcreation.setCapacity(capacity);

        eventcreation.setName((String) requestBody.get("name"));
        eventcreation.setLocation((String) requestBody.get("location"));

        Repository.updateObject(eventcreation);

        return eventcreation.toHashMap();
    }

    public HashMap<String, Object> getEventCreation(String idStr) {
        int id = Integer.parseInt(idStr);
        EventCreation eventcreation = Repository.getObject(id);
        return eventcreation.toHashMap();
    }

    public HashMap<String, Object> getEventCreationById(int id) {
        List<HashMap<String, Object>> eventcreationList = getAllEventCreation();

        for (HashMap<String, Object> eventcreation : eventcreationList) {
            int recordId = ((Number) eventcreation.get("eventId")).intValue();

            if (recordId == id) {
                return eventcreation;
            }
        }

        return null;
    }

    public List<HashMap<String,Object>> getAllEventCreation() {
        List<EventCreation> list = Repository.getAllObject("eventcreation_impl");
        return transformListToHashMap(list);
    }

    public List<HashMap<String,Object>> transformListToHashMap(List<EventCreation> list) {
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();

        for (EventCreation eventcreation : list) {
            resultList.add(eventcreation.toHashMap());
        }

        return resultList;
    }

    public List<HashMap<String,Object>> deleteEventCreation(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("eventId");
        int id = Integer.parseInt(idStr);

        Repository.deleteObject(id);

        return getAllEventCreation();
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