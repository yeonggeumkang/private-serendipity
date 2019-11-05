package com.example.local_serendipity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FavorFragment extends Fragment {

    private String title;
    private int page;
    private ArrayList list;

    public static FavorFragment newInstance(String title, List contentsList) {
        FavorFragment fragment = new FavorFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        args.putStringArrayList("someList", (ArrayList<String>) contentsList);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("someTitle");
        list = getArguments().getStringArrayList("someList");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favor, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        TextView tv1 = (TextView) view.findViewById(R.id.tv_1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv_2);
        TextView tv3 = (TextView) view.findViewById(R.id.tv_3);
        TextView tv4 = (TextView) view.findViewById(R.id.tv_4);
        TextView tv5 = (TextView) view.findViewById(R.id.tv_5);
        tv1.setText((String)list.get(0));
        tv2.setText((String)list.get(1));
        tv3.setText((String)list.get(2));
        tv4.setText((String)list.get(3));
        tv5.setText((String)list.get(4));
        return view;
    }
}