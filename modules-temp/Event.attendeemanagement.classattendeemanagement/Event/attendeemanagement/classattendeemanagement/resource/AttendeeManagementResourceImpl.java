package Event.attendeemanagement.classattendeemanagement.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.attendeemanagement.core.resource.AttendeeManagementResourceDecorator;
import Event.attendeemanagement.core.resource.AttendeeManagementResourceComponent;
import Event.attendeemanagement.core.model.AttendeeManagement;
import Event.attendeemanagement.core.model.AttendeeManagementImpl;
import Event.attendeemanagement.core.service.AttendeeManagementServiceComponent;
import Event.attendeemanagement.classattendeemanagement.service.AttendeeManagementServiceImpl;

public class AttendeeManagementResourceImpl extends AttendeeManagementResourceDecorator {
	private AttendeeManagementServiceComponent attendeemanagementclassattendeemanagementServiceImpl;

    public AttendeeManagementResourceImpl (AttendeeManagementResourceComponent record, AttendeeManagementServiceComponent recordService) {
        super(record);
		this.attendeemanagementclassattendeemanagementServiceImpl = new AttendeeManagementServiceImpl(recordService);
    }

    
    @Route(url="call/classattendeemanagement/save")
    public List<HashMap<String,Object>> saveAttendeeManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AttendeeManagement attendeemanagementclassattendeemanagement = createAttendeeManagement(vmjExchange);
		return getAllAttendeeManagement(vmjExchange);
	}

    public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AttendeeManagement result = attendeemanagementclassattendeemanagementServiceImpl.createAttendeeManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public AttendeeManagement createAttendeeManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AttendeeManagement result = attendeemanagementclassattendeemanagementServiceImpl.createAttendeeManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/classattendeemanagement/update")
    public HashMap<String, Object> updateAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return attendeemanagementclassattendeemanagementServiceImpl.updateAttendeeManagement(requestBody);
	}

	
    @Route(url="call/classattendeemanagement/detail")
    public HashMap<String, Object> getAttendeeManagement(VMJExchange vmjExchange){
		return record.getAttendeeManagement(vmjExchange);
	}

	
    @Route(url="call/classattendeemanagement/list")
    public List<HashMap<String,Object>> getAllAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return attendeemanagementclassattendeemanagementServiceImpl.getAllAttendeeManagement();
	}

    public List<HashMap<String,Object>> transformAttendeeManagementListToHashMap(List<AttendeeManagement> AttendeeManagementClassAttendeeManagementList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AttendeeManagementClassAttendeeManagementList.size(); i++) {
            resultList.add(AttendeeManagementClassAttendeeManagementList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/classattendeemanagement/delete")
    public List<HashMap<String,Object>> deleteAttendeeManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return attendeemanagementclassattendeemanagementServiceImpl.deleteAttendeeManagement(requestBody);
	}

	
}
