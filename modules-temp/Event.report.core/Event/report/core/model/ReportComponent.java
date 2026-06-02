package Event.report.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="report_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReportComponent implements Report{
	@Id
	protected int reportId; 
	protected int eventId;
	protected int totalAttendee;
	protected int totalRevenue;
	protected String summary;
	protected String objectName = ReportComponent.class.getName();

	public ReportComponent() {

	} 

	public ReportComponent(
        int reportId, int eventId, int totalAttendee, int totalRevenue, String summary
    ) {
        this.reportId = reportId;
        this.eventId = eventId;
        this.totalAttendee = totalAttendee;
        this.totalRevenue = totalRevenue;
        this.summary = summary;
    }

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getTotalAttendee() {
		return this.totalAttendee;
	}

	public void setTotalAttendee(int totalAttendee) {
		this.totalAttendee = totalAttendee;
	}
	public int getTotalRevenue() {
		return this.totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
 

	@Override
    public String toString() {
        return "{" +
            " reportId='" + getReportId() + "'" +
            " eventId='" + getEventId() + "'" +
            " totalAttendee='" + getTotalAttendee() + "'" +
            " totalRevenue='" + getTotalRevenue() + "'" +
            " summary='" + getSummary() + "'" +
            "}";
    }
	
}
