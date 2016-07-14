package com.example.com.content_test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private CreateDB create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Create_DB();
    }

    public void Create_DB() {
        create = new CreateDB(MainActivity.this);
        db  = create.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","張三");
        values.put("sex","男");
        db.insert("Provider",null,values);

        Cursor cursor= db.query("Provider",null,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            System.out.println(id+"---"+name+"---"+sex);
        }
    }

}
