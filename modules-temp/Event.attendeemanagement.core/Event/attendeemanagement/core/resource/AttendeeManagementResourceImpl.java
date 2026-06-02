package Event.attendeemanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.attendeemanagement.AttendeeManagementFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Event.attendeemanagement.core.model.AttendeeManagement;
import Event.attendeemanagement.core.service.AttendeeManagementServiceImpl;
//add other required packages


public class AttendeeManagementResourceImpl extends AttendeeManagementResourceComponent{
	
	private AttendeeManagementServiceImpl attendeemanagementServiceImpl = new AttendeeManagementServiceImpl();

	
    @Route(url="call/attendeemanagement/save")
    public List<HashMap<String,Object>> saveAttendeeManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AttendeeManagement attendeemanagement = createAttendeeManagement(vmjExchange);
		return attendeemanagementServiceImpl.getAllAttendeeManagement();
	}

    public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AttendeeManagement result = attendeemanagementServiceImpl.createAttendeeManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AttendeeManagement result = attendeemanagementServiceImpl.createAttendeeManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/attendeemanagement/update")
    public HashMap<String, Object> updateAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return attendeemanagementServiceImpl.updateAttendeeManagement(requestBody);
		
	}

	
    @Route(url="call/attendeemanagement/detail")
    public HashMap<String, Object> getAttendeeManagement(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("attendeeId");
		return attendeemanagementServiceImpl.getAttendeeManagement(idStr);
	}

	
    @Route(url="call/attendeemanagement/list")
    public List<HashMap<String,Object>> getAllAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return attendeemanagementServiceImpl.getAllAttendeeManagement();
	}

	
    @Route(url="call/attendeemanagement/delete")
    public List<HashMap<String,Object>> deleteAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return attendeemanagementServiceImpl.deleteAttendeeManagement(requestBody);
	}


}
