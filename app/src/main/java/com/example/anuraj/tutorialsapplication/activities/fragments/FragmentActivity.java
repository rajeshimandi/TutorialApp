package com.example.anuraj.tutorialsapplication.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/14/2018.
 */

public class FragmentActivity extends AppCompatActivity implements CustomClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Code for portrait mode

        /*FragmentA fragmentA = new FragmentA();

        Bundle bundle = new Bundle();
        bundle.putInt("version",3);

        fragmentA.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer,fragmentA, "fragA");
        fragmentTransaction.commit();*/


    }


    @Override
    public void onButtonClick(String msg, int pos) {

        ((FragmentB) getSupportFragmentManager().findFragmentByTag("fragB")).setMessage(msg, pos);

    }
}
