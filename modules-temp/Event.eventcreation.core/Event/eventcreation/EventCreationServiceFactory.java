package Event.eventcreation;

import Event.eventcreation.core.service.EventCreationService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class EventCreationServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(EventCreationServiceFactory.class.getName());

    public EventCreationServiceFactory() {}

    public static EventCreationService createEventCreationService(String fullyQualifiedName, Object ... base) {
        EventCreationService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (EventCreationService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of EventCreationService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to EventCreationService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating EventCreationService.");
            System.exit(50);
        }
        return record;
    }
}
