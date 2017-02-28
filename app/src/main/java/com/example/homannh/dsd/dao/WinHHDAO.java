package com.example.homannh.dsd.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by homannh on 2/23/2017.
 */
public class WinHHDAO extends SQLiteOpenHelper {

    //HOH

    //Arlo table
    public static final String ARLO_TABLE = "ARLO";
    public static final String _ID_ARLO= "_ID_ARLO";
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

    //Route Table
    public static final String ROUTE_TABLE = "ROUTE";
    public static final String _ID_ROUTE = "_ID_ROUTE";
    public static final String ROUTE_ID = "ROUTE_ID";
    public static final String ROUTE_NAME = "ROUTE_NAME";
    public static final String ROUTE_TYPE = "ROUTE_TYPE";
    public static final String DISPLAY_PRICE_IND = "DISPLAY_PRICE_IND";
    public static final String DEX_SIGNATURE_CODE = "DEX_SIGNATURE_CODE";
    public static final String LOAD_SECURITY_CODE = "LOAD_SECURITY_CODE";
    public static final String RETURN_SECURITY_CODE = "RETURN_SECURITY_CODE";
    public static final String COMMUNICATION_SECURITY_CODE = "COMMUNICATION_SECURITY_CODE";
    public static final String DNL_DATE = "DNL_DATE";
    public static final String INVOICE_MARKET_ID = "INVOICE_MARKET_ID";
    public static final String SLF_PLUS_IND = "SLF_PLUS_IND";
    public static final String STD_ORD_CONTROL_CODE = "STD_ORD_CONTROL_CODE";
    public static final String OVERSELL_LOAD_IND = "OVERSELL_LOAD_IND";
    public static final String DEPOT_NAME = "DEPOT_NAME";
    public static final String UNLOCK_STOPS_IND = "UNLOCK_STOPS_IND";
    public static final String PRESET_ORDER_IND = "PRESET_ORDER_IND";
    public static final String ORDER_CHANGE_CODE = "ORDER_CHANGE_CODE";
    public static final String ROUTE_LEVEL_ORDER_IND = "ROUTE_LEVEL_ORDER_IND";
    public static final String SCREEN_SECURITY_CODE = "SCREEN_SECURITY_CODE";
    public static final String COMM_TIME = "COMM_TIME";
    public static final String DISABLE_ADD_CO_IND = "DISABLE_ADD_CO_IND";
    public static final String ADDITIONAL_CONTROLS_IND = "ADDITIONAL_CONTROLS_IND";
    public static final String ZERO_DISTRIBUTION_IND = "ZERO_DISTRIBUTION_IND";
    public static final String DELAYED_CASH_IND = "DELAYED_CASH_IND";
    public static final String DEF_RET_LOCATION = "DEF_RET_LOCATION";

    //Product Table
    public static final String PRODUCT_TABLE = "PRODUCT";
    public static final String _ID_PRODUCT = "_ID_PRODUCT";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String ITEM_NO = "ITEM_NO";
    public static final String COMPANY_CODE = "COMPANY_CODE";
    public static final String UPC_CODE = "UPC_CODE";
    public static final String SUB_UPC_CODE = "SUB_UPC_CODE";
    public static final String PRODUCT_GROUP_CODE = "PRODUCT_GROUP_CODE";
    public static final String PRODUCT_CAT_CODE = "PRODUCT_CAT_CODE";
    public static final String FINANCIAL_CAT_CODE = "FINANCIAL_CAT_CODE";
    public static final String PRODUCT_DESC = "PRODUCT_DESC";
    public static final String SHELF_LIFE_DAY_1 = "SHELF_LIFE_DAY_1";
    public static final String SHELF_LIFE_DAY_2 = "SHELF_LIFE_DAY_2";
    public static final String SHELF_LIFE_DAY_3 = "SHELF_LIFE_DAY_3";
    public static final String SHELF_LIFE_DAY_4 = "SHELF_LIFE_DAY_4";
    public static final String SHELF_LIFE_DAY_5 = "SHELF_LIFE_DAY_5";
    public static final String SHELF_LIFE_DAY_6 = "SHELF_LIFE_DAY_6";
    public static final String SHELF_LIFE_DAY_7 = "SHELF_LIFE_DAY_7";
    public static final String FORECAST_TYPE = "FORECAST_TYPE";
    public static final String RETURNS_ALLOWED_IND = "RETURNS_ALLOWED_IND";
    public static final String SPREAD_GROUP = "SPREAD_GROUP";
    public static final String SALES_ALLOWED_IND = "SALES_ALLOWED_IND";
    public static final String FRESH_RETURNS_ALLOWED_IND = "FRESH_RETURNS_ALLOWED_IND";
    public static final String DEX_COUNTRY_CODE = "DEX_COUNTRY_CODE";
    public static final String DEX_PRODUCT_TYPE = "DEX_PRODUCT_TYPE";
    public static final String PACK_SIZE_QTY = "PACK_SIZE_QTY";
    public static final String NO_DNL_DATE = "NO_DNL_DATE";

