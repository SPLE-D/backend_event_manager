package Event.report.priorityreport.service;

import java.util.*;

import Event.report.ReportFactory;
import Event.report.core.model.Report;
import Event.report.core.model.ReportComponent;
import Event.report.core.service.ReportServiceComponent;
import Event.report.core.service.ReportServiceDecorator;
import Event.report.priorityreport.model.ReportImpl;

public class ReportServiceImpl extends ReportServiceDecorator {
    public ReportServiceImpl(ReportServiceComponent record) {
        super(record);
    }

    public Report createReport(Map<String, Object> requestBody) {
        String priorityReport = (String) requestBody.get("priorityReport");
        Report baseReport = record.createReport(requestBody);

        Report decoratedReport = ReportFactory.createReport(
            "Event.report.priorityreport.model.ReportImpl",
            (ReportComponent) baseReport,
            priorityReport
        );

        Repository.saveObject(decoratedReport);
        return decoratedReport;
    }

    public Report createReport(Map<String, Object> requestBody, int id) {
        String priorityReport = (String) requestBody.get("priorityReport");
        Report baseReport = record.createReport(requestBody, id);

        Report decoratedReport = ReportFactory.createReport(
            "Event.report.priorityreport.model.ReportImpl",
            (ReportComponent) baseReport,
            priorityReport
        );

        Repository.saveObject(decoratedReport);
        return decoratedReport;
    }

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody) {
        int id = Integer.parseInt((String) requestBody.get("reportId"));
        ReportImpl report = getPriorityReportObjectById(id);

        report.setEventId(Integer.parseInt((String) requestBody.get("eventId")));
        report.setTotalAttendee(Integer.parseInt((String) requestBody.get("totalAttendee")));
        report.setTotalRevenue(Integer.parseInt((String) requestBody.get("totalRevenue")));
        report.setSummary((String) requestBody.get("summary"));
        report.setPriorityReport((String) requestBody.get("priorityReport"));

        Repository.updateObject(report);
        return report.toHashMap();
    }

    public HashMap<String, Object> getReport(String idStr) {
        int id = Integer.parseInt(idStr);
        return getPriorityReportObjectById(id).toHashMap();
    }

    public HashMap<String, Object> getReportById(int id) {
        for (HashMap<String, Object> report : getAllReport()) {
            int recordId = ((Number) report.get("reportId")).intValue();
            if (recordId == id) {
                return report;
            }
        }
        return null;
    }

    public List<HashMap<String, Object>> getAllReport() {
        List<Report> list = Repository.getAllObject("report_priorityreport");
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Report> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (Report report : list) {
            resultList.add(report.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteReport(Map<String, Object> requestBody) {
        record.deleteReport(requestBody);
        return getAllReport();
    }

    private ReportImpl getPriorityReportObjectById(int id) {
        List<Report> list = Repository.getAllObject("report_priorityreport");
        for (Report report : list) {
            if (report.getReportId() == id) {
                return (ReportImpl) report;
            }
        }
        throw new IllegalArgumentException("PriorityReport not found for reportId: " + id);
    }
}
