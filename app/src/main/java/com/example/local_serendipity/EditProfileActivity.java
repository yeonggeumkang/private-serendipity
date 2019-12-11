package com.example.local_serendipity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

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

    }
}
