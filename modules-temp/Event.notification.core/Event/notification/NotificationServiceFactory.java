package Event.notification;

import Event.notification.core.service.NotificationService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class NotificationServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(NotificationServiceFactory.class.getName());

    public NotificationServiceFactory() {}

    public static NotificationService createNotificationService(String fullyQualifiedName, Object ... base) {
        NotificationService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (NotificationService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of NotificationService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to NotificationService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating NotificationService.");
            System.exit(50);
        }
        return record;
    }
}
