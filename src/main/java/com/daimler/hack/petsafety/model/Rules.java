package com.daimler.hack.petsafety.model;


import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rules {

	 @JsonProperty("ruleId")
	 int ruleId;
	 
	 @JsonProperty("ruleName")
	 String ruleName;
	 
	 @JsonProperty("ruleActiveStatus")
	 boolean ruleStatus;
	 
	 @JsonProperty("vehicleParams")
	 Map<String, String> vehicleParams;
}
