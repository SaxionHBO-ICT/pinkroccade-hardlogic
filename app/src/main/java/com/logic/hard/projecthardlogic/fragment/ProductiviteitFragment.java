package com.logic.hard.projecthardlogic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.Gauge;
import com.logic.hard.projecthardlogic.model.Productiviteit;
import com.logic.hard.projecthardlogic.model.ReportModel;


/**
 * Fragment for showing Productiviteit Report.
 * Fragment contains 2 gauges (Progressbars) that will be filled
 * using Gauges in Productiviteit class
 */
public class ProductiviteitFragment extends Fragment {

    //Objects in ProductiviteitFragment
    private TextView tv_title_productiviteit, tv_title_handenaanbed;
    private TextView tv_productiviteit, tv_handenaanbed;
    private ProgressBar pgb_productiviteit, pgb_handenaanbed;

    public final static String key = "REPORTKEY";
    private Button bt_back;

    public ProductiviteitFragment() {
        // Required empty public constructor
    }

    /**
     * initialize fragment with objects and set info
     * @param inflater layoutinflator
     * @param container viewgroud
     * @param savedInstanceState savedinstance
     * @return view with object filled
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_productiviteit, container, false);
        Bundle b = getArguments();
        Productiviteit p = (Productiviteit) ReportModel.getInstance().getReportList().get(b.getInt("POS"));
        Gauge[] items = p.getGauges();
        Gauge productiviteit = items[Productiviteit.PRODUCTIVITEIT];
        Gauge handenaanbed = items[Productiviteit.HANDENAANBED];

        tv_title_handenaanbed = (TextView) v.findViewById(R.id.tv_title_HandenAanBed);
        tv_title_productiviteit = (TextView) v.findViewById(R.id.tv_title_Productiviteit);
        tv_handenaanbed = (TextView) v.findViewById(R.id.tvHandenAanBed);
        tv_productiviteit = (TextView) v.findViewById(R.id.tvProductiviteit);
        pgb_handenaanbed = (ProgressBar) v.findViewById(R.id.pgbHandenAanBed);
        pgb_productiviteit = (ProgressBar) v.findViewById(R.id.pgbProductiviteit);

        //Set maximum value for both Gauges
        pgb_handenaanbed.setMax((int) handenaanbed.getMaxValue());
        pgb_productiviteit.setMax((int) productiviteit.getMaxValue());

        //Set value for both Gauges
        pgb_handenaanbed.setProgress((int) handenaanbed.getInputValue());
        pgb_productiviteit.setProgress((int) productiviteit.getInputValue());

        //Set Value for Gauge Textview
        tv_handenaanbed.setText(handenaanbed.getInputValue() +"/"+ handenaanbed.getMaxValue());
        tv_productiviteit.setText(productiviteit.getInputValue() +"/"+ productiviteit.getMaxValue());

        //Set back button functionallity
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
