package com.example.anuraj.tutorialsapplication.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import com.example.anuraj.tutorialsapplication.TutorialsApp;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class LocationTrackerService extends Service {

    private Location mLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Creates instance of fused location provider client
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());

        //Callback for location updates
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                mLocation = locationResult.getLastLocation();
                if (mLocation != null) {
                    getAddress();
                    stopTrackingLocation();
                }
            }
        };
        getLocation();
    }

    /**
     * Creates location request
     *
     * @return
     */
    public LocationRequest getLocationRequest() {
        if (mLocation == null) {
            mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(10000);
            mLocationRequest.setFastestInterval(5000);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        }
        return mLocationRequest;
    }

    /**
     * Instantiates async task to fetch address
     */
    private void getAddress() {
        FetchAddress fetchAddress = new FetchAddress();
        fetchAddress.execute();
    }

    /**
     * initiates for location updates
     */
    private void startTrackingLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.requestLocationUpdates(getLocationRequest(), mLocationCallback, null /* Looper */);
        }
    }

    /**
     * Fetches user location from last known value. If its null requests location updates
     */
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.getLastLocation().addOnSuccessListener(
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                mLocation = location;
                                getAddress();
                            } else {
                                if (location == null) {
                                    startTrackingLocation();
                                }
                            }
                        }
                    });

        }
    }

    /**
     * Unregisters location updates
     */
    private void stopTrackingLocation() {
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    /**
     * Async task to fetch address
     */
    public class FetchAddress extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            List<Address> addresses = null;
            String resultMessage = "";
            Address address = null;
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(
                        mLocation.getLatitude(),
                        mLocation.getLongitude(),
                        1);
                if (addresses != null && addresses.size() > 0) {
                    address = addresses.get(0);
                    ArrayList<String> addressParts = new ArrayList<>();
                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                        addressParts.add(address.getAddressLine(i));
                    }
                    resultMessage = TextUtils.join(" ", addressParts);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            TutorialsApp app = (TutorialsApp) getApplication();
            app.setAddress(resultMessage);
            app.setLocation(mLocation);
            stopService();
            return resultMessage;
        }
    }

    /**
     * Stops service
     */
    private void stopService() {
        stopSelf();
    }


}
