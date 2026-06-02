package Event.notification.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.notification.core.model.Notification;

public abstract class NotificationServiceDecorator extends NotificationServiceComponent{
	protected NotificationServiceComponent record;

    public NotificationServiceDecorator(NotificationServiceComponent record) {
        this.record = record;
    }

	public Notification createNotification(Map<String, Object> requestBody){
		return record.createNotification(requestBody);
	}
	
	public Notification createNotification(Map<String, Object> requestBody, int id){
		return record.createNotification(requestBody, id);
	}

	public HashMap<String, Object> getNotification(String idStr){
		return record.getNotification(idStr);
	}

	public List<HashMap<String,Object>> getAllNotification(){
		return record.getAllNotification();
	}

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody){
		return record.updateNotification(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notification> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteNotification(Map<String, Object> requestBody){
		return record.deleteNotification(requestBody);
	}

	public HashMap<String, Object> getNotificationById(int id){
        return record.getNotificationById(id);
    }

	public boolean sendNotification() {
		return record.sendNotification();
	}
}
