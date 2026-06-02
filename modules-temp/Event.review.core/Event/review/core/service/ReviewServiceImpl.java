package Event.review.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.review.ReviewFactory;
import Event.review.core.model.Review;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ReviewServiceImpl extends ReviewServiceComponent{

    public Review createReview(Map<String, Object> requestBody){
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		String attendeeIdStr = (String) requestBody.get("attendeeId");
		int attendeeId = Integer.parseInt(attendeeIdStr);
		String ratingStr = (String) requestBody.get("rating");
		int rating = Integer.parseInt(ratingStr);
		String comment = (String) requestBody.get("comment");
		
		//to do: fix association attributes
		
		Review review = ReviewFactory.createReview("Event.review.core.model.ReviewImpl", eventId, attendeeId, rating, comment);
		Repository.saveObject(review);
		return review;
	}

	public Review createReview(Map<String, Object> requestBody, int id){
		int reviewId = id;
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		String attendeeIdStr = (String) requestBody.get("attendeeId");
		int attendeeId = Integer.parseInt(attendeeIdStr);
		String ratingStr = (String) requestBody.get("rating");
		int rating = Integer.parseInt(ratingStr);
		String comment = (String) requestBody.get("comment");
		
		//to do: fix association attributes
		Review review = ReviewFactory.createReview("Event.review.core.model.ReviewImpl",reviewId, eventId, attendeeId, rating, comment);
		Repository.saveObject(review);
		return review;
	}

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewId");
		int id = Integer.parseInt(idStr);
		Review review = Repository.getObject(id);
		
		String eventIdStr = (String) requestBody.get("eventId");
		review.setEventId(Integer.parseInt(eventIdStr));
		
		String attendeeIdStr = (String) requestBody.get("attendeeId");
		review.setAttendeeId(Integer.parseInt(attendeeIdStr));
		
		String ratingStr = (String) requestBody.get("rating");
		review.setRating(Integer.parseInt(ratingStr));
		
		review.setComment((String) requestBody.get("comment"));
		
		Repository.updateObject(review);
		
		//to do: fix association attributes
		
		return review.toHashMap();
		
	}

    public HashMap<String, Object> getReview(String idStr){
		int id = Integer.parseInt(idStr);
		Review review = Repository.getObject(id);
		return review.toHashMap();
	}

	public HashMap<String, Object> getReviewById(int id){
		List<HashMap<String, Object>> reviewList = getAllReview();
		for (HashMap<String, Object> review : reviewList){
			int record_id = ((Double) review.get("reviewId")).intValue();
			if (record_id == id){
				return review;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReview(){
		List<Review> List = Repository.getAllObject("review_impl");
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
