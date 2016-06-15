package com.logic.hard.projecthardlogic.model;

import java.util.ArrayList;

/**
 * Created by Vincent on 6/15/2016.
 */
public class ReportLoopLijst extends Report {

    private ArrayList<LoopLijstItem> items;

    public ReportLoopLijst(String title) {
        super(title);
        items = new ArrayList<>();
    }

    public void addLoopLijstItem(LoopLijstItem item) {
        assert (item.getClientName() != null && item.getClientAddress() != null && item.getActivity() != null && item.getComments() != null);
        items.add(item);
    }

    public ArrayList<LoopLijstItem> getItems() {
        return new ArrayList<>(items);
    }
}
