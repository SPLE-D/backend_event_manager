package Event.notification.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.notification.NotificationFactory;
import Event.notification.core.model.Notification;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class NotificationServiceImpl extends NotificationServiceComponent{

    public Notification createNotification(Map<String, Object> requestBody){
		String content = (String) requestBody.get("content");
		
		//to do: fix association attributes
		
		Notification notification = NotificationFactory.createNotification("Event.notification.core.model.NotificationImpl", content);
		Repository.saveObject(notification);
		return notification;
	}

	public Notification createNotification(Map<String, Object> requestBody, int id){
		int notifiationId = id;
		String content = (String) requestBody.get("content");
		
		//to do: fix association attributes
		Notification notification = NotificationFactory.createNotification("Event.notification.core.model.NotificationImpl",notifiationId, content);
		Repository.saveObject(notification);
		return notification;
	}

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("notifiationId");
		int id = Integer.parseInt(idStr);
		Notification notification = Repository.getObject(id);
		
		notification.setContent((String) requestBody.get("content"));
		
		Repository.updateObject(notification);
		
		//to do: fix association attributes
		
		return notification.toHashMap();
		
	}

    public HashMap<String, Object> getNotification(String idStr){
		int id = Integer.parseInt(idStr);
		Notification notification = Repository.getObject(id);
		return notification.toHashMap();
	}

	public HashMap<String, Object> getNotificationById(int id){
		List<HashMap<String, Object>> notificationList = getAllNotification();
		for (HashMap<String, Object> notification : notificationList){
			int record_id = ((Double) notification.get("notifiationId")).intValue();
			if (record_id == id){
				return notification;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllNotification(){
		List<Notification> List = Repository.getAllObject("notification_impl");
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

	public boolean sendNotification() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
