package com.example.schoolapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 帅气的靓仔 on 2017/4/5.
 */

public class HoursDB extends SQLiteOpenHelper {

    final String SQL_CREATE_TABLE = "create table time_table (" +

            "_id integer primary key autoincrement, " +

            "news_tittle varchar(50), " +

            "news_content varchar(5000), " +

            "news_else varchar(50))";
    public HoursDB(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("call update");
    }
}
