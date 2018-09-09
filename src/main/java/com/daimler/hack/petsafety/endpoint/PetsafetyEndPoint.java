package com.daimler.hack.petsafety.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daimler.hack.petsafety.model.Rules;
import com.daimler.hack.petsafety.request.PushNotificationRequestNotNoop;
import com.daimler.hack.petsafety.response.NotificationResponse;
import com.daimler.hack.petsafety.service.PetsafetyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Petsafety Endpoint")
public class PetsafetyEndPoint {

	@Autowired
	private PetsafetyService petsafetyService; 

	private String vehicleIPAddress = "127.0.0.1";

	@RequestMapping(method = { RequestMethod.GET},value = "/dummy-api")
	@ApiOperation(value = "Dummay endpoint")

    public String dummyTestApi() {
        return "dummy test api";
    }
	
	@RequestMapping(method = { RequestMethod.POST},value = "/addRule")
	@ApiOperation(value = "Dummay endpoint")
	
    public String addNewRule(@RequestParam(value = "timestamp", required = false) String timestamp) {
        return "dummy test api";
    }
	
	
	@RequestMapping(method = { RequestMethod.GET},value = "/getRules")
	@ApiOperation(value = "Dummay endpoint")

    public List<Rules> getPredefinedRules() {
        return new ArrayList<Rules>();
    }
	
	@RequestMapping(method = { RequestMethod.POST},value = "/activte_deactivateRule")
	@ApiOperation(value = "Dummay endpoint")

    public String activateDeactivateRule() {
        return "activate/deactivate rule";
    }
	
	@RequestMapping(method = { RequestMethod.POST},value = "/pushNotificationToDevice")
	@ApiOperation(value = "Dummay endpoint")

	public ResponseEntity<NotificationResponse> pushNotificationToDevice(@RequestBody PushNotificationRequestNotNoop notification,
			HttpServletRequest httpRequest) {
		petsafetyService.pushNotificationToDevice(notification.getNotificationMessage(), notification.getCustomFields(),
				notification.getDeviceTokens());
		return new ResponseEntity<NotificationResponse>(HttpStatus.CREATED);
	}
	@ApiOperation(value = "Dummay endpoint")

    public String pushNotificationToHU() {
        return "activate rule";
    }
	
	@RequestMapping(method = { RequestMethod.GET},value = "/getVehicleParams")
	@ApiOperation(value = "possible param values:doorlockstatus or temperature or sunroofstatus or currentspeed or ignitionstatus")
    public String getVehicleParams(@RequestParam String param) {
		String response = null;
		
		switch (param) {
		case "":
		case "all":
			response= petsafetyService.getVehicleData();
			break;
		case "doorlockstatus":
			response= petsafetyService.getDoorLockStatus();
			break;
		case "temperature":
			response= petsafetyService.getTemperature();
			break;
		case "sunroofstatus":
			response= petsafetyService.getRoofStatus();
			break;
		case "currentspeed":
			response= petsafetyService.getCurrentSpeed();
			break;
		case "ignitionstatus":
			response= petsafetyService.getIgnitionStatus();
			break;
		default:
			response= "Invalid param";
			break;
		}
		return response;
    }
	
	@RequestMapping(method = { RequestMethod.POST},value = "/setVehicleParams")
	@ApiOperation(value = "Dummay endpoint")

    public String setVehicleParams(@RequestParam String param, @RequestParam String value) {
		
        String response = "";
        switch (param) {
		case "doorlockstatus":
			response= petsafetyService.setDoorLockStatus(value);
			break;
		case "temperature":
			response= petsafetyService.setTemperature(value);
			break;
		case "sunroofstatus":
			response= petsafetyService.setRoofStatus(value);
			break;
		case "currentspeed":
			response= petsafetyService.setCurrentSpeed(value);
			break;
		case "ignitionstatus":
			response= petsafetyService.setIgnitionStatus(value);
			break;
		default:
			response= "Invalid param";
			break;
           }
        return response;

	}
	
	@RequestMapping(method = { RequestMethod.GET},value = "/getStreamingUrl")
	@ApiOperation(value = "streaming Api endpoint")

    public String getStreamingUrl() {
        return this.vehicleIPAddress;
    }
	
	@RequestMapping(method = { RequestMethod.POST},value = "/setStreamingUrl")
	@ApiOperation(value = "Streaming endpoint")

    public void setStreamingUrl(String vehicleIPAddress) {
        this.vehicleIPAddress = vehicleIPAddress;
    }
}
