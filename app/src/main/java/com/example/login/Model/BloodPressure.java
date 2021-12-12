package com.example.login.Model;

public class BloodPressure {

    String date,time,sys,dia,pul;
    public  BloodPressure(String date, String time, String sys, String dia, String pul){
      this.time=time;
      this.date=date;
      this.sys=sys;
      this.pul=pul;
      this.dia=dia;
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
