package Event.report.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.report.ReportFactory;
import Event.report.core.model.Report;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ReportServiceImpl extends ReportServiceComponent{

    public Report createReport(Map<String, Object> requestBody){
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		String totalAttendeeStr = (String) requestBody.get("totalAttendee");
		int totalAttendee = Integer.parseInt(totalAttendeeStr);
		String totalRevenueStr = (String) requestBody.get("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);
		String summary = (String) requestBody.get("summary");
		
		//to do: fix association attributes
		
		Report report = ReportFactory.createReport("Event.report.core.model.ReportImpl", eventId, totalAttendee, totalRevenue, summary);
		Repository.saveObject(report);
		return report;
	}

	public Report createReport(Map<String, Object> requestBody, int id){
		int reportId = id;
		String eventIdStr = (String) requestBody.get("eventId");
		int eventId = Integer.parseInt(eventIdStr);
		String totalAttendeeStr = (String) requestBody.get("totalAttendee");
		int totalAttendee = Integer.parseInt(totalAttendeeStr);
		String totalRevenueStr = (String) requestBody.get("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);
		String summary = (String) requestBody.get("summary");
		
		//to do: fix association attributes
		Report report = ReportFactory.createReport("Event.report.core.model.ReportImpl",reportId, eventId, totalAttendee, totalRevenue, summary);
		Repository.saveObject(report);
		return report;
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reportId");
		int id = Integer.parseInt(idStr);
		Report report = Repository.getObject(id);
		
		String eventIdStr = (String) requestBody.get("eventId");
		report.setEventId(Integer.parseInt(eventIdStr));
		
		String totalAttendeeStr = (String) requestBody.get("totalAttendee");
		report.setTotalAttendee(Integer.parseInt(totalAttendeeStr));
		
		String totalRevenueStr = (String) requestBody.get("totalRevenue");
		report.setTotalRevenue(Integer.parseInt(totalRevenueStr));
		
		report.setSummary((String) requestBody.get("summary"));
		
		Repository.updateObject(report);
		
		//to do: fix association attributes
		
		return report.toHashMap();
		
	}

    public HashMap<String, Object> getReport(String idStr){
		int id = Integer.parseInt(idStr);
		Report report = Repository.getObject(id);
		return report.toHashMap();
	}

	public HashMap<String, Object> getReportById(int id){
		List<HashMap<String, Object>> reportList = getAllReport();
		for (HashMap<String, Object> report : reportList){
			int record_id = ((Double) report.get("reportId")).intValue();
			if (record_id == id){
				return report;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReport(){
		List<Report> List = Repository.getAllObject("report_impl");
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
