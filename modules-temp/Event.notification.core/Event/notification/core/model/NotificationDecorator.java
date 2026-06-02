package Event.notification.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class NotificationDecorator extends NotificationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected NotificationComponent record;

	public NotificationDecorator () {
		super();
		Random r = new Random();
		this.notifiationId = Math.abs(r.nextInt());
	}

	public NotificationDecorator (int notifiationId, NotificationComponent record) {
		this.notifiationId =  notifiationId;
		this.record = record;
	}
	
	public NotificationDecorator (NotificationComponent record, String objectName) {
		Random r = new Random();
		this.notifiationId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getNotifiationId() {
		return record.getNotifiationId();
	}
	public void setNotifiationId(int notifiationId) {
		record.setNotifiationId(notifiationId);
	}
	public String getContent() {
		return record.getContent();
	}
	public void setContent(String content) {
		record.setContent(content);
	}

	public boolean sendNotification() {
		return record.sendNotification();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
