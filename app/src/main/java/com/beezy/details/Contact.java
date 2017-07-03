package com.beezy.details;

import android.media.Image;

enum phoneType {
    MOBILE, WORK, HOME, MAIN, OTHER, CUSTOM;
}
public class Contact {
    private String mFirstName;
    private String mLastName;
    private String mNickname;
    private String mEmail;
    private String mPhone;
    private Image img;

    public Contact(String firstname, String lastname, String nickname, String email, String phone) {
        mFirstName = firstname;
        mLastName = lastname;
        mNickname = nickname;
        mEmail = email;
        mPhone = phone;
    }


}
