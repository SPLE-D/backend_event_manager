package Event.review.reviewanonymous.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.review.core.service.ReviewServiceDecorator;
import Event.review.core.model.ReviewImpl;
import Event.review.core.service.ReviewServiceComponent;
import Event.review.core.model.Review;
import Event.review.core.model.ReviewDecorator;
import Event.review.ReviewFactory;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl (ReviewServiceComponent record) {
        super(record);
    }

 	public Review createReview(Map<String, Object> requestBody){
		boolean anonymous = (boolean) requestBody.get("anonymous");
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		String attendeeIdStr = (String) requestBody.get("attendeeId");
		int attendeeId = Integer.parseInt(attendeeIdStr);
		String ratingStr = (String) requestBody.get("rating");
		int rating = Integer.parseInt(ratingStr);
		String comment = (String) requestBody.get("comment");
		Review reviewreviewanonymous = record.createReview(requestBody);
		Review reviewreviewanonymousdeco = ReviewFactory.createReview("Event.review.reviewanonymous.model.ReviewImpl", reviewreviewanonymous, anonymous);
		Repository.saveObject(reviewreviewanonymousdeco);
		return reviewreviewanonymousdeco;
	}

	public Review createReview(Map<String, Object> requestBody, int id){
		Review savedReview = Repository.getObject(id);
		boolean anonymous = (boolean) requestBody.get("anonymous");
		UUID recordReviewReviewId = ((ReviewDecorator) savedReview).getReviewId();
		Review review = record.createReview(requestBody, recordReviewReviewId);
		Review reviewreviewanonymous = ReviewFactory.createReview("Event.review.reviewanonymous.ReviewImpl", review, anonymous);
		return reviewreviewanonymous;
	}

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewId");
		
		Review reviewreviewanonymous = Repository.getObject(id);
		reviewreviewanonymous = createReview(requestBody, id);
		
		Repository.updateObject(reviewreviewanonymous);
		reviewreviewanonymous = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return reviewreviewanonymous.toHashMap();
	}

	public HashMap<String, Object> getReview(String idStr){
		int id = Integer.parseInt(idStr);
		Review reviewreviewanonymous = Repository.getObject(id);
		return reviewreviewanonymous.toHashMap();
	}

	public HashMap<String, Object> getReviewById(int id){
		List<HashMap<String, Object>> reviewList = getAllReview();
		for (HashMap<String, Object> review : reviewList){
			int review_id = ((Double) review.get("reviewid")).intValue();
			if (review_id == id){
				return review;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReview(){
		List<Review> List = Repository.getAllObject("review_reviewanonymous");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("reviewId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReview();
	}

	
}
