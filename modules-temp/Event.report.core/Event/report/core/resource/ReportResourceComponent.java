package Event.report.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.report.core.model.Report;
//add other required packages

public abstract class ReportResourceComponent implements ReportResource{
	
	public ReportResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange);
    public abstract Report createReport(VMJExchange vmjExchange);
	public abstract Report createReport(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateReport(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReport(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange);

}
