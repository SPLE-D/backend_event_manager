package Event.report.core.service;
import java.util.*;

import Event.report.core.model.Report;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReportService {
	Report createReport(Map<String, Object> requestBody);
	HashMap<String, Object> getReport(String idStr);
    HashMap<String, Object> updateReport(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllReport();
    List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Report> List);
}
