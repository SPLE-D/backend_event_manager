package Event.notification.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="notification_impl")
@Table(name="notification_impl")
public class NotificationImpl extends NotificationComponent {

	public NotificationImpl(int notifiationId, String content) {
		this.notifiationId = notifiationId;
		this.content = content;
	}

	public NotificationImpl(int notifiationId, String content) {
		Random r = new Random();
		this.notifiationId = Math.abs(r.nextInt());
		this.content = content;
	}

	public NotificationImpl() { }

	public int getNotifiationId() {
		return this.notifiationId;
	}

	public void setNotifiationId(int notifiationId) {
		this.notifiationId = notifiationId;
	}
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean sendNotification() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> notificationMap = new HashMap<String,Object>();
		notificationMap.put("notifiationId",getNotifiationId());
		notificationMap.put("content",getContent());

        return notificationMap;
    }

}
