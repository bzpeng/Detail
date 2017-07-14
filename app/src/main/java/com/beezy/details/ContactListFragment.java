package com.beezy.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }
}
