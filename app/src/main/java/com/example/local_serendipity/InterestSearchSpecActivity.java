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
        ArrayList<String> listSports = new ArrayList<>();
        listSports.add("자전거");
        listSports.add("볼링");
        listSports.add("클라이밍");
        listSports.add("탁구");
        listSports.add("야구");
        listSports.add("펜싱");

        listSports.add("배드민턴");
        listSports.add("스키/보드");
        listSports.add("다이어트");
        listSports.add("요가/필라테스");
        listSports.add("배구");
        listSports.add("크루즈보드");
        listSports.add("테니스/스쿼시");

        listSports.add("스케이트/인라인");
        listSports.add("골프");
        listSports.add("헬스/크로스핏");
        listSports.add("농구");

        ArrayList<String> listMusic = new ArrayList<>();
        listMusic.add("노래/보컬");
        listMusic.add("기타/베이스");
        listMusic.add("우쿨렐레");
        listMusic.add("드럼");
        listMusic.add("피아노");
        listMusic.add("바이올린");

        listMusic.add("플룻");
        listMusic.add("오카리나");
        listMusic.add("밴드/합주");
        listMusic.add("작사/작곡");
        listMusic.add("인디음악");
        listMusic.add("랩/힙합");
        listMusic.add("클래식");

        listMusic.add("재즈");
        listMusic.add("락/메탈");
        listMusic.add("일렉");
        listMusic.add("국악");
        listMusic.add("찬양/CCM");
        listMusic.add("뉴에이지");



        //리사이클러뷰에 표시할 데이터 리스트 생성.

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView1 = findViewById(R.id.recycler1) ;
        RecyclerView recyclerView2 = findViewById(R.id.recycler2) ;

        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL));

        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        RecyclerAdapter2 adapterSports = new RecyclerAdapter2(listSports) ;
        RecyclerAdapter2 adapterMusic = new RecyclerAdapter2(listMusic);
        recyclerView1.setAdapter(adapterSports);
        recyclerView2.setAdapter(adapterMusic);
    }


}
