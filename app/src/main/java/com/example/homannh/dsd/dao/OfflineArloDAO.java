package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.example.homannh.dsd.dto.ArloDTO;
import com.example.homannh.dsd.dto.ProductDTO;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by homannh on 2/21/2017.
 */

public class OfflineArloDAO extends WinHHDAO implements IOfflineArloDAO {

    //we have to make constructor since this SQLiteOpenHelper does not have the default contructor
    // that's why we have to create our own as a method below
    public OfflineArloDAO(Context ctx){

        super(ctx); //-> SQLiteOpenHelper needs 4 parms, COntent of this activity, db name, null, version no.

       /* H. Homann 02-22-2017 Tried to use SD card but failed. Don't know why?????
        super(ctx, Environment.getExternalStorageDirectory()+
                File.separator + "winhh.db", null, 1); //-> SQLiteOpenHelper needs 4 parms, COntent of this activity, db name, null, version no.
        */
    }


    @Override
    public List<ArloDTO> fetchArlos(String searchTerm) {
        return null;
    }

    @Override
    public List<ArloDTO> getArlosBySQL(String yourSQL) {
        return null;
    }

    @Override
    public void insert(ArloDTO arlo){
        ContentValues cv = new ContentValues();

        cv.put(GUID_CUSTOMER, arlo.getGUID_CUSTOMER());
        cv.put(CUSTOMER_ID, arlo.getCUSTOMER_ID());
        cv.put(ARLO_NO, arlo.getARLO_NO());
        cv.put(STORE_NO, arlo.getSTORE_NO());
        cv.put(STOP_NO, arlo.getSTOP_NO());
        cv.put(ACCOUNT_NO, arlo.getACCOUNT_NO());
        cv.put(START_DATE, arlo.getSTART_DATE());
        cv.put(END_DATE, arlo.getEND_DATE());
        cv.put(TICKET_TYPE, arlo.getTICKET_TYPE());
        cv.put(TICKET_TYPE_SEQ, arlo.getTICKET_TYPE_SEQ());
        cv.put(TICKET_COPIES_QTY, arlo.getTICKET_COPIES_QTY());
        cv.put(CR_TERMS_CODE, arlo.getCR_TERMS_CODE());
        cv.put(CR_STATUS_CODE, arlo.getCR_STATUS_CODE());
        cv.put(PRODUCT_TYPE, arlo.getPRODUCT_TYPE());
        cv.put(CUST_VENDOR, arlo.getCUST_VENDOR());
        cv.put(LOCKBOX_ID, arlo.getLOCKBOX_ID());
        cv.put(DEPT_CONTACT, arlo.getDEPT_CONTACT());
        cv.put(DEPT_CODE, arlo.getDEPT_CODE());
        cv.put(PRICE_OV_IND, arlo.getPRICE_OV_IND());
        cv.put(TICKET_DISCOUNT_PER, arlo.getTICKET_DISCOUNT_PER());
        cv.put(PROMO_IND, arlo.getPROMO_IND());
        cv.put(AGE_DATED_RET_IND, arlo.getAGE_DATED_RET_IND());
        cv.put(PROMPT_FROM_LOAD_IND, arlo.getPROMPT_FROM_LOAD_IND());
        cv.put(FORECAST_IND, arlo.getFORECAST_IND());
        cv.put(DSD_REQ_IND, arlo.getDSD_REQ_IND());
        cv.put(SIGNATURE_REQUIRED_IND, arlo.getSIGNATURE_REQUIRED_IND());
        cv.put(PRINT_DISCOUNT_IND, arlo.getPRINT_DISCOUNT_IND());
        cv.put(PRINT_RETAIL_PRICE_IND, arlo.getPRINT_RETAIL_PRICE_IND());
        cv.put(STORE_STAMP_REQ_TICKET, arlo.getSTORE_STAMP_REQ_TICKET());
        cv.put(TICKET_FORMAT, arlo.getTICKET_FORMAT());
        cv.put(AUTH_LIST_ID, arlo.getAUTH_LIST_ID());
        cv.put(LOCK_IND, arlo.getLOCK_IND());
        cv.put(ROUTE_STORE_IND, arlo.getROUTE_STORE_IND());
        cv.put(STD_ORDER_ALLOW_IND, arlo.getSTD_ORDER_ALLOW_IND());
        cv.put(INVOICE_SORT_CODE, arlo.getINVOICE_SORT_CODE());
        cv.put(CARRY_OVER_DAY, arlo.getCARRY_OVER_DAY());
        cv.put(AMDUTCH_IND, arlo.getAMDUTCH_IND());
        cv.put(ORDERS_ONLY_IND, arlo.getORDERS_ONLY_IND());
        cv.put(SUPPLIER_COMM_ID, arlo.getSUPPLIER_COMM_ID());
        cv.put(SUPPLIER_DUNS_NO, arlo.getSUPPLIER_DUNS_NO());
        cv.put(SUPPLIER_LOCATION_NO, arlo.getSUPPLIER_LOCATION_NO());
        cv.put(RECEIVER_COMM_ID, arlo.getRECEIVER_COMM_ID());
        cv.put(RECEIVER_DUNS_NO, arlo.getRECEIVER_DUNS_NO());
        cv.put(RECEIVER_LOCATION_NO, arlo.getRECEIVER_LOCATION_NO());
        cv.put(DEX_VERSION, arlo.getDEX_VERSION());
        cv.put(GENERATE_G72_IND, arlo.getGENERATE_G72_IND());
        cv.put(STORE_NAME, arlo.getSTORE_NAME());
        cv.put(STORE_ADDRESS_1, arlo.getSTORE_ADDRESS_1());
        cv.put(STORE_ADDRESS_2, arlo.getSTORE_ADDRESS_2());
        cv.put(STORE_ADDRESS_3, arlo.getSTORE_ADDRESS_3());
        cv.put(STORE_CITY_NAME, arlo.getSTORE_CITY_NAME());
        cv.put(STORE_STATE_CODE, arlo.getSTORE_STATE_CODE());
        cv.put(STORE_ZIP_CODE, arlo.getSTORE_ZIP_CODE());
        cv.put(STORE_PHONE_NO, arlo.getSTORE_PHONE_NO());
        cv.put(STORE_CONTACT, arlo.getSTORE_CONTACT());
        cv.put(STORE_REF_NO, arlo.getSTORE_REF_NO());
        cv.put(MAXIMUM_DUE_BILL, arlo.getMAXIMUM_DUE_BILL());
        cv.put(STORE_CHANGE_IND, arlo.getSTORE_CHANGE_IND());
        cv.put(ACCOUNT_TYPE, arlo.getACCOUNT_TYPE());
        cv.put(DEPT_NAME, arlo.getDEPT_NAME());
        cv.put(SERVICED, arlo.getSERVICED());
        cv.put(NAME_MODIFIED_IND, arlo.getNAME_MODIFIED_IND());
        cv.put(BALANCE_AMT, arlo.getBALANCE_AMT());
        cv.put(SELECTED_STOP, arlo.getSELECTED_STOP());
        cv.put(TICKET_SURCHARGE_AMT, arlo.getTICKET_SURCHARGE_AMT());
        cv.put(DELIVERY_MESSAGE, arlo.getDELIVERY_MESSAGE());
        cv.put(CALLBACK_PROMPT_IND, arlo.getCALLBACK_PROMPT_IND());
        cv.put(CALLBACK_TODAY_CODE, arlo.getCALLBACK_TODAY_CODE());
        cv.put(WEB_ORDER_IND, arlo.getWEB_ORDER_IND());
        cv.put(SALES_TAX_RATE, arlo.getSALES_TAX_RATE());

        //insert record to db
        long cacheID = getWritableDatabase().insert(ARLO_TABLE, CUSTOMER_ID, cv);
       //rlo.(cacheID);

    }

    @Override
    public void IsArloExist() {

    }

    @Override
    public int countArlos(){
        int arloCount = 0;

        String sgl = "SELECT COUNT(*) FROM " + ARLO_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sgl, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            arloCount = cursor.getInt(0);
        }

        cursor.close();

        return arloCount;
    }

    @Override
    public Set<Integer> fetchAllArloGuids(){

        //this is to create a hash set which contains all GUID_CUSTOMER

        Set<Integer>allArloGuid = new HashSet<Integer>();

        String sql = "SELECT " + GUID_CUSTOMER + " FROM " + ARLO_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                int guidCustomer = cursor.getInt(cursor.getColumnIndex(GUID_CUSTOMER));

                //add this guidCustomer to our set collection
                allArloGuid.add(Integer.valueOf(guidCustomer));
                cursor.moveToNext();
            }
        }

        cursor.close();
        return allArloGuid;
    }

}
