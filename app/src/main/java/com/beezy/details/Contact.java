package com.beezy.details;

import android.media.Image;

enum phoneType {
    MOBILE, WORK, HOME, MAIN, OTHER, CUSTOM;
}
public class Contact {
//    private String mFirstName;
//    private String mLastName;
//    private String mNickname;
//    private String mEmail;
//    private String mPhone;
//    private Image img;
//
//    public Contact(String firstname, String lastname, String nickname, String email, String phone) {
//        mFirstName = firstname;
//        mLastName = lastname;
//        mNickname = nickname;
//        mEmail = email;
//        mPhone = phone;
//    }
    private String ContactImage;
    private String ContactName;
    private String ContactNumber;
    private long ContactId;

    public Contact() {
    }

    public long getContactId() {
        return ContactId;
    }

    public void setContactId(long contactId) {
        ContactId = contactId;
    }

    public String getContactImage() {
        return ContactImage;
    }

    public void setContactImage(String contactImage) {
        this.ContactImage = ContactImage;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

}
