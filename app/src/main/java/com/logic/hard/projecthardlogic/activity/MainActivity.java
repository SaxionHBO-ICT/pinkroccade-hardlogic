package com.logic.hard.projecthardlogic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logic.hard.projecthardlogic.R;
//import com.logic.hard.projecthardlogic.model.InputParser;
import com.logic.hard.projecthardlogic.model.LoopLijstItem;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onResume() {
        getSupportFragmentManager().popBackStackImmediate();
        super.onResume();
    }
}
