package com.logic.hard.projecthardlogic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.Report;


/**
 * Fragment that show a report
 * report is chosen in reportlistfragment
 */
public class ReportFragment extends Fragment {

    public ReportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        TextView tv_report_name = (TextView)view.findViewById(R.id.tv_report_name);

        //Set back button functionallity (using fragmentmanager)
        Button bt_back = (Button) view.findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        //retrieve data from bundle
        Bundle b = getArguments();
        if(b != null){
            String title = b.getString(Report.TITLE);
            tv_report_name.setText(title);
        }

        return view;
    }
}
