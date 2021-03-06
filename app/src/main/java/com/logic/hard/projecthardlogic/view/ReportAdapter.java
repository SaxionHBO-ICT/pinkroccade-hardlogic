package com.logic.hard.projecthardlogic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.Report;
import com.logic.hard.projecthardlogic.model.ReportModel;

import java.util.List;

/**
 * Adapter for showing reports in Reportlist (listview)
 */
public class ReportAdapter extends ArrayAdapter<Report> {

    public ReportAdapter(Context context, List<Report> objects) {
        super(context, -1, ReportModel.getInstance().getReportList());
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.report_list_item, parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_report_title);
        //tvTitle.setText("Sample");
        Report r = ReportModel.getInstance().getReportList().get(position);
        String t = ReportModel.getInstance().getTitle(position);
        tvTitle.setText(t);

        return convertView;
    }
}
