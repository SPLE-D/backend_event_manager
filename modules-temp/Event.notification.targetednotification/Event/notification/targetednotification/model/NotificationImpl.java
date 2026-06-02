package Event.notification.targetednotification.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.notification.core.model.NotificationDecorator;
import Event.notification.core.model.NotificationComponent;

@Entity(name="notification_targetednotification")
@Table(name="notification_targetednotification")
public class NotificationImpl extends NotificationDecorator {

	public int target;
	public NotificationImpl() {
        super();
        this.objectName = NotificationImpl.class.getName();
    }

	public NotificationImpl(NotificationComponent record, int target) {
		super(record, NotificationImpl.class.getName());
		this.target = target;
		this.objectName = NotificationImpl.class.getName();
	}

	public int getTarget() {
		return this.target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
		map.put("target", getTarget());

        return map;
    }

}