    //BASEPRICE
    public static final String BASEPRICE_TABLE = "BASEPRICE";
    public static final String _ID_BASEPRICE = "_ID_BASEPRICE";
    public static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
    public static final String WHOLESALE_PRICE = "WHOLESALE_PRICE";
    public static final String RETAIL_PRICE = "RETAIL_PRICE";
    public static final String DISTRIBUTOR_PRICE = "DISTRIBUTOR_PRICE";
    public static final String DISTRIBUTOR_SPREAD_PER = "DISTRIBUTOR_SPREAD_PER";
    public static final String DISTRIBUTOR_PROMO_PART_IND = "DISTRIBUTOR_PROMO_PART_IND";

    //INVENADJ
    public static final String INVENADJ_TABLE = "INVENADJ";
    public static final String _ID_INVENADJ = "_ID_INVENADJ";
    public static final String INVENADJ_ID = "INVENADJ_ID";
    public static final String RECORD_TYPE = "RECORD_TYPE";
    public static final String STORE_DELIVERY_DATE = "STORE_DELIVERY_DATE";
    public static final String TRANSACTION_DATE = "TRANSACTION_DATE";
    public static final String TRANSACTION_HOUR = "TRANSACTION_HOUR";
    public static final String TRANSACTION_MINUTE = "TRANSACTION_MINUTE";
    public static final String DOCUMENT_NUMBER = "DOCUMENT_NUMBER";
    public static final String ADJUST_INVENTORY = "ADJUST_INVENTORY";
    public static final String ADJUST_TYPE = "ADJUST_TYPE";
    public static final String THRIFT_STORE = "THRIFT_STORE";
    public static final String ADJUST_QTY = "ADJUST_QTY";
    public static final String ROUTE_PRICE = "ROUTE_PRICE";
    public static final String UPLOAD_IND = "UPLOAD_IND";


