package Event.notification.targetednotification.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.notification.core.resource.NotificationResourceDecorator;
import Event.notification.core.resource.NotificationResourceComponent;
import Event.notification.core.model.Notification;
import Event.notification.core.model.NotificationImpl;
import Event.notification.core.service.NotificationServiceComponent;
import Event.notification.targetednotification.service.NotificationServiceImpl;

public class NotificationResourceImpl extends NotificationResourceDecorator {
	private NotificationServiceComponent notificationtargetednotificationServiceImpl;

    public NotificationResourceImpl (NotificationResourceComponent record, NotificationServiceComponent recordService) {
        super(record);
		this.notificationtargetednotificationServiceImpl = new NotificationServiceImpl(recordService);
    }

    
    @Route(url="call/targetednotification/save")
    public List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notification notificationtargetednotification = createNotification(vmjExchange);
		return getAllNotification(vmjExchange);
	}

    public Notification createNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationtargetednotificationServiceImpl.createNotification(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Notification createNotification(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationtargetednotificationServiceImpl.createNotification(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/targetednotification/update")
    public HashMap<String, Object> updateNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return notificationtargetednotificationServiceImpl.updateNotification(requestBody);
	}

	
    @Route(url="call/targetednotification/detail")
    public HashMap<String, Object> getNotification(VMJExchange vmjExchange){
		return record.getNotification(vmjExchange);
	}

	
    @Route(url="call/targetednotification/list")
    public List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return notificationtargetednotificationServiceImpl.getAllNotification();
	}

    public List<HashMap<String,Object>> transformNotificationListToHashMap(List<Notification> NotificationTargetedNotificationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < NotificationTargetedNotificationList.size(); i++) {
            resultList.add(NotificationTargetedNotificationList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/targetednotification/delete")
    public List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return notificationtargetednotificationServiceImpl.deleteNotification(requestBody);
	}

	
}
