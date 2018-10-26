package com.example.anuraj.tutorialsapplication.activities.lifecycle;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.anuraj.tutorialsapplication.R;


public class LifeCycleActivity extends AppCompatActivity {

    private final String TAG = "LifeCycle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, "--onCreate--");

        if(savedInstanceState != null){
            Log.d(TAG, "--IntVal--"+savedInstanceState.getInt("MyInt"));
        }


        /*final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("My Alert");
        builder.setMessage("This is an alert dialog");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();*/

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("MyInt", 7);
        outState.putChar("MyChar", 'c');

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "--onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "--onStop--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "--onRestart--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--onDestroy--");
    }
}
