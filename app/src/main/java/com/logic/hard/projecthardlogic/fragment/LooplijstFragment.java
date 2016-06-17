package com.logic.hard.projecthardlogic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;
import com.logic.hard.projecthardlogic.model.ReportModel;
import com.logic.hard.projecthardlogic.view.LooplijstAdapter;

public class LooplijstFragment extends Fragment {
    private LoopLijstModel lm;
    private ListView lv;
    public final static String key = "REPORTKEY";
    Button bt_back;

    public LooplijstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_looplijst_list, container, false);
        Bundle b = getArguments();;
        lm = (LoopLijstModel) ReportModel.getInstance().getReportList().get(b.getInt("POS"));

        LooplijstAdapter adapter = new LooplijstAdapter(getContext(), R.layout.looplijst_list_item, lm.getItems());

        lv = (ListView) v.findViewById(R.id.lv_loop_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Looplijst_itemFragment fragment = new Looplijst_itemFragment();
                fragment.setArguments(lm.getItems().get(position).tobundle());

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.reportList, fragment).addToBackStack(null).commit();
            }
        });


        bt_back = (Button) v.findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
