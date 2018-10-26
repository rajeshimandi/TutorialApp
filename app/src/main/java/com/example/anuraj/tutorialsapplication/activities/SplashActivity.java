package com.example.anuraj.tutorialsapplication.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.anuraj.tutorialsapplication.R;
import com.example.anuraj.tutorialsapplication.ToastUtils;
import com.example.anuraj.tutorialsapplication.Utils;
import com.example.anuraj.tutorialsapplication.home.HomeActivity;
import com.example.anuraj.tutorialsapplication.service.LocationTrackerService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/**
 * Created by AnuRaj on 10/26/2018.
 */

public class SplashActivity extends AppCompatActivity {

    private final int LOC_REQ = 111;
    private final int REQUEST_CHECK_SETTINGS = 222;
    private final int PLAY_SERVICES = 333;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Utils.isNetworkAvailable(this)) {

            if (isGooglePlayServicesAvailable()) {
                if (isLocPermissionAvailable()) {
                    getUserLocation();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOC_REQ);
                }
            } else {
                ToastUtils.showShortToast(this, getResources().getString(R.string.error_msg_no_play_services));
            }
        } else {
            ToastUtils.showShortToast(this, getResources().getString(R.string.error_msg_no_internet));
        }

    }

    /**
     * checks availability of play services app
     *
     * @return
     */
    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if (status != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(status)) {
                googleApiAvailability.getErrorDialog(this, status, PLAY_SERVICES).show();
            }
            return false;
        }
        return true;
    }

    /**
     * Checks if location is enabled and starts service
     */
    private void getUserLocation() {
        if (isLocationEnabled(this))
            startLocationService();
        else
            showSettingsAlert();
    }

    /**
     * Checks for fine location permission
     *
     * @return
     */
    private boolean isLocPermissionAvailable() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    /**
     * Starts service
     */
    private void startLocationService() {
        startService(new Intent(SplashActivity.this, LocationTrackerService.class));
        navigateToNextActivity();
    }

    /**
     * Checks if location services are enabled
     *
     * @param activity
     * @return
     */
    private boolean isLocationEnabled(Activity activity) {
        LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled, networkEnabled;
        try {
            gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
            return false;
        }
        return gpsEnabled && networkEnabled;
    }

    /**
     * Shows enable location dialog
     */
    private void showSettingsAlert() {
        LocationSettingsRequest settingsRequest = new LocationSettingsRequest.Builder()
                .addLocationRequest(new LocationTrackerService().getLocationRequest()).build();
        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client
                .checkLocationSettings(settingsRequest);
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                int statusCode = ((ApiException) e).getStatusCode();
                if (statusCode == LocationSettingsStatusCodes.RESOLUTION_REQUIRED) {
                    try {
                        ResolvableApiException resolvable =
                                (ResolvableApiException) e;
                        resolvable.startResolutionForResult
                                (SplashActivity.this, REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        startLocationService();
                    }
                }
            }
        });
    }

    /**
     * Navigates to next activity based on the condition met
     */
    private void navigateToNextActivity() {
        new Handler().
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                        finish();
                    }
                }, 1500);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOC_REQ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getUserLocation();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.error_msg_loc_denied), Toast.LENGTH_SHORT).show();
                    navigateToNextActivity();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                if (resultCode == RESULT_CANCELED) {
                    ToastUtils.showShortToast(SplashActivity.this, getResources().getString(R.string.msg_enable_loc_services));
                    navigateToNextActivity();
                } else if (resultCode == RESULT_OK) {
                    startLocationService();
                }
                break;

            case PLAY_SERVICES:
                break;
        }
    }

}
