package com.beezy.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactConvoFragment extends Fragment {

    private View rootView;
    RecyclerView mRecyclerView;
    ArrayList<Contact> contactsList;

    final String savedList = "com.beezy.details.contactConvo";

    public static ContactConvoFragment getInstance(ArrayList<Contact> contactsList) {
        ContactConvoFragment fragment = new ContactConvoFragment();
        fragment.contactsList = contactsList;
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.contacts_conversation, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            contactsList = savedInstanceState.getParcelableArrayList(savedList);
        }
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.contacts_convo);
        AllConvoAdapter adapter = new AllConvoAdapter(contactsList, getContext(), getFragmentManager());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(savedList, contactsList);
    }


}
