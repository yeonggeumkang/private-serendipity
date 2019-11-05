package com.example.local_serendipity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ArgActivity extends AppCompatActivity {
    private CustomDialogPhoto mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arg);


        Button btnArg = (Button)findViewById(R.id.btn_arg);
        btnArg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArgActivity.this, FavorActivity.class);
                startActivity(intent);
            }
        });
    }


    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "네",
                    Toast.LENGTH_SHORT).show();
            mCustomDialog.dismiss();
        }
    };

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "아니오",
                    Toast.LENGTH_SHORT).show();
        }
    };



    public void OnClickHandler(View view){

        mCustomDialog = new CustomDialogPhoto(this, leftListener, rightListener);
        mCustomDialog.show();
    }
}
