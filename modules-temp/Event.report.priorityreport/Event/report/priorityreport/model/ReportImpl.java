package Event.report.priorityreport.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.report.core.model.ReportDecorator;
import Event.report.core.model.ReportComponent;

@Entity(name="report_priorityreport")
@Table(name="report_priorityreport")
public class ReportImpl extends ReportDecorator {

	protected String priorityReport;
	public ReportImpl() {
        super();
        this.objectName = ReportImpl.class.getName();
    }

	public ReportImpl(ReportComponent record, String priorityReport) {
		super(record, ReportImpl.class.getName());
		this.priorityReport = priorityReport;
		this.objectName = ReportImpl.class.getName();
	}

	public String getPriorityReport() {
		return this.priorityReport;
	}

	public void setPriorityReport(String priorityReport) {
		this.priorityReport = priorityReport;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
		map.put("priorityReport", getPriorityReport());

        return map;
    }

}
