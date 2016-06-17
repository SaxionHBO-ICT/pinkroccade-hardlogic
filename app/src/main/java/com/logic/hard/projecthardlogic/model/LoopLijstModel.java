package com.logic.hard.projecthardlogic.model;

import java.util.ArrayList;

/**
 * Created by Vincent on 6/15/2016.
 */
public class LoopLijstModel extends Report {
    public static final String ITEMS = "ITEMS";


    private ArrayList<LoopLijstItem> items;
    public static LoopLijstModel instance;

    public LoopLijstModel(String title) {
        super(title);
        items = new ArrayList<>();
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));
//        items.add(new LoopLijstItem("dfsfd", "dsgdfgdfg", "ssdfdgd", "GDsfgdgd"));

    }
    public static LoopLijstModel getInstance(){
        if(instance == null){
            instance = new LoopLijstModel("Looplijst");
        }
        return instance;
    }

    public void addLoopLijstItem(LoopLijstItem item) {
        assert (item.getClientName() != null && item.getClientAddress() != null && item.getActivity() != null && item.getComments() != null);
        items.add(item);
    }

    public ArrayList<LoopLijstItem> getItems() {
        return new ArrayList<>(items);
    }


}
