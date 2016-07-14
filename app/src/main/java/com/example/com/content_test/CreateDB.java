package com.example.com.content_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/14.
 */
public class CreateDB extends SQLiteOpenHelper {
    public CreateDB(Context context) {
        super(context, "MM.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table [Provider](id integer primary key autoincrement" +
                ",name char(20)" +
                ",sex char(10)) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
