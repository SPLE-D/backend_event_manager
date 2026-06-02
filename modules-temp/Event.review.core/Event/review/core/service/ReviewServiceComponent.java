package Event.review.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.review.core.model.Review;
//add other required packages

public abstract class ReviewServiceComponent implements ReviewService{
	protected RepositoryUtil<Review> Repository;

    public ReviewServiceComponent(){
        this.Repository = new RepositoryUtil<Review>(Event.review.core.model.ReviewComponent.class);
    }	

    public abstract Review createReview(Map<String, Object> requestBody);
	public abstract Review createReview(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateReview(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReview(String idStr);
    public abstract List<HashMap<String,Object>> getAllReview();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Review> List);
    public abstract List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewById(int id);

}
