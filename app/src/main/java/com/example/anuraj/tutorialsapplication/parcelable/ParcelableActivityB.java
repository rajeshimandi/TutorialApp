package com.example.anuraj.tutorialsapplication.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/31/2018.
 */

public class ParcelableActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_b);

        Intent intent = getIntent();
        Contact contact = intent.getParcelableExtra("cont");

        ((TextView) findViewById(R.id.text)).setText(contact.getName() + "\n" + contact.getLastName() + "\n" + contact.getId());

    }
}
