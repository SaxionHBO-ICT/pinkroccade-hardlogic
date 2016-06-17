package com.logic.hard.projecthardlogic.model;

import java.util.ArrayList;

/**
 * Created by Vincent on 5/25/2016.
 */
public class ReportModel {
    private static ReportModel instance = null;
    private ArrayList<Report> reports;

    public static ReportModel getInstance() {
        if(instance == null){
            instance = new ReportModel();
        }
        return instance;
    }

    private ReportModel() {
        reports = new ArrayList<>();
    }

    public String getTitle(int position){
        return reports.get(position).getTitle();
    }

    public ArrayList<Report> getReportList() {
        return reports;
    }

    public void addReport(Report r){
        reports.add(r);
    }
}
