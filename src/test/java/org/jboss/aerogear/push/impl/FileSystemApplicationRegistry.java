package org.jboss.aerogear.push.impl;

import org.jboss.aerogear.push.PushApplicationRegistry;
import org.jboss.aerogear.push.application.PushApplication;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 3/15/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileSystemApplicationRegistry implements PushApplicationRegistry {
    private final Map<String, PushApplication> pushApps = new LinkedHashMap<String, PushApplication>();

    @Override
    public void registerPushApplication(PushApplication pushApplication) {
        pushApps.put(pushApplication.getApplicationKey(), pushApplication);
    }

    @Override
    public void unregisterPushApplication(PushApplication pushApplication) {
        pushApps.remove(pushApplication.getApplicationKey());
    }

    @Override
    public PushApplication getPushApplication(String applicationKey) {
        return pushApps.get(applicationKey);
    }

    @Override
    public List<PushApplication> getPushApplications() {
        List<PushApplication> retVal = new ArrayList<PushApplication>(pushApps.values());
        return Collections.unmodifiableList(retVal);
    }
}
