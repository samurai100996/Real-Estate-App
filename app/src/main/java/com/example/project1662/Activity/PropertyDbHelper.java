package com.example.project1662.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PropertyDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Property.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PropertyContract.PropertyEntry.TABLE_NAME + " (" +
                    PropertyContract.PropertyEntry._ID + " INTEGER PRIMARY KEY," +
                    PropertyContract.PropertyEntry.COLUMN_NAME_TITLE + " TEXT," +
                    PropertyContract.PropertyEntry.COLUMN_NAME_ADDRESS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PropertyContract.PropertyEntry.TABLE_NAME;

    public PropertyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}

