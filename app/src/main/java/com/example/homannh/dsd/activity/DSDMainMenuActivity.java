package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.MainActivity;
import com.example.homannh.appone.R;
import com.example.homannh.dsd.dto.RouteDTO;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;

public class DSDMainMenuActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private TextView lblRouteInfoID;
    private String _Routeinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmain_menu);

        lblRouteInfoID = (TextView) findViewById(R.id.lblRoutinfoID);
        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        toolBar.setTitle("D.S.D. Main Menu");

        Bundle bundle = getIntent().getExtras();
        _Routeinfo  = bundle.getString("VAR_Routeinfo");
        if(_Routeinfo!=null) {
            lblRouteInfoID.setText(_Routeinfo);
        }


    }
    public void btnExitOnClicked(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void btnAdjutmentClicked(View view){
        Intent sodActivity = new Intent(this, SODActivity.class);
        sodActivity.putExtra("VAR_Routeinfo", _Routeinfo);
        startActivity(sodActivity);
    }

    public void btnSalesClicked(View view){
        DisplayMessages("No Ready yet!");

    }

    public void btnOrdersClicked(View view){
        DisplayMessages("No Ready yet!");

    }

    public void btnEndOfDayClicked(View view){
        DisplayMessages("No Ready yet!");

    }

    public void btnMiscellaneousClicked(View view){
        Intent dsdMiscMenuActivity = new Intent(this, DSDMiscMenuActivity.class);
        dsdMiscMenuActivity.putExtra("VAR_Routeinfo", _Routeinfo);
        startActivity(dsdMiscMenuActivity);
    }

    public void DisplayMessages(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
