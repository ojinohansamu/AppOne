package com.example.homannh.dsd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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

    }

    public void ReadAllMarkets(){

        List<MarketDTO> allMarkets = new ArrayList<MarketDTO>();
        IMarketDAO marketDAO = new MarketDAO(MarketListViewActivity.this, "Winhh.db", null, 1);
        if(marketDAO.countsMarkets() > 0)
        {}
        else
        {
            allMarkets = LoadMarketRaw();
            for (MarketDTO market : allMarkets){
                //marketDAO.save();
            }


        }

    }

    public List<MarketDTO>LoadMarketRaw(){
        InputStream inputStream;
        String[] data;

        List<MarketDTO> allMarketRaw = new ArrayList<MarketDTO>();
        inputStream = getResources().openRawResource(R.raw.market);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvLine;
            int cnt = 0;

            while ((csvLine = reader.readLine()) != null)
            {
                data = csvLine.split(",");
                try
                {
                    if(cnt>0)
                    {
                        MarketDTO market = new MarketDTO();
                        market.setMARKET_ID(data[0].toString());
                        market.setMARKET_DESCRIPTION((data[1].toString()));
                        allMarketRaw.add(market);
                    }
                    cnt++;

                }catch (Exception e){
                    Log.e("Problem", e.toString());
                }
            }

        }
        catch (IOException eX){
            throw new RuntimeException("Error in reading CSV file: " + eX.toString());
        }


        return allMarketRaw;
    }


}



