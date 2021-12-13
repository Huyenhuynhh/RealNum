package com.example.login;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.Model.BloodPressure;
import com.example.login.Service.DataBaseService;

import java.util.Calendar;
import java.util.TimeZone;

public class BloodPressureActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
     EditText sys,dia,pul;
     TextView amTime,pmTime,time,date;
    boolean amTimeStatus;
    private int _day;
    private int _month;
    private int _birthYear;
    int hour ;
    int minute  ;
    String _time;
    String _date;

    DataBaseService database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure);
        date=findViewById(R.id.tfdate);
        time=findViewById(R.id.tftime);
        sys=findViewById(R.id.tfsys);
        dia=findViewById(R.id.tfdia);
        pul=findViewById(R.id.tfpul);
        amTime=findViewById(R.id.tfamtime);
        pmTime=findViewById(R.id.tfpmtime);
        amTimeStatus=true;
        database = new DataBaseService(this);
    }

    public void closScreen(View view) {
        startActivity(new Intent(this,BloodPresureGlucoseActivity.class)
                .putExtra("title","Blood Pressure"));
        finish();
    }

    public void addBloodPressureData(View view) {


database.AddBloodPressureData(new BloodPressure(_date,_time,sys.getText().toString(),dia.getText().toString(),pul.getText().toString(),amTimeStatus+""));
        Toast.makeText(this, "data added", Toast.LENGTH_SHORT).show();


    }

    public void setAmTime(View view) {
        amTimeStatus=true;
        amTime.setTextColor(getResources().getColor(R.color.white));
        pmTime.setTextColor(getResources().getColor(R.color.black));
        amTime.setBackgroundResource(R.drawable.text_am_bg);
        pmTime.setBackgroundResource(R.drawable.text_pm_bg);
    }
    public void setPmTime(View view) {
        amTimeStatus=false;
        amTime.setTextColor(getResources().getColor(R.color.black));
        pmTime.setTextColor(getResources().getColor(R.color.white));
        pmTime.setBackgroundResource(R.drawable.text_am_bg);
        amTime.setBackgroundResource(R.drawable.text_pm_bg);
    }

    public void openTimeDialog(View view) {
        Calendar mcurrentTime = Calendar.getInstance();
         hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
         minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(BloodPressureActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time.setText( selectedHour + ":" + selectedMinute);
                 _time=selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    public void openDateDialog(View view) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(this, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        _birthYear = year;
        _month = monthOfYear;
        _day = dayOfMonth;
        _date =_day+"/"+_month+"/"+_birthYear;
        date.setText(_date);
    }
}