    public WinHHDAO(Context context) {
        super(context, "winhh.db", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //This one from implements IArloDAO

        //Create ARLO Table
        String sql = "CREATE TABLE "
                + ARLO_TABLE + " (" +
                _ID_ARLO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + GUID_CUSTOMER + " INTEGER, " + CUSTOMER_ID + " TEXT,"  +
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

        //Create Market Table
        sql = "CREATE TABLE "
                + MARKET_TABLE + " ( " + _ID_MARKET + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + MARKET_DESCRIPTION
                + " TEXT " + ");";
        db.execSQL(sql);

        //Create Route Table
        sql = "CREATE TABLE "
                + ROUTE_TABLE + "(" + _ID_ROUTE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + ROUTE_ID + " TEXT, " + ROUTE_NAME + " TEXT, " + ROUTE_TYPE + " TEXT, "
                + DISPLAY_PRICE_IND + " TEXT, " + DEX_SIGNATURE_CODE + " TEXT, " + LOAD_SECURITY_CODE + " TEXT, " + RETURN_SECURITY_CODE + " TEXT, " + COMMUNICATION_SECURITY_CODE + " TEXT, "
                + DNL_DATE + " TEXT, " + INVOICE_MARKET_ID + " TEXT, " + SLF_PLUS_IND + " TEXT, " + STD_ORD_CONTROL_CODE + " TEXT, " + OVERSELL_LOAD_IND + " TEXT, "
                + DEPOT_NAME + " TEXT, " + UNLOCK_STOPS_IND + " TEXT, " + PRESET_ORDER_IND + " TEXT, " + ORDER_CHANGE_CODE + " TEXT, " + ROUTE_LEVEL_ORDER_IND + " TEXT, "
                + SCREEN_SECURITY_CODE + " TEXT, " + COMM_TIME + " TEXT, " + DISABLE_ADD_CO_IND + " TEXT, " + ADDITIONAL_CONTROLS_IND + " TEXT, " + ZERO_DISTRIBUTION_IND + " TEXT, "
                + DELAYED_CASH_IND + " TEXT, "+ DEF_RET_LOCATION + " TEXT"
                + ");";

        db.execSQL(sql);

        //Create Product Table

        sql = "CREATE TABLE "
                + PRODUCT_TABLE + "(" + _ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, " + COMPANY_CODE + " TEXT, " + UPC_CODE + " TEXT, "
                + SUB_UPC_CODE + " TEXT, " + PRODUCT_GROUP_CODE + " TEXT, " + PRODUCT_CAT_CODE + " TEXT, " + FINANCIAL_CAT_CODE + " TEXT, " + PRODUCT_DESC + " TEXT, "
                + SHELF_LIFE_DAY_1 + " INTEGER, " + SHELF_LIFE_DAY_2 + " INTEGER, " + SHELF_LIFE_DAY_3 + " INTEGER, " + SHELF_LIFE_DAY_4 + " INTEGER, " + SHELF_LIFE_DAY_5 + " INTEGER, "
                + SHELF_LIFE_DAY_6 + " INTEGER, " + SHELF_LIFE_DAY_7 + " INTEGER, "
                + FORECAST_TYPE + " TEXT, " + RETURNS_ALLOWED_IND + " TEXT, " + SPREAD_GROUP + " TEXT, " + SALES_ALLOWED_IND + " TEXT, " + FRESH_RETURNS_ALLOWED_IND + " TEXT, "
                + DEX_COUNTRY_CODE + " TEXT, " + DEX_PRODUCT_TYPE + " TEXT, " + PACK_SIZE_QTY + " TEXT, " + NO_DNL_DATE + " TEXT"
                + ");";

        db.execSQL(sql);

        //Create Baseprice Table

        sql = "CREATE TABLE "
                + BASEPRICE_TABLE + "(" + _ID_BASEPRICE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EFFECTIVE_DATE + " TEXT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, "
                + WHOLESALE_PRICE + " DOUBLE, "  + RETAIL_PRICE + " DOUBLE, "  + DISTRIBUTOR_PRICE + " DOUBLE, "
                + DISTRIBUTOR_SPREAD_PER + " DOUBLE, " + DISTRIBUTOR_PROMO_PART_IND + " TEXT "
                + ");";

        db.execSQL(sql);

        //Create Invenadj Table

        sql = "CREATE TABLE "
                + INVENADJ_TABLE + "(" + _ID_INVENADJ + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INVENADJ_ID + " long, " + RECORD_TYPE + " TEXT, " + ITEM_NO + " TEXT, "
                + STORE_DELIVERY_DATE + " TEXT, "  + TRANSACTION_DATE + " TEXT, "  + TRANSACTION_HOUR + " TEXT, " + TRANSACTION_MINUTE + " TEXT, "
                + DOCUMENT_NUMBER + " TEXT, "  + ADJUST_INVENTORY + " TEXT, "  + ADJUST_TYPE + " TEXT, " + THRIFT_STORE + " TEXT, "
                + ADJUST_QTY + " INTEGER, " + ROUTE_PRICE + " DOUBLE, " + UPLOAD_IND + " TEXT, " + PRODUCT_ID + " TEXT "
                + ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ARLO_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MARKET_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ROUTE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BASEPRICE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INVENADJ_TABLE);
        onCreate(db);

    }

    public void reCreateArloTable(SQLiteDatabase db){
        String sql = "DROP TABLE IF EXISTS ";
            db.execSQL(sql + ARLO_TABLE);

            sql = "CREATE TABLE "
                + ARLO_TABLE + " (" +
                _ID_ARLO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + GUID_CUSTOMER + " INTEGER, " + CUSTOMER_ID + " TEXT,"  +
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
    }

    public void reCreateMarketTable(SQLiteDatabase db){
        String sql = "DROP TABLE IF EXISTS ";
        db.execSQL(sql + MARKET_TABLE);

        sql = "CREATE TABLE "
                + MARKET_TABLE + " ( " + _ID_MARKET + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + MARKET_DESCRIPTION
                + " TEXT " + ");";
        db.execSQL(sql);

    }

