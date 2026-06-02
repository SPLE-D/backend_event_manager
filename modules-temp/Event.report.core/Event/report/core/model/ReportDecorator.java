package Event.report.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReportDecorator extends ReportComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReportComponent record;

	public ReportDecorator () {
		super();
		Random r = new Random();
		this.reportId = Math.abs(r.nextInt());
	}

	public ReportDecorator (int reportId, ReportComponent record) {
		this.reportId =  reportId;
		this.record = record;
	}
	
	public ReportDecorator (ReportComponent record, String objectName) {
		Random r = new Random();
		this.reportId = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getReportId() {
		return record.getReportId();
	}
	public void setReportId(int reportId) {
		record.setReportId(reportId);
	}
	public int getEventId() {
		return record.getEventId();
	}
	public void setEventId(int eventId) {
		record.setEventId(eventId);
	}
	public int getTotalAttendee() {
		return record.getTotalAttendee();
	}
	public void setTotalAttendee(int totalAttendee) {
		record.setTotalAttendee(totalAttendee);
	}
	public int getTotalRevenue() {
		return record.getTotalRevenue();
	}
	public void setTotalRevenue(int totalRevenue) {
		record.setTotalRevenue(totalRevenue);
	}
	public String getSummary() {
		return record.getSummary();
	}
	public void setSummary(String summary) {
		record.setSummary(summary);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
