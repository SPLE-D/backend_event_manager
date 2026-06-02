package Event.checkin.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.checkin.core.model.CheckIn;
//add other required packages

public abstract class CheckInServiceComponent implements CheckInService{
	protected RepositoryUtil<CheckIn> Repository;

    public CheckInServiceComponent(){
        this.Repository = new RepositoryUtil<CheckIn>(Event.checkin.core.model.CheckInComponent.class);
    }	

    public abstract CheckIn createCheckIn(Map<String, Object> requestBody);
	public abstract CheckIn createCheckIn(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCheckIn(String idStr);
    public abstract List<HashMap<String,Object>> getAllCheckIn();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<CheckIn> List);
    public abstract List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getCheckInById(int id);

	public abstract boolean checkIn();
}
