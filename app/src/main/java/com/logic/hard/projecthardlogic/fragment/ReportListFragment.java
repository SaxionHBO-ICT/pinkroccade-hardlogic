package com.logic.hard.projecthardlogic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.activity.ReportListActivity;
import com.logic.hard.projecthardlogic.model.LoopLijstItem;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;
import com.logic.hard.projecthardlogic.model.Report;
import com.logic.hard.projecthardlogic.model.ReportHandenAanBed;
import com.logic.hard.projecthardlogic.model.ReportMedewerkerProductiviteit;
import com.logic.hard.projecthardlogic.model.ReportModel;
import com.logic.hard.projecthardlogic.view.ReportAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportListFragment extends Fragment implements ReportListActivity.OnDateSetListener {
    public static final String ITEMS = "ITEMS";
    private String naam, adress, product, tijd, opmerking, sleutel;
    private XmlPullParserFactory xmlFactory;
    private XmlPullParser parser;
    public static final int KEY_OK = 0;
    public static final int KEY_ERROR = -1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView reportList;
    private TextView tv_date;

    private OnFragmentInteractionListener mListener;

    public ReportListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportListFragment newInstance(String param1, String param2) {
        ReportListFragment fragment = new ReportListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.report_list_fragment, container, false);
        reportList = (ListView) rootView.findViewById(R.id.reportList);

        ReportAdapter adapter = new ReportAdapter(getActivity(), ReportModel.getInstance().getReportList());
        reportList.setAdapter(adapter);

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
                Report s = ReportModel.getInstance().getReportList().get(position);

                if (s instanceof LoopLijstModel) {
                    //TODO MAKE GO TO LOOPLIJSTVIEW
                    LooplijstFragment fragment = new LooplijstFragment();
                    Bundle b = ReportModel.getInstance().getReportList().get(position).toBundle();
                    fragment.setArguments(b);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.reportList, fragment).addToBackStack(null).commit();
                } else if (s instanceof ReportHandenAanBed) {
                    //TODO MAKE GO TO HANDENAANBED
                } else if (s instanceof ReportMedewerkerProductiviteit) {
                    //TODO MAKE GO TO PRODUCTIVITEIT
                }


//                //TODO to make select work just uncomment line under here
////                if (s instanceof ReportHandenAanBed || s instanceof ReportMedewerkerProductiviteit) {
//                    ReportFragment fragment = new ReportFragment();
//                    Bundle b = ReportModel.getInstance().getReportList().get(position).toBundle();
//                    fragment.setArguments(b);
//
//
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.reportList, fragment).addToBackStack(null).commit();
//                //TODO and this1
//                }


            }
        });


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

    private String setDate() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return year + " - " + month + " - " + day;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void doSomethingWithDate(int dia, int mes, int anio) {
        Toast.makeText(getContext(), "Datum ingesteld op: " + dia + " - " + mes + " - " + anio, Toast.LENGTH_LONG).show();
        tv_date.setText(dia + " - " + mes + " - " + anio);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
