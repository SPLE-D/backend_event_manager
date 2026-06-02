package Event.notification.targetednotification.service;

import java.util.*;

import Event.notification.NotificationFactory;
import Event.notification.core.model.Notification;
import Event.notification.core.model.NotificationComponent;
import Event.notification.core.service.NotificationServiceComponent;
import Event.notification.core.service.NotificationServiceDecorator;
import Event.notification.targetednotification.model.NotificationImpl;

public class NotificationServiceImpl extends NotificationServiceDecorator {
    public NotificationServiceImpl(NotificationServiceComponent record) {
        super(record);
    }

    public Notification createNotification(Map<String, Object> requestBody) {
        int target = Integer.parseInt((String) requestBody.get("target"));
        Notification baseNotification = record.createNotification(requestBody);

        Notification decoratedNotification = NotificationFactory.createNotification(
            "Event.notification.targetednotification.model.NotificationImpl",
            (NotificationComponent) baseNotification,
            target
        );

        Repository.saveObject(decoratedNotification);
        return decoratedNotification;
    }

    public Notification createNotification(Map<String, Object> requestBody, int id) {
        int target = Integer.parseInt((String) requestBody.get("target"));
        Notification baseNotification = record.createNotification(requestBody, id);

        Notification decoratedNotification = NotificationFactory.createNotification(
            "Event.notification.targetednotification.model.NotificationImpl",
            (NotificationComponent) baseNotification,
            target
        );

        Repository.saveObject(decoratedNotification);
        return decoratedNotification;
    }

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody) {
        int id = Integer.parseInt((String) requestBody.get("notifiationId"));
        NotificationImpl notification = getTargetedNotificationObjectById(id);

        notification.setContent((String) requestBody.get("content"));
        notification.setTarget(Integer.parseInt((String) requestBody.get("target")));

        Repository.updateObject(notification);
        return notification.toHashMap();
    }

    public HashMap<String, Object> getNotification(String idStr) {
        int id = Integer.parseInt(idStr);
        return getTargetedNotificationObjectById(id).toHashMap();
    }

    public HashMap<String, Object> getNotificationById(int id) {
        for (HashMap<String, Object> notification : getAllNotification()) {
            int recordId = ((Number) notification.get("notifiationId")).intValue();
            if (recordId == id) {
                return notification;
            }
        }
        return null;
    }

    public List<HashMap<String, Object>> getAllNotification() {
        List<Notification> list = Repository.getAllObject("notification_targetednotification");
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Notification> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (Notification notification : list) {
            resultList.add(notification.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteNotification(Map<String, Object> requestBody) {
        record.deleteNotification(requestBody);
        return getAllNotification();
    }

    private NotificationImpl getTargetedNotificationObjectById(int id) {
        List<Notification> list = Repository.getAllObject("notification_targetednotification");
        for (Notification notification : list) {
            if (notification.getNotifiationId() == id) {
                return (NotificationImpl) notification;
            }
        }
        throw new IllegalArgumentException("TargetedNotification not found for notifiationId: " + id);
    }
}
