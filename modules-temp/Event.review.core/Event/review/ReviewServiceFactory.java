package Event.review;

import Event.review.core.service.ReviewService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReviewServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReviewServiceFactory.class.getName());

    public ReviewServiceFactory() {}

    public static ReviewService createReviewService(String fullyQualifiedName, Object ... base) {
        ReviewService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReviewService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReviewService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReviewService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReviewService.");
            System.exit(50);
        }
        return record;
    }
}
