package com.daimler.hack.petsafety;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.daimler.hack.petsafety.service.PetsafetyService;

import lombok.Data;

@Data
@Component
public class Config {
	
	Config(){
		getAllLinesFromFile();
	}

	 @Value("${petsafety.test.URL}")
	 public String baseUrl;
	 
	 @Value("${petsafety.Url.attribute.doorstatus}")
	 public String doorlockUrl;
	 
	 @Value("${persafety.cookie}")
	 public String cookie;

	@Value("${petsafety.Url.attribute.temperaturestatus}")
	 public String temperature;
	
	@Value("${petsafety.Url.attribute.windowstatus}")
	 public String windowStatus;
	
	@Value("${petsafety.Url.attribute.speedCheck}")
	 public String speedCheck;
	
	@Value("${petsafety.Url.attribute.ignitionstatus}")
	 public String ignitionstatus;
	
	@Value("${petsafety.Url.attribute.roofstatus}")
	 public String roofstatus;
	
	public List<String> fileContent = null;
	
	private List<String> getAllLinesFromFile(){
    	try {
			 fileContent = Files.readAllLines(Paths.get(PetsafetyService.class.getClassLoader().getResource("mockdata.txt").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return fileContent;
    }
	
	
	
	
}
