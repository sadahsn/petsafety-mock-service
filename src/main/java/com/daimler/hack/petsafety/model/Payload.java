
package com.daimler.hack.petsafety.model;

import java.util.HashMap;
import java.util.Map;

public class Payload {

    private String zone;
    private Double temp;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
