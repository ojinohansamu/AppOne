package com.example.homannh.dsd.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.bll.RouteInfoSER;

public class DSDMiscMenuActivity extends AppCompatActivity {

    public static final String _VAR_RouteinfoTag = "VAR_Routeinfo";
    private Toolbar toolBar;
    private TextView lblMainHeader;
    private RouteInfoSER _routeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmisc_menu);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        lblMainHeader = (TextView) findViewById(R.id.lblMainHeader);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            _routeInfo = new RouteInfoSER();
            _routeInfo = (RouteInfoSER) bundle.getSerializable(_VAR_RouteinfoTag);
            if (_routeInfo != null) {
                toolBar.setTitle(_routeInfo.getMARKET_ID() + _routeInfo.getROUTE_ID() + "  " + _routeInfo.getROUTE_NAME());
            }
            lblMainHeader.setText(R.string.lblMiscellaneous);
        }

    }

    public void btnExitOnClicked(View view){
        Intent dsdMainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
        dsdMainMenuActivity.putExtra(_VAR_RouteinfoTag, _routeInfo);
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
        Intent productListView = new Intent(this, ProductListViewActivity.class);
        startActivity(productListView);
    }

    public void btnScannerTestClicked(View view){
        Intent scannerActivity = new Intent(this, ScannerActivity.class);
        startActivity(scannerActivity);
    }

    public void btnReloadDBClicked(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Confirm Rebuilding..");
        alertDialog.setMessage("Are you sure you want to re-build the database?");
        alertDialog.setIcon(R.drawable.bimboround);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent  hhActivity = new Intent(DSDMiscMenuActivity.this, HHActivity.class);
                startActivity(hhActivity);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }

    public void DisplayMessages(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
