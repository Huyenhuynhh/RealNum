package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BloodPressureActivity extends AppCompatActivity {
     EditText date,time,sys,dia,pul;
     TextView amTime,pmTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure);
        date=findViewById(R.id.tfdate);
        sys=findViewById(R.id.tfsys);
        dia=findViewById(R.id.tfdia);
        pul=findViewById(R.id.tfpul);
        amTime=findViewById(R.id.tfamtime);
        pmTime=findViewById(R.id.tfpmtime);
    }

    public void closScreen(View view) {
        finish();
    }

    public void addBloodPressureData(View view) {
    }

    public void setAmTime(View view) {
    }
    public void setPmTime(View view) {
    }
}