package com.example.test_2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    String databasename  = "Employee.dp";
    public Dbhelper(@Nullable Context context) {
        super(context, "Employee.dp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table EmployeeRegister (Id integer primary key autoincrement , Name text , Email text , Password text , Salary integer , Projecthandle integer , Speciality text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("Drop table if exists EmployeeRegister");
    }
    public boolean Inserted(String Name , String Email , String Password , Integer Salary , Integer projecthandle , String Speciality){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insert = new ContentValues();
        insert.put("Name" , Name);
        insert.put("Email" , Email);
        insert.put("Password" , Password);
        insert.put("Salary" , Salary);
        insert.put("Projecthandle" , projecthandle);
        insert.put("Speciality" , Speciality);
       long result = db.insert("EmployeeRegister" , null , insert);
        if (result > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean emailcheck(String Emailcheck){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor checkEmail = db.rawQuery("Select * From EmployeeRegister Where Email = ?" , new String[]{Emailcheck});
        if (checkEmail.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean logincheck(String loginemail , String loginpassword){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor checkEmail = db.rawQuery("Select * From EmployeeRegister Where Email = ? and Password = ?" , new String[]{loginemail , loginpassword});
        if (checkEmail.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
