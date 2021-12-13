package com.example.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BloodGlucoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_glucose);
    }

    public void closScreen(View view) {
        finish();
    }

    public void addBloodGlucoseData(View view) {
    }
    public void setAmTime(View view) {
    }
    public void setPmTime(View view) {
    }
}