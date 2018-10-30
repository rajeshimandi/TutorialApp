package com.example.anuraj.tutorialsapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;

/**
 * Created by AnuRaj on 10/30/2018.
 */

public class IntentServiceActivity extends AppCompatActivity {

    private DiscountReceiver discountReciver;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        tv = (TextView) findViewById(R.id.disc_results);
        registerDiscountReceiver();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(discountReciver);
    }

    /**
     * Starts intent service
     *
     * @param view
     */
    public void startDiscService(View view) {
        EditText et = (EditText) findViewById(R.id.disc_cat);

        Intent cbIntent = new Intent();
        cbIntent.setClass(this, DiscountIntentService.class);
        cbIntent.putExtra("discount_cat", et.getText().toString());
        startService(cbIntent);
    }

    /**
     * Registers local broad cast register with specified action
     */
    private void registerDiscountReceiver() {
        discountReciver = new DiscountReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DiscountIntentService.DISCOUNT_INFO);

        registerReceiver(discountReciver, intentFilter);
    }

    /**
     * Local broadcast receiver
     */
    private class DiscountReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String discInfo = intent.getStringExtra("discount");
            tv.setText(discInfo);
        }
    }

}
