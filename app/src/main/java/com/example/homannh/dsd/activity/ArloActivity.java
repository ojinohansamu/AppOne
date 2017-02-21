package com.example.homannh.dsd.activity;

/*
H. Homann 2-21-2017
 1. Create OfflineArloDAO and interface IOfflineArloDAO. Create method to create ARLO_TABLE
    https://www.youtube.com/watch?v=YxsW1u5FChk
 2. Use these OfflineDAO to fill ARLO_TABLE checking a set first, so we wont create duplicate. As on this video
    https://www.youtube.com/watch?v=gvzGUWhwnfs
    or this my playlist
    https://www.youtube.com/watch?v=gvzGUWhwnfs&index=11&list=PLLdH-HQ5W6asD8ogl95HkJOq6pCsnAWP-

H. Homann 2-20-2017
1. Added dao and dto packages plus the interface as a set of videos below. here is my playlist
    https://www.youtube.com/watch?v=Ncl4G0FSfXs&list=PLLdH-HQ5W6asD8ogl95HkJOq6pCsnAWP-&index=1

2. Try to use AutoCompleteTextView as on the video below, but it's hard to see because the background as video below
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
import com.example.homannh.dsd.dao.IOfflineArloDAO;
import com.example.homannh.dsd.dao.OfflineArloDAO;
import com.example.homannh.dsd.dto.ArloDTO;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        /*
        H. Homann 02-21-2017
        https://www.youtube.com/watch?v=gvzGUWhwnfs
        */
        @Override
        protected List<ArloDTO> doInBackground(String... params) {

            IArloDAO arloDAO = new ArloDAOStub();
            List<ArloDTO> allArlos = new ArrayList<ArloDTO>();

            IOfflineArloDAO offlineArloDAO = new OfflineArloDAO(ArloActivity.this);

            int countArlos = offlineArloDAO.countArlos();
            if(countArlos == 0)
            {
                allArlos = LoadArloRaw();

                //for (ArloDTO arlo)

            }
            else
               allArlos = arloDAO.fetchArlos(params[0]);

            return allArlos;
        }



    }

    public List<ArloDTO> LoadArloRaw(){
        InputStream inputStream;
        String[] data;
        List<ArloDTO> allArloRaw = new ArrayList<ArloDTO>();

        inputStream = getResources().openRawResource(R.raw.arlo);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvLine;
            while ((csvLine = reader.readLine()) != null)
            {
                data = csvLine.split(",");
                try
                {
                    ArloDTO arlo = new ArloDTO();
                    arlo.setCUSTOMER_ID(data[0].toString());
                    arlo.setARLO_NO(data[1].toString());
                    arlo.setSTORE_NO(data[2].toString());
                    arlo.setSTOP_NO(Integer.parseInt(data[3].toString()));
                    arlo.setSTART_DATE(data[4].toString());
                    arlo.setEND_DATE(data[5].toString());
                    arlo.setTICKET_COPIES_QTY(Integer.parseInt(data[8].toString()));

                    arlo.setPRODUCT_TYPE(data[11].toString());
                    arlo.setSTORE_NAME(data[45].toString());
                    arlo.setSTORE_ADDRESS_1(data[46].toString());
                    arlo.setSTORE_ADDRESS_2(data[47].toString());
                    arlo.setSTORE_CITY_NAME(data[49].toString());
                    arlo.setSTORE_STATE_CODE(data[50].toString());
                    arlo.setSTORE_ZIP_CODE(data[51].toString());
                    arlo.setDEPT_NAME(data[58].toString());

                    allArloRaw.add(arlo);
                    Log.e("Data =", ""+data[0] + ", " + data[1] +" Length=" + String.valueOf(data.length));
                }catch (Exception e){
                    Log.e("Problem", e.toString());
                }
            }

        }
        catch (IOException eX){
            throw new RuntimeException("Error in reading CSV file: " + eX.toString());
        }

    return allArloRaw;
    }
}
