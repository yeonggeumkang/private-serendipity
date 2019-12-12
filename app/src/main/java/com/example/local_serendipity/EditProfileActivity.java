package com.example.local_serendipity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private CustomDialogDouble mDialog;
    Button btnBody1, btnBody2, btnBody3, btnBody4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //Set Button to back
        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //Set Submit Button
        boolean changed = true;
        Button btnPreSubmit = (Button)findViewById(R.id.btn_pre_submit);
        Button btnActiveSubmit = (Button)findViewById(R.id.btn_active_submit);
        if(changed){
            btnPreSubmit.setVisibility(View.GONE);
            btnActiveSubmit.setVisibility(View.VISIBLE);
        }


        //Set City spinner
        Spinner spinnerCity = (Spinner)findViewById(R.id.spinner_city);
        ArrayAdapter<CharSequence> adapterC = ArrayAdapter.createFromResource(this,
                R.array.city_array, R.layout.support_simple_spinner_dropdown_item);
        adapterC.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterC);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Set height spinner
        Spinner spinnerHeight = (Spinner)findViewById(R.id.spinner_height);
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(this,
                R.array.height_array, R.layout.support_simple_spinner_dropdown_item);
        adapterH.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerHeight.setAdapter(adapterH);

        spinnerHeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Set Body Buttons
        btnBody1 = (Button)findViewById(R.id.btn_body1);
        btnBody2 = (Button)findViewById(R.id.btn_body2);
        btnBody3 = (Button)findViewById(R.id.btn_body3);
        btnBody4 = (Button)findViewById(R.id.btn_body4);

        //Set Interest Button
        Button btnInterest = (Button)findViewById(R.id.btn_more_interest);
        btnInterest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfileActivity.this, InterestSearchActivity.class);
                startActivity(intent);
            }
        });
    }
    // Start Chatting
    private View.OnClickListener YesListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "저장", Toast.LENGTH_SHORT).show();
            mDialog.dismiss();
        }
    };

    private View.OnClickListener NoListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
            mDialog.dismiss();
        }
    };

    public void OnClickHandlerSubmit(View view){
        mDialog = new CustomDialogDouble(this, "변경사항을 저장하시겠어요?", YesListener, NoListener);
        mDialog.show();
    }

    public void setDefault(Button btnA, Button btnB, Button btnC){
        btnA.setTextColor(getColor(R.color.colorMineShaft));
        btnA.setBackground(getDrawable(R.drawable.custom_edit_text));
        btnB.setTextColor(getColor(R.color.colorMineShaft));
        btnB.setBackground(getDrawable(R.drawable.custom_edit_text));
        btnC.setTextColor(getColor(R.color.colorMineShaft));
        btnC.setBackground(getDrawable(R.drawable.custom_edit_text));
    }

    public void setFocused(Button btn){
        btn.setTextColor(getColor(R.color.colorRoyalBlue2));
        btn.setBackground(getDrawable(R.drawable.custom_focus_button));
    }

    public void OnClickBtnBody(View view){
        switch(view.getId()) {
            case R.id.btn_body1:
                setFocused(btnBody1);
                setDefault(btnBody2, btnBody3, btnBody4);
                break;
            case R.id.btn_body2:
                setFocused(btnBody2);
                setDefault(btnBody1, btnBody3, btnBody4);
                break;
            case R.id.btn_body3:
                setFocused(btnBody3);
                setDefault(btnBody2, btnBody1, btnBody4);
                break;
            case R.id.btn_body4:
                setFocused(btnBody4);
                setDefault(btnBody1, btnBody2, btnBody3);
                break;
        }
        //Toast.makeText(getApplicationContext(), "선택됨(test용)", Toast.LENGTH_SHORT).show();
    }

}
