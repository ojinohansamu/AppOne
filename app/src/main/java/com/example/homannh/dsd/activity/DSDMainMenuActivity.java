package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.MainActivity;
import com.example.homannh.appone.R;
import com.example.homannh.dsd.bll.RouteInfoSER;

public class DSDMainMenuActivity extends AppCompatActivity {

    public static final String _VAR_RouteinfoTag = "VAR_Routeinfo";
    private Toolbar toolBar;
    private TextView lblMainHeader;
    private RouteInfoSER _routeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmain_menu);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        lblMainHeader = (TextView) findViewById(R.id.lblMainHeader);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            _routeInfo = new RouteInfoSER();
            _routeInfo = (RouteInfoSER) bundle.getSerializable(_VAR_RouteinfoTag);
            if (_routeInfo != null) {
                toolBar.setTitle(_routeInfo.getMARKET_ID() + _routeInfo.getROUTE_ID() + "  " + _routeInfo.getROUTE_NAME());
            }
            lblMainHeader.setText(R.string.lblDSDMain);
        }


    }
    public void btnExitOnClicked(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void btnAdjutmentClicked(View view){
        Intent sodActivity = new Intent(this, SODActivity.class);
        sodActivity.putExtra(_VAR_RouteinfoTag, _routeInfo);
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
        dsdMiscMenuActivity.putExtra(_VAR_RouteinfoTag, _routeInfo);
        startActivity(dsdMiscMenuActivity);
    }

    public void DisplayMessages(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
