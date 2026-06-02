package Event.report.core.resource;
import java.util.*;

import Event.report.core.model.Report;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReportResource {
    List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange);
    HashMap<String, Object> updateReport(VMJExchange vmjExchange);
    HashMap<String, Object> getReport(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange);
}
