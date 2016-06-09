package com.logic.hard.projecthardlogic.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Werner on 09-06-16.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private FragmentInteraction mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (FragmentInteraction) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Show picker with actual date presetted
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int anio, int mes, int dia) {
        mListener.doSomethingWithDate(dia, mes + 1, anio);
    }

    public interface FragmentInteraction{
        public void doSomethingWithDate(int dia, int mes, int anio);
    }
}