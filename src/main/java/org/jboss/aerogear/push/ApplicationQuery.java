package org.jboss.aerogear.push;

import org.jboss.aerogear.push.application.PushApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 3/15/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationQuery {

    private String aeroGearMobileAppId;

    private String channel;

    private int geographicalZoneId;

    public String getAeroGearMobileAppId() {
        return aeroGearMobileAppId;
    }

    public void setAeroGearMobileAppId(String aeroGearMobileAppId) {
        this.aeroGearMobileAppId = aeroGearMobileAppId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getGeographicalZoneId() {
        return geographicalZoneId;
    }

    public void setGeographicalZoneId(int geographicalZoneId) {
        this.geographicalZoneId = geographicalZoneId;
    }

    public List<PushApplication> getResults() {
        return new ArrayList<PushApplication>();
    }
}
