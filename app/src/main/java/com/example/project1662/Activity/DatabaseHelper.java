package com.example.project1662.Activity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project1662.Domain.PropertyDomain;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "property_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "properties";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_BEDROOMS = "bedrooms";
    private static final String COLUMN_BATHROOMS = "bathrooms";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_PRICE + " REAL, " +
                COLUMN_BEDROOMS + " INTEGER, " +
                COLUMN_BATHROOMS + " INTEGER" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addProperty(PropertyDomain property) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, property.getTitle());
        values.put(COLUMN_TYPE, property.getType());
        values.put(COLUMN_ADDRESS, property.getAddress());
        values.put(COLUMN_PRICE, property.getPrice());
        values.put(COLUMN_BEDROOMS, property.getBed());
        values.put(COLUMN_BATHROOMS, property.getBath());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<PropertyDomain> getProperties() {
        ArrayList<PropertyDomain> properties = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                @SuppressLint("Range") String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
                @SuppressLint("Range") double price = cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE));
                @SuppressLint("Range") int bedrooms = cursor.getInt(cursor.getColumnIndex(COLUMN_BEDROOMS));
                @SuppressLint("Range") int bathrooms = cursor.getInt(cursor.getColumnIndex(COLUMN_BATHROOMS));
                PropertyDomain property = new PropertyDomain(type, title, address, "", (int) price, bedrooms, bathrooms);
                properties.add(property);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return properties;
    }
}

