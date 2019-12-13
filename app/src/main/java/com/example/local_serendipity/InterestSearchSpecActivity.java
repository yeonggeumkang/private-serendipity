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
        GridView gv1 = (GridView)findViewById(R.id.gv_interest1);
        GridView gv2 = (GridView)findViewById(R.id.gv_interest2);
        GridView gv3 = (GridView)findViewById(R.id.gv_interest3);

        gv1.setAdapter(adapterA);
        gv2.setAdapter(adapterA);
        gv3.setAdapter(adapterA);

    }


}
