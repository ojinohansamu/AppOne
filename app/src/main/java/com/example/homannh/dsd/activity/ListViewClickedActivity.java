package com.example.homannh.dsd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.homannh.appone.R;

public class ListViewClickedActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Bundle extraBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_clicked);

        mToolbar = (Toolbar) findViewById(R.id.toolbarOnActivityListViewClicked);
        extraBundle = getIntent().getExtras();
        if(extraBundle!= null){
            mToolbar.setTitle(extraBundle.getString("ArloName"));
        }
    }
}
