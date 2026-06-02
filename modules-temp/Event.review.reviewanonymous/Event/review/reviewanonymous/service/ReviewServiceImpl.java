package Event.review.reviewanonymous.service;

import java.util.*;

import Event.review.ReviewFactory;
import Event.review.core.model.Review;
import Event.review.core.model.ReviewComponent;
import Event.review.core.service.ReviewServiceComponent;
import Event.review.core.service.ReviewServiceDecorator;
import Event.review.reviewanonymous.model.ReviewImpl;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl(ReviewServiceComponent record) {
        super(record);
    }

    public Review createReview(Map<String, Object> requestBody) {
        boolean anonymous = parseBooleanValue(requestBody.get("anonymous"));
        Review baseReview = record.createReview(requestBody);

        Review decoratedReview = ReviewFactory.createReview(
            "Event.review.reviewanonymous.model.ReviewImpl",
            (ReviewComponent) baseReview,
            anonymous
        );

        Repository.saveObject(decoratedReview);
        return decoratedReview;
    }

    public Review createReview(Map<String, Object> requestBody, int id) {
        boolean anonymous = parseBooleanValue(requestBody.get("anonymous"));
        Review baseReview = record.createReview(requestBody, id);

        Review decoratedReview = ReviewFactory.createReview(
            "Event.review.reviewanonymous.model.ReviewImpl",
            (ReviewComponent) baseReview,
            anonymous
        );

        Repository.saveObject(decoratedReview);
        return decoratedReview;
    }

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody) {
        int id = Integer.parseInt((String) requestBody.get("reviewId"));
        ReviewImpl review = getReviewAnonymousObjectById(id);

        review.setEventId(Integer.parseInt((String) requestBody.get("eventId")));
        review.setAttendeeId(Integer.parseInt((String) requestBody.get("attendeeId")));
        review.setRating(Integer.parseInt((String) requestBody.get("rating")));
        review.setComment((String) requestBody.get("comment"));
        review.setAnonymous(parseBooleanValue(requestBody.get("anonymous")));

        Repository.updateObject(review);
        return review.toHashMap();
    }

    public HashMap<String, Object> getReview(String idStr) {
        int id = Integer.parseInt(idStr);
        return getReviewAnonymousObjectById(id).toHashMap();
    }

    public HashMap<String, Object> getReviewById(int id) {
        for (HashMap<String, Object> review : getAllReview()) {
            int recordId = ((Number) review.get("reviewId")).intValue();
            if (recordId == id) {
                return review;
            }
        }
        return null;
    }

    public List<HashMap<String, Object>> getAllReview() {
        List<Review> list = Repository.getAllObject("review_reviewanonymous");
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Review> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (Review review : list) {
            resultList.add(review.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteReview(Map<String, Object> requestBody) {
        record.deleteReview(requestBody);
        return getAllReview();
    }

    private ReviewImpl getReviewAnonymousObjectById(int id) {
        List<Review> list = Repository.getAllObject("review_reviewanonymous");
        for (Review review : list) {
            if (review.getReviewId() == id) {
                return (ReviewImpl) review;
            }
        }
        throw new IllegalArgumentException("ReviewAnonymous not found for reviewId: " + id);
    }

    private boolean parseBooleanValue(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof String) {
            return Boolean.parseBoolean((String) value);
        }
        throw new IllegalArgumentException("Invalid boolean value for anonymous: " + value);
    }
}
