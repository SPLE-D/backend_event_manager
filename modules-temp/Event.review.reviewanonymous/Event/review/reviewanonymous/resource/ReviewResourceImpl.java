package Event.review.reviewanonymous.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.review.core.resource.ReviewResourceDecorator;
import Event.review.core.resource.ReviewResourceComponent;
import Event.review.core.model.Review;
import Event.review.core.model.ReviewImpl;
import Event.review.core.service.ReviewServiceComponent;
import Event.review.reviewanonymous.service.ReviewServiceImpl;

public class ReviewResourceImpl extends ReviewResourceDecorator {
	private ReviewServiceComponent reviewreviewanonymousServiceImpl;

    public ReviewResourceImpl (ReviewResourceComponent record, ReviewServiceComponent recordService) {
        super(record);
		this.reviewreviewanonymousServiceImpl = new ReviewServiceImpl(recordService);
    }

    
    @Route(url="call/reviewanonymous/save")
    public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Review reviewreviewanonymous = createReview(vmjExchange);
		return getAllReview(vmjExchange);
	}

    public Review createReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewreviewanonymousServiceImpl.createReview(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Review createReview(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewreviewanonymousServiceImpl.createReview(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/reviewanonymous/update")
    public HashMap<String, Object> updateReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewreviewanonymousServiceImpl.updateReview(requestBody);
	}

	
    @Route(url="call/reviewanonymous/detail")
    public HashMap<String, Object> getReview(VMJExchange vmjExchange){
		return record.getReview(vmjExchange);
	}

	
    @Route(url="call/reviewanonymous/list")
    public List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return reviewreviewanonymousServiceImpl.getAllReview();
	}

    public List<HashMap<String,Object>> transformReviewListToHashMap(List<Review> ReviewReviewAnonymousList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReviewReviewAnonymousList.size(); i++) {
            resultList.add(ReviewReviewAnonymousList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/reviewanonymous/delete")
    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewreviewanonymousServiceImpl.deleteReview(requestBody);
	}

	
}
