package Event.checkin.timestampcheckin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Event.checkin.CheckInFactory;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInComponent;
import Event.checkin.core.service.CheckInServiceComponent;
import Event.checkin.core.service.CheckInServiceDecorator;
import Event.checkin.timestampcheckin.model.CheckInImpl;

public class CheckInServiceImpl extends CheckInServiceDecorator {
    public CheckInServiceImpl(CheckInServiceComponent record) {
        super(record);
    }

    public CheckIn createCheckIn(Map<String, Object> requestBody) {
        Date timestamp = parseTimestamp(requestBody.get("timestamp"));
        CheckIn baseCheckIn = record.createCheckIn(requestBody);

        CheckIn decoratedCheckIn = CheckInFactory.createCheckIn(
            "Event.checkin.timestampcheckin.model.CheckInImpl",
            (CheckInComponent) baseCheckIn,
            timestamp
        );

        Repository.saveObject(decoratedCheckIn);
        return decoratedCheckIn;
    }

    public CheckIn createCheckIn(Map<String, Object> requestBody, int id) {
        Date timestamp = parseTimestamp(requestBody.get("timestamp"));
        CheckIn baseCheckIn = record.createCheckIn(requestBody, id);

        CheckIn decoratedCheckIn = CheckInFactory.createCheckIn(
            "Event.checkin.timestampcheckin.model.CheckInImpl",
            (CheckInComponent) baseCheckIn,
            timestamp
        );

        Repository.saveObject(decoratedCheckIn);
        return decoratedCheckIn;
    }

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody) {
        int id = Integer.parseInt((String) requestBody.get("checkInId"));
        CheckInImpl checkIn = getTimestampCheckInObjectById(id);

        checkIn.setAttended(parseBooleanValue(requestBody.get("attended")));
        checkIn.setTimestamp(parseTimestamp(requestBody.get("timestamp")));

        Repository.updateObject(checkIn);
        return checkIn.toHashMap();
    }

    public HashMap<String, Object> getCheckIn(String idStr) {
        int id = Integer.parseInt(idStr);
        return getTimestampCheckInObjectById(id).toHashMap();
    }

    public HashMap<String, Object> getCheckInById(int id) {
        for (HashMap<String, Object> checkIn : getAllCheckIn()) {
            int recordId = ((Number) checkIn.get("checkInId")).intValue();
            if (recordId == id) {
                return checkIn;
            }
        }
        return null;
    }

    public List<HashMap<String, Object>> getAllCheckIn() {
        List<CheckIn> list = Repository.getAllObject("checkin_timestampcheckin");
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<CheckIn> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (CheckIn checkIn : list) {
            resultList.add(checkIn.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteCheckIn(Map<String, Object> requestBody) {
        record.deleteCheckIn(requestBody);
        return getAllCheckIn();
    }

    private CheckInImpl getTimestampCheckInObjectById(int id) {
        List<CheckIn> list = Repository.getAllObject("checkin_timestampcheckin");
        for (CheckIn checkIn : list) {
            if (checkIn.getCheckInId() == id) {
                return (CheckInImpl) checkIn;
            }
        }
        throw new IllegalArgumentException("TimestampCheckIn not found for checkInId: " + id);
    }

    private Date parseTimestamp(Object value) {
        if (value == null) {
            return new Date();
        }
        if (value instanceof Date) {
            return (Date) value;
        }
        if (value instanceof String) {
            String dateStr = (String) value;
            List<String> patterns = Arrays.asList("yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            for (String pattern : patterns) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
                    formatter.setLenient(false);
                    return formatter.parse(dateStr);
                } catch (ParseException ignored) {
                }
            }
        }
        throw new IllegalArgumentException("Invalid timestamp value: " + value);
    }

    private boolean parseBooleanValue(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof String) {
            return Boolean.parseBoolean((String) value);
        }
        throw new IllegalArgumentException("Invalid boolean value for attended: " + value);
    }
}
