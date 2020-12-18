package com.android.bmi_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HistoryDB extends SQLiteOpenHelper {

    public HistoryDB(@Nullable Context context) {
        super(context, "HistoryDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE user(userid INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userheight INTEGER, userweight INTEGER, userbmi NUMBER, userneed NUMBER, usericon INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS user;";
        db.execSQL(query);
        onCreate(db);
    }
}
