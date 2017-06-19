package com.example.nikhil.saibabaxd.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nikhil.saibabaxd.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Nikhil on 5/24/2017.
 */

public class GridViewAdapter extends BaseAdapter{

    LayoutInflater layoutInflater = null;
    Context cont;
    ArrayList <String> Name  = new ArrayList<String>();

    public GridViewAdapter ( ArrayList<String> result, Context context)
    {
        Name = result;
        cont = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return Name.size();
    }

    @Override
    public Object getItem(int position) {
        return Name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.activity_gridview,null);
      TextView tv = (TextView)view.findViewById(R.id.label);
        tv.setText(Name.get(position));
        return view;
    }



}
