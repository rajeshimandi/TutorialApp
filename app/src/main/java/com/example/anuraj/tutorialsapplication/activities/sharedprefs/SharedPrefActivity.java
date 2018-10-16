package com.example.anuraj.tutorialsapplication.activities.sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/14/2018.
 */

public class SharedPrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shared_prefs);

        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();


        editor.putBoolean("bool", true); // Storing boolean - true/false
        editor.putString("str", "string value"); // Storing string
        editor.putInt("int", 777); // Storing integer
        editor.putFloat("float", 2.0f); // Storing float
        editor.putLong("long", 98765); // Storing long

        editor.commit(); // commit changes

        ((Button) findViewById(R.id.btn_pref)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean bool = pref.getBoolean("bool", false); // getting boolean
                String str = pref.getString("str", null); // getting String
                int x = pref.getInt("int", -1); // getting Integer
                float y = pref.getFloat("float", 0.0f); // getting Float
                long z = pref.getLong("long", 0); // getting Long

                String prefs = "Bool:" + bool + "\n" + "String:" + str + "\n" + "Integer:" + x + "\n" + "Float:" + y + "\n" + "Long:" + z;

                ((TextView) findViewById(R.id.prefVal)).setText(prefs);

            }
        });


        ((Button) findViewById(R.id.btn_remove_pref)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editor.remove("float"); // will delete key float
                editor.remove("long"); // will delete key long

                //editor.clear(); // clears all

                editor.commit(); // commit changes

                boolean bool = pref.getBoolean("bool", false); // getting boolean
                String str = pref.getString("str", null); // getting String
                int x = pref.getInt("int", -1); // getting Integer
                float y = pref.getFloat("float", 0.0f); // getting Float
                long z = pref.getLong("long", 0); // getting Long

                String prefs = "Bool:" + bool + "\n" + "String:" + str + "\n" + "Integer:" + x + "\n" + "Float:" + y + "\n" + "Long:" + z;

                ((TextView) findViewById(R.id.prefVal)).setText(prefs);

            }
        });

    }
}
