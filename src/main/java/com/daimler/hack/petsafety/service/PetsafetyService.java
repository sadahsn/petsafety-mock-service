package com.daimler.hack.petsafety.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.daimler.hack.petsafety.Config;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PetsafetyService implements IPetsafetyService{
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
	private Config config;
	
	public String getRules() {
		// TODO Auto-generated method stub
		return null;
	}

    public String getVehicleData(){
    	return getVehicleParamResponse(config.getBaseUrl());
    }
public void pushNotificationToDevice(String alertBody, Map<String, String> customFields,
			List<String> deviceTokens) {	
		ApnsService service = null;
		try {
			service = APNS.newService().withCert("PetMonitorAPNS.p12", "12345")
					.asPool(Runtime.getRuntime().availableProcessors()).withSandboxDestination().build();

			final String payload = APNS.newPayload().alertBody(alertBody).customFields(customFields).build();

			for (final String token : deviceTokens) {
				System.out.println("sending notification to device with token: " + token);
				service.push(token, payload);
			}

		} catch (final Exception e) {
			log.error(e.getMessage());
		}
	}    
    private String getVehicleParamResponse(String url){
    	HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON ));
        headers.set("Content-Type", "application/json");
    	headers.set("Cookie", "SMSESSION="+config.getCookie());
    	final HttpEntity httpEntity = new HttpEntity("parameters", headers );
    	final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    	ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, String.class);
    	
    	 log.info("response:"+response.getBody());
    	return response.getBody().toString();
    }
    
    
    
    public String setDoorLockStatus(String value){
    	config.getFileContent().set(0, value);
    	return config.getFileContent().get(0);
    }
    public String getDoorLockStatus(){
    	
    	/*String doorlockStr =  getVehicleParamResponse(config.getDoorlockUrl());
    	Gson gson = new Gson();
    	DoorLockPOJO  doorLockPOJO = gson.fromJson(doorlockStr, DoorLockPOJO.class);
    	
    	String vehicleLockStatus = "false";
    	if(doorLockPOJO.getDoorlockstatusfrontleft().getValue().equals("true") 
    			&& doorLockPOJO.getDoorlockstatusfrontleft().getValue().equals("true")
    			&& doorLockPOJO.getDoorlockstatusfrontleft().getValue().equals("true")
    			&& doorLockPOJO.getDoorlockstatusfrontleft().getValue().equals("true")){
    		vehicleLockStatus = "true";
    	}*/
    	
    	String vehicleLockStatus = config.getFileContent().get(0).contains("=")?config.getFileContent().get(0).split("=")[1]:config.getFileContent().get(0) ;
    	
    	return vehicleLockStatus;
    }
    
    public String getTemperature(){/*
    	String temperature = getVehicleParamResponse(config.getTemperature());
    	ObjectMapper mapper = new ObjectMapper();
    	TemperaturePOJO  temperaturePOJO = null;
    	try {
			temperaturePOJO = mapper.readValue(temperature, TemperaturePOJO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	String payloadStr = temperaturePOJO.getTemperaturePoints().getValue().replaceAll("\\", "");
    	Gson gson = new Gson();
    	
    	
    	TemperaturePayload temperaturePayload = null;
		temperaturePayload=gson.fromJson(temperaturePOJO.getTemperaturePoints().getValue(), TemperaturePayload.class);
    	Double maxtemp = 0.0;
    	for(int i=0;i<temperaturePayload.getPayload().size();i++){
    		if(maxtemp<temperaturePayload.getPayload().get(i).getTemp())
    		maxtemp = temperaturePayload.getPayload().get(i).getTemp();
    		
    	}
    	String resp = "{\"maxtemp\":"+maxtemp+" }";
    	return resp;
    */
    
    	String temp = config.getFileContent().get(1).contains("=")?config.getFileContent().get(1).split("=")[1]:config.getFileContent().get(1) ;
    	return temp;
    }
    
    public String getWidowStatus(){
    	return getVehicleParamResponse(config.getWindowStatus());
    }
    
    public String getRoofStatus(){
    	
    	String roof = config.getFileContent().get(2).contains("=")?config.getFileContent().get(2).split("=")[1]:config.getFileContent().get(2) ;
    	return roof;
    }
    
    public String getCurrentSpeed(){
    	String speed = config.getFileContent().get(3).contains("=")?config.getFileContent().get(3).split("=")[1]:config.getFileContent().get(3) ;
    	return speed;
    }
    
    public String getIgnitionStatus(){
    	String ignition = config.getFileContent().get(3).contains("=")?config.getFileContent().get(3).split("=")[1]:config.getFileContent().get(3) ;
    	return ignition;
    }

	public String setTemperature(String value) {
		config.getFileContent().set(1, value);
    	return config.getFileContent().get(1);
	}

	public String setRoofStatus(String value) {
		config.getFileContent().set(2, value);
    	return config.getFileContent().get(2);
	}

	public String setCurrentSpeed(String value) {
		config.getFileContent().set(3, value);
    	return config.getFileContent().get(3);
	}

	public String setIgnitionStatus(String value) {
		config.getFileContent().set(4, value);
    	return config.getFileContent().get(4);
	}
}
