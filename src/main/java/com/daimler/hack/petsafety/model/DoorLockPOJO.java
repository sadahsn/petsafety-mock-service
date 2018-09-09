
package com.daimler.hack.petsafety.model;

import java.util.HashMap;
import java.util.Map;

public class DoorLockPOJO {

    private Doorlockstatusrearright doorlockstatusrearright;
    private Doorlockstatusrearleft doorlockstatusrearleft;
    private Doorlockstatusfrontright doorlockstatusfrontright;
    private Doorlockstatusfrontleft doorlockstatusfrontleft;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Doorlockstatusrearright getDoorlockstatusrearright() {
        return doorlockstatusrearright;
    }

    public void setDoorlockstatusrearright(Doorlockstatusrearright doorlockstatusrearright) {
        this.doorlockstatusrearright = doorlockstatusrearright;
    }

    public Doorlockstatusrearleft getDoorlockstatusrearleft() {
        return doorlockstatusrearleft;
    }

    public void setDoorlockstatusrearleft(Doorlockstatusrearleft doorlockstatusrearleft) {
        this.doorlockstatusrearleft = doorlockstatusrearleft;
    }

    public Doorlockstatusfrontright getDoorlockstatusfrontright() {
        return doorlockstatusfrontright;
    }

    public void setDoorlockstatusfrontright(Doorlockstatusfrontright doorlockstatusfrontright) {
        this.doorlockstatusfrontright = doorlockstatusfrontright;
    }

    public Doorlockstatusfrontleft getDoorlockstatusfrontleft() {
        return doorlockstatusfrontleft;
    }

    public void setDoorlockstatusfrontleft(Doorlockstatusfrontleft doorlockstatusfrontleft) {
        this.doorlockstatusfrontleft = doorlockstatusfrontleft;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
