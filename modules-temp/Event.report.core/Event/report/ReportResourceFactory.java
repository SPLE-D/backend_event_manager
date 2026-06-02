package Event.report;

import Event.report.core.resource.ReportResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReportResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReportResourceFactory.class.getName());

    public ReportResourceFactory() {}

    public static ReportResource createReportResource(String fullyQualifiedName, Object ... base) {
        ReportResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReportResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReportResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReportResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReportResource.");
            System.exit(50);
        }
        return record;
    }
}
