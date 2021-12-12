package com.example.login.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.login.Model.BloodGlucose;
import com.example.login.Model.BloodPressure;

import java.util.ArrayList;
import java.util.List;

public class DataBaseService extends SQLiteOpenHelper {
    public static final String DBName = "blood_Database";
    public static final String TName = "BloodGlucose";
    public static final String TName2 = "BloodPressure";
    public static final String Col_1 = "Date";
    public static final String Col_2 = "Time";
    public static final String Col_3 = "sys";
    public static final String Col_4 = "dia";
    public static final String Col_5 = "pul";
    public static final String Col_6 = "Id";
    public static final String Col_7 = "bloodglucose";
    public static final String Col_8 = "mealtime";

    public DataBaseService(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TName + "(" + Col_1 + " TEXT," + Col_2 + " TEXT," + Col_7 + " TEXT," + Col_8 + " TEXT,"  + Col_6 + " INTEGER PRIMARY KEY)");

        db.execSQL(" create table " + TName2 + "(" + Col_1 + " TEXT," + Col_2 + " TEXT," + Col_3 + " TEXT," + Col_4 + " TEXT," + Col_5 + " TEXT," + Col_6 + " INTEGER PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TName);
        db.execSQL("DROP TABLE IF EXISTS " + TName2);
        onCreate(db);
    }

    public void AddBloodPressureData(BloodPressure bloodPressure) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_1, bloodPressure.getDate());
        cv.put(Col_2, bloodPressure.getTime());
        cv.put(Col_3, bloodPressure.getSys());
        cv.put(Col_4, bloodPressure.getDia());
        cv.put(Col_5, bloodPressure.getPul());
        db.insert(TName, null, cv);
        db.close();
    }
    public void BloodGlucose(BloodGlucose bloodGlucose) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_1, bloodGlucose.getDate());
        cv.put(Col_2, bloodGlucose.getTime());
        cv.put(Col_3, bloodGlucose.getBloodg());
        cv.put(Col_4, bloodGlucose.getMealtime());
        db.insert(TName, null, cv);
        db.close();
    }

    // method to get the data from the database
    public ArrayList<BloodGlucose> getBloodGlucoseData() {
        List<BloodGlucose> dataList = new ArrayList<BloodGlucose>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TName, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String a = cursor.getString(0);
            BloodGlucose ca = new BloodGlucose(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataList.add(ca);
            cursor.moveToNext();
        }
        return (ArrayList<BloodGlucose>) dataList;
    }
    public ArrayList<BloodPressure> getBloodPrusreData() {
        List<BloodPressure> dataList = new ArrayList<BloodPressure>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TName, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String a = cursor.getString(0);
            BloodPressure ca = new BloodPressure(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
            dataList.add(ca);
            cursor.moveToNext();
        }
        return (ArrayList<BloodPressure>) dataList;
    }
}
