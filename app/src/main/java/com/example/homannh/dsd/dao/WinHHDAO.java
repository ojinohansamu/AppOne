package com.example.homannh.dsd.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by homannh on 2/23/2017.
 */
public class WinHHDAO extends SQLiteOpenHelper {

    //Arlo table
    public static final String ARLO_TABLE = "ARLO";
    public static final String _ID = "_ID";
    public static final String GUID_CUSTOMER = "GUID_CUSTOMER";
    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String ARLO_NO = "ARLO_NO";
    public static final String STORE_NO = "STORE_NO";
    public static final String STOP_NO = "STOP_NO";
    public static final String ACCOUNT_NO = "ACCOUNT_NO";
    public static final String START_DATE = "START_DATE";
    public static final String END_DATE = "END_DATE";
    public static final String TICKET_TYPE = "TICKET_TYPE";
    public static final String TICKET_TYPE_SEQ = "TICKET_TYPE_SEQ";
    public static final String TICKET_COPIES_QTY = "TICKET_COPIES_QTY";
    public static final String CR_TERMS_CODE = "CR_TERMS_CODE";
    public static final String CR_STATUS_CODE = "CR_STATUS_CODE";
    public static final String PRODUCT_TYPE = "PRODUCT_TYPE";
    public static final String CUST_VENDOR = "CUST_VENDOR";
    public static final String LOCKBOX_ID = "LOCKBOX_ID";
    public static final String DEPT_CONTACT = "DEPT_CONTACT";
    public static final String DEPT_CODE = "DEPT_CODE";
    public static final String PRICE_OV_IND = "PRICE_OV_IND";
    public static final String TICKET_DISCOUNT_PER = "TICKET_DISCOUNT_PER";
    public static final String PROMO_IND = "PROMO_IND";
    public static final String AGE_DATED_RET_IND = "AGE_DATED_RET_IND";
    public static final String PROMPT_FROM_LOAD_IND = "PROMPT_FROM_LOAD_IND";
    public static final String FORECAST_IND = "FORECAST_IND";
    public static final String DSD_REQ_IND = "DSD_REQ_IND";
    public static final String SIGNATURE_REQUIRED_IND = "SIGNATURE_REQUIRED_IND";
    public static final String PRINT_DISCOUNT_IND = "PRINT_DISCOUNT_IND";
    public static final String PRINT_RETAIL_PRICE_IND = "PRINT_RETAIL_PRICE_IND";
    public static final String STORE_STAMP_REQ_TICKET = "STORE_STAMP_REQ_TICKET";
    public static final String TICKET_FORMAT = "TICKET_FORMAT";
    public static final String AUTH_LIST_ID = "AUTH_LIST_ID";
    public static final String LOCK_IND = "LOCK_IND";
    public static final String ROUTE_STORE_IND = "ROUTE_STORE_IND";
    public static final String STD_ORDER_ALLOW_IND = "STD_ORDER_ALLOW_IND";
    public static final String INVOICE_SORT_CODE = "INVOICE_SORT_CODE";
    public static final String CARRY_OVER_DAY = "CARRY_OVER_DAY";
    public static final String AMDUTCH_IND = "AMDUTCH_IND";
    public static final String ORDERS_ONLY_IND = "ORDERS_ONLY_IND";
    public static final String SUPPLIER_COMM_ID = "SUPPLIER_COMM_ID";
    public static final String SUPPLIER_DUNS_NO = "SUPPLIER_DUNS_NO";
    public static final String SUPPLIER_LOCATION_NO = "SUPPLIER_LOCATION_NO";
    public static final String RECEIVER_COMM_ID = "RECEIVER_COMM_ID";
    public static final String RECEIVER_DUNS_NO = "RECEIVER_DUNS_NO";
    public static final String RECEIVER_LOCATION_NO = "RECEIVER_LOCATION_NO";
    public static final String DEX_VERSION = "DEX_VERSION";
    public static final String GENERATE_G72_IND = "GENERATE_G72_IND";
    public static final String STORE_NAME = "STORE_NAME";
    public static final String STORE_ADDRESS_1 = "STORE_ADDRESS_1";
    public static final String STORE_ADDRESS_2 = "STORE_ADDRESS_2";
    public static final String STORE_ADDRESS_3 = "STORE_ADDRESS_3";
    public static final String STORE_CITY_NAME = "STORE_CITY_NAME";
    public static final String STORE_STATE_CODE = "STORE_STATE_CODE";
    public static final String STORE_ZIP_CODE = "STORE_ZIP_CODE";
    public static final String STORE_PHONE_NO = "STORE_PHONE_NO";
    public static final String STORE_CONTACT = "STORE_CONTACT";
    public static final String STORE_REF_NO = "STORE_REF_NO";
    public static final String MAXIMUM_DUE_BILL = "MAXIMUM_DUE_BILL";
    public static final String STORE_CHANGE_IND = "STORE_CHANGE_IND";
    public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
    public static final String DEPT_NAME = "DEPT_NAME";
    public static final String SERVICED = "SERVICED";
    public static final String NAME_MODIFIED_IND = "NAME_MODIFIED_IND";
    public static final String BALANCE_AMT = "BALANCE_AMT";
    public static final String SELECTED_STOP = "SELECTED_STOP";
    public static final String TICKET_SURCHARGE_AMT = "TICKET_SURCHARGE_AMT";
    public static final String DELIVERY_MESSAGE = "DELIVERY_MESSAGE";
    public static final String CALLBACK_PROMPT_IND = "CALLBACK_PROMPT_IND";
    public static final String CALLBACK_TODAY_CODE = "CALLBACK_TODAY_CODE";
    public static final String WEB_ORDER_IND = "WEB_ORDER_IND";
    public static final String SALES_TAX_RATE = "SALES_TAX_RATE";

    //MARKET Table
    public static final String MARKET_TABLE = "MARKET";
    public static final String _ID_MARKET = "_ID_MARKET";
    public static final String MARKET_ID = "MARKET_ID";
    public static final String MARKET_DESCRIPTION = "MARKET_DESCRIPTION";


    public WinHHDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //This one from implements IArloDAO

        String sql = "CREATE TABLE " + ARLO_TABLE + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + GUID_CUSTOMER + " INTEGER, " + CUSTOMER_ID + " TEXT,"  +
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


        db.execSQL(sql);

        sql = "CREATE TABLE " + MARKET_TABLE + " ( " + _ID_MARKET + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + MARKET_DESCRIPTION
                + " TEXT " + ");";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ARLO_TABLE);
        onCreate(db);

    }
}
