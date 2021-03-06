package org.jboss.aerogear.push.impl;

import java.io.IOException;
import java.util.List;

import org.jboss.aerogear.push.application.AndroidApplication;
import org.jboss.aerogear.push.application.MobileApplicationInstance;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class AndroidApp extends MobileApplicationImpl implements
        AndroidApplication {
    
    private String googleAPIKey;
    private Sender sender = null;

    @Override
    public void setGoogleAPIKey(String apiKey) {
        this.googleAPIKey = apiKey;
    }

    @Override
    public <T> void send(T message) {
        // meh:
        sender = new Sender(googleAPIKey);
        
        List<MobileApplicationInstance> instances = this.getInstances();
        //String token = instances.get(0).getDeviceToken();
        
        String token = "123";
        Message msg = new Message.Builder().addData("text", message.toString()).addData("title", "FOOOOO").build();
        
        
        // send it out.....
        try {
            sender.send(msg, token, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        

    }

}
