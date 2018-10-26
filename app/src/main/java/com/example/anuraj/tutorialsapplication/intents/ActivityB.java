package com.example.anuraj.tutorialsapplication.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/12/2018.
 */

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        TextView b = findViewById(R.id.textB);
        TextView e = findViewById(R.id.textE);


        //b.setText(getIntent().getStringExtra("name"));
        e.setText(getIntent().getStringExtra("editVal"));

        ((Button)findViewById(R.id.result)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("xx", "This is OnActivity result");
                setResult(RESULT_OK, i);
                finish();
            }
        });




    }

}
