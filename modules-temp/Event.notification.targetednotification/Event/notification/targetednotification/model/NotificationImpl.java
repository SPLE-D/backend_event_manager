package Event.notification.targetednotification.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.notification.core.model.NotificationDecorator;
import Event.notification.core.model.Notification;
import Event.notification.core.model.NotificationComponent;

@Entity(name="notification_targetednotification")
@Table(name="notification_targetednotification")
public class NotificationImpl extends NotificationDecorator {

	public int target;
	public NotificationImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = NotificationImpl.class.getName();
    }

	public NotificationImpl(NotificationComponent record, int target, AttendeeManagementImpl attendeemanagementimpl) {
		super(record, NotificationImpl.class.getName());
		this.target = target;
		this.objectName = NotificationImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("notifiationId", notifiationId);
		map.put("target", getTarget());

        return map;
    }

}
