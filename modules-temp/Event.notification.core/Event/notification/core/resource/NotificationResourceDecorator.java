package Event.notification.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.notification.core.model.Notification;

public abstract class NotificationResourceDecorator extends NotificationResourceComponent{
	protected NotificationResourceComponent record;

    public NotificationResourceDecorator(NotificationResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange){
		return record.saveNotification(vmjExchange);
	}

    public Notification createNotification(VMJExchange vmjExchange){
		return record.createNotification(vmjExchange);
	}
	
	public Notification createNotification(VMJExchange vmjExchange, int id){
		return record.createNotification(vmjExchange, id);
	}

    public HashMap<String, Object> updateNotification(VMJExchange vmjExchange){
		return record.updateNotification(vmjExchange);
	}

    public HashMap<String, Object> getNotification(VMJExchange vmjExchange){
		return record.getNotification(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange){
		return record.getAllNotification(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange){
		return record.deleteNotification(vmjExchange);
	}

	public boolean sendNotification() {
		return record.sendNotification();
	}
}
