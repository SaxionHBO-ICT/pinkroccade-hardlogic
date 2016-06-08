package com.logic.hard.projecthardlogic.model;

import android.os.Bundle;

/**
 * Created by Vincent on 5/25/2016.
 */
public class Report {
    private String title;
    private String startDate;
    private String endDate;
    public static final String TITLE = "TITLE";

    public Report(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putString(TITLE, title);

        return b;
    }
}
