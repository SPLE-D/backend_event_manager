package Event.attendeemanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Event.attendeemanagement.core.model.AttendeeManagement;
//add other required packages

public abstract class AttendeeManagementServiceComponent implements AttendeeManagementService{
	protected RepositoryUtil<AttendeeManagement> Repository;

    public AttendeeManagementServiceComponent(){
        this.Repository = new RepositoryUtil<AttendeeManagement>(Event.attendeemanagement.core.model.AttendeeManagementComponent.class);
    }	

    public abstract AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody);
	public abstract AttendeeManagement createAttendeeManagement(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateAttendeeManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAttendeeManagement(String idStr);
    public abstract List<HashMap<String,Object>> getAllAttendeeManagement();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<AttendeeManagement> List);
    public abstract List<HashMap<String,Object>> deleteAttendeeManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAttendeeManagementById(int id);

}
