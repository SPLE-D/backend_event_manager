package Event.review.core.model;

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
@Table(name="review_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewComponent implements Review{
	@Id
	protected int reviewId; 
	protected int reviewId;
	protected int eventId;
	protected int attendeeId;
	protected int rating;
	protected String comment;
	protected String objectName = ReviewComponent.class.getName();

	public ReviewComponent() {

	} 

	public ReviewComponent(
        int reviewId, int eventId, int attendeeId, int rating, String comment
    ) {
        this.reviewId = reviewId;
        this.eventId = eventId;
        this.attendeeId = attendeeId;
        this.rating = rating;
        this.comment = comment;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " reviewId='" + getReviewId() + "'" +
            " eventId='" + getEventId() + "'" +
            " attendeeId='" + getAttendeeId() + "'" +
            " rating='" + getRating() + "'" +
            " comment='" + getComment() + "'" +
            "}";
    }
	
}
