package Event.review.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.review.core.model.Review;

public abstract class ReviewServiceDecorator extends ReviewServiceComponent{
	protected ReviewServiceComponent record;

    public ReviewServiceDecorator(ReviewServiceComponent record) {
        this.record = record;
    }

	public Review createReview(Map<String, Object> requestBody){
		return record.createReview(requestBody);
	}
	
	public Review createReview(Map<String, Object> requestBody, int id){
		return record.createReview(requestBody, id);
	}

	public HashMap<String, Object> getReview(String idStr){
		return record.getReview(idStr);
	}

	public List<HashMap<String,Object>> getAllReview(){
		return record.getAllReview();
	}

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody){
		return record.updateReview(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody){
		return record.deleteReview(requestBody);
	}

	public HashMap<String, Object> getReviewById(int id){
        return record.getReviewById(id);
    }

}
