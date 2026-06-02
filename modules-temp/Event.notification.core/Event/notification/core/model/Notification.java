package Event.notification.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Notification {
	    public int getNotifiationId();
	    public void setNotifiationId(int notifiationId);
	    public String getContent();
	    public void setContent(String content);
	HashMap<String, Object> toHashMap();
}
