package com.beezy.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactListFragment extends Fragment {

    private View rootView;
    RecyclerView mRecyclerView;
    ArrayList<Contact> contactsList;

    final String savedList = "com.beezy.details.contactList";

    public static ContactListFragment getInstance(ArrayList<Contact> contactsList) {
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

        if (savedInstanceState != null) {
            contactsList = savedInstanceState.getParcelableArrayList(savedList);
        }
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.contacts_list);
            AllContactsAdapter adapter = new AllContactsAdapter(contactsList, getContext(), getFragmentManager());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(savedList, contactsList);
    }


}
