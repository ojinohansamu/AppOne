package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.homannh.appone.R;

public class DSDMiscMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmisc_menu);
    }

    public void btnExitOnClicked(View view){
        Intent dsdMainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
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
        DisplayMessages("Not implemented yet!");
    }

    public void DisplayMessages(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
