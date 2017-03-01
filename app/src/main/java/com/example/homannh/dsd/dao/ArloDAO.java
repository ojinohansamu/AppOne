package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homannh.dsd.dto.ArloDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HOH on 2/20/2017.
 */

public class ArloDAO extends WinHHDAO implements IArloDAO {

    public ArloDAO(Context context) {
        super(context);
    }

    @Override
    public void initArlo(Context context) {
        super.reCreateArloTable();
    }

    @Override
    public List<ArloDTO> fetchArlos(String searchTerm) {
        List<ArloDTO> someArlos = new ArrayList<ArloDTO>();
        String sql = "SELECT * FROM " + ARLO_TABLE + " ORDER BY " + STOP_NO;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                ArloDTO anArlo = new ArloDTO();
                anArlo.setCUSTOMER_ID(cursor.getString(cursor.getColumnIndex(CUSTOMER_ID)));
                anArlo.setARLO_NO (cursor.getString(cursor.getColumnIndex(ARLO_NO)));
                anArlo.setSTORE_NO (cursor.getString(cursor.getColumnIndex(STORE_NO)));
                anArlo.setSTOP_NO (cursor.getInt(cursor.getColumnIndex(STOP_NO)));
                anArlo.setACCOUNT_NO (cursor.getString(cursor.getColumnIndex(ACCOUNT_NO)));
                anArlo.setSTART_DATE (cursor.getString(cursor.getColumnIndex(START_DATE)));
                anArlo.setEND_DATE (cursor.getString(cursor.getColumnIndex(END_DATE)));
                anArlo.setTICKET_TYPE (cursor.getString(cursor.getColumnIndex(TICKET_TYPE)));
                anArlo.setTICKET_TYPE_SEQ (cursor.getString(cursor.getColumnIndex(TICKET_TYPE_SEQ)));
                anArlo.setTICKET_COPIES_QTY (cursor.getInt(cursor.getColumnIndex(TICKET_COPIES_QTY)));
                anArlo.setCR_TERMS_CODE (cursor.getInt(cursor.getColumnIndex(CR_TERMS_CODE)));
                anArlo.setCR_STATUS_CODE (cursor.getString(cursor.getColumnIndex(CR_STATUS_CODE)));
                anArlo.setPRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(PRODUCT_TYPE)));
                anArlo.setCUST_VENDOR (cursor.getString(cursor.getColumnIndex(CUST_VENDOR)));
                anArlo.setLOCKBOX_ID (cursor.getString(cursor.getColumnIndex(LOCKBOX_ID)));
                anArlo.setDEPT_CONTACT (cursor.getString(cursor.getColumnIndex(DEPT_CONTACT)));
                anArlo.setDEPT_CODE (cursor.getString(cursor.getColumnIndex(DEPT_CODE)));
                anArlo.setPRICE_OV_IND (cursor.getString(cursor.getColumnIndex(PRICE_OV_IND)));
                anArlo.setTICKET_DISCOUNT_PER (cursor.getDouble(cursor.getColumnIndex(TICKET_DISCOUNT_PER)));
                anArlo.setPROMO_IND (cursor.getString(cursor.getColumnIndex(PROMO_IND )));
                anArlo.setAGE_DATED_RET_IND (cursor.getString(cursor.getColumnIndex(AGE_DATED_RET_IND)));
                anArlo.setPROMPT_FROM_LOAD_IND (cursor.getString(cursor.getColumnIndex(PROMPT_FROM_LOAD_IND)));
                anArlo.setFORECAST_IND (cursor.getString(cursor.getColumnIndex(FORECAST_IND)));
                anArlo.setDSD_REQ_IND (cursor.getString(cursor.getColumnIndex(DSD_REQ_IND)));
                anArlo.setSIGNATURE_REQUIRED_IND (cursor.getString(cursor.getColumnIndex(SIGNATURE_REQUIRED_IND)));
                anArlo.setPRINT_DISCOUNT_IND (cursor.getString(cursor.getColumnIndex(PRINT_DISCOUNT_IND)));
                anArlo.setPRINT_RETAIL_PRICE_IND (cursor.getString(cursor.getColumnIndex(PRINT_RETAIL_PRICE_IND)));
                anArlo.setSTORE_STAMP_REQ_TICKET (cursor.getString(cursor.getColumnIndex(STORE_STAMP_REQ_TICKET)));
                anArlo.setTICKET_FORMAT (cursor.getString(cursor.getColumnIndex(TICKET_FORMAT)));
                anArlo.setAUTH_LIST_ID (cursor.getString(cursor.getColumnIndex(AUTH_LIST_ID)));
                anArlo.setLOCK_IND (cursor.getString(cursor.getColumnIndex(LOCK_IND)));
                anArlo.setROUTE_STORE_IND (cursor.getString(cursor.getColumnIndex(ROUTE_STORE_IND)));
                anArlo.setSTD_ORDER_ALLOW_IND (cursor.getString(cursor.getColumnIndex(STD_ORDER_ALLOW_IND)));
                anArlo.setINVOICE_SORT_CODE (cursor.getString(cursor.getColumnIndex(INVOICE_SORT_CODE)));
                anArlo.setCARRY_OVER_DAY (cursor.getString(cursor.getColumnIndex(CARRY_OVER_DAY)));
                anArlo.setAMDUTCH_IND (cursor.getString(cursor.getColumnIndex(AMDUTCH_IND)));
                anArlo.setORDERS_ONLY_IND (cursor.getString(cursor.getColumnIndex(ORDERS_ONLY_IND)));
                anArlo.setSUPPLIER_COMM_ID (cursor.getString(cursor.getColumnIndex(SUPPLIER_COMM_ID)));
                anArlo.setSUPPLIER_DUNS_NO (cursor.getString(cursor.getColumnIndex(SUPPLIER_DUNS_NO)));
                anArlo.setSUPPLIER_LOCATION_NO (cursor.getString(cursor.getColumnIndex(SUPPLIER_LOCATION_NO)));
                anArlo.setRECEIVER_COMM_ID (cursor.getString(cursor.getColumnIndex(RECEIVER_COMM_ID)));
                anArlo.setRECEIVER_DUNS_NO (cursor.getString(cursor.getColumnIndex(RECEIVER_DUNS_NO)));
                anArlo.setRECEIVER_LOCATION_NO (cursor.getString(cursor.getColumnIndex(RECEIVER_LOCATION_NO)));
                anArlo.setDEX_VERSION (cursor.getString(cursor.getColumnIndex(DEX_VERSION)));
                anArlo.setGENERATE_G72_IND (cursor.getString(cursor.getColumnIndex(GENERATE_G72_IND)));
                anArlo.setSTORE_NAME (cursor.getString(cursor.getColumnIndex(STORE_NAME)));
                anArlo.setSTORE_ADDRESS_1 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_1)));
                anArlo.setSTORE_ADDRESS_2 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_2)));
                anArlo.setSTORE_ADDRESS_3 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_3)));
                anArlo.setSTORE_CITY_NAME (cursor.getString(cursor.getColumnIndex(STORE_CITY_NAME)));
                anArlo.setSTORE_STATE_CODE (cursor.getString(cursor.getColumnIndex(STORE_STATE_CODE)));
                anArlo.setSTORE_ZIP_CODE (cursor.getString(cursor.getColumnIndex(STORE_ZIP_CODE)));
                anArlo.setSTORE_PHONE_NO (cursor.getString(cursor.getColumnIndex(STORE_PHONE_NO)));
                anArlo.setSTORE_CONTACT (cursor.getString(cursor.getColumnIndex(STORE_CONTACT)));
                anArlo.setSTORE_REF_NO (cursor.getString(cursor.getColumnIndex(STORE_REF_NO)));
                anArlo.setMAXIMUM_DUE_BILL (cursor.getDouble(cursor.getColumnIndex(MAXIMUM_DUE_BILL)));
                anArlo.setSTORE_CHANGE_IND (cursor.getString(cursor.getColumnIndex(STORE_CHANGE_IND)));
                anArlo.setACCOUNT_TYPE (cursor.getString(cursor.getColumnIndex(ACCOUNT_TYPE)));
                anArlo.setDEPT_NAME (cursor.getString(cursor.getColumnIndex(DEPT_NAME)));
                anArlo.setSERVICED (cursor.getInt(cursor.getColumnIndex(SERVICED)));
                anArlo.setNAME_MODIFIED_IND (cursor.getString(cursor.getColumnIndex(NAME_MODIFIED_IND)));
                anArlo.setBALANCE_AMT (cursor.getDouble(cursor.getColumnIndex(BALANCE_AMT)));
                anArlo.setSELECTED_STOP (cursor.getString(cursor.getColumnIndex(SELECTED_STOP)));
                anArlo.setTICKET_SURCHARGE_AMT (cursor.getDouble(cursor.getColumnIndex(TICKET_SURCHARGE_AMT)));
                anArlo.setDELIVERY_MESSAGE (cursor.getString(cursor.getColumnIndex(DELIVERY_MESSAGE)));
                anArlo.setCALLBACK_PROMPT_IND (cursor.getString(cursor.getColumnIndex(CALLBACK_PROMPT_IND)));
                anArlo.setCALLBACK_TODAY_CODE (cursor.getString(cursor.getColumnIndex(CALLBACK_TODAY_CODE)));
                anArlo.setWEB_ORDER_IND (cursor.getString(cursor.getColumnIndex(WEB_ORDER_IND)));
                anArlo.setSALES_TAX_RATE (cursor.getDouble(cursor.getColumnIndex(SALES_TAX_RATE)));

                someArlos.add(anArlo);
                cursor.moveToNext();
                /* sample code
                anArlo.set (cursor.getString(cursor.getColumnIndex()));
                anArlo.set (cursor.getString(cursor.getColumnIndex()));
                 */
            }

        }

        cursor.close();
        return someArlos;
    }

    @Override
    public List<ArloDTO> getArlosBySQL(String yourSQL) {
        List<ArloDTO> someArlos = new ArrayList<ArloDTO>();
        Cursor cursor = getReadableDatabase().rawQuery(yourSQL, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                ArloDTO anArlo = new ArloDTO();
                anArlo.setCUSTOMER_ID(cursor.getString(cursor.getColumnIndex(CUSTOMER_ID)));
                anArlo.setARLO_NO (cursor.getString(cursor.getColumnIndex(ARLO_NO)));
                anArlo.setSTORE_NO (cursor.getString(cursor.getColumnIndex(STORE_NO)));
                anArlo.setSTOP_NO (cursor.getInt(cursor.getColumnIndex(STOP_NO)));
                anArlo.setACCOUNT_NO (cursor.getString(cursor.getColumnIndex(ACCOUNT_NO)));
                anArlo.setSTART_DATE (cursor.getString(cursor.getColumnIndex(START_DATE)));
                anArlo.setEND_DATE (cursor.getString(cursor.getColumnIndex(END_DATE)));
                anArlo.setTICKET_TYPE (cursor.getString(cursor.getColumnIndex(TICKET_TYPE)));
                anArlo.setTICKET_TYPE_SEQ (cursor.getString(cursor.getColumnIndex(TICKET_TYPE_SEQ)));
                anArlo.setTICKET_COPIES_QTY (cursor.getInt(cursor.getColumnIndex(TICKET_COPIES_QTY)));
                anArlo.setCR_TERMS_CODE (cursor.getInt(cursor.getColumnIndex(CR_TERMS_CODE)));
                anArlo.setCR_STATUS_CODE (cursor.getString(cursor.getColumnIndex(CR_STATUS_CODE)));
                anArlo.setPRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(PRODUCT_TYPE)));
                anArlo.setCUST_VENDOR (cursor.getString(cursor.getColumnIndex(CUST_VENDOR)));
                anArlo.setLOCKBOX_ID (cursor.getString(cursor.getColumnIndex(LOCKBOX_ID)));
                anArlo.setDEPT_CONTACT (cursor.getString(cursor.getColumnIndex(DEPT_CONTACT)));
                anArlo.setDEPT_CODE (cursor.getString(cursor.getColumnIndex(DEPT_CODE)));
                anArlo.setPRICE_OV_IND (cursor.getString(cursor.getColumnIndex(PRICE_OV_IND)));
                anArlo.setTICKET_DISCOUNT_PER (cursor.getDouble(cursor.getColumnIndex(TICKET_DISCOUNT_PER)));
                anArlo.setPROMO_IND (cursor.getString(cursor.getColumnIndex(PROMO_IND )));
                anArlo.setAGE_DATED_RET_IND (cursor.getString(cursor.getColumnIndex(AGE_DATED_RET_IND)));
                anArlo.setPROMPT_FROM_LOAD_IND (cursor.getString(cursor.getColumnIndex(PROMPT_FROM_LOAD_IND)));
                anArlo.setFORECAST_IND (cursor.getString(cursor.getColumnIndex(FORECAST_IND)));
                anArlo.setDSD_REQ_IND (cursor.getString(cursor.getColumnIndex(DSD_REQ_IND)));
                anArlo.setSIGNATURE_REQUIRED_IND (cursor.getString(cursor.getColumnIndex(SIGNATURE_REQUIRED_IND)));
                anArlo.setPRINT_DISCOUNT_IND (cursor.getString(cursor.getColumnIndex(PRINT_DISCOUNT_IND)));
                anArlo.setPRINT_RETAIL_PRICE_IND (cursor.getString(cursor.getColumnIndex(PRINT_RETAIL_PRICE_IND)));
                anArlo.setSTORE_STAMP_REQ_TICKET (cursor.getString(cursor.getColumnIndex(STORE_STAMP_REQ_TICKET)));
                anArlo.setTICKET_FORMAT (cursor.getString(cursor.getColumnIndex(TICKET_FORMAT)));
                anArlo.setAUTH_LIST_ID (cursor.getString(cursor.getColumnIndex(AUTH_LIST_ID)));
                anArlo.setLOCK_IND (cursor.getString(cursor.getColumnIndex(LOCK_IND)));
                anArlo.setROUTE_STORE_IND (cursor.getString(cursor.getColumnIndex(ROUTE_STORE_IND)));
                anArlo.setSTD_ORDER_ALLOW_IND (cursor.getString(cursor.getColumnIndex(STD_ORDER_ALLOW_IND)));
                anArlo.setINVOICE_SORT_CODE (cursor.getString(cursor.getColumnIndex(INVOICE_SORT_CODE)));
                anArlo.setCARRY_OVER_DAY (cursor.getString(cursor.getColumnIndex(CARRY_OVER_DAY)));
                anArlo.setAMDUTCH_IND (cursor.getString(cursor.getColumnIndex(AMDUTCH_IND)));
                anArlo.setORDERS_ONLY_IND (cursor.getString(cursor.getColumnIndex(ORDERS_ONLY_IND)));
                anArlo.setSUPPLIER_COMM_ID (cursor.getString(cursor.getColumnIndex(SUPPLIER_COMM_ID)));
                anArlo.setSUPPLIER_DUNS_NO (cursor.getString(cursor.getColumnIndex(SUPPLIER_DUNS_NO)));
                anArlo.setSUPPLIER_LOCATION_NO (cursor.getString(cursor.getColumnIndex(SUPPLIER_LOCATION_NO)));
                anArlo.setRECEIVER_COMM_ID (cursor.getString(cursor.getColumnIndex(RECEIVER_COMM_ID)));
                anArlo.setRECEIVER_DUNS_NO (cursor.getString(cursor.getColumnIndex(RECEIVER_DUNS_NO)));
                anArlo.setRECEIVER_LOCATION_NO (cursor.getString(cursor.getColumnIndex(RECEIVER_LOCATION_NO)));
                anArlo.setDEX_VERSION (cursor.getString(cursor.getColumnIndex(DEX_VERSION)));
                anArlo.setGENERATE_G72_IND (cursor.getString(cursor.getColumnIndex(GENERATE_G72_IND)));
                anArlo.setSTORE_NAME (cursor.getString(cursor.getColumnIndex(STORE_NAME)));
                anArlo.setSTORE_ADDRESS_1 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_1)));
                anArlo.setSTORE_ADDRESS_2 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_2)));
                anArlo.setSTORE_ADDRESS_3 (cursor.getString(cursor.getColumnIndex(STORE_ADDRESS_3)));
                anArlo.setSTORE_CITY_NAME (cursor.getString(cursor.getColumnIndex(STORE_CITY_NAME)));
                anArlo.setSTORE_STATE_CODE (cursor.getString(cursor.getColumnIndex(STORE_STATE_CODE)));
                anArlo.setSTORE_ZIP_CODE (cursor.getString(cursor.getColumnIndex(STORE_ZIP_CODE)));
                anArlo.setSTORE_PHONE_NO (cursor.getString(cursor.getColumnIndex(STORE_PHONE_NO)));
                anArlo.setSTORE_CONTACT (cursor.getString(cursor.getColumnIndex(STORE_CONTACT)));
                anArlo.setSTORE_REF_NO (cursor.getString(cursor.getColumnIndex(STORE_REF_NO)));
                anArlo.setMAXIMUM_DUE_BILL (cursor.getDouble(cursor.getColumnIndex(MAXIMUM_DUE_BILL)));
                anArlo.setSTORE_CHANGE_IND (cursor.getString(cursor.getColumnIndex(STORE_CHANGE_IND)));
                anArlo.setACCOUNT_TYPE (cursor.getString(cursor.getColumnIndex(ACCOUNT_TYPE)));
                anArlo.setDEPT_NAME (cursor.getString(cursor.getColumnIndex(DEPT_NAME)));
                anArlo.setSERVICED (cursor.getInt(cursor.getColumnIndex(SERVICED)));
                anArlo.setNAME_MODIFIED_IND (cursor.getString(cursor.getColumnIndex(NAME_MODIFIED_IND)));
                anArlo.setBALANCE_AMT (cursor.getDouble(cursor.getColumnIndex(BALANCE_AMT)));
                anArlo.setSELECTED_STOP (cursor.getString(cursor.getColumnIndex(SELECTED_STOP)));
                anArlo.setTICKET_SURCHARGE_AMT (cursor.getDouble(cursor.getColumnIndex(TICKET_SURCHARGE_AMT)));
                anArlo.setDELIVERY_MESSAGE (cursor.getString(cursor.getColumnIndex(DELIVERY_MESSAGE)));
                anArlo.setCALLBACK_PROMPT_IND (cursor.getString(cursor.getColumnIndex(CALLBACK_PROMPT_IND)));
                anArlo.setCALLBACK_TODAY_CODE (cursor.getString(cursor.getColumnIndex(CALLBACK_TODAY_CODE)));
                anArlo.setWEB_ORDER_IND (cursor.getString(cursor.getColumnIndex(WEB_ORDER_IND)));
                anArlo.setSALES_TAX_RATE (cursor.getDouble(cursor.getColumnIndex(SALES_TAX_RATE)));

                someArlos.add(anArlo);
                cursor.moveToNext();
                /* sample code
                anArlo.set (cursor.getString(cursor.getColumnIndex()));
                anArlo.set (cursor.getString(cursor.getColumnIndex()));
                 */
            }
        }
        cursor.close();
        return someArlos;
    }

    @Override
    public void insert(ArloDTO arlo) {
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
            //long cacheID = getWritableDatabase().insert(ARLO_TABLE, CUSTOMER_ID, cv);
            //arlo._ID_ARLO(cacheID);
            getWritableDatabase().insert(ARLO_TABLE, CUSTOMER_ID, cv);
        }

    @Override
    public void isArloTable() {
        //Create ARLO Table if not exist
        String sql = "CREATE TABLE IF NOT EXISTS "
                 + ARLO_TABLE + " (" +
                _ID_ARLO+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + GUID_CUSTOMER + " INTEGER, " + CUSTOMER_ID + " TEXT,"  +
                ARLO_NO + " TEXT," + STORE_NO + " TEXT," + STOP_NO + " INTEGER," + ACCOUNT_NO + " TEXT," +
                START_DATE + " TEXT," + END_DATE + " TEXT," + TICKET_TYPE + " TEXT," + TICKET_TYPE_SEQ + " TEXT," +
                TICKET_COPIES_QTY + " INTEGER," + CR_TERMS_CODE + " INTEGER," + CR_STATUS_CODE + " TEXT," + PRODUCT_TYPE + " TEXT," +
                CUST_VENDOR + " TEXT," + LOCKBOX_ID + " TEXT," + DEPT_CONTACT + " TEXT," + DEPT_CODE + " TEXT," +
                PRICE_OV_IND + " TEXT," + TICKET_DISCOUNT_PER + " TEXT," + PROMO_IND + " INTEGER," + AGE_DATED_RET_IND + " TEXT," +
                PROMPT_FROM_LOAD_IND + " TEXT," + FORECAST_IND + " TEXT," + DSD_REQ_IND + " TEXT," + SIGNATURE_REQUIRED_IND + " TEXT," +
                PRINT_DISCOUNT_IND + " TEXT," + PRINT_RETAIL_PRICE_IND + " TEXT," + STORE_STAMP_REQ_TICKET + " TEXT," + TICKET_FORMAT + " TEXT," +
                AUTH_LIST_ID + " TEXT," + LOCK_IND + " TEXT," + ROUTE_STORE_IND + " TEXT," + STD_ORDER_ALLOW_IND + " TEXT," +
                INVOICE_SORT_CODE + " TEXT," + CARRY_OVER_DAY + " TEXT," + AMDUTCH_IND + " TEXT," + ORDERS_ONLY_IND + " TEXT," +
                SUPPLIER_COMM_ID + " TEXT," + SUPPLIER_DUNS_NO + " TEXT," + SUPPLIER_LOCATION_NO + " TEXT," + RECEIVER_COMM_ID + " TEXT," +
                RECEIVER_DUNS_NO + " TEXT," + RECEIVER_LOCATION_NO + " TEXT," + DEX_VERSION + " TEXT," + GENERATE_G72_IND + " TEXT," +
                STORE_NAME + " TEXT," + STORE_ADDRESS_1 + " TEXT," + STORE_ADDRESS_2 + " TEXT," + STORE_ADDRESS_3 + " TEXT," +
                STORE_CITY_NAME + " TEXT," + STORE_STATE_CODE + " TEXT," + STORE_ZIP_CODE + " TEXT," + STORE_PHONE_NO + " TEXT," +
                STORE_CONTACT + " TEXT," + STORE_REF_NO + " TEXT," + MAXIMUM_DUE_BILL + " TEXT," + STORE_CHANGE_IND + " TEXT," +
                ACCOUNT_TYPE + " TEXT," + DEPT_NAME + " TEXT," + SERVICED + " INTEGER," +
                NAME_MODIFIED_IND + " TEXT," + BALANCE_AMT + " TEXT," + SELECTED_STOP + " TEXT," + TICKET_SURCHARGE_AMT + " TEXT," +
                DELIVERY_MESSAGE + " TEXT," + CALLBACK_PROMPT_IND + " TEXT," + CALLBACK_TODAY_CODE + " TEXT," + WEB_ORDER_IND + " TEXT," +
                SALES_TAX_RATE + " TEXT"
                + " );";

    }

    @Override
    public int countArlos() {
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
    public Set<Integer> fetchAllArloGuids() {
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
