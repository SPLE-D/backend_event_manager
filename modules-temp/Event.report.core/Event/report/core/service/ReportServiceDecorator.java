package Event.report.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.report.core.model.Report;

public abstract class ReportServiceDecorator extends ReportServiceComponent{
	protected ReportServiceComponent record;

    public ReportServiceDecorator(ReportServiceComponent record) {
        this.record = record;
    }

	public Report createReport(Map<String, Object> requestBody){
		return record.createReport(requestBody);
	}
	
	public Report createReport(Map<String, Object> requestBody, int id){
		return record.createReport(requestBody, id);
	}

	public HashMap<String, Object> getReport(String idStr){
		return record.getReport(idStr);
	}

	public List<HashMap<String,Object>> getAllReport(){
		return record.getAllReport();
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		return record.updateReport(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Report> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody){
		return record.deleteReport(requestBody);
	}

	public HashMap<String, Object> getReportById(int id){
        return record.getReportById(id);
    }

}
