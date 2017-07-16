package com.beezy.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ActivityFragment extends AppCompatActivity {

    long id;
    String name;

    private NewConvoFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();

            fragment = new NewConvoFragment();
            fragment.show(fm, "newContact");
        }
    }
