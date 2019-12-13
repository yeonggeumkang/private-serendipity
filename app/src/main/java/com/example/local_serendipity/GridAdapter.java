package com.example.local_serendipity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class GridAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList list;
    LayoutInflater inf;

    public GridAdapter(Context context, ArrayList list) {
        this.context = context;
        //this.layout = layout;
        this.list = list;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inf.inflate(R.layout.layout_interest_item, null);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_item);
        tv.setText((String) list.get(position));

        return convertView;
    }
}
