package Event.attendeemanagement;

import Event.attendeemanagement.core.service.AttendeeManagementService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AttendeeManagementServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(AttendeeManagementServiceFactory.class.getName());

    public AttendeeManagementServiceFactory() {}

    public static AttendeeManagementService createAttendeeManagementService(String fullyQualifiedName, Object ... base) {
        AttendeeManagementService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AttendeeManagementService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AttendeeManagementService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AttendeeManagementService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AttendeeManagementService.");
            System.exit(50);
        }
        return record;
    }
}
