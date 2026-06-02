package Event.notification.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="notification_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NotificationComponent implements Notification{
	@Id
	protected int notifiationId; 
	protected int notifiationId;
	protected String content;
	protected String objectName = NotificationComponent.class.getName();

	public NotificationComponent() {

	} 

	public NotificationComponent(
        int notifiationId, String content
    ) {
        this.notifiationId = notifiationId;
        this.content = content;
    }

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
 
	public abstract boolean sendNotification();

	@Override
    public String toString() {
        return "{" +
            " notifiationId='" + getNotifiationId() + "'" +
            " content='" + getContent() + "'" +
            "}";
    }
	
}
