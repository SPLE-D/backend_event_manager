package Event.checkin.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Event.checkin.CheckInFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.service.CheckInServiceImpl;
//add other required packages


public class CheckInResourceImpl extends CheckInResourceComponent{
	
	private CheckInServiceImpl checkinServiceImpl = new CheckInServiceImpl();

	
    @Route(url="call/checkin/save")
    public List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CheckIn checkin = createCheckIn(vmjExchange);
		return checkinServiceImpl.getAllCheckIn();
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkinServiceImpl.createCheckIn(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public CheckIn createCheckIn(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkinServiceImpl.createCheckIn(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/checkin/update")
    public HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return checkinServiceImpl.updateCheckIn(requestBody);
		
	}

	
    @Route(url="call/checkin/detail")
    public HashMap<String, Object> getCheckIn(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("checkInId");
		return checkinServiceImpl.getCheckIn(idStr);
	}

	
    @Route(url="call/checkin/list")
    public List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return checkinServiceImpl.getAllCheckIn();
	}

	
    @Route(url="call/checkin/delete")
    public List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return checkinServiceImpl.deleteCheckIn(requestBody);
	}


	
	public boolean checkIn() {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

    public CheckIn createTimeStampCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkinServiceImpl.createTimeStampCheckIn(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    @Route(url="call/timestampcheckin/save")
    public List<HashMap<String,Object>> saveTimeStampCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CheckIn checkin = createTimeStampCheckIn(vmjExchange);
		return checkinServiceImpl.getAllTimeStampCheckIn();
	}

    @Route(url="call/timestampcheckin/update")
    public HashMap<String, Object> updateTimeStampCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return checkinServiceImpl.updateTimeStampCheckIn(requestBody);
	}

    @Route(url="call/timestampcheckin/detail")
    public HashMap<String, Object> getTimeStampCheckIn(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("checkInId");
		return checkinServiceImpl.getTimeStampCheckIn(idStr);
	}

    @Route(url="call/timestampcheckin/list")
    public List<HashMap<String,Object>> getAllTimeStampCheckIn(VMJExchange vmjExchange){
		return checkinServiceImpl.getAllTimeStampCheckIn();
	}

    @Route(url="call/timestampcheckin/delete")
    public List<HashMap<String,Object>> deleteTimeStampCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return checkinServiceImpl.deleteTimeStampCheckIn(requestBody);
	}
}
