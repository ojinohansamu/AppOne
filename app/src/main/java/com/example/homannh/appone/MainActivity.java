package com.example.homannh.appone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOneClicked(View view){
        Intent gpsActivity = new Intent(this,GPSActivity.class);
        startActivity(gpsActivity);


    }

    public void btnTwoClicked(View view){
        notReadyMessage();

    }

    public void btnThreeClicked(View view){
        notReadyMessage();

    }

    public void btnFourClicked(View view){
        notReadyMessage();

    }

    public void btnFiveClicked(View view){
        notReadyMessage();

    }

    public void btnSixClicked(View view){
        notReadyMessage();

    }

    public void notReadyMessage(){
        new MessagesDisplay(MainActivity.this, "From Main ..");
        MessagesDisplay.showMessage();
        //Toast.makeText(this, "Not ready yet!", Toast.LENGTH_LONG).show();
    }
}
