package com.example.com.content_test;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Content_Provider extends ContentProvider {
    private static UriMatcher matcher = new UriMatcher(-1);
    private CreateDB datebase;

    static
    {
        matcher.addURI("com.example.com.visitDB.provider","query",1);
        matcher.addURI("com.example.com.visitDB.provider","select",2);
        matcher.addURI("com.example.com.visitDB.provider","insert",3);
        matcher.addURI("com.example.com.visitDB.provider","delete",4);
    }
    @Override
    public boolean onCreate() {
    datebase = new CreateDB(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        SQLiteDatabase db =datebase.getReadableDatabase();
        Cursor cursor =null;
        if(matcher.match(uri)==1)
        {
           cursor = db.query("Provider",strings,s,strings1,null,null,s1);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
