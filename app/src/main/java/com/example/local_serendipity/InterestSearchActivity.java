package com.example.local_serendipity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InterestSearchActivity extends AppCompatActivity {
    boolean selected;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_interest);

        //Back button 활성화
        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //next button 활성화
        selected = false;
        btnNext = (Button)findViewById(R.id.btn_next);
        if(selected){
            btnNext.setBackgroundColor(getColor(R.color.colorCornflowerBlue));
        }
        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterestSearchActivity.this, InterestSearchSpecActivity.class);
                startActivity(intent);
            }
        });

    }

    public void OnClickInterest(View view){
        Toast.makeText(getApplicationContext(), "선택됨(test용)", Toast.LENGTH_SHORT).show();
        selected = true;
        btnNext.setBackgroundColor(getColor(R.color.colorCornflowerBlue));
    }
}
