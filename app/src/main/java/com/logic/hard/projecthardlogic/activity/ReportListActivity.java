package com.logic.hard.projecthardlogic.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.fragment.ReportListFragment;

/**
 * Created by Vincent on 5/25/2016.
 */
public class ReportListActivity extends AppCompatActivity implements ReportListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false); // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // remove the icon
        }

        //set fragment in framelayout with id = reportlist
        ReportListFragment fragment = new ReportListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.add(R.id.reportList, fragment);
        fragmenttransaction.addToBackStack("reportlist");
        fragmenttransaction.commit();


    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}