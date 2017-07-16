package com.beezy.details;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String ContactName;
    private long ContactId;

    public Contact() {
    }

    public long getContactId() {
        return ContactId;
    }

    public void setContactId(long contactId) {
        ContactId = contactId;
    }


    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }


    protected Contact(Parcel in) {
        ContactName = in.readString();
        ContactId = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ContactName);
        dest.writeLong(ContactId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}