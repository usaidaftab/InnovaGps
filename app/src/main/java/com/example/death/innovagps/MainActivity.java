package com.example.death.innovagps;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView speed,location;
    Button start;

    LocationManager locationManager;
    locationProvider object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speed=(TextView)findViewById(R.id.textView);
        location=(TextView)findViewById(R.id.textView2);
        start=(Button)findViewById(R.id.button);
        locationManager=(LocationManager) getSystemService(LOCATION_SERVICE);

        object=new locationProvider(MainActivity.this,location,speed);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,object);

            }
        });

    }
}
