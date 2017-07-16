package com.beezy.details;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class DetailsPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Contact> contacts;
    ContactList cl;
    SQLiteDatabase db;
    ContactsDatabase.ContactsDbHelper dbHelper;
    Context context;


    String[] projection = {
            ContactsDatabase.ContactEntry.COLUMN_NAME_CONTACT_ID,
            ContactsDatabase.ContactEntry.COLUMN_NAME_NAME
    };

    String selection = ContactsDatabase.ContactEntry.COLUMN_NAME_CONTACT_ID + " = ?";
    String order = ContactsDatabase.ContactEntry.COLUMN_NAME_NAME + " DESC";


    public DetailsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        contacts = new ArrayList<>();
        cl = ContactList.getInstance(context);
        pullContactList();

    }

    private void pullContactList() {
        Contact contact;
        dbHelper = new ContactsDatabase.ContactsDbHelper(context);
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(ContactsDatabase.ContactEntry.TABLE_NAME, projection, null, null, null, null, order);
        while(cursor.moveToNext()) {
            long contactId = cursor.getLong(cursor.getColumnIndex(ContactsDatabase.ContactEntry.COLUMN_NAME_CONTACT_ID));
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsDatabase.ContactEntry.COLUMN_NAME_NAME));
            contact = new Contact();
            contact.setContactId(contactId);
            contact.setContactName(contactName);
            contacts.add(contact);
        }

        cursor.close();
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        switch(position) {
            case 0:
                fragment = ContactListFragment.getInstance(contacts);
                break;
            case 1:
                fragment = ContactConvoFragment.getInstance(contacts);
                break;
        }
        // Fragment fragment = new ContactListFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Contacts";

            case 1:
                return "Conversations";

        }
        return "";
    }
}