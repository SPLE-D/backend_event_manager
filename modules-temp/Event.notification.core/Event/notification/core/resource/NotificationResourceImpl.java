package Event.notification.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.notification.NotificationFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Event.notification.core.model.Notification;
import Event.notification.core.service.NotificationServiceImpl;
//add other required packages


public class NotificationResourceImpl extends NotificationResourceComponent{
	
	private NotificationServiceImpl notificationServiceImpl = new NotificationServiceImpl();

	
    @Route(url="call/notification/save")
    public List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notification notification = createNotification(vmjExchange);
		return notificationServiceImpl.getAllNotification();
	}

    public Notification createNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationServiceImpl.createNotification(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Notification createNotification(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationServiceImpl.createNotification(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/notification/update")
    public HashMap<String, Object> updateNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return notificationServiceImpl.updateNotification(requestBody);
		
	}

	
    @Route(url="call/notification/detail")
    public HashMap<String, Object> getNotification(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("notifiationId");
		return notificationServiceImpl.getNotification(idStr);
	}

	
    @Route(url="call/notification/list")
    public List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return notificationServiceImpl.getAllNotification();
	}

	
    @Route(url="call/notification/delete")
    public List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return notificationServiceImpl.deleteNotification(requestBody);
	}


	
	public boolean sendNotification() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
