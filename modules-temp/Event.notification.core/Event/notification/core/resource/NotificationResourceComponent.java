package Event.notification.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.notification.core.model.Notification;
//add other required packages

public abstract class NotificationResourceComponent implements NotificationResource{
	
	public NotificationResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange);
    public abstract Notification createNotification(VMJExchange vmjExchange);
	public abstract Notification createNotification(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateNotification(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getNotification(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange);

	public abstract boolean sendNotification();
}
