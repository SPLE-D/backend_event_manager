package Event.report.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.report.core.model.Report;
//add other required packages

public abstract class ReportServiceComponent implements ReportService{
	protected RepositoryUtil<Report> Repository;

    public ReportServiceComponent(){
        this.Repository = new RepositoryUtil<Report>(Event.report.core.model.ReportComponent.class);
    }	

    public abstract Report createReport(Map<String, Object> requestBody);
	public abstract Report createReport(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateReport(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReport(String idStr);
    public abstract List<HashMap<String,Object>> getAllReport();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Report> List);
    public abstract List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReportById(int id);

}
