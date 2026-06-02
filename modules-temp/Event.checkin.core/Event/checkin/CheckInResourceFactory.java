package Event.checkin;

import Event.checkin.core.resource.CheckInResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CheckInResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(CheckInResourceFactory.class.getName());

    public CheckInResourceFactory() {}

    public static CheckInResource createCheckInResource(String fullyQualifiedName, Object ... base) {
        CheckInResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CheckInResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CheckInResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CheckInResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CheckInResource.");
            System.exit(50);
        }
        return record;
    }
}
