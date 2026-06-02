package Event.checkin.timestampcheckin.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.checkin.core.resource.CheckInResourceDecorator;
import Event.checkin.core.resource.CheckInResourceComponent;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInImpl;
import Event.checkin.core.service.CheckInServiceComponent;
import Event.checkin.timestampcheckin.service.CheckInServiceImpl;

public class CheckInResourceImpl extends CheckInResourceDecorator {
	private CheckInServiceComponent checkintimestampcheckinServiceImpl;

    public CheckInResourceImpl (CheckInResourceComponent record, CheckInServiceComponent recordService) {
        super(record);
		this.checkintimestampcheckinServiceImpl = new CheckInServiceImpl(recordService);
    }

    
    @Route(url="call/timestampcheckin/save")
    public List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CheckIn checkintimestampcheckin = createCheckIn(vmjExchange);
		return getAllCheckIn(vmjExchange);
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkintimestampcheckinServiceImpl.createCheckIn(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkintimestampcheckinServiceImpl.createCheckIn(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/timestampcheckin/update")
    public HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return checkintimestampcheckinServiceImpl.updateCheckIn(requestBody);
	}

	
    @Route(url="call/timestampcheckin/detail")
    public HashMap<String, Object> getCheckIn(VMJExchange vmjExchange){
		return record.getCheckIn(vmjExchange);
	}

	
    @Route(url="call/timestampcheckin/list")
    public List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return checkintimestampcheckinServiceImpl.getAllCheckIn();
	}

    public List<HashMap<String,Object>> transformCheckInListToHashMap(List<CheckIn> CheckInTimeStampCheckInList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CheckInTimeStampCheckInList.size(); i++) {
            resultList.add(CheckInTimeStampCheckInList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/timestampcheckin/delete")
    public List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return checkintimestampcheckinServiceImpl.deleteCheckIn(requestBody);
	}

	
}
