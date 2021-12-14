package com.example.login.Model;

public class BloodPressure {

    String date,time,sys,dia,pul,timestatus;
    public  BloodPressure(String date, String time, String sys, String dia, String pul ,String timestatus){
      this.time=time;
      this.date=date;
      this.sys=sys;
      this.pul=pul;
      this.dia=dia;
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

    public String getSys() {
        return sys;
    }

    public String getDia() {
        return dia;
    }

    public String getPul() {
        return pul;
    }
}
