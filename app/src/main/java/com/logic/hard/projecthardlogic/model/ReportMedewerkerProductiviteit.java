package com.logic.hard.projecthardlogic.model;

/**
 * Created by Vincent on 6/8/2016.
 */
public class ReportMedewerkerProductiviteit extends Report {

    private String employeeName;
    private float productivity;

    /**
     * constructor
     * @param title the report title
     */
    public ReportMedewerkerProductiviteit(String title) {
        super(title);
    }
}
