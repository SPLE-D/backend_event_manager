package Event.review.reviewanonymous.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.review.core.model.ReviewDecorator;
import Event.review.core.model.ReviewComponent;

@Entity(name="review_reviewanonymous")
@Table(name="review_reviewanonymous")
public class ReviewImpl extends ReviewDecorator {

	protected boolean anonymous;
	public ReviewImpl() {
        super();
        this.objectName = ReviewImpl.class.getName();
    }

	public ReviewImpl(ReviewComponent record, boolean anonymous) {
		super(record, ReviewImpl.class.getName());
		this.anonymous = anonymous;
		this.objectName = ReviewImpl.class.getName();
	}

	public boolean getAnonymous() {
		return this.anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
		map.put("anonymous", getAnonymous());

        return map;
    }

}
