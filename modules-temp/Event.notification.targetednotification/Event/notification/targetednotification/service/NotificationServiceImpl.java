package Event.notification.targetednotification.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.notification.core.service.NotificationServiceDecorator;
import Event.notification.core.model.NotificationImpl;
import Event.notification.core.service.NotificationServiceComponent;
import Event.notification.core.model.Notification;
import Event.notification.core.model.NotificationDecorator;
import Event.notification.NotificationFactory;

public class NotificationServiceImpl extends NotificationServiceDecorator {
    public NotificationServiceImpl (NotificationServiceComponent record) {
        super(record);
    }

 	public Notification createNotification(Map<String, Object> requestBody){
		String targetStr = (String) requestBody.get("target");
		int target = Integer.parseInt(targetStr);
		String content = (String) requestBody.get("content");
		Notification notificationtargetednotification = record.createNotification(requestBody);
		Notification notificationtargetednotificationdeco = NotificationFactory.createNotification("Event.notification.targetednotification.model.NotificationImpl", notificationtargetednotification, target);
		Repository.saveObject(notificationtargetednotificationdeco);
		return notificationtargetednotificationdeco;
	}

	public Notification createNotification(Map<String, Object> requestBody, int id){
		Notification savedNotification = Repository.getObject(id);
		String targetStr = (String) requestBody.get("target");
		int target = Integer.parseInt(targetStr);
		UUID recordNotificationNotifiationId = ((NotificationDecorator) savedNotification).getNotifiationId();
		Notification notification = record.createNotification(requestBody, recordNotificationNotifiationId);
		Notification notificationtargetednotification = NotificationFactory.createNotification("Event.notification.targetednotification.NotificationImpl", notification, target);
		return notificationtargetednotification;
	}

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("notifiationId");
		
		Notification notificationtargetednotification = Repository.getObject(id);
		notificationtargetednotification = createNotification(requestBody, id);
		
		Repository.updateObject(notificationtargetednotification);
		notificationtargetednotification = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return notificationtargetednotification.toHashMap();
	}

	public HashMap<String, Object> getNotification(String idStr){
		int id = Integer.parseInt(idStr);
		Notification notificationtargetednotification = Repository.getObject(id);
		return notificationtargetednotification.toHashMap();
	}

	public HashMap<String, Object> getNotificationById(int id){
		List<HashMap<String, Object>> notificationList = getAllNotification();
		for (HashMap<String, Object> notification : notificationList){
			int notification_id = ((Double) notification.get("notifiationid")).intValue();
			if (notification_id == id){
				return notification;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllNotification(){
		List<Notification> List = Repository.getAllObject("notification_targetednotification");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notification> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteNotification(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("notifiationId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllNotification();
	}

	
}
