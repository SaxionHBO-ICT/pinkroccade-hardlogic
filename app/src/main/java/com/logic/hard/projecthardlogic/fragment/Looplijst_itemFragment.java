package com.logic.hard.projecthardlogic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.LoopLijstItem;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Looplijst_itemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Looplijst_itemFragment extends Fragment {
    private TextView clientNaam, clientAdress, clientActiviteit, clientSleutel, clientopmerking;
    private Button bt_back;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Looplijst_itemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Looplijst_itemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Looplijst_itemFragment newInstance(String param1, String param2) {
        Looplijst_itemFragment fragment = new Looplijst_itemFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_looplijst, container, false);
        Bundle b = getArguments();

        clientNaam = (TextView) v.findViewById(R.id.tv_cname);
        clientNaam.setText(b.getString("NAME"));
        clientAdress = (TextView) v.findViewById(R.id.tv_cadress);
        clientAdress.setText(b.getString("ADRESS"));
        clientActiviteit = (TextView) v.findViewById(R.id.tv_cactiviteit);
        clientActiviteit.setText(b.getString("ACTIVITY"));
        clientSleutel = (TextView) v.findViewById(R.id.tv_csleutel);
        clientSleutel.setText(b.getString("KEY"));
        clientopmerking = (TextView) v.findViewById(R.id.tv_copmerking);
        clientopmerking.setText(b.getString("COMMENT"));

        bt_back = (Button) v.findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return v;
    }

}
