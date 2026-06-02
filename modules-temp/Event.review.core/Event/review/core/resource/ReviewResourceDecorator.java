package Event.review.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.review.core.model.Review;

public abstract class ReviewResourceDecorator extends ReviewResourceComponent{
	protected ReviewResourceComponent record;

    public ReviewResourceDecorator(ReviewResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
		return record.saveReview(vmjExchange);
	}

    public Review createReview(VMJExchange vmjExchange){
		return record.createReview(vmjExchange);
	}
	
	public Review createReview(VMJExchange vmjExchange, int id){
		return record.createReview(vmjExchange, id);
	}

    public HashMap<String, Object> updateReview(VMJExchange vmjExchange){
		return record.updateReview(vmjExchange);
	}

    public HashMap<String, Object> getReview(VMJExchange vmjExchange){
		return record.getReview(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange){
		return record.getAllReview(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		return record.deleteReview(vmjExchange);
	}

}
