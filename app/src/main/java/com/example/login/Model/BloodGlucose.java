package com.example.login.Model;

public class BloodGlucose {
    String date,time,bloodg,mealtime;

public BloodGlucose(String date,String time,String bloodg,String mealtime){
    this.bloodg=bloodg;
    this.date=date;
    this.time=time;
    this.mealtime=mealtime;
}

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getBloodg() {
        return bloodg;
    }

    public String getMealtime() {
        return mealtime;
    }
}
