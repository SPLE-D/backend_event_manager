package Event.review.core.service;
import java.util.*;

import Event.review.core.model.Review;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReviewService {
	Review createReview(Map<String, Object> requestBody);
	HashMap<String, Object> getReview(String idStr);
    HashMap<String, Object> updateReview(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllReview();
    List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Review> List);
}
