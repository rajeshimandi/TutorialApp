package com.example.anuraj.tutorialsapplication.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/31/2018.
 */

public class ParcelableActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_a);

        ((Button) findViewById(R.id.btnSend)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact("Srinath", "Gudipati", 2);
                Intent intent = new Intent(ParcelableActivityA.this, ParcelableActivityB.class);
                intent.putExtra("cont", contact);
                startActivity(intent);

            }
        });

    }
}
