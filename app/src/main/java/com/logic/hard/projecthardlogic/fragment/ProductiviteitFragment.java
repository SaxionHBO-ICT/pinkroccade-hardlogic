package com.logic.hard.projecthardlogic.fragment;

import android.content.Context;
import android.net.Uri;
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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductiviteitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductiviteitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductiviteitFragment extends Fragment {
    //private ListView lv;
    TextView tv_title_productiviteit, tv_title_handenaanbed;
    TextView tv_productiviteit, tv_handenaanbed;
    ProgressBar pgb_productiviteit, pgb_handenaanbed;

    public final static String key = "REPORTKEY";
    Button bt_back;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProductiviteitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LooplijstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductiviteitFragment newInstance(String param1, String param2) {
        ProductiviteitFragment fragment = new ProductiviteitFragment();
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

        pgb_handenaanbed.setMax((int) handenaanbed.getMaxValue());
        pgb_productiviteit.setMax((int) productiviteit.getMaxValue());
        pgb_handenaanbed.setProgress((int) handenaanbed.getInputValue());
        pgb_productiviteit.setProgress((int) productiviteit.getInputValue());

        tv_handenaanbed.setText(handenaanbed.getInputValue() +"/"+ handenaanbed.getMaxValue());
        tv_productiviteit.setText(productiviteit.getInputValue() +"/"+ productiviteit.getMaxValue());



        bt_back = (Button) v.findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
