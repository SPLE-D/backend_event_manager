package Event.review.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.review.ReviewFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Event.review.core.model.Review;
import Event.review.core.service.ReviewServiceImpl;
//add other required packages


public class ReviewResourceImpl extends ReviewResourceComponent{
	
	private ReviewServiceImpl reviewServiceImpl = new ReviewServiceImpl();

	
    @Route(url="call/review/save")
    public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Review review = createReview(vmjExchange);
		return reviewServiceImpl.getAllReview();
	}

    public Review createReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewServiceImpl.createReview(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Review createReview(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewServiceImpl.createReview(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/review/update")
    public HashMap<String, Object> updateReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewServiceImpl.updateReview(requestBody);
		
	}

	
    @Route(url="call/review/detail")
    public HashMap<String, Object> getReview(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("reviewId");
		return reviewServiceImpl.getReview(idStr);
	}

	
    @Route(url="call/review/list")
    public List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewServiceImpl.getAllReview();
	}

	
    @Route(url="call/review/delete")
    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewServiceImpl.deleteReview(requestBody);
	}


}
