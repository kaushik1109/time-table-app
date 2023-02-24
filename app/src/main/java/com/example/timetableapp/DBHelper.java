package com.example.timetableapp;

import static android.content.ContentValues.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,email VARCHAR,password VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
    }

    public Boolean insertData(String name, String email, String password)
    {
        SQLiteDatabase MYyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = MYyDB.insert("users",null, contentValues);
        if(result==-1) return false;
        else return true;
    }

    public Boolean checkemail(String email)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from users where email= ?",new String[] {email});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else return false;
    }

    public Boolean checkusernamepass(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from users where email= ? and password= ?",new String[] {email,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else return false;
    }


}
