package com.logic.hard.projecthardlogic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.model.LoopLijstItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Werner on 15-06-16.
 */
public class LooplijstAdapter extends ArrayAdapter {
    TextView clientNaam, clientAdress, clientActiviteit, clientSleutel;
    List<LoopLijstItem> items;
    public LooplijstAdapter(Context context, int resource, List<LoopLijstItem> objects) {
        super(context, resource, objects);
        items = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO set layout path
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.looplijst_list_item, parent, false);

            LoopLijstItem i = items.get(position);

            clientNaam = (TextView) convertView.findViewById(R.id.tvClientNaamText);
            clientNaam.setText(i.getClientName());
            clientAdress = (TextView) convertView.findViewById(R.id.tvClientAdresText);
            clientAdress.setText(i.getClientAddress());
            clientActiviteit = (TextView) convertView.findViewById(R.id.tvActivityText);
            clientActiviteit.setText(i.getActivity());
            clientSleutel = (TextView) convertView.findViewById(R.id.tvSleutelText);
            clientSleutel.setText(i.getKey());
        }
        return convertView;
    }
}
