package com.example.androidinovation.ListType.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidinovation.R;


/**
 * Created by sonu on 15/15/2023.
 */

public class ListViewAdapter extends ArrayAdapter<String> {
    Context context;
    String[] style;


    public ListViewAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.style = objects;
    }

//    @Override
//    public View getDropDownView(int position, View convertView,
//                                ViewGroup parent) {
//        return getCustomView(position, convertView, parent);
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView,  ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(context).inflate(R.layout.spinner_row, parent, false);
//        LayoutInflater inflater = getLayoutInflater();
//        View row = inflater.inflate(R.layout.spinner_row, parent, false);

            TextView label = (TextView) row.findViewById(R.id.textView1);
             label.setText(style[position]);

        }

        return row;
    }

}
