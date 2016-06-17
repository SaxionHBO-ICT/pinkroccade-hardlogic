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


public class Looplijst_itemFragment extends Fragment {
    private TextView clientNaam, clientAdress, clientActiviteit, clientSleutel, clientopmerking;
    private Button bt_back;

    public Looplijst_itemFragment() {
        // Required empty public constructor
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
