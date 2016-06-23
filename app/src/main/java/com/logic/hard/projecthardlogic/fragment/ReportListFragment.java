package com.logic.hard.projecthardlogic.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.activity.ReportListActivity;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;
import com.logic.hard.projecthardlogic.model.Productiviteit;
import com.logic.hard.projecthardlogic.model.Report;
import com.logic.hard.projecthardlogic.model.ReportModel;
import com.logic.hard.projecthardlogic.view.ReportAdapter;

import java.util.Calendar;

/**
 * Fragment used to display ReportList, also added OnClickListener
 * to function as a menu (in ReportListActivity)
 */
public class ReportListFragment extends Fragment implements ReportListActivity.OnDateSetListener {

    private ListView reportList;
    private TextView tv_date;

    public ReportListFragment() {
        // Required empty public constructor
    }

    /**
     * Initialize and fill in objects in fragment
     * @param inflater layoutinflator
     * @param container viewgroup
     * @param savedInstanceState savedinstance
     * @return view with objects filled
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.report_list_fragment, container, false);
        reportList = (ListView) rootView.findViewById(R.id.reportList);

        reportList.setAdapter(new ReportAdapter(getContext(), ReportModel.getInstance().getReportList()));

        TextView tv_welcome = (TextView) rootView.findViewById(R.id.tv_welcome);
        getActivity().getIntent().getStringExtra("username");
        tv_welcome.setText("Welkom: " + getActivity().getIntent().getStringExtra("username"));

        tv_date = (TextView) rootView.findViewById(R.id.et_select_date);
        tv_date.setText(setDate());
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), setDate());
            }
        });

        //set onitemclicklistener for listview
        reportList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Report s = ReportModel.getInstance().getReportList().get(position); //chosen report

                //If chosen item is LoopLijst do:
                if(s instanceof LoopLijstModel){
                    LooplijstFragment fragment = new LooplijstFragment();
                    Bundle b = new Bundle();
                    b.putInt("POS", position);
                    fragment.setArguments(b);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.reportList, fragment).addToBackStack(null).commit();

                //If chosen item is Productiveit do:
                } else if(s instanceof Productiviteit){
                    ProductiviteitFragment fragment = new ProductiviteitFragment();
                    Bundle b = new Bundle();
                    b.putInt("POS", position);
                    fragment.setArguments(b);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.reportList, fragment).addToBackStack(null).commit();
                }
            }
        });


        //Logout button with functionallity
        Button bt_logout = (Button) rootView.findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                Toast.makeText(getContext(), "Uitgelogd", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    /**
     * Set current date for Textview date
     * @return String with current date
     */
    //Set current date for date picker
    private String setDate(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return year +" - "+ month +" - "+ day;
    }

    /**
     * implemented interface for callbacks from datepickerDialog
     * set date in TextView for notifing user
     * send toast message with date that is set
     * @param dia day
     * @param mes month
     * @param anio year
     */
    @Override
    public void doSomethingWithDate(int dia, int mes, int anio) {
        Toast.makeText(getContext(), "Datum ingesteld op: " + dia +" - "+ mes +" - "+ anio, Toast.LENGTH_LONG).show();
        tv_date.setText(dia +" - "+ mes +" - "+ anio);
    }
}
