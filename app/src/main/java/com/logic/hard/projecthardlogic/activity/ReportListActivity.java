package com.logic.hard.projecthardlogic.activity;

import android.net.Uri;
import android.os.Bundle;
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

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
