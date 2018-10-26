package com.example.anuraj.tutorialsapplication;


import android.content.Context;
import android.widget.Toast;

/**
 * Handles short and long toasts through out app
 */
public class ToastUtils {

    public static void showLongToast(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();

        }
    }

    public static void showShortToast(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
        }
    }

}
