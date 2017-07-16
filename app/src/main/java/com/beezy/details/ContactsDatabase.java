package com.beezy.details;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class ContactsDatabase {

    public static class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CONTACT_ID= "id";
    }

    // Creating the database
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ContactEntry.TABLE_NAME + " " + " (" +
                    ContactEntry.COLUMN_NAME_CONTACT_ID + " LONG PRIMARY KEY, " +
                    ContactEntry.COLUMN_NAME_NAME + " TEXT)";


    public static class ContactsDbHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "ContactReader.db";
        public static final int DATABASE_VERSION = 1;


        public ContactsDbHelper(Context context) {
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
