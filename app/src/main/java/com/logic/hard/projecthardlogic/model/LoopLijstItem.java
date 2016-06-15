package com.logic.hard.projecthardlogic.model;

/**
 * Created by Vincent on 6/15/2016.
 */
public class LoopLijstItem {
    private String clientName;
    private String clientAddress;
    private String activity;
    private String comments;

    public LoopLijstItem(String clientName, String clientAddress, String activity) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.activity = activity;
        this.comments = "";
    }

    public LoopLijstItem(String clientName, String clientAddress, String activity, String comments) {
        this(clientName, clientAddress, activity);
        this.comments = comments;
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
}
