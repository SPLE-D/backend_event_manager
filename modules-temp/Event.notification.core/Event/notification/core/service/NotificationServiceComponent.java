package Event.notification.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.notification.core.model.Notification;
//add other required packages

public abstract class NotificationServiceComponent implements NotificationService{
	protected RepositoryUtil<Notification> Repository;

    public NotificationServiceComponent(){
        this.Repository = new RepositoryUtil<Notification>(Event.notification.core.model.NotificationComponent.class);
    }	

    public abstract Notification createNotification(Map<String, Object> requestBody);
	public abstract Notification createNotification(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateNotification(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getNotification(String idStr);
    public abstract List<HashMap<String,Object>> getAllNotification();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Notification> List);
    public abstract List<HashMap<String,Object>> deleteNotification(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getNotificationById(int id);

	public abstract boolean sendNotification();
}
