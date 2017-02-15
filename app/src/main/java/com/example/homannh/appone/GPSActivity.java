package com.example.homannh.appone;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class GPSActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener{

    private TextView lblLatitudeValue;
    private TextView lblLongitude;
    private double latitude;
    private double longitude;
    private FusedLocationProviderApi locationProvider = LocationServices.FusedLocationApi;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private final static int MILLISECONDS_PER_SECOND = 1000;
    public final static int MINUTE = 60 * MILLISECONDS_PER_SECOND;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        lblLatitudeValue = (TextView) findViewById(R.id.lblLatitudeValue);
        lblLongitude = (TextView) findViewById(R.id.lblLongitudeValue);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        //Init Location request with the accuracy and frequency
        locationRequest = new LocationRequest();

        locationRequest.setInterval(MINUTE);
        locationRequest.setFastestInterval(10 * MILLISECONDS_PER_SECOND);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);//PRIORITY_BALANCED_POWER_ACCURACY);

    }

    public void btnPauseGPSOnClicked(View view)
    {
        notReadyMessage();
    }


    public void notReadyMessage(){
        new MessagesDisplay(GPSActivity.this, "From GPS \nNOT Ready!");
        MessagesDisplay.showMessage();
    }


    @Override
    public void onConnected(Bundle bundle) {

        requestLocationUpdate();
    }

    private void requestLocationUpdate() {
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(googleApiClient.isConnected()){
            requestLocationUpdate();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        //Toast.makeText(this, "Location changed = " + location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_LONG).show();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        //now put these results to UI
        lblLatitudeValue.setText(""+ latitude);
        lblLongitude.setText(Double.toString(longitude)); // This use the Double to string method to change from doule to string

    }


}
