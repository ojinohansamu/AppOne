package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.R;

public class DSDMiscMenuActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private String _Routeinfo;
    private TextView lblRouteInfoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmisc_menu);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        toolBar.setTitle("Miscellaneous");

        lblRouteInfoID = (TextView) findViewById(R.id.lblRoutinfoID);
        Bundle bundle = getIntent().getExtras();
        _Routeinfo  = bundle.getString("VAR_Routeinfo");
        if(_Routeinfo!=null) {
            lblRouteInfoID.setText(_Routeinfo);
        }
    }

    public void btnExitOnClicked(View view){
        Intent dsdMainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
        dsdMainMenuActivity.putExtra("VAR_Routeinfo",_Routeinfo );
        startActivity(dsdMainMenuActivity);

    }

    public void btnDisplayArlosClicked(View view){
        Intent arloListViewActivity = new Intent(this, ArloListViewActivity.class);
        startActivity(arloListViewActivity);
    }

    public void btnDisplayMarketsClicked(View view){
        Intent marketListViewActivity = new Intent(this, MarketListViewActivity.class);
        startActivity(marketListViewActivity);
    }
    public void btnDisplayProductsClicked(View view){
        Intent productListView = new Intent(this, ProductListView.class);
        startActivity(productListView);
    }

    public void DisplayMessages(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
