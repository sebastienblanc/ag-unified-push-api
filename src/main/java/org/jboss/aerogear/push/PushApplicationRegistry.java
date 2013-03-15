package org.jboss.aerogear.push;

import org.jboss.aerogear.push.application.PushApplication;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 3/15/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PushApplicationRegistry {


    /**
     * Adds a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void registerPushApplication(PushApplication pushApplication);

    /**
     * Removes a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void unregisterPushApplication(PushApplication pushApplication);

    /**
     * Returns a specific <code>PushApplication</code> instance, identified by its
     * applicationKey.
     */
    PushApplication getPushApplication(String applicationKey);

    /**
     * List of all registered <code>PushApplication</code>s...
     */
    List<PushApplication> getPushApplications();
}
