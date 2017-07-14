package com.beezy.details;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactList {

    private static ContactList instance = null;
    List<Contact> contactList = null;
    Context context = null;

    private ContactList(Context context){
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

        Activity mActivity = (Activity) context;
        Contact mContact;

        ContentResolver mContentResolver = mActivity.getContentResolver();
        Cursor cursor = mContentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if(cursor.getCount() > 0) {
            Toast.makeText(context, Integer.toString(cursor.getCount()),Toast.LENGTH_LONG).show();
            while(cursor.moveToNext()) {
                mContact = new Contact();
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                long mId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                Log.d("Contact id: ", id);
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                mContact.setContactName(name);
                mContact.setContactId(mId);

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String[] mContactId = {id};
                    Cursor phoneCursor = mContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? ", mContactId, null);
                    if(phoneCursor.moveToNext()) {
                        mContact.setContactNumber(phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    }
                }
                contactList.add(mContact);
            }
        }
    }

}