    public void reCreateRouteTable(SQLiteDatabase db) {
        String sql = "DROP TABLE IF EXISTS ";
        db.execSQL(sql + ROUTE_TABLE);

        sql = "CREATE TABLE "
                + ROUTE_TABLE + "(" + _ID_ROUTE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + ROUTE_ID + " TEXT, " + ROUTE_NAME + " TEXT, " + ROUTE_TYPE + " TEXT, "
                + DISPLAY_PRICE_IND + " TEXT, " + DEX_SIGNATURE_CODE + " TEXT, " + LOAD_SECURITY_CODE + " TEXT, " + RETURN_SECURITY_CODE + " TEXT, " + COMMUNICATION_SECURITY_CODE + " TEXT, "
                + DNL_DATE + " TEXT, " + INVOICE_MARKET_ID + " TEXT, " + SLF_PLUS_IND + " TEXT, " + STD_ORD_CONTROL_CODE + " TEXT, " + OVERSELL_LOAD_IND + " TEXT, "
                + DEPOT_NAME + " TEXT, " + UNLOCK_STOPS_IND + " TEXT, " + PRESET_ORDER_IND + " TEXT, " + ORDER_CHANGE_CODE + " TEXT, " + ROUTE_LEVEL_ORDER_IND + " TEXT, "
                + SCREEN_SECURITY_CODE + " TEXT, " + COMM_TIME + " TEXT, " + DISABLE_ADD_CO_IND + " TEXT, " + ADDITIONAL_CONTROLS_IND + " TEXT, " + ZERO_DISTRIBUTION_IND + " TEXT, "
                + DELAYED_CASH_IND + " TEXT, "+ DEF_RET_LOCATION + " TEXT"
                + ");";

        db.execSQL(sql);

    }

    public void reCreateProductTable(SQLiteDatabase db) {
        String sql = "DROP TABLE IF EXISTS ";
        db.execSQL(sql + PRODUCT_TABLE);

        sql = "CREATE TABLE "
                + PRODUCT_TABLE + "(" + _ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, " + COMPANY_CODE + " TEXT, " + UPC_CODE + " TEXT, "
                + SUB_UPC_CODE + " TEXT, " + PRODUCT_GROUP_CODE + " TEXT, " + PRODUCT_CAT_CODE + " TEXT, " + FINANCIAL_CAT_CODE + " TEXT, " + PRODUCT_DESC + " TEXT, "
                + SHELF_LIFE_DAY_1 + " INTEGER, " + SHELF_LIFE_DAY_2 + " INTEGER, " + SHELF_LIFE_DAY_3 + " INTEGER, " + SHELF_LIFE_DAY_4 + " INTEGER, " + SHELF_LIFE_DAY_5 + " INTEGER, "
                + SHELF_LIFE_DAY_6 + " INTEGER, " + SHELF_LIFE_DAY_7 + " INTEGER, "
                + FORECAST_TYPE + " TEXT, " + RETURNS_ALLOWED_IND + " TEXT, " + SPREAD_GROUP + " TEXT, " + SALES_ALLOWED_IND + " TEXT, " + FRESH_RETURNS_ALLOWED_IND + " TEXT, "
                + DEX_COUNTRY_CODE + " TEXT, " + DEX_PRODUCT_TYPE + " TEXT, " + PACK_SIZE_QTY + " TEXT, " + NO_DNL_DATE + " TEXT"
                + ");";

        db.execSQL(sql);
    }

    public void reCreateBasepriceTable(SQLiteDatabase db) {
        String sql = "DROP TABLE IF EXISTS ";
        db.execSQL(sql + BASEPRICE_TABLE);

        sql = "CREATE TABLE "
                + BASEPRICE_TABLE + "(" + _ID_BASEPRICE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EFFECTIVE_DATE + " TEXT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, "
                + WHOLESALE_PRICE + " DOUBLE, "  + RETAIL_PRICE + " DOUBLE, "  + DISTRIBUTOR_PRICE + " DOUBLE, "
                + DISTRIBUTOR_SPREAD_PER + " DOUBLE, " + DISTRIBUTOR_PROMO_PART_IND + " TEXT "
                + ");";

        db.execSQL(sql);
    }

    public void reCreateInvenadjTable(SQLiteDatabase db) {
        String sql = "DROP TABLE IF EXISTS ";
        db.execSQL(sql + INVENADJ_TABLE);

        sql = "CREATE TABLE "
                + INVENADJ_TABLE + "(" + _ID_INVENADJ + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INVENADJ_ID + " long, " + RECORD_TYPE + " TEXT, " + ITEM_NO + " TEXT, "
                + STORE_DELIVERY_DATE + " TEXT, "  + TRANSACTION_DATE + " TEXT, "  + TRANSACTION_HOUR + " TEXT, " + TRANSACTION_MINUTE + " TEXT, "
                + DOCUMENT_NUMBER + " TEXT, "  + ADJUST_INVENTORY + " TEXT, "  + ADJUST_TYPE + " TEXT, " + THRIFT_STORE + " TEXT, "
                + ADJUST_QTY + " INTEGER, " + ROUTE_PRICE + " DOUBLE, " + UPLOAD_IND + " TEXT, " + PRODUCT_ID + " TEXT "
                + ");";

        db.execSQL(sql);
    }


}
