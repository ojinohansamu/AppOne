package com.example.homannh.dsd.activity;

/*
H. Homann 2-20-2017
1. Added dao and dto packages plus the interface as a set of videos below. here is my playlist
    https://www.youtube.com/watch?v=Ncl4G0FSfXs&list=PLLdH-HQ5W6asD8ogl95HkJOq6pCsnAWP-&index=1

2. Try to use AutoCompleteTextView as on the video below, but could not make it worked as video below
    -https://www.youtube.com/watch?v=RSLcu0jW4Ys

 */
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.ArloDAOStub;
import com.example.homannh.dsd.dao.IArloDAO;
import com.example.homannh.dsd.dto.ArloDTO;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ArloActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private AutoCompleteTextView actStoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arlo);
        actStoreName = (AutoCompleteTextView) findViewById(R.id.actStoreName);

        //get Arlo names for our auto comple
        ArloSearchTask ast = new ArloSearchTask();
        ast.execute("e");
    }

    public void btnBackClicked (View view){
        Intent dsdmainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
        startActivity(dsdmainMenuActivity);


    }

    @Override
    public void onConnected(Bundle bundle) {
        
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    class ArloSearchTask extends AsyncTask<String, Integer, List<ArloDTO>>{

        @Override
        protected void onPostExecute(List<ArloDTO> arloDTOs) {
            super.onPostExecute(arloDTOs);
            ArrayAdapter<ArloDTO> arloAdapter =
                    new ArrayAdapter<ArloDTO>(ArloActivity.this.getApplicationContext(), android.R.layout.simple_list_item_1, arloDTOs);

             actStoreName.setAdapter(arloAdapter);
        }

        @Override
        protected List<ArloDTO> doInBackground(String... params) {

            IArloDAO arloDAO = new ArloDAOStub();

            return arloDAO.fetchArlos(params[0]);
        }



    }

    /*
    public void LoadArloRaw(){
        InputStream inputStream;
        String[] data;

        inputStream = getResources().openRawResource(R.raw.arlo);

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
