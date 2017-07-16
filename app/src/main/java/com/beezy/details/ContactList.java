package com.beezy.details;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactList {

    SQLiteDatabase contactdb;
    ContactsDatabase.ContactsDbHelper contactsdbHelper;

    private static ContactList instance = null;
    List<Contact> contactList = null;
    Context context = null;

    private ContactList(Context context){
        contactsdbHelper = new ContactsDatabase.ContactsDbHelper(context);
        if(this.context == null) {
            this.context = context;
        }
        if(contactList == null) {
            contactList = new ArrayList<>();
            getAllContacts();
        }

    }

    public static ContactList getInstance(Context context) {
        if (instance == null) {
            instance = new ContactList(context);
        }
        return instance;
    }

    private void getAllContacts() {

        contactdb = contactsdbHelper.getWritableDatabase();
        Activity mActivity = (Activity) context;
        Contact mContact;

        // Creating new map of values
        ContentValues values;
        ContentResolver mContentResolver = mActivity.getContentResolver();
        Cursor cursor = mContentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                mContact = new Contact();
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                long mId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                Log.d("Contact id: ", id);
                Log.d("*********************", "TEST");
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                values = new ContentValues();
                values.put(ContactsDatabase.ContactEntry.COLUMN_NAME_CONTACT_ID, id);
                values.put(ContactsDatabase.ContactEntry.COLUMN_NAME_NAME, name);
                long newRowId = contactdb.insert(ContactsDatabase.ContactEntry.TABLE_NAME, null, values);
            }
        }
        cursor.close();
    }

}
