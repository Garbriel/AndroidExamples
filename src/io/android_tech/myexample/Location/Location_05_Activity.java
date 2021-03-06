package io.android_tech.myexample.Location;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class Location_05_Activity extends FragmentActivity implements View.OnClickListener {
    EditText etLatitude;
    EditText etLongitude;
    Button btnMove;
    private GoogleMap map;
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_location_05);

        etLatitude = (EditText) findViewById(io.android_tech.myexample.R.id.etLatitude);
        etLongitude = (EditText) findViewById(io.android_tech.myexample.R.id.etLongitude);
        btnMove = (Button) findViewById(io.android_tech.myexample.R.id.btnMove);

        btnMove.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnMove:
                float latitude = Float.parseFloat(etLatitude.getText().toString());
                float longitude = Float.parseFloat(etLongitude.getText().toString());

                LatLng curPoint = new LatLng(latitude, longitude);
                map = ((MapFragment) getFragmentManager().findFragmentById(io.android_tech.myexample.R.id.map)).getMap();
                map.animateCamera(CameraUpdateFactory.newLatLng(curPoint));

                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        }
    }
}