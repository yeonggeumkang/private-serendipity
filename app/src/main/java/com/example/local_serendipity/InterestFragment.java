package com.example.local_serendipity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InterestFragment extends Fragment {
    private RecyclerView recyclerView;

    public InterestFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interest, container, false);


        // 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list = new ArrayList<>();
        list.add("자전거");
        list.add("요가/필라테스");
        list.add("레슬링");
        list.add("3대운동 300");

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler1) ;
        //recyclerView.setLayoutManager(new LinearLayoutManager(LinearLayoutManager.HORIZONTAL)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        RecyclerAdapter adapter = new RecyclerAdapter(list) ;
        recyclerView.setAdapter(adapter) ;
        return view;
    }


}