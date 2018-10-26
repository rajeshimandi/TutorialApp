package com.example.anuraj.tutorialsapplication.activities;

import android.app.Application;
import android.location.Location;

/**
 * Created by AnuRaj on 10/26/2018.
 */

public class TutorialsApp extends Application {

    private Location location;
    private String address;
    private String userName;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
