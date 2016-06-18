package com.logic.hard.projecthardlogic.model;

import java.util.ArrayList;

/**
 * Created by Vincent on 6/15/2016.
 */
public class LoopLijstModel extends Report {
    public static final String ITEMS = "ITEMS";

    private ArrayList<LoopLijstItem> items;

    /**
     * Constructor for a new LoopLijstModel
     * @param title Model title
     */
    public LoopLijstModel(String title) {
        super(title);
        items = new ArrayList<>();
    }

    public void addLoopLijstItem(LoopLijstItem item) {
        assert (item.getClientName() != null && item.getClientAddress() != null && item.getActivity() != null && item.getComments() != null);
        items.add(item);
    }

    /**
     * used to get looplijstitems from model
     * @return duplicate arraylist, so nothing can change
     */
    public ArrayList<LoopLijstItem> getItems() {
        return new ArrayList<>(items);
    }


}
