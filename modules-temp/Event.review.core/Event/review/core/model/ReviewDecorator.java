package Event.review.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReviewDecorator extends ReviewComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReviewComponent record;

	public ReviewDecorator () {
		super();
		Random r = new Random();
		this.reviewId = Math.abs(r.nextInt());
	}

	public ReviewDecorator (int reviewId, ReviewComponent record) {
		this.reviewId =  reviewId;
		this.record = record;
	}
	
	public ReviewDecorator (ReviewComponent record, String objectName) {
		Random r = new Random();
		this.reviewId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getReviewId() {
		return record.getReviewId();
	}
	public void setReviewId(int reviewId) {
		record.setReviewId(reviewId);
	}
	public int getEventId() {
		return record.getEventId();
	}
	public void setEventId(int eventId) {
		record.setEventId(eventId);
	}
	public int getAttendeeId() {
		return record.getAttendeeId();
	}
	public void setAttendeeId(int attendeeId) {
		record.setAttendeeId(attendeeId);
	}
	public int getRating() {
		return record.getRating();
	}
	public void setRating(int rating) {
		record.setRating(rating);
	}
	public String getComment() {
		return record.getComment();
	}
	public void setComment(String comment) {
		record.setComment(comment);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
