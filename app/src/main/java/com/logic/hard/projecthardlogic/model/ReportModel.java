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

    /**
     * Return the report, given at a position
     * @param position of the Report in the listview
     * @return report, connected to position in listview
     */
    public String getTitle(int position){
        return reports.get(position).getTitle();
    }

    /**
     * return reports
     * @return duplicate arraylist, for safety
     */
    public ArrayList<Report> getReportList() {
        return reports;
    }

    public void addReport(Report r){
        reports.add(r);
    }
}
