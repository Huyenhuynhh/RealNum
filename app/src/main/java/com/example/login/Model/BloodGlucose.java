package com.example.login.Model;

public class BloodGlucose {
    String date,time,bloodg,mealtime,timestatus;

public BloodGlucose(String date,String time,String bloodg,String mealtime,String timestatus){
    this.bloodg=bloodg;
    this.date=date;
    this.time=time;
    this.mealtime=mealtime;
    this.timestatus=timestatus;
}

    public String getTimestatus() {
        return timestatus;
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
