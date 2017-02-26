package com.example.homannh.dsd.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.ArloDAO;
import com.example.homannh.dsd.dao.IArloDAO;
import com.example.homannh.dsd.dto.ArloDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class ArloListViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arlo_list_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Stops");
        listViewMain = (ListView) findViewById(R.id.listViewMain);
        listViewMain.setAdapter(new MyCustomAdapter(this));

 /*       ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(ArloListViewActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.arlos));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent listViewClickedActivity = new Intent(ArloListViewActivity.this, ListViewClickedActivity.class);
                listViewClickedActivity.putExtra("ArloName", listView.getItemAtPosition(position).toString());
                startActivity(listViewClickedActivity);

            }
        });
        listView.setAdapter(mAdapter); */
    }

    class SingleRow
    {
        String name;
        String address;
        SingleRow(String name, String address)
        {
            this.name = name;
            this.address = address;
        }

    }
    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<SingleRow> myList;
        Context ctx;

        MyCustomAdapter(Context context)
        {
            ctx = context;
            myList = new ArrayList<SingleRow>();
            List<ArloDTO> allArlos = new ArrayList<ArloDTO>();
            IArloDAO arloDAO = new ArloDAO(ctx);
            String sql = "SELECT * FROM ARLO GROUP BY STORE_NO ORDER BY STOP_NO ";
            allArlos = arloDAO.getArlosBySQL(sql);

            for (ArloDTO arlo : allArlos) {
                SingleRow singleRowAdapter = new SingleRow(arlo.getSTORE_NAME(), arlo.getSTORE_ADDRESS_1() + ", " + arlo.getSTORE_CITY_NAME());
                myList.add(singleRowAdapter);
            }
        }

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.single_row, parent, false);
            TextView lblName = (TextView) row.findViewById(R.id.lblName);
            TextView lblAddress = (TextView) row.findViewById(R.id.lblAddress);

            SingleRow singleRow = myList.get(position);
            lblName.setText(singleRow.name);
            lblAddress.setText(singleRow.address);
            return row;
        }
    }
}