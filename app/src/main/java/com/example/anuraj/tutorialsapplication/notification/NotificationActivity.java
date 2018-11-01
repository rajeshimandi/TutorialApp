package com.example.anuraj.tutorialsapplication.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.anuraj.tutorialsapplication.R;
import com.example.anuraj.tutorialsapplication.parcelable.Contact;
import com.example.anuraj.tutorialsapplication.parcelable.ParcelableActivityA;
import com.example.anuraj.tutorialsapplication.parcelable.ParcelableActivityB;

/**
 * Created by AnuRaj on 11/1/2018.
 */

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ((Button) findViewById(R.id.btnSend)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this, "");
                builder.setSmallIcon(android.R.drawable.ic_dialog_email
                );

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Main_Page"));
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 11, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                builder.setContentTitle("Notifications Title");
                builder.setContentText("Your notification content here.");
                builder.setSubText("Tap to view the website.");

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(22, builder.build());

            }
        });

        ((Button) findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancel(22);

            }
        });

    }
}
