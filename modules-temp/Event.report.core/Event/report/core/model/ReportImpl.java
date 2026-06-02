package Event.report.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="report_impl")
@Table(name="report_impl")
public class ReportImpl extends ReportComponent {

	public ReportImpl(int reportId, int eventId, int totalAttendee, int totalRevenue, String summary) {
	    this.reportId = reportId;
	    this.eventId = eventId;
	    this.totalAttendee = totalAttendee;
	    this.totalRevenue = totalRevenue;
	    this.summary = summary;
	}

	public ReportImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reportMap = new HashMap<String,Object>();
		reportMap.put("reportId",getReportId());
		reportMap.put("eventId",getEventId());
		reportMap.put("totalAttendee",getTotalAttendee());
		reportMap.put("totalRevenue",getTotalRevenue());
		reportMap.put("summary",getSummary());

        return reportMap;
    }

}
