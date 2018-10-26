package com.example.anuraj.tutorialsapplication.uiwidgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;

import java.util.ArrayList;


public class UIWidgetsActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> spinnerList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiwidgets);

        spinnerList.add("Java");
        spinnerList.add("Android");
        spinnerList.add("C++");
        spinnerList.add("iOS");
        spinnerList.add("Angular");


        Button button = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.editText);
        CheckBox checkBox = findViewById(R.id.checkBox);
        TextView textView = findViewById(R.id.text);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        ImageView imageView = findViewById(R.id.imageView);

        progressBar.setVisibility(View.INVISIBLE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView.setOnClickListener(this);

        //imageView.setImageResource(R.drawable.ic_launcher_foreground);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UIWidgetsActivity.this, "Clicked position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIWidgetsActivity.this, "Clicked Button", Toast.LENGTH_SHORT).show();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("UIWidgets:", "--beforeTextChanged--");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(UIWidgetsActivity.this, "On Text Changed:" + s, Toast.LENGTH_SHORT).show();
                Log.d("UIWidgets:", "--onTextChanged--");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("UIWidgets:", "--afterTextChanged--");
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(UIWidgetsActivity.this, "Checked status:" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r1:
                        Toast.makeText(UIWidgetsActivity.this, "Checked R1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.r2:
                        Toast.makeText(UIWidgetsActivity.this, "Checked R2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView:

                break;
            case R.id.imageView:

                break;
        }
    }
}
