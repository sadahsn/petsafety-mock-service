
package com.daimler.hack.petsafety.model;

import java.util.HashMap;
import java.util.Map;

public class TemperaturePOJO {

    private TemperaturePoints temperaturePoints;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public TemperaturePoints getTemperaturePoints() {
        return temperaturePoints;
    }

    public void setTemperaturePoints(TemperaturePoints temperaturePoints) {
        this.temperaturePoints = temperaturePoints;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
