package com.logic.hard.projecthardlogic.model;

import android.os.Bundle;

/**
 * Created by Vincent on 6/15/2016.
 */
public class LoopLijstItem {
    private String clientName;
    private String clientAddress;
    private String clientPhoneNumber;
    private String activity;
    private String comments;
    private String key;
    private String duration;
    private String startTime;

    /**
     * @param clientName    name of the client
     * @param clientAddress adress of the client
     * @param activity      activities that need to be done at the client
     * @param comments      (optional) comments
     */
    public LoopLijstItem(String clientName, String clientAddress, String activity, String comments) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.activity = activity;
        this.comments = comments;
    }

    public LoopLijstItem(String clientName, String clientAddress, String clientPhoneNumber, String activity, String comments, String key, String duration, String startTime) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhoneNumber = clientPhoneNumber;
        this.activity = activity;
        this.comments = comments;
        this.key = key;
        this.duration = duration;
        this.startTime = startTime;
    }

    /**
     * returns the client name
     * @return string clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * returns the client's address
     * @return string clientAddress
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * returns the activity
     * @return string activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * returns the comments
     * @return string comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * returns key
     * @return string key
     */
    public String getKey() {
        return key;
    }

    /**
     * Put all client data in a bundle.
     * @return bundle with client
     */
    public Bundle tobundle() {
        Bundle b = new Bundle();
        b.putString("NAME", clientName);
        b.putString("ADRESS", clientAddress);
        b.putString("PHONENUMBER", clientPhoneNumber);
        b.putString("ACTIVITY", activity);
        b.putString("COMMENT", comments);
        b.putString("KEY", key);
        b.putString("DURATION", duration);
        b.putString("STARTTIME", startTime);

        return b;
    }


}
