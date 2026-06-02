package Event.review.core.model;

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


@Entity(name="review_impl")
@Table(name="review_impl")
public class ReviewImpl extends ReviewComponent {

	public ReviewImpl(int reviewId, int eventId, int attendeeId, int rating, String comment) {
		this.reviewId = reviewId;
		this.eventId = eventId;
		this.attendeeId = attendeeId;
		this.rating = rating;
		this.comment = comment;
	}

	public ReviewImpl(int reviewId, int eventId, int attendeeId, int rating, String comment) {
		Random r = new Random();
		this.reviewId = Math.abs(r.nextInt());
		this.eventId = eventId;
		this.attendeeId = attendeeId;
		this.rating = rating;
		this.comment = comment;
	}

	public ReviewImpl() { }

	public int getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getAttendeeId() {
		return this.attendeeId;
	}

	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewMap = new HashMap<String,Object>();
		reviewMap.put("reviewId",getReviewId());
		reviewMap.put("eventId",getEventId());
		reviewMap.put("attendeeId",getAttendeeId());
		reviewMap.put("rating",getRating());
		reviewMap.put("comment",getComment());

        return reviewMap;
    }

}
