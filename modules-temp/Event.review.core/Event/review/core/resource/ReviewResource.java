package Event.review.core.resource;
import java.util.*;

import Event.review.core.model.Review;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReviewResource {
    List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange);
    HashMap<String, Object> updateReview(VMJExchange vmjExchange);
    HashMap<String, Object> getReview(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange);
}
