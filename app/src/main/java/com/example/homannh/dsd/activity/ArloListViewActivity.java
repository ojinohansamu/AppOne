package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.homannh.appone.R;

public class ArloListViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arlo_list_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(ArloListViewActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.arlos));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent listViewClickedActivity = new Intent(ArloListViewActivity.this, ListViewClickedActivity.class);
                listViewClickedActivity.putExtra("ArloName", listView.getItemAtPosition(position).toString());
                startActivity(listViewClickedActivity);

            }
        });
        listView.setAdapter(mAdapter);
    }
}
