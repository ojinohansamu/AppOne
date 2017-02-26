package com.example.homannh.dsd.dao;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.activity.ArloActivity;
import com.example.homannh.dsd.dto.ArloDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by HOH on 2/20/2017.
 */

public class ArloDAOStub implements IArloDAO {

    @Override
    public List<ArloDTO> fetchArlos(String searchTerm)
    {
        List<ArloDTO> allArlos = new ArrayList<ArloDTO>();

        //This class is to create dummy product as a test;
        // for now how about we loop to the raw data that I have from our production database;

        ArloDTO arlo1 = new ArloDTO();
        arlo1.setCUSTOMER_ID("1028045");
        arlo1.setARLO_NO("07");
        arlo1.setSTORE_NO("900330296");
        arlo1.setSTOP_NO(1);
        arlo1.setSTORE_NAME("SHOPRITE 0296 W ORANGE");
        arlo1.setSTORE_ADDRESS_1("1 ROONEY CIRCLE");
        arlo1.setSTORE_CITY_NAME("WEST ORANGE");
        allArlos.add(arlo1);

        ArloDTO arlo2 = new ArloDTO();
        arlo2.setCUSTOMER_ID("1034745");
        arlo2.setARLO_NO("07");
        arlo2.setSTORE_NO("400080800");
        arlo2.setSTOP_NO(2);
        arlo2.setSTORE_NAME("STOP & SHOP 0800");
        arlo2.setSTORE_ADDRESS_1("8 FRANKLIN STREET");
        arlo2.setSTORE_CITY_NAME("BLOOMFIELD");
        allArlos.add(arlo2);

        ArloDTO arlo3 = new ArloDTO();
        arlo3.setCUSTOMER_ID("1034745");
        arlo3.setARLO_NO("09");
        arlo3.setSTORE_NO("400080800");
        arlo3.setSTOP_NO(2);
        arlo3.setSTORE_NAME("STOP & SHOP 0800");
        arlo3.setSTORE_ADDRESS_1("8 FRANKLIN STREET");
        arlo3.setSTORE_CITY_NAME("BLOOMFIELD");
        allArlos.add(arlo3);

        return allArlos;
    }

    @Override
    public List<ArloDTO> getArlosBySQL(String yourSQL) {
        return null;
    }

    @Override
    public void insert(ArloDTO arlo) {

    }

    @Override
    public void IsArloExist() {

    }

    @Override
    public int countArlos() {
        return 0;
    }

    @Override
    public Set<Integer> fetchAllArloGuids() {
        return null;
    }

    /*
    private List<ArloDTO> allArlos(){

        List<ArloDTO> arloRaw = new ArrayList<ArloDTO>();


        return  arloRaw;
    }
    */

/*
    public void doArlo(){

        InputStream inputStream;
        String[] data;

        inputStream = getResources().openRawResource(R.raw.);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvLine;
            while ((csvLine = reader.readLine()) != null)
            {
                data = csvLine.split(",");
                try
                {
                    Market market = new Market();
                    market.set_market_id(data[0].toString());
                    market.set_market_description(data[1].toString());
                    dbHandler.addMarket(market);
                    Log.e("Data =", ""+data[0] + ", " + data[1] +" Length=" + String.valueOf(data.length));
                }catch (Exception e){
                    Log.e("Problem", e.toString());
                }
            }

        }
        catch (IOException eX){
            throw new RuntimeException("Error in reading CSV file: " + eX.toString());
        }

    }
    */

}
