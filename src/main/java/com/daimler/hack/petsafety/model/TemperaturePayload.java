
package com.daimler.hack.petsafety.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemperaturePayload {

    private List<Payload> payload = null;
    private String serializertype;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public String getSerializertype() {
        return serializertype;
    }

    public void setSerializertype(String serializertype) {
        this.serializertype = serializertype;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
