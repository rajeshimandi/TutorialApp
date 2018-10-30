package com.example.anuraj.tutorialsapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 */
public class DiscountIntentService extends IntentService {

    public static final String DISCOUNT_INFO = "discount_info";

    public DiscountIntentService() {
        super("DiscountIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        String category = intent.getStringExtra("discount_cat");

        String discountInfo = getDiscountInfo(category);
        //Delaying by 2 sec
        SystemClock.sleep(2000);
        sendDiscountInfoToClient(discountInfo);

    }

    /**
     * Calculates discount
     *
     * @param cat
     * @return
     */
    private String getDiscountInfo(String cat) {
        String discount;
        if ("electronics".equals(cat)) {
            discount = "Upto 20% discount on electronics";
        } else if ("fashion".equals(cat)) {
            discount = "Upto 60% discount on all fashion items";
        } else {
            discount = "All other categories except fashion and electronics, flat 30% discount";
        }
        return discount;
    }

    /**
     * Sends info back to activity
     *
     * @param msg
     */
    private void sendDiscountInfoToClient(String msg) {
        Intent intent = new Intent();
        intent.setAction(DISCOUNT_INFO);
        intent.putExtra("discount", msg);
        sendBroadcast(intent);
    }
}
