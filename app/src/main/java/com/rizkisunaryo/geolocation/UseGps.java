package com.rizkisunaryo.geolocation;

/**
 * Created by DELL on 3/10/2016.
 */

import android.Manifest;
import android.app.Activity;

import android.content.Context;

import android.content.pm.PackageManager;
import android.location.Location;

import android.location.LocationListener;

import android.location.LocationManager;

import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class UseGps extends Activity

{

    /** Called when the activity is first created. */

    @Override

    public void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

/* Use the LocationManager class to obtain GPS locations */

        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener mlocListener = new MyLocationListener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

    }

/* Class My Location Listener */

    public class MyLocationListener implements LocationListener

    {

        @Override

        public void onLocationChanged(Location loc)

        {

            loc.getLatitude();

            loc.getLongitude();

            String Text = "My current location is: " +

            "Latitud = " + loc.getLatitude() +

            "Longitud = " + loc.getLongitude();

            Toast.makeText( getApplicationContext(),

                    Text,

                    Toast.LENGTH_SHORT).show();

        }

        @Override

        public void onProviderDisabled(String provider)

        {

            Toast.makeText( getApplicationContext(),

                    "Gps Disabled",

                    Toast.LENGTH_SHORT ).show();

        }

        @Override

        public void onProviderEnabled(String provider)

        {

            Toast.makeText( getApplicationContext(),

                    "Gps Enabled",

                    Toast.LENGTH_SHORT).show();

        }

        @Override

        public void onStatusChanged(String provider, int status, Bundle extras)

        {

        }

    }/* End of Class MyLocationListener */

}/* End of UseGps Activity */