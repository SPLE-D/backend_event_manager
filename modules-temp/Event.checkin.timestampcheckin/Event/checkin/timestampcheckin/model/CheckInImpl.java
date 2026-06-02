package Event.checkin.timestampcheckin.model;

import java.util.*;
import java.lang.*;
import java.util.Date;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.checkin.core.model.CheckInDecorator;
import Event.checkin.core.model.CheckInComponent;

@Entity(name="checkin_timestampcheckin")
@Table(name="checkin_timestampcheckin")
public class CheckInImpl extends CheckInDecorator {

	public Date timestamp;
	public CheckInImpl() {
        super();
        this.objectName = CheckInImpl.class.getName();
    }

	public CheckInImpl(CheckInComponent record, Date timestamp) {
		super(record, CheckInImpl.class.getName());
		this.timestamp = timestamp;
		this.objectName = CheckInImpl.class.getName();
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
		map.put("timestamp", getTimestamp());

        return map;
    }

}
