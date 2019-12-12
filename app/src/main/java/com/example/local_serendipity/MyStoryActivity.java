package com.example.local_serendipity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyStoryActivity extends AppCompatActivity {
    private CustomDialogDouble mDialogSubmit;
    boolean written;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_story);

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
        written = true;
        Button btnPreSubmit = (Button)findViewById(R.id.btn_pre_submit);
        Button btnActiveSubmit = (Button)findViewById(R.id.btn_active_submit);
        if(written){
            btnPreSubmit.setVisibility(View.GONE);
            btnActiveSubmit.setVisibility(View.VISIBLE);
        }

        //Title Spannable 설정
        TextView tvTitle = (TextView)findViewById(R.id.tv_title);

    }
    // Set Submit
    private View.OnClickListener YesListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "저장", Toast.LENGTH_SHORT).show();
            mDialogSubmit.dismiss();
            finish();
        }
    };

    private View.OnClickListener NoListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
            mDialogSubmit.dismiss();
        }
    };

    public void OnClickHandlerSubmit(View view){
        mDialogSubmit = new CustomDialogDouble(this, "변경사항을 저장하시겠어요?", YesListener, NoListener);
        mDialogSubmit.show();
    }
}
