/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.aerogear.push;

import java.util.List;

import org.jboss.aerogear.push.application.MobileApplication;
import org.jboss.aerogear.push.application.MobileApplicationInstance;
import org.jboss.aerogear.push.application.PushApplication;

/**
 * Manages all "Push applications"
 */
public class UnifiedPushManager {

    private PushApplicationRegistry pushApplicationRegistry;

    private Sender sender;


    List<PushApplication> findApplications(ApplicationQuery applicationQuery){
        //blabla
        return applicationQuery.getResults();
    }


    /**
     * Adds a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void registerPushApplication(PushApplication pushApplication){
         this.getPushApplicationRegistry().registerPushApplication(pushApplication);
    }

    /**
     * Removes a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void unregisterPushApplication(PushApplication pushApplication){
        this.getPushApplicationRegistry().unregisterPushApplication(pushApplication);
    }

    /**
     * Returns a specific <code>PushApplication</code> instance, identified by its
     * applicationKey.
     */
    PushApplication getPushApplication(String applicationKey) {
       return this.getPushApplicationRegistry().getPushApplication(applicationKey);
    }

    /**
     * List of all registered <code>PushApplication</code>s...
     */
    List<PushApplication> getPushApplications(){
        return this.getPushApplicationRegistry().getPushApplications();
    }

    public <T> void sendMessage(T message) {
        getSender().sendMessage(message);
    }

    public <T> void sendMessageToDevice(T message, MobileApplicationInstance installation) {
        getSender().sendMessageToDevice(message, installation);
    }

    public <T> void sendMessageToDevices(T message, List<MobileApplicationInstance> installations) {
        getSender().sendMessageToDevices(message, installations);
    }

    public <T> void sendMessageToApplications(T message, List<PushApplication> apps) {
        getSender().sendMessageToApplications(message, apps);
    }

    public <T> void sendMessageToMobileApplication(T message, MobileApplication app) {
        getSender().sendMessageToMobileApplication(message, app);
    }

    public <T> void sendMessageToMobileApplications(T message, List<MobileApplication> apps) {
        getSender().sendMessageToMobileApplications(message, apps);
    }

    public <T> void sendMessageToApplication(T message, PushApplication app) {
        getSender().sendMessageToApplication(message, app);
    }







    public PushApplicationRegistry getPushApplicationRegistry() {
        return pushApplicationRegistry;
    }

    public void setPushApplicationRegistry(PushApplicationRegistry pushApplicationRegistry) {
        this.pushApplicationRegistry = pushApplicationRegistry;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
