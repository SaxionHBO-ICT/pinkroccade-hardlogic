package com.logic.hard.projecthardlogic.model;

import android.os.Bundle;

/**
 * Created by Vincent on 5/25/2016.
 */
public abstract class Report {
    private String title;
    public static final String TITLE = "TITLE";

    /**
     * Constructor
     * @param title the title of the report you're going to create
     */
    public Report(String title) {
        this.title = title;
    }

    /**
     * Returns the report title
     * @return the report title
     */
    public String getTitle() {
        return title;
    }

    /**
     * basic constructor that creates a bundle so we can pass a string between activities and fragments
     * Classes that extend this class have a bit more info to send.
     * @return the created bundle
     */
    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putString(TITLE, title);

        return b;
    }
}
