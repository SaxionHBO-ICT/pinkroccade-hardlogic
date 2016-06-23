package com.logic.hard.projecthardlogic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.controller.XMLReader;

public class MainActivity extends AppCompatActivity {
    private static boolean notIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.v("xmlTest", "onCreate");

        if(notIn) {
            XMLReader.readProductivityXML(getApplicationContext());
            XMLReader.readLoopLijstXML(getApplicationContext());
            notIn = false;
        }
    }

    @Override
    protected void onResume() {
        getSupportFragmentManager().popBackStackImmediate();
        super.onResume();
    }

}
