package com.example.local_serendipity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPast = (Button)findViewById(R.id.btn_past);
        btnPast.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PastActivity.class);
                startActivity(intent);
            }
        });


        Button btnTutorial = (Button)findViewById(R.id.btn_tutorial);
        btnTutorial.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });

        Button btnProfile = (Button)findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        Button btnYourProfile = (Button)findViewById(R.id.btn_your_profile);
        btnYourProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, YourProfileActivity.class);
                startActivity(intent);
            }
        });

        Button btnInterestList = (Button)findViewById(R.id.btn_interest_list);
        btnInterestList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InterestListActivity.class);
                startActivity(intent);
            }
        });

        Button btnStory = (Button)findViewById(R.id.btn_story);
        btnStory.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
