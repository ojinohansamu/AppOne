package com.example.homannh.dsd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.IMarketDAO;
import com.example.homannh.dsd.dao.MarketDAO;
import com.example.homannh.dsd.dto.MarketDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MarketListViewActivity extends AppCompatActivity {

    private ListView marketListView;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_list_view);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Markets");
        marketListView = (ListView) findViewById(R.id.listViewMarket);
        ReadMarkets();

    }

    public void ReadMarkets(){

        List<MarketDTO> allMarkets = new ArrayList<MarketDTO>();
        IMarketDAO marketDAO = new MarketDAO(MarketListViewActivity.this);
        allMarkets = marketDAO.fetchMarkets("");
        // now try to get to the listview adapter
        //
        ArrayAdapter<MarketDTO> marketAdapter =
                new ArrayAdapter<MarketDTO>(MarketListViewActivity.this.getApplicationContext(), android.R.layout.simple_list_item_1, allMarkets);
        marketListView.setAdapter(marketAdapter);
    }

}



