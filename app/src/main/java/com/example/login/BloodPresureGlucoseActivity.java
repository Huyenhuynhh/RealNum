package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BloodPresureGlucoseActivity extends AppCompatActivity {
      TextView title,daytext,mothtext,weektext,datatext;
      Button addbtn;
      ListView listview;
    String[] weekArray = {"Monday","Tuesday","Wednesday","Thursday",
            "Friday","Saturday","Sunday"};
    String[] monthArray = {"January","February","March","April",
            "May","June","July","August","September","October","November","December"};
    ArrayAdapter weekAdapter,mothAdapter;
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
        addbtn=findViewById(R.id.addbtn);
        listview=findViewById(R.id.listview);
        weekAdapter = new ArrayAdapter<String>(this,
                R.layout.item_list, weekArray);
        mothAdapter = new ArrayAdapter<String>(this,
                R.layout.item_list, monthArray);
        weektext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
        addbtn.setVisibility(View.VISIBLE);
        datatext.setVisibility(View.VISIBLE);
        listview.setVisibility(View.GONE);

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
        addbtn.setVisibility(View.VISIBLE);
        datatext.setVisibility(View.VISIBLE);
        listview.setVisibility(View.GONE);
    }

    public void weekTextClicked(View view) {
        weektext.setBackgroundResource(R.drawable.text_bg);
        daytext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
        addbtn.setVisibility(View.GONE);
        datatext.setVisibility(View.GONE);
        listview.setAdapter(weekAdapter);
        listview.setVisibility(View.VISIBLE);
    }

    public void mothTextClicked(View view) {
        mothtext.setBackgroundResource(R.drawable.text_bg);
        weektext.setBackgroundResource(0);
        daytext.setBackgroundResource(0);
        addbtn.setVisibility(View.GONE);
        datatext.setVisibility(View.GONE);
        listview.setAdapter(mothAdapter);
        listview.setVisibility(View.VISIBLE);
    }
}