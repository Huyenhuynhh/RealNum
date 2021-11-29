package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
    }

    public void closScreen(View view) {
        finish();
    }

    public void openBloodPressureScreen(View view) {
        startActivity(new Intent(this,BloodPresureGlucoseActivity.class)
        .putExtra("title","Blood Pressure"));
    }

    public void openBloodGlucoseScreen(View view) {
        startActivity(new Intent(this,BloodPresureGlucoseActivity.class)
                .putExtra("title","Blood Glucose"));
    }
}