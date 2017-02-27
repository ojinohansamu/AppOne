package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.MainActivity;
import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.ArloDAO;
import com.example.homannh.dsd.dao.BasepriceDAO;
import com.example.homannh.dsd.dao.IArloDAO;
import com.example.homannh.dsd.dao.IBasepriceDAO;
import com.example.homannh.dsd.dao.IMarketDAO;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.IRouteDAO;
import com.example.homannh.dsd.dao.MarketDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dao.RouteDAO;
import com.example.homannh.dsd.dto.ArloDTO;
import com.example.homannh.dsd.dto.BasepriceDTO;
import com.example.homannh.dsd.dto.MarketDTO;
import com.example.homannh.dsd.dto.ProductDTO;
import com.example.homannh.dsd.dto.RouteDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DSDActivity extends AppCompatActivity {

    private TextView lblUserValue;
    private TextView txtUserPassword;
    private String marketRouteID = "";
    private String routeID = "";
    private Toolbar toolBar;
    private RouteDTO _route;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsd);
        lblUserValue = (TextView) findViewById(R.id.lblUserValue);
        txtUserPassword = (TextView) findViewById(R.id.txtPassword);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        toolBar.setTitle("D.S.D. X-Cell Plus");
        HouseKeeping();
        lblUserValue.setText(marketRouteID);

    }

    private void HouseKeeping() {

        CheckRouteTable();
        CheckMarketTable();
        CheckArloTable();
        CheckProductTable();
        CheckBasepriceTable();
    }

    public void btnExitOnClicked(View view){
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

    public void btnLoginOnClicked(View view){
        if(password.equals(txtUserPassword.getText().toString())) {
            Intent dsdMainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
            dsdMainMenuActivity.putExtra("VAR_Routeinfo", _route.getMARKET_ID() + " " + _route.getROUTE_ID() + "  " + _route.getROUTE_NAME());
            //Does not work this is try to pass the RouteDTO dsdMainMenuActivity.putExtra("data", (Serializable) _route);
            startActivity(dsdMainMenuActivity);
        }
        else
        {
            Toast.makeText(this, "Invalid Password!", Toast.LENGTH_SHORT).show();
            txtUserPassword.setText("");
        }
    }

    public void CheckRouteTable(){
        //Read Route
        List<RouteDTO> allroutes = new ArrayList<RouteDTO>();
        IRouteDAO routeDAO = new RouteDAO(DSDActivity.this);
        routeDAO.IsRouteExist();
        if(routeDAO.countRoute()>0)
        {}
        else
        {   // Generate Route table from raw data
            allroutes = LoadRouteRaw();
            for (RouteDTO aRoute : allroutes) {
                try {
                    routeDAO.insert(aRoute);
                } catch (Exception e) {
                }
            }
        }
        allroutes = routeDAO.fetchRoutes("");
        for (RouteDTO aRoute : allroutes)
        {
                marketRouteID = aRoute.getMARKET_ID().toString() + aRoute.getROUTE_ID();
                routeID = aRoute.getROUTE_ID();
                _route = aRoute;
                break;
        }
        password = new StringBuilder(routeID).reverse().toString();
     }

    private List<RouteDTO> LoadRouteRaw() {
        InputStream inputStream;
        String[] data;
        List<RouteDTO> allRouteRaw = new ArrayList<RouteDTO>();
        inputStream = getResources().openRawResource(R.raw.route);
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
                        RouteDTO route = new RouteDTO();
                        route.setMARKET_ID(data[0].toString());
                        route.setROUTE_ID((data[1].toString()));
                        route.setROUTE_NAME ((data[2].toString()));
                        route.setROUTE_TYPE ((data[3].toString()));
                        route.setDISPLAY_PRICE_IND ((data[4].toString()));
                        route.setDEX_SIGNATURE_CODE ((data[5].toString()));
                        route.setLOAD_SECURITY_CODE ((data[6].toString()));
                        route.setRETURN_SECURITY_CODE ((data[7].toString()));
                        route.setCOMMUNICATION_SECURITY_CODE ((data[8].toString()));
                        route.setDNL_DATE ((data[9].toString()));
                        route.setINVOICE_MARKET_ID((data[10].toString()));
                        route.setSLF_PLUS_IND ((data[11].toString()));
                        route.setSTD_ORD_CONTROL_CODE ((data[12].toString()));
                        route.setOVERSELL_LOAD_IND ((data[13].toString()));
                        route.setDEPOT_NAME ((data[14].toString()));
                        route.setUNLOCK_STOPS_IND ((data[15].toString()));
                        route.setPRESET_ORDER_IND ((data[16].toString()));
                        route.setORDER_CHANGE_CODE ((data[17].toString()));
                        route.setROUTE_LEVEL_ORDER_IND ((data[18].toString()));
                        route.setSCREEN_SECURITY_CODE ((data[19].toString()));
                        route.setCOMM_TIME ((data[20].toString()));
                        route.setDISABLE_ADD_CO_IND ((data[21].toString()));
                        route.setADDITIONAL_CONTROLS_IND ((data[22].toString()));
                        route.setZERO_DISTRIBUTION_IND ((data[23].toString()));
                        route.setDELAYED_CASH_IND ((data[24].toString()));
                        route.setDEF_RET_LOCATION ((data[25].toString()));

                        allRouteRaw.add(route);
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

        return allRouteRaw;
    }

    public void CheckMarketTable(){
        List<MarketDTO> allMarkets = new ArrayList<MarketDTO>();
        IMarketDAO marketDAO = new MarketDAO(this);

        marketDAO.IsMarketExist();
        if(marketDAO.countsMarkets() > 0)
        {}
        else
        {
            allMarkets = LoadMarketRaw();
            for (MarketDTO mkt : allMarkets){
                try {
                    marketDAO.insert(mkt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    private void CheckArloTable() {
        List<ArloDTO> allArlos = new ArrayList<ArloDTO>();
        IArloDAO arloDAO = new ArloDAO(this);
        arloDAO.IsArloExist();

        if(arloDAO.countArlos() > 0)
        {}
        else
        {
            allArlos = LoadArloRaw();
            for (ArloDTO arlo : allArlos){
                try {
                    arloDAO.insert(arlo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //marketDAO.save();
            }
        }
    }

    public List<ArloDTO>LoadArloRaw(){
        InputStream inputStream;
        String[] data;

        List<ArloDTO> allArloRaw = new ArrayList<ArloDTO>();
        inputStream = getResources().openRawResource(R.raw.arlo);
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
                        ArloDTO arlo = new ArloDTO();
                        arlo.setCUSTOMER_ID(data[0].toString());
                        arlo.setARLO_NO(data[1].toString());
                        arlo.setSTORE_NO(data[2].toString());
                        arlo.setSTOP_NO(Integer.parseInt(data[3].toString()));
                        arlo.setACCOUNT_NO(data[4].toString());
                        arlo.setSTART_DATE(data[5].toString());
                        arlo.setEND_DATE(data[6].toString());
                        arlo.setTICKET_TYPE(data[7].toString());
                        arlo.setTICKET_TYPE_SEQ(data[8].toString());
                        arlo.setTICKET_COPIES_QTY(Integer.parseInt(data[9].toString()));
                        arlo.setCR_TERMS_CODE(Integer.parseInt(data[10].toString()));
                        arlo.setCR_STATUS_CODE(data[11].toString());
                        arlo.setPRODUCT_TYPE(data[12].toString());

                        arlo.setCUST_VENDOR (data[13].toString());
                        arlo.setLOCKBOX_ID(data[14].toString());
                        arlo.setDEPT_CONTACT(data[15].toString());
                        arlo.setDEPT_CODE(data[16].toString());
                        arlo.setPRICE_OV_IND(data[17].toString());
                        arlo.setTICKET_DISCOUNT_PER(Double.parseDouble(data[18].toString()));
                        arlo.setPROMO_IND(data[19].toString());
                        arlo.setAGE_DATED_RET_IND(data[20].toString());
                        arlo.setPROMPT_FROM_LOAD_IND(data[21].toString());
                        arlo.setFORECAST_IND(data[22].toString());
                        arlo.setDSD_REQ_IND(data[23].toString());
                        arlo.setSIGNATURE_REQUIRED_IND(data[24].toString());
                        arlo.setPRINT_DISCOUNT_IND(data[25].toString());
                        arlo.setPRINT_RETAIL_PRICE_IND(data[26].toString());
                        arlo.setSTORE_STAMP_REQ_TICKET(data[27].toString());
                        arlo.setTICKET_FORMAT(data[28].toString());
                        arlo.setAUTH_LIST_ID(data[29].toString());
                        arlo.setLOCK_IND(data[30].toString());
                        arlo.setROUTE_STORE_IND(data[31].toString());
                        arlo.setSTD_ORDER_ALLOW_IND(data[32].toString());
                        arlo.setINVOICE_SORT_CODE(data[33].toString());
                        arlo.setCARRY_OVER_DAY(data[34].toString());
                        arlo.setAMDUTCH_IND(data[35].toString());
                        arlo.setORDERS_ONLY_IND (data[36].toString());
                        arlo.setSUPPLIER_COMM_ID(data[37].toString());
                        arlo.setSUPPLIER_DUNS_NO(data[38].toString());
                        arlo.setSUPPLIER_LOCATION_NO(data[39].toString());
                        arlo.setRECEIVER_COMM_ID(data[40].toString());
                        arlo.setRECEIVER_DUNS_NO(data[41].toString());
                        arlo.setRECEIVER_LOCATION_NO(data[42].toString());
                        arlo.setDEX_VERSION(data[43].toString());
                        arlo.setGENERATE_G72_IND(data[44].toString());
                        arlo.setSTORE_NAME(data[45].toString());
                        arlo.setSTORE_ADDRESS_1(data[46].toString());
                        arlo.setSTORE_ADDRESS_2(data[47].toString());
                        arlo.setSTORE_CITY_NAME(data[49].toString());
                        arlo.setSTORE_STATE_CODE(data[50].toString());
                        arlo.setSTORE_ZIP_CODE(data[51].toString());
                        arlo.setDEPT_NAME(data[58].toString());

                        arlo.setSERVICED(Integer.parseInt(data[59].toString()));
                        arlo.setNAME_MODIFIED_IND(data[60].toString());
                        arlo.setMAXIMUM_DUE_BILL(Double.parseDouble(data[61].toString()));
                        arlo.setBALANCE_AMT(Double.parseDouble(data[62].toString()));
                        arlo.setTICKET_SURCHARGE_AMT(Double.parseDouble(data[63].toString()));
                        arlo.setDELIVERY_MESSAGE(data[64].toString());
                        arlo.setCALLBACK_PROMPT_IND(data[65].toString());
                        arlo.setCALLBACK_TODAY_CODE(data[66].toString());
                        arlo.setWEB_ORDER_IND(data[67].toString());
                        arlo.setSALES_TAX_RATE(Double.parseDouble(data[68].toString()));

                        allArloRaw.add(arlo);
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


        return allArloRaw;
    }


    public void CheckProductTable(){
        List<ProductDTO> allProducts = new ArrayList<ProductDTO>();
        IProductDAO productDAO = new ProductDAO(DSDActivity.this);
        productDAO.IsPoductExist();
        if(productDAO.countProducts()>100)
        {}
        else
        {
            allProducts = LoadProductRaw();
            for (ProductDTO aProduct : allProducts) {
                try
                {
                    productDAO.insert(aProduct);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private List<ProductDTO> LoadProductRaw() {
        InputStream inputStream;
        String[] data;
        List<ProductDTO> allProductRaw = new ArrayList<ProductDTO>();
        inputStream = getResources().openRawResource(R.raw.product);
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
                        ProductDTO product = new ProductDTO();
                        product.setPRODUCT_ID(data[0].toString());
                        product.setITEM_NO((data[1].toString()));
                        product.setCOMPANY_CODE ((data[2].toString()));
                        product.setUPC_CODE ((data[3].toString()));
                        product.setSUB_UPC_CODE ((data[4].toString()));
                        product.setPRODUCT_GROUP_CODE ((data[5].toString()));
                        product.setPRODUCT_CAT_CODE ((data[6].toString()));
                        product.setFINANCIAL_CAT_CODE ((data[7].toString()));
                        product.setPRODUCT_DESC((data[8].toString()));
                        product.setSHELF_LIFE_DAY_1 (Integer.parseInt(data[9].toString()));
                        product.setSHELF_LIFE_DAY_2 (Integer.parseInt(data[10].toString()));
                        product.setSHELF_LIFE_DAY_3 (Integer.parseInt(data[11].toString()));
                        product.setSHELF_LIFE_DAY_4 (Integer.parseInt(data[12].toString()));
                        product.setSHELF_LIFE_DAY_5 (Integer.parseInt(data[13].toString()));
                        product.setSHELF_LIFE_DAY_6 (Integer.parseInt(data[14].toString()));
                        product.setSHELF_LIFE_DAY_7 (Integer.parseInt(data[15].toString()));
                        product.setFORECAST_TYPE((data[16].toString()));
                        product.setRETURNS_ALLOWED_IND((data[17].toString()));
                        product.setSPREAD_GROUP((data[18].toString()));
                        product.setSALES_ALLOWED_IND((data[19].toString()));
                        product.setFRESH_RETURNS_ALLOWED_IND((data[20].toString()));
                        product.setDEX_COUNTRY_CODE((data[21].toString()));
                        product.setDEX_PRODUCT_TYPE((data[22].toString()));
                        product.setPACK_SIZE_QTY((data[23].toString()));
                        product.setNO_DNL_DATE((data[25].toString()));

                        allProductRaw.add(product);
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

        return allProductRaw;
    }

    public void CheckBasepriceTable(){
        List<BasepriceDTO> allBaseprice = new ArrayList<BasepriceDTO>();
        IBasepriceDAO basepriceDAO = new BasepriceDAO(DSDActivity.this);
        basepriceDAO.IsBasepriceExist();
        if(basepriceDAO.countBaseprice()>0)
        {}
        else
        {
            allBaseprice = LoadBasepriceRaw();
            for (BasepriceDTO aBaseprice : allBaseprice) {
                try
                {
                    basepriceDAO.insert(aBaseprice);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private List<BasepriceDTO> LoadBasepriceRaw() {
        InputStream inputStream;
        String[] data;
        List<BasepriceDTO> allBasepriceRaw = new ArrayList<BasepriceDTO>();
        inputStream = getResources().openRawResource(R.raw.baseprice);
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
                        BasepriceDTO baseprice = new BasepriceDTO();
                        baseprice.setEFFECTIVE_DATE(data[0].toString());
                        baseprice.setPRODUCT_ID(data[1].toString());
                        baseprice.setITEM_NO((data[2].toString()));
                        baseprice.setWHOLESALE_PRICE (Double.parseDouble(data[3].toString()));
                        baseprice.setRETAIL_PRICE (Double.parseDouble(data[4].toString()));
                        baseprice.setDISTRIBUTOR_PRICE (Double.parseDouble(data[5].toString()));
                        baseprice.setDISTRIBUTOR_SPREAD_PER (Double.parseDouble(data[6].toString()));
                        baseprice.setDISTRIBUTOR_PROMO_PART_IND((data[7].toString()));
                        allBasepriceRaw.add(baseprice);
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

        return allBasepriceRaw;
    }


}
