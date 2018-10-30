package com.example.anuraj.tutorialsapplication.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by AnuRaj on 10/30/2018.
 */

public class ConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (null != intent && intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {

            if (isAirplaneModeOn(context)) {
                Toast.makeText(context, "Air Plane Mode: ON", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Air Plane Mode: OFF", Toast.LENGTH_LONG).show();
            }

        }

    }

    private boolean isAirplaneModeOn(Context context) {

        return Settings.Global.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

    }

}
