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

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getActivity() {
        return activity;
    }

    public String getComments() {
        return comments;
    }

    public String getKey() {
        return key;
    }

    public Bundle tobundle(){
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



    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
