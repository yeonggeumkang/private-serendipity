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
        return 1;
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
            convertView = inf.inflate(R.layout.layout_interest_items, null);
        TextView tv1 = (TextView) convertView.findViewById(R.id.tv_item1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.tv_item2);
        TextView tv3 = (TextView) convertView.findViewById(R.id.tv_item3);
        TextView tv4 = (TextView) convertView.findViewById(R.id.tv_item4);
        TextView tv5 = (TextView) convertView.findViewById(R.id.tv_item5);
        TextView tv6 = (TextView) convertView.findViewById(R.id.tv_item6);
        TextView tv7 = (TextView) convertView.findViewById(R.id.tv_item7);
        TextView tv8 = (TextView) convertView.findViewById(R.id.tv_item8);
        TextView tv9 = (TextView) convertView.findViewById(R.id.tv_item9);
        TextView tv10 = (TextView) convertView.findViewById(R.id.tv_item10);
        TextView tv11 = (TextView) convertView.findViewById(R.id.tv_item11);
        TextView tv12 = (TextView) convertView.findViewById(R.id.tv_item12);
        TextView tv13 = (TextView) convertView.findViewById(R.id.tv_item13);
        TextView tv14 = (TextView) convertView.findViewById(R.id.tv_item14);
        TextView tv15 = (TextView) convertView.findViewById(R.id.tv_item15);
        TextView tv16 = (TextView) convertView.findViewById(R.id.tv_item16);
        TextView tv17 = (TextView) convertView.findViewById(R.id.tv_item17);

        tv1.setText((String) list.get(0));
        tv2.setText((String) list.get(1));
        tv3.setText((String) list.get(2));
        tv4.setText((String) list.get(3));
        tv5.setText((String) list.get(4));
        tv6.setText((String) list.get(5));
        tv7.setText((String) list.get(6));
        tv8.setText((String) list.get(7));
        tv9.setText((String) list.get(8));
        tv10.setText((String) list.get(9));
        tv11.setText((String) list.get(10));
        tv12.setText((String) list.get(11));
        tv13.setText((String) list.get(12));
        tv14.setText((String) list.get(13));
        tv15.setText((String) list.get(14));
        tv16.setText((String) list.get(15));
        tv17.setText((String) list.get(16));

        return convertView;
    }
}
