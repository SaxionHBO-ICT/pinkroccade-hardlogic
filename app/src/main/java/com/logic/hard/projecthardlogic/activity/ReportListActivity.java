package com.logic.hard.projecthardlogic.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.fragment.DatePickerFragment;
import com.logic.hard.projecthardlogic.fragment.ReportListFragment;

/**
 * Main activity for showing Report menu.
 * Sends user to every other fragment.
 * first landing fragment = LooplijstFragment
 */
public class ReportListActivity extends AppCompatActivity implements DatePickerFragment.FragmentInteraction{
    private OnDateSetListener fragmentCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);  //set XML-layout file

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false); // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // remove the icon
        }

        ReportListFragment fragment = new ReportListFragment();     //set fragment in framelayout with id = reportlist
        fragmentCallbacks = (OnDateSetListener) fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.add(R.id.reportList, fragment);
        fragmenttransaction.addToBackStack("reportlist");
        fragmenttransaction.commit();



    }

    /**
     * Callback for when date is picked in DatePickerFragment
     * @param dia Day
     * @param mes Month
     * @param anio Year
     */
    @Override
    public void doSomethingWithDate(int dia, int mes, int anio) {
        fragmentCallbacks.doSomethingWithDate(dia, mes, anio);
    }


    public interface OnDateSetListener{
        public void doSomethingWithDate(int dia, int mes, int anio);
    }
}
