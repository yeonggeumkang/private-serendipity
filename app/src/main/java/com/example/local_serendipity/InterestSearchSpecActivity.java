package com.example.local_serendipity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class InterestSearchSpecActivity extends AppCompatActivity {
    boolean written;
    GridView gridInterest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_interest_specific);

        //Back button 활성화
        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //Submit Button 활성화
        written = false;
        Button btnPreSubmit = (Button)findViewById(R.id.btn_pre_submit);
        Button btnActiveSubmit = (Button)findViewById(R.id.btn_active_submit);
        if(written){
            btnPreSubmit.setVisibility(View.GONE);
            btnActiveSubmit.setVisibility(View.VISIBLE);
        }

        //gridview
        ArrayList<String> list = new ArrayList<>();
        list.add("자전거");
        list.add("배드민턴");
        list.add("테니스/스쿼시");
        list.add("볼링");
        list.add("스키/보드");
        list.add("골프");

        list.add("클라이밍");
        list.add("다이어트");
        list.add("헬스/크로스핏");
        list.add("탁구");
        list.add("요가/필라테스");
        list.add("농구");

        list.add("야구");
        list.add("배구");
        list.add("스케이트/인라인");
        list.add("펜싱");
        list.add("크루즈보드");

            // 커스텀 아답타 생성
        GridAdapter adapterA = new GridAdapter (getApplicationContext(),list);
        //GridView gv1 = (GridView)findViewById(R.id.gv_interest1);
        //GridView gv2 = (GridView)findViewById(R.id.gv_interest2);
        GridView gv3 = (GridView)findViewById(R.id.gv_interest3);

        //gv1.setAdapter(adapterA);
        //gv2.setAdapter(adapterA);
        gv3.setAdapter(adapterA);


        //리사이클러뷰에 표시할 데이터 리스트 생성.

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView1 = findViewById(R.id.recycler1) ;
        RecyclerView recyclerView2 = findViewById(R.id.recycler2) ;

        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        RecyclerAdapter2 adapter = new RecyclerAdapter2(list) ;
        recyclerView1.setAdapter(adapter) ;
        recyclerView2.setAdapter(adapter);
    }


}
