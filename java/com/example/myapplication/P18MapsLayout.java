package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class P18MapsLayout extends AppCompatActivity {


    FusedLocationProviderClient myclient;
    TextView tv, tv1, tv2;
    double dlatitude, dlongitude;
    Location lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p18_maps_layout);

        tv = findViewById(R.id.textView1);
        tv1 = findViewById(R.id.textView2);
        tv2 = findViewById(R.id.textView3);

//implementation 'com.google.android.gms:play-services-location:18.0.0'
// or
// during LocationService it wil automatically add
        myclient = LocationServices.getFusedLocationProviderClient(this);

    }
    public void dothis(View v) {
        checkLOcationPermission();
    }
    private void checkLOcationPermission() {
// request for permission if not granted and get the result on onRequestPermissionsResult overridden method
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();

// add permission in manifests <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
//or
// getLastLocation() will do automatically

//The getLastLocation() method doesn't actually make a location request.
// It simply returns the location most recently obtained by the FusedLocationProviderClient class.
            myclient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        lastLocation = location;
                        dlatitude = lastLocation.getLatitude();
                        dlongitude = lastLocation.getLongitude();
                        tv.setText("" + dlatitude + "\n" + dlongitude);
                        Toast.makeText(getApplicationContext(), ""+dlatitude +dlongitude, Toast.LENGTH_SHORT).show();
// Geocoder class is used for Geocoding as well as Reverse Geocoding.
// Geocoding refers to transforming street address or any address into latitude and longitude.
// and in our app we are using ReverseGeoCoding as From latitude and longitude we are finding Physical address
                        Geocoder geocoder = new Geocoder(P18MapsLayout.this, Locale.getDefault());
                        try {

                            List<Address> locationList = geocoder.getFromLocation(dlatitude, dlongitude, 1);
                            if (locationList.size() > 0) {
                                Address address = locationList.get(0);
                                tv2.setText("" + address);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Location is null", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}