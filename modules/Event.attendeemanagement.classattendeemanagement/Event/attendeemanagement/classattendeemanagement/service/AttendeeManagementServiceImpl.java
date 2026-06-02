package Event.attendeemanagement.classattendeemanagement.service;

import java.util.*;

import Event.attendeemanagement.AttendeeManagementFactory;
import Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl;
import Event.attendeemanagement.core.model.AttendeeManagement;
import Event.attendeemanagement.core.model.AttendeeManagementComponent;
import Event.attendeemanagement.core.service.AttendeeManagementServiceComponent;
import Event.attendeemanagement.core.service.AttendeeManagementServiceDecorator;

public class AttendeeManagementServiceImpl extends AttendeeManagementServiceDecorator {
    public AttendeeManagementServiceImpl(AttendeeManagementServiceComponent record) {
        super(record);
    }

    public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody) {
        String attendeeClass = (String) requestBody.get("attendeeClass");
        AttendeeManagement baseAttendeeManagement = record.createAttendeeManagement(requestBody);

        AttendeeManagement decoratedAttendeeManagement = AttendeeManagementFactory.createAttendeeManagement(
            "Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl",
            (AttendeeManagementComponent) baseAttendeeManagement,
            attendeeClass
        );

        Repository.saveObject(decoratedAttendeeManagement);
        return decoratedAttendeeManagement;
    }

    public AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody, int id) {
        String attendeeClass = (String) requestBody.get("attendeeClass");
        AttendeeManagement baseAttendeeManagement = record.createAttendeeManagement(requestBody, id);

        AttendeeManagement decoratedAttendeeManagement = AttendeeManagementFactory.createAttendeeManagement(
            "Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl",
            (AttendeeManagementComponent) baseAttendeeManagement,
            attendeeClass
        );

        Repository.saveObject(decoratedAttendeeManagement);
        return decoratedAttendeeManagement;
    }

    public HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody) {
        int id = Integer.parseInt((String) requestBody.get("attendeeId"));
        AttendeeManagementImpl attendeeManagement = getClassAttendeeManagementObjectById(id);

        attendeeManagement.setPhoneNumber((String) requestBody.get("phoneNumber"));
        attendeeManagement.setEmail((String) requestBody.get("email"));
        attendeeManagement.setAttendeeClass((String) requestBody.get("attendeeClass"));

        Repository.updateObject(attendeeManagement);
        return attendeeManagement.toHashMap();
    }

    public HashMap<String, Object> getAttendeeManagement(String idStr) {
        int id = Integer.parseInt(idStr);
        return getClassAttendeeManagementObjectById(id).toHashMap();
    }

    public HashMap<String, Object> getAttendeeManagementById(int id) {
        for (HashMap<String, Object> attendeeManagement : getAllAttendeeManagement()) {
            int recordId = ((Number) attendeeManagement.get("attendeeId")).intValue();
            if (recordId == id) {
                return attendeeManagement;
            }
        }
        return null;
    }

    public List<HashMap<String, Object>> getAllAttendeeManagement() {
        List<AttendeeManagement> list = Repository.getAllObject("attendeemanagement_classattendeemanagement");
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<AttendeeManagement> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (AttendeeManagement attendeeManagement : list) {
            resultList.add(attendeeManagement.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteAttendeeManagement(Map<String, Object> requestBody) {
        record.deleteAttendeeManagement(requestBody);
        return getAllAttendeeManagement();
    }

    private AttendeeManagementImpl getClassAttendeeManagementObjectById(int id) {
        List<AttendeeManagement> list = Repository.getAllObject("attendeemanagement_classattendeemanagement");
        for (AttendeeManagement attendeeManagement : list) {
            if (attendeeManagement.getAttendeeId() == id) {
                return (AttendeeManagementImpl) attendeeManagement;
            }
        }
        throw new IllegalArgumentException("ClassAttendeeManagement not found for attendeeId: " + id);
    }
}
