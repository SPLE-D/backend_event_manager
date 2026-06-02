package Event.notification;

import Event.notification.core.resource.NotificationResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class NotificationResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(NotificationResourceFactory.class.getName());

    public NotificationResourceFactory() {}

    public static NotificationResource createNotificationResource(String fullyQualifiedName, Object ... base) {
        NotificationResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (NotificationResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of NotificationResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to NotificationResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating NotificationResource.");
            System.exit(50);
        }
        return record;
    }
}
