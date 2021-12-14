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

import com.example.login.Model.BloodGlucose;
import com.example.login.Service.DataBaseService;

import java.util.Calendar;
import java.util.TimeZone;

public class BloodGlucoseActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
  EditText tvbloodG;
  TextView time,amTime,pmTime,date;
  boolean amTimeStatus,beforeMealStatus;
    private int _day;
    private int _month;
    private int _birthYear;
    int hour ;
    int minute;
    String _time;
    String _date;
    DataBaseService database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_glucose);
        date=findViewById(R.id.tvdate);
        time=findViewById(R.id.tvtime);
        tvbloodG=findViewById(R.id.tvbloodg);
        amTime=findViewById(R.id.tvamtime);
        pmTime=findViewById(R.id.tvpmtime);
        amTimeStatus=true;
        beforeMealStatus=true;
        database = new DataBaseService(this);


    }


    public void closScreen(View view) {

        startActivity(new Intent(this,BloodPresureGlucoseActivity.class)
                .putExtra("title","Blood Glucose"));
        finish();
    }

    public void addBloodGlucoseData(View view) {

  database.AddBloodGlucose(new BloodGlucose(_date,_time,tvbloodG.getText().toString(),beforeMealStatus+"",amTimeStatus+""));
        Toast.makeText(this, "blood glucose data added", Toast.LENGTH_SHORT).show();
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

    public void beforeMealClicked(View view) {
        beforeMealStatus=true;
    }

    public void afterMealClicked(View view) {
        beforeMealStatus=false;
    }

    public void openTimeDialog(View view) {

        Calendar mcurrentTime = Calendar.getInstance();
         hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
         minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(BloodGlucoseActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time.setText( selectedHour + ":" + selectedMinute);
                _time=selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        _birthYear = year;
        _month = monthOfYear;
        _day = dayOfMonth;
        _date =_day+"/"+_month+"/"+_birthYear;
        date.setText(_date);
    }

    public void openDateDialog(View view) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(this, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}