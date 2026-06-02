package Event.report.priorityreport.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.report.core.resource.ReportResourceDecorator;
import Event.report.core.resource.ReportResourceComponent;
import Event.report.core.model.Report;
import Event.report.core.model.ReportImpl;
import Event.report.core.service.ReportServiceComponent;
import Event.report.priorityreport.service.ReportServiceImpl;

public class ReportResourceImpl extends ReportResourceDecorator {
	private ReportServiceComponent reportpriorityreportServiceImpl;

    public ReportResourceImpl (ReportResourceComponent record, ReportServiceComponent recordService) {
        super(record);
		this.reportpriorityreportServiceImpl = new ReportServiceImpl(recordService);
    }

    
    @Route(url="call/priorityreport/save")
    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Report reportpriorityreport = createReport(vmjExchange);
		return getAllReport(vmjExchange);
	}

    public Report createReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportpriorityreportServiceImpl.createReport(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Report createReport(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportpriorityreportServiceImpl.createReport(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/priorityreport/update")
    public HashMap<String, Object> updateReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reportpriorityreportServiceImpl.updateReport(requestBody);
	}

	
    @Route(url="call/priorityreport/detail")
    public HashMap<String, Object> getReport(VMJExchange vmjExchange){
		return record.getReport(vmjExchange);
	}

	
    @Route(url="call/priorityreport/list")
    public List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return reportpriorityreportServiceImpl.getAllReport();
	}

    public List<HashMap<String,Object>> transformReportListToHashMap(List<Report> ReportPriorityReportList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReportPriorityReportList.size(); i++) {
            resultList.add(ReportPriorityReportList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/priorityreport/delete")
    public List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reportpriorityreportServiceImpl.deleteReport(requestBody);
	}

	
}
