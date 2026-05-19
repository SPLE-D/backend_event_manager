package Event.report.priorityreport.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.report.core.model.ReportDecorator;
import Event.report.core.model.Report;
import Event.report.core.model.ReportComponent;

@Entity(name="report_priorityreport")
@Table(name="report_priorityreport")
public class ReportImpl extends ReportDecorator {

	public PriorityReport PriorityReport;
	public ReportImpl() {
        super();
		Random r = new Random();
        this.objectName = ReportImpl.class.getName();
    }

	public ReportImpl(ReportComponent record, PriorityReport PriorityReport) {
		super(record, ReportImpl.class.getName());
		this.PriorityReport = PriorityReport;
		this.objectName = ReportImpl.class.getName();
	}
	
	public PriorityReport getPriorityReport() {
	    return this.PriorityReport;
	}

	public void setPriorityReport(PriorityReport PriorityReport) {
	    this.PriorityReport = PriorityReport;
	}
	

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("reportId", reportId);
		map.put("PriorityReport", getPriorityReport());

        return map;
    }

}
