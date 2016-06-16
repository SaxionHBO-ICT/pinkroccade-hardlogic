package com.logic.hard.projecthardlogic.model;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by Vincent on 6/15/2016.
 */
public class LoopLijstModel extends Report {



    private ArrayList<LoopLijstItem> items = null;
    public static LoopLijstModel instance;

    private LoopLijstModel(String title) {
        super(title);
        items = new ArrayList<>();
        instance = this;

    }

    public static LoopLijstModel getInstance(){
        if(instance == null){
            instance = new LoopLijstModel("Looplijst");

        }
        return instance;
    }




    public void addLoopLijstItem(LoopLijstItem item) {
        items.add(item);
    }

    public ArrayList<LoopLijstItem> getItems() {
        return new ArrayList<>(items);
    }




}
