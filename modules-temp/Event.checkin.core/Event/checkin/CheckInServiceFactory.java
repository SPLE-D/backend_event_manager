package Event.checkin;

import Event.checkin.core.service.CheckInService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CheckInServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(CheckInServiceFactory.class.getName());

    public CheckInServiceFactory() {}

    public static CheckInService createCheckInService(String fullyQualifiedName, Object ... base) {
        CheckInService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CheckInService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CheckInService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CheckInService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CheckInService.");
            System.exit(50);
        }
        return record;
    }
}
