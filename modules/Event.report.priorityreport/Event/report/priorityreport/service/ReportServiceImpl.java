package Event.report.priorityreport.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.report.core.service.ReportServiceDecorator;
import Event.report.core.model.ReportImpl;
import Event.report.core.service.ReportServiceComponent;
import Event.report.core.model.Report;
import Event.report.core.model.ReportDecorator;
import Event.report.ReportFactory;
import Event.report.priorityreport.model.PriorityReport;

public class ReportServiceImpl extends ReportServiceDecorator {
    public ReportServiceImpl (ReportServiceComponent record) {
        super(record);
    }

    public Report createReport(Map<String, Object> requestBody){
        String eventIdStr = (String) requestBody.get("eventId");
        int eventId = Integer.parseInt(eventIdStr);

        String totalAttendeeStr = (String) requestBody.get("totalAttendee");
        int totalAttendee = Integer.parseInt(totalAttendeeStr);

        String totalRevenueStr = (String) requestBody.get("totalRevenue");
        int totalRevenue = Integer.parseInt(totalRevenueStr);

        String summary = (String) requestBody.get("summary");

        String priorityReportStr = (String) requestBody.get("PriorityReport");
        PriorityReport priorityReport = PriorityReport.valueOf(priorityReportStr);

        Report reportpriorityreport = record.createReport(requestBody);

        Report reportpriorityreportdeco = ReportFactory.createReport(
            "Event.report.priorityreport.model.ReportImpl",
            reportpriorityreport,
            priorityReport
        );

        Repository.saveObject(reportpriorityreportdeco);
        return reportpriorityreportdeco;
    }

	public Report createReport(Map<String, Object> requestBody, int id){
		Report savedReport = Repository.getObject(id);
		UUID recordReportReportId = ((ReportDecorator) savedReport).getReportId();
		Report report = record.createReport(requestBody, recordReportReportId);
		Report reportpriorityreport = ReportFactory.createReport("Event.report.priorityreport.ReportImpl", report, PriorityReport);
		return reportpriorityreport;
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reportId");
		
		Report reportpriorityreport = Repository.getObject(id);
		reportpriorityreport = createReport(requestBody, id);
		
		Repository.updateObject(reportpriorityreport);
		reportpriorityreport = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return reportpriorityreport.toHashMap();
	}

	public HashMap<String, Object> getReport(String idStr){
		int id = Integer.parseInt(idStr);
		Report reportpriorityreport = Repository.getObject(id);
		return reportpriorityreport.toHashMap();
	}

	public HashMap<String, Object> getReportById(int id){
		List<HashMap<String, Object>> reportList = getAllReport();
		for (HashMap<String, Object> report : reportList){
			int report_id = ((Double) report.get("reportid")).intValue();
			if (report_id == id){
				return report;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReport(){
		List<Report> List = Repository.getAllObject("report_priorityreport");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Report> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("reportId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReport();
	}

	
}
