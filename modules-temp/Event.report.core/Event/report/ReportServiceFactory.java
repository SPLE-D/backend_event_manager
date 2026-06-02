package Event.report;

import Event.report.core.service.ReportService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReportServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReportServiceFactory.class.getName());

    public ReportServiceFactory() {}

    public static ReportService createReportService(String fullyQualifiedName, Object ... base) {
        ReportService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReportService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReportService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReportService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReportService.");
            System.exit(50);
        }
        return record;
    }
}
