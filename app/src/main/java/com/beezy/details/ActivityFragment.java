package com.beezy.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ActivityFragment extends AppCompatActivity {

    private NewContactFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();

            fragment = NewContactFragment.newInstance();
            fm.beginTransaction().add(fragment, "newContact")
                    .commit();
        }
    }
