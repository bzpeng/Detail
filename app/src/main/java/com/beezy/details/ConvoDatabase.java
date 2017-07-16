package com.beezy.details;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class ConvoDatabase {

    public static class ConvoEntry implements BaseColumns {
        public static final String TABLE_NAME = "conversation";
        public static final String COLUMN_NAME_CONVO = "convo";
        public static final String COLUMN_NAME_CONTACT_ID= "id";
    }

    // Creating the database
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ConvoEntry.TABLE_NAME + " " + " (" +
                    ConvoEntry.COLUMN_NAME_CONTACT_ID + " LONG, " +
                    ConvoEntry.COLUMN_NAME_CONVO + " TEXT)";


    public static class ConvoDbHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "ConvoReader.db";
        public static final int DATABASE_VERSION = 1;


        public ConvoDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            super.onDowngrade(db, oldVersion, newVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
