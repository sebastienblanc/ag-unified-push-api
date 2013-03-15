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

import org.jboss.aerogear.push.application.MobileApplicationInstance;
import org.jboss.aerogear.push.application.PushApplication;
import org.jboss.aerogear.push.impl.*;
import org.junit.Before;
import org.junit.Test;

public class UnifiedPushManagerTest {

    private UnifiedPushManager pushMgr;

    private PushApplicationRegistry registry;

    private Sender sender;

    @Before
    public void setup() {
        pushMgr = new UnifiedPushManager();
        registry = new FileSystemApplicationRegistry();
        pushMgr.setPushApplicationRegistry(registry);
        sender = new SenderImpl();
        pushMgr.setSender(sender);
    }

    @Test
    public void sendNotificationTo_iOS_and_Android() {
        // CREATE push app:
        PushApplication pa = new PushApplicationImpl();
        pa.setName("All The Thingz - backend");
        pa.setDescription("Logical rep. of a application that needs to push notifications to different mobile apps");

        // iOS app:
        iOSApp pusher = new iOSApp();
        pusher.setAppleAppId("net.wessendorf.Pusher");
        pusher.setCertificate("/Users/matzew/Desktop/CERT.p12");
        pusher.setPassphrase("foo");

        // DEVICE REG:
        MobileApplicationInstance installedApp = new MobileApplicationInstanceImpl();
        installedApp
                .setDeviceToken("MEH-123");
        pusher.addInstance(installedApp);

        // add the iOS app:
        pa.addMobileApplication(pusher);

        AndroidApp todoApp = new AndroidApp();
        todoApp.setGoogleAPIKey("KEY");

        // DEVICE REG:
        MobileApplicationInstance installedAndroidApp = new MobileApplicationInstanceImpl();
        installedAndroidApp
                .setDeviceToken("TOKEN-FOR-Android");
        todoApp.addInstance(installedAndroidApp);

        // add the app:
        pa.addMobileApplication(todoApp);

        // register it with server:
        pushMgr.registerPushApplication(pa);

        // send the message to all devices/mobile apps, for this Push app"
        pushMgr.sendMessageToApplications("Yo, dude!",pushMgr.getPushApplications());
    }
}
