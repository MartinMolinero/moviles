package com.example.malejmol.lab6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by malejmol on 23/02/17.
 */

public class myList extends ArrayAdapter<String> {
    private final Activity act;
    private final String[] bigText;
    private final Integer[] idImage;
    private final String[] smallText;

    public myList(Activity activity, String[] bt, Integer[] imId, String[] smText ){
        super(activity, R.layout.list_adapter, bt);
        this.act = activity;
        this.bigText = bt;
        this.smallText = smText;
        this.idImage = imId;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = act.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_adapter, null);

        ImageView imgV = (ImageView) rowView.findViewById(R.id.img);
        imgV.setImageResource(idImage[position]);

        TextView big = (TextView) rowView.findViewById(R.id.bigtxt);
        big.setText(bigText[position]);

        TextView small = (TextView) rowView.findViewById(R.id.smalltxt);
        small.setText(smallText[position]);

        ToggleButton check = (ToggleButton) rowView.findViewById(R.id.check);

        return rowView;
    }
}
