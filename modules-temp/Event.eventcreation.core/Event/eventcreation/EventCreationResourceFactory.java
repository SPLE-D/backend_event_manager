package Event.eventcreation;

import Event.eventcreation.core.resource.EventCreationResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class EventCreationResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(EventCreationResourceFactory.class.getName());

    public EventCreationResourceFactory() {}

    public static EventCreationResource createEventCreationResource(String fullyQualifiedName, Object ... base) {
        EventCreationResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (EventCreationResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of EventCreationResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to EventCreationResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating EventCreationResource.");
            System.exit(50);
        }
        return record;
    }
}
