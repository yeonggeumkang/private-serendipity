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
        list.add("요가/필라테스");
        list.add("레슬링");
        list.add("테니스/스쿼시");
        list.add("볼링");
        list.add("스키");
        list.add("헬스/크로스핏");
        list.add("탁구");
        list.add("스케이트/인라인");
        list.add("크루즈보드");


        // 커스텀 아답타 생성
        GridAdapter adapter = new GridAdapter (getApplicationContext(),list);

        GridView gv = (GridView)findViewById(R.id.gv_interest1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //tv.setText("position : " + position);
            }
        });

    }


}
