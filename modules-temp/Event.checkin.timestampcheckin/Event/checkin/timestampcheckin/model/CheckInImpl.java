package Event.checkin.timestampcheckin.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.checkin.core.model.CheckInDecorator;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInComponent;

@Entity(name="checkin_timestampcheckin")
@Table(name="checkin_timestampcheckin")
public class CheckInImpl extends CheckInDecorator {

	public EDate timestamp;
	public CheckInImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = CheckInImpl.class.getName();
    }

	public CheckInImpl(CheckInComponent record, EDate timestamp) {
		super(record, CheckInImpl.class.getName());
		this.timestamp = timestamp;
		this.objectName = CheckInImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("checkInId", checkInId);
		map.put("timestamp", getTimestamp());

        return map;
    }

}
