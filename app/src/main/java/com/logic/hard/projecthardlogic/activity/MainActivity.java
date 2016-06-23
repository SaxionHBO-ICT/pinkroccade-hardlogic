package com.logic.hard.projecthardlogic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.controller.XMLReader;

/**
 * Landing activity when opening app
 * Sends user to LoginFragment
 */
public class MainActivity extends AppCompatActivity {
    private static boolean notIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //set XML-layout file

        //Log.v("xmlTest", "onCreate");

        /**
         * If not already loaded, load in productiviteit and looplijst using XMLReader class
         * when loaded, update notIn Status.
         */
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
