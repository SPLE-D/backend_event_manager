package Event.review.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.review.core.model.Review;
//add other required packages

public abstract class ReviewResourceComponent implements ReviewResource{
	
	public ReviewResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange);
    public abstract Review createReview(VMJExchange vmjExchange);
	public abstract Review createReview(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateReview(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReview(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange);

}
