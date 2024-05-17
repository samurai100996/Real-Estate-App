package com.example.project1662.Activity;

import android.provider.BaseColumns;

public class PropertyContract {
    public static class PropertyEntry implements BaseColumns {
        public static final String TABLE_NAME = "properties";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_ADDRESS = "address";
        // Add more columns as needed
    }
}
