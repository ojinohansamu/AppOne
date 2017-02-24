package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.homannh.appone.MainActivity;
import com.example.homannh.appone.R;

public class DSDMainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdmain_menu);
    }
    public void btnExitOnClicked(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void btnAdjutmentClicked(View view){
        Intent arloActivity = new Intent(this, ArloActivity.class);
        startActivity(arloActivity);
    }

    public void btnMiscellaneousClicked(View view){
        Intent dsdMiscMenuActivity = new Intent(this, DSDMiscMenuActivity.class);
        startActivity(dsdMiscMenuActivity);
    }
}
