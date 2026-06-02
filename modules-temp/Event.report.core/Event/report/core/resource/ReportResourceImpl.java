package Event.report.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.report.ReportFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Event.report.core.model.Report;
import Event.report.core.service.ReportServiceImpl;
//add other required packages


public class ReportResourceImpl extends ReportResourceComponent{
	
	private ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

	
    @Route(url="call/report/save")
    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Report report = createReport(vmjExchange);
		return reportServiceImpl.getAllReport();
	}

    public Report createReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportServiceImpl.createReport(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Report createReport(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportServiceImpl.createReport(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/report/update")
    public HashMap<String, Object> updateReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reportServiceImpl.updateReport(requestBody);
		
	}

	
    @Route(url="call/report/detail")
    public HashMap<String, Object> getReport(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("reportId");
		return reportServiceImpl.getReport(idStr);
	}

	
    @Route(url="call/report/list")
    public List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reportServiceImpl.getAllReport();
	}

	
    @Route(url="call/report/delete")
    public List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reportServiceImpl.deleteReport(requestBody);
	}


}
