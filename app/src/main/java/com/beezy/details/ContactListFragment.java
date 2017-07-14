package com.beezy.details;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.provider.ContactsContract;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ContactListFragment extends Fragment {

    private View rootView;
    RecyclerView mRecyclerView;
    List<Contact> contactsList;

    public static ContactListFragment getInstance(List<Contact> contactsList) {
        ContactListFragment fragment = new ContactListFragment();
        fragment.contactsList = contactsList;
        return fragment;
    }

   // private class AllContactsAdapter extends RecyclerView.Adapter<>
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.contact_fragment, container, false);
        return rootView;
    }
    

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        for(Contact c: contactsList) {
//            Log.d("Contact Name: ", c.getContactName());
//        }

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.contacts_list);
        AllContactsAdapter adapter = new AllContactsAdapter(contactsList, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);

        //Uri uri = ContentUris.withAppendedId()

    }


}
