package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BloodPresureGlucoseActivity extends AppCompatActivity {
      TextView title,daytext,mothtext,weektext,datatext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_presure_glucose);
        title=findViewById(R.id.title);
        daytext=findViewById(R.id.daytext);
        mothtext=findViewById(R.id.mothtext);
        weektext=findViewById(R.id.weektext);
        daytext.setBackgroundResource(R.drawable.text_bg);
        datatext=findViewById(R.id.datatext);

    }

    @Override
    protected void onStart() {
        title.setText(getIntent().getStringExtra("title"));
        super.onStart();
    }

    public void closScreen(View view) {
        finish();
    }

    public void dayTextClicked(View view) {
        daytext.setBackgroundResource(R.drawable.text_bg);
        weektext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
    }

    public void weekTextClicked(View view) {
        weektext.setBackgroundResource(R.drawable.text_bg);
        daytext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
    }

    public void mothTextClicked(View view) {
        mothtext.setBackgroundResource(R.drawable.text_bg);
        weektext.setBackgroundResource(0);
        daytext.setBackgroundResource(0);
    }
}