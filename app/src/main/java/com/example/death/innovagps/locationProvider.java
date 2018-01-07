package com.example.death.innovagps;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Death on 10/30/2017.
 */

public class locationProvider implements LocationListener{

    Context context;
    TextView locationview,speedview;

    public locationProvider(Context context, TextView location,TextView speed)
    {
        this.context=context;
        this.locationview=location;
        this.speedview=speed;
    }

    @Override
    public void onLocationChanged(Location location) {

        double latitude=location.getLatitude();
        double longitude=location.getLongitude();
        double speed=location.getSpeed()*3.6;

        locationview.setText("Latitude: "+latitude+"\nLongitutde: "+longitude);

        Toast.makeText(context, "Latitude: "+latitude+"\nLongitude: "+longitude+"\nSpeed: "+speed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

        Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        context.startActivity(intent);
        Toast.makeText(context, "Gps is off", Toast.LENGTH_SHORT).show();
    }
}
