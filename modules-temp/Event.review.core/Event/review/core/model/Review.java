package Event.review.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Review {
	    public int getReviewId();
	    public void setReviewId(int reviewId);
	    public int getEventId();
	    public void setEventId(int eventId);
	    public int getAttendeeId();
	    public void setAttendeeId(int attendeeId);
	    public int getRating();
	    public void setRating(int rating);
	    public String getComment();
	    public void setComment(String comment);
	HashMap<String, Object> toHashMap();
}
