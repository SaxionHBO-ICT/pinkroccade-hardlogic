package com.logic.hard.projecthardlogic.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;


/**
 * Dialog fragment for showing option to pick date.
 * fragment will be started in a dialog
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private FragmentInteraction mListener;

    /**
     * added callbacks-intefrace for inter-fragment communication
     * @param context application context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (FragmentInteraction) context;
    }

    /**
     * When dialog is created, set initial value to current date
     * @param savedInstanceState saved state
     * @return dialog fragment with current date set
     */
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

    /**
     * when date is set, return using callbacks to reportlist_fragment
     * @param view  Datepicker view
     * @param anio year
     * @param mes month
     * @param dia day
     */
    @Override
    public void onDateSet(DatePicker view, int anio, int mes, int dia) {
        mListener.doSomethingWithDate(dia, mes + 1, anio);
    }

    public interface FragmentInteraction{
        public void doSomethingWithDate(int dia, int mes, int anio);
    }
}