package com.beezy.details;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DetailsPagerAdapter extends FragmentStatePagerAdapter {
    ContactList cl;

    public DetailsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        cl = ContactList.getInstance(context);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        switch(position) {
            case 0:
                fragment = ContactListFragment.getInstance(cl.contactList);
                break;
            case 1:
                fragment = new ContactListFragment();
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
        return "Object" + (position + 1);
    }
}