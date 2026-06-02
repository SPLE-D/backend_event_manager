package Event.review;

import Event.review.core.resource.ReviewResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReviewResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReviewResourceFactory.class.getName());

    public ReviewResourceFactory() {}

    public static ReviewResource createReviewResource(String fullyQualifiedName, Object ... base) {
        ReviewResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReviewResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReviewResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReviewResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReviewResource.");
            System.exit(50);
        }
        return record;
    }
}
