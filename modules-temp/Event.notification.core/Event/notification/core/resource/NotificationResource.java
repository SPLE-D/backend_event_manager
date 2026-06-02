package Event.notification.core.resource;
import java.util.*;

import Event.notification.core.model.Notification;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface NotificationResource {
    List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange);
    HashMap<String, Object> updateNotification(VMJExchange vmjExchange);
    HashMap<String, Object> getNotification(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange);
}
