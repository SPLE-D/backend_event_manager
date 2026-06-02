package Event.attendeemanagement;

import Event.attendeemanagement.core.resource.AttendeeManagementResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AttendeeManagementResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(AttendeeManagementResourceFactory.class.getName());

    public AttendeeManagementResourceFactory() {}

    public static AttendeeManagementResource createAttendeeManagementResource(String fullyQualifiedName, Object ... base) {
        AttendeeManagementResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AttendeeManagementResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AttendeeManagementResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AttendeeManagementResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AttendeeManagementResource.");
            System.exit(50);
        }
        return record;
    }
}
