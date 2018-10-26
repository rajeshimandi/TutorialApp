package com.example.anuraj.tutorialsapplication.intents;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/12/2018.
 */

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        final TextView a = findViewById(R.id.textA);

        final EditText e = findViewById(R.id.editTextA);

        ((Button)findViewById(R.id.goToB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editval = e.getText().toString().trim();
                if(editval != null && editval.length()>0) {
                   /* Intent intentA = new Intent(ActivityA.this, ActivityB.class);
                    intentA.putExtra("name", a.getText().toString());
                    intentA.putExtra("editVal", e.getText().toString());
                    intentA.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivityForResult(intentA, 555);*/

                   /*Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                   intent.putExtra(SearchManager.QUERY, editval);
                   startActivity(intent);*/

                   /*Intent email = new Intent(Intent.ACTION_SENDTO);
                   email.putExtra(Intent.EXTRA_EMAIL,"venk.h@hh.com");
                   email.putExtra(Intent.EXTRA_SUBJECT, "Reg test");
                   email.putExtra(Intent.EXTRA_TEXT,"mail body");
                   startActivity(Intent.createChooser(email,"Choose from"));*/

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","abc@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));


                }else{
                    Toast.makeText(ActivityA.this, "Please enter a val",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 555){
            Toast.makeText(ActivityA.this, data.getStringExtra("xx"),Toast.LENGTH_SHORT).show();
        }

    }
}
