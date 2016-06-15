package com.logic.hard.projecthardlogic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.Report;
import com.logic.hard.projecthardlogic.model.ReportLoopLijst;
import com.logic.hard.projecthardlogic.model.ReportModel;

import java.util.List;

/**
 * Created by Werner on 15-06-16.
 */
public class LooplijstAdapter extends ArrayAdapter {
    public LooplijstAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //TODO set layout path
////        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.Looplijst,parent, false)
//        ReportLoopLijst report = (ReportLoopLijst) ReportModel.getInstance().getReportList().get(position);
//    }
}
