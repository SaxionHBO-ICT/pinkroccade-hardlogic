package com.logic.hard.projecthardlogic.model;

import java.util.ArrayList;

/**
 * Created by Vincent on 5/25/2016.
 */
public class ReportModel {
    private static ReportModel ourInstance = new ReportModel();
    private ArrayList<Report> reports;

    public static ReportModel getInstance() {
        return ourInstance;
    }

    private ReportModel() {
        reports = new ArrayList<>();
        int number = 0;

        reports.add(new Report("Looplijst"));
        reports.add(new Report("Urentabel"));
    }

    public ArrayList<Report> getReportList() {
        return reports;
    }
}
