package com.example.anuraj.tutorialsapplication.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;
import com.example.anuraj.tutorialsapplication.TutorialsApp;
import com.example.anuraj.tutorialsapplication.async.AyncTaskActivity;
import com.example.anuraj.tutorialsapplication.fragments.FragmentActivity;
import com.example.anuraj.tutorialsapplication.fragments.ViewPagerActivity;
import com.example.anuraj.tutorialsapplication.googlemap.MapsActivity;
import com.example.anuraj.tutorialsapplication.intents.ActivityA;
import com.example.anuraj.tutorialsapplication.lifecycle.LifeCycleActivity;
import com.example.anuraj.tutorialsapplication.menu.MenuActivity;
import com.example.anuraj.tutorialsapplication.notification.NotificationActivity;
import com.example.anuraj.tutorialsapplication.parcelable.ParcelableActivityA;
import com.example.anuraj.tutorialsapplication.retrofit.RetrofitActivity;
import com.example.anuraj.tutorialsapplication.service.IntentServiceActivity;
import com.example.anuraj.tutorialsapplication.sharedprefs.SharedPrefActivity;
import com.example.anuraj.tutorialsapplication.sqlite.SQLiteActivity;
import com.example.anuraj.tutorialsapplication.uiwidgets.UIWidgetsActivity;
import com.example.anuraj.tutorialsapplication.webview.WebViewActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements MenuItemSelectedListener {

    private ArrayList<String> mTopicsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TutorialsApp app = (TutorialsApp) getApplication();
        app.setUserName("Raj");

        mTopicsList.add("LifeCycle");
        mTopicsList.add("Layouts");
        mTopicsList.add("Proj Structure & Manifest");
        mTopicsList.add("Build Process");
        mTopicsList.add("UI Widgets");
        mTopicsList.add("Events");
        mTopicsList.add("Intents");
        mTopicsList.add("ActivityForResult");
        mTopicsList.add("Menu");
        mTopicsList.add("Fragments");
        mTopicsList.add("Fragments-ViewPager");
        mTopicsList.add("ListView Vs RecyclerView");
        mTopicsList.add("RecyclerView");
        mTopicsList.add("JSON-Parsing");
        mTopicsList.add("SharedPreferences");
        mTopicsList.add("Service");
        mTopicsList.add("IntentService");
        mTopicsList.add("Broadcast Receiver");
        mTopicsList.add("WebView");
        mTopicsList.add("AlertDialog");
        mTopicsList.add("GoogleMap");
        mTopicsList.add("Location");
        mTopicsList.add("Webservices");
        mTopicsList.add("Volley");
        mTopicsList.add("Retrofit");
        mTopicsList.add("AsyncTask");
        mTopicsList.add("Media");
        mTopicsList.add("Localization");
        mTopicsList.add("Building Universal App");
        mTopicsList.add("DVM vs ART");
        mTopicsList.add("Runtime Permissions");
        mTopicsList.add("Git");


        mTopicsList.add("SQLite");
        mTopicsList.add("Parcelable / Seriazable");
        mTopicsList.add("Unit Test Cases");
        mTopicsList.add("Product Flavours");
        mTopicsList.add("Progaurd");
        mTopicsList.add("LaunchMode");
        mTopicsList.add("Content Provider");
        mTopicsList.add("Notifications");

        RecyclerView menuRecyclerView = findViewById(R.id.menuRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        HomeListAdapter listAdapter = new HomeListAdapter(mTopicsList, this);

        menuRecyclerView.setLayoutManager(layoutManager);
        menuRecyclerView.setAdapter(listAdapter);


        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("These are the list of Topics");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create();
        builder.show();*/

    }


    @Override
    public void onMenuItemSelected(int pos, String name) {
        Toast.makeText(HomeActivity.this, "Selected " + mTopicsList.get(pos), Toast.LENGTH_SHORT).show();

        switch (name) {

            case "LifeCycle":
                startActivity(new Intent(HomeActivity.this, LifeCycleActivity.class));
                break;
            case "UI Widgets":
                startActivity(new Intent(HomeActivity.this, UIWidgetsActivity.class));
                break;

            case "Intents":
                startActivity(new Intent(HomeActivity.this, ActivityA.class));
                break;

            case "Fragments":
                startActivity(new Intent(HomeActivity.this, FragmentActivity.class));
                break;

            case "Fragments-ViewPager":
                startActivity(new Intent(HomeActivity.this, ViewPagerActivity.class));
                break;

            case "SharedPreferences":

                startActivity(new Intent(HomeActivity.this, SharedPrefActivity.class));
                break;

            case "Retrofit":
                startActivity(new Intent(HomeActivity.this, RetrofitActivity.class));
                break;

            case "AsyncTask":
                startActivity(new Intent(HomeActivity.this, AyncTaskActivity.class));
                break;

            case "Menu":
                startActivity(new Intent(HomeActivity.this, MenuActivity.class));
                break;

            case "GoogleMap":
                startActivity(new Intent(HomeActivity.this, MapsActivity.class));
                break;

            case "WebView":
                startActivity(new Intent(HomeActivity.this, WebViewActivity.class));
                break;

            case "IntentService":
                startActivity(new Intent(HomeActivity.this, IntentServiceActivity.class));
                break;

            case "Parcelable / Seriazable":
                startActivity(new Intent(HomeActivity.this, ParcelableActivityA.class));
                break;

            case "Notifications":
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
                break;

                case "SQLite":
                startActivity(new Intent(HomeActivity.this, SQLiteActivity.class));
                break;

        }

    }
}
