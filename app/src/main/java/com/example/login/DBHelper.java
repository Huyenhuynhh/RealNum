package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String REALNUMDB = "RealNum.db";

    public DBHelper(Context context) {
        super(context, "RealNum.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase realNumDB) {
        realNumDB.execSQL("create Table realNumProfiles(userEmailPhone TEXT primary key, " +
                "password TEXT, username TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase realNumDB, int i, int i1) {
        realNumDB.execSQL("drop Table if exists realNumProfiles");

    }

    public Boolean insertData(String userEmailPhone, String password, String username) {
        SQLiteDatabase realNumDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userEmailPhone", userEmailPhone);
        contentValues.put("password", password);
        contentValues.put("username", username);
        long result = realNumDB.insert("realNumProfiles", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Boolean checkUserEmailPhone(String userEmailPhone) {
        SQLiteDatabase realNumDB = this.getWritableDatabase();
        Cursor cursor = realNumDB.rawQuery("select * from realNumProfiles where " +
                        "userEmailPhone = ?", new String[] {userEmailPhone});
        if(cursor.getCount() > 0)
            return  true;
        else
            return false;
    }

    public Boolean checkPassword(String userEmailPhone, String password) {
        SQLiteDatabase realNumDB =this.getWritableDatabase();
        Cursor cursor = realNumDB.rawQuery("Select * from realNumProfiles where " +
                "userEmailPhone = ? and password = ?", new String[] {userEmailPhone,password});
        if(cursor.getCount() > 0)
            return  true;
        else
            return false;
    }

}
