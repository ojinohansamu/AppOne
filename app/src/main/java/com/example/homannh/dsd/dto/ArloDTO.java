package com.example.homannh.dsd.dto;

import android.view.ViewDebug;

/**
 * Created by HOH on 2/20/2017.
 */

public class ArloDTO {

    long _ID;
    int GUID_CUSTOMER;
    String CUSTOMER_ID;
    String ARLO_NO;
    String STORE_NO;
    int STOP_NO;
    String ACCOUNT_NO;
    String START_DATE;
    String END_DATE;
    String TICKET_TYPE;
    String TICKET_TYPE_SEQ;
    int TICKET_COPIES_QTY;
    String CR_TERMS_CODE;
    String CR_STATUS_CODE;
    String PRODUCT_TYPE;
    String CUST_VENDOR;
    String LOCKBOX_ID;
    String DEPT_CONTACT;
    String DEPT_CODE;
    String PRICE_OV_IND;
    String TICKET_DISCOUNT_PER;
    String PROMO_IND;
    String AGE_DATED_RET_IND;
    String PROMPT_FROM_LOAD_IND;
    String FORECAST_IND;
    String DSD_REQ_IND;
    String SIGNATURE_REQUIRED_IND;
    String PRINT_DISCOUNT_IND;
    String PRINT_RETAIL_PRICE_IND;
    String STORE_STAMP_REQ_TICKET;
    String TICKET_FORMAT;
    String AUTH_LIST_ID;
    String LOCK_IND;
    String ROUTE_STORE_IND;
    String STD_ORDER_ALLOW_IND;
    String INVOICE_SORT_CODE;
    String CARRY_OVER_DAY;
    String AMDUTCH_IND;
    String ORDERS_ONLY_IND;
    String SUPPLIER_COMM_ID;
    String SUPPLIER_DUNS_NO;
    String SUPPLIER_LOCATION_NO;
    String RECEIVER_COMM_ID;
    String RECEIVER_DUNS_NO;
    String RECEIVER_LOCATION_NO;
    String DEX_VERSION;
    String GENERATE_G72_IND;
    String STORE_NAME;
    String STORE_ADDRESS_1;
    String STORE_ADDRESS_2;
    String STORE_ADDRESS_3;
    String STORE_CITY_NAME;
    String STORE_STATE_CODE;
    String STORE_ZIP_CODE;
    String STORE_PHONE_NO;
    String STORE_CONTACT;
    String STORE_REF_NO;
    double MAXIMUM_DUE_BILL;
    String STORE_CHANGE_IND;
    String ACCOUNT_TYPE;
    String DEPT_NAME;
    int SERVICED;
    String NAME_MODIFIED_IND;
    double BALANCE_AMT;
    String SELECTED_STOP;
    String TICKET_SURCHARGE_AMT;
    String DELIVERY_MESSAGE;
    String CALLBACK_PROMPT_IND;
    String CALLBACK_TODAY_CODE;
    String WEB_ORDER_IND;
    double SALES_TAX_RATE;

    public String toString(){
        //return Integer.toString(STOP_NO) + " " + ARLO_NO + " " + STORE_NAME + " " + STORE_ADDRESS_1;
        return CUSTOMER_ID + " " + ARLO_NO + " " + STORE_NAME + " " + STORE_ADDRESS_1;
    }

    public long get_ID() {
        return _ID;
    }

    public void set_ID(long _ID) {
        this._ID = _ID;
    }

    public int getGUID_CUSTOMER() {
        return GUID_CUSTOMER;
    }

    public void setGUID_CUSTOMER(int GUID_CUSTOMER) {
        this.GUID_CUSTOMER = GUID_CUSTOMER;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getARLO_NO() {
        return ARLO_NO;
    }

    public void setARLO_NO(String ARLO_NO) {
        this.ARLO_NO = ARLO_NO;
    }

    public String getSTORE_NO() {
        return STORE_NO;
    }

    public void setSTORE_NO(String STORE_NO) {
        this.STORE_NO = STORE_NO;
    }

    public int getSTOP_NO() {
        return STOP_NO;
    }

    public void setSTOP_NO(int STOP_NO) {
        this.STOP_NO = STOP_NO;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(String START_DATE) {
        this.START_DATE = START_DATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getTICKET_TYPE() {
        return TICKET_TYPE;
    }

    public void setTICKET_TYPE(String TICKET_TYPE) {
        this.TICKET_TYPE = TICKET_TYPE;
    }

    public String getTICKET_TYPE_SEQ() {
        return TICKET_TYPE_SEQ;
    }

    public void setTICKET_TYPE_SEQ(String TICKET_TYPE_SEQ) {
        this.TICKET_TYPE_SEQ = TICKET_TYPE_SEQ;
    }

    public int getTICKET_COPIES_QTY() {
        return TICKET_COPIES_QTY;
    }

    public void setTICKET_COPIES_QTY(int TICKET_COPIES_QTY) {
        this.TICKET_COPIES_QTY = TICKET_COPIES_QTY;
    }

    public String getCR_TERMS_CODE() {
        return CR_TERMS_CODE;
    }

    public void setCR_TERMS_CODE(String CR_TERMS_CODE) {
        this.CR_TERMS_CODE = CR_TERMS_CODE;
    }

    public String getCR_STATUS_CODE() {
        return CR_STATUS_CODE;
    }

    public void setCR_STATUS_CODE(String CR_STATUS_CODE) {
        this.CR_STATUS_CODE = CR_STATUS_CODE;
    }

    public String getPRODUCT_TYPE() {
        return PRODUCT_TYPE;
    }

    public void setPRODUCT_TYPE(String PRODUCT_TYPE) {
        this.PRODUCT_TYPE = PRODUCT_TYPE;
    }

    public String getCUST_VENDOR() {
        return CUST_VENDOR;
    }

    public void setCUST_VENDOR(String CUST_VENDOR) {
        this.CUST_VENDOR = CUST_VENDOR;
    }

    public String getLOCKBOX_ID() {
        return LOCKBOX_ID;
    }

    public void setLOCKBOX_ID(String LOCKBOX_ID) {
        this.LOCKBOX_ID = LOCKBOX_ID;
    }

    public String getDEPT_CONTACT() {
        return DEPT_CONTACT;
    }

    public void setDEPT_CONTACT(String DEPT_CONTACT) {
        this.DEPT_CONTACT = DEPT_CONTACT;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getPRICE_OV_IND() {
        return PRICE_OV_IND;
    }

    public void setPRICE_OV_IND(String PRICE_OV_IND) {
        this.PRICE_OV_IND = PRICE_OV_IND;
    }

    public String getTICKET_DISCOUNT_PER() {
        return TICKET_DISCOUNT_PER;
    }

    public void setTICKET_DISCOUNT_PER(String TICKET_DISCOUNT_PER) {
        this.TICKET_DISCOUNT_PER = TICKET_DISCOUNT_PER;
    }

    public String getPROMO_IND() {
        return PROMO_IND;
    }

    public void setPROMO_IND(String PROMO_IND) {
        this.PROMO_IND = PROMO_IND;
    }

    public String getAGE_DATED_RET_IND() {
        return AGE_DATED_RET_IND;
    }

    public void setAGE_DATED_RET_IND(String AGE_DATED_RET_IND) {
        this.AGE_DATED_RET_IND = AGE_DATED_RET_IND;
    }

    public String getPROMPT_FROM_LOAD_IND() {
        return PROMPT_FROM_LOAD_IND;
    }

    public void setPROMPT_FROM_LOAD_IND(String PROMPT_FROM_LOAD_IND) {
        this.PROMPT_FROM_LOAD_IND = PROMPT_FROM_LOAD_IND;
    }

    public String getFORECAST_IND() {
        return FORECAST_IND;
    }

    public void setFORECAST_IND(String FORECAST_IND) {
        this.FORECAST_IND = FORECAST_IND;
    }

    public String getDSD_REQ_IND() {
        return DSD_REQ_IND;
    }

    public void setDSD_REQ_IND(String DSD_REQ_IND) {
        this.DSD_REQ_IND = DSD_REQ_IND;
    }

    public String getSIGNATURE_REQUIRED_IND() {
        return SIGNATURE_REQUIRED_IND;
    }

    public void setSIGNATURE_REQUIRED_IND(String SIGNATURE_REQUIRED_IND) {
        this.SIGNATURE_REQUIRED_IND = SIGNATURE_REQUIRED_IND;
    }

    public String getPRINT_DISCOUNT_IND() {
        return PRINT_DISCOUNT_IND;
    }

    public void setPRINT_DISCOUNT_IND(String PRINT_DISCOUNT_IND) {
        this.PRINT_DISCOUNT_IND = PRINT_DISCOUNT_IND;
    }

    public String getPRINT_RETAIL_PRICE_IND() {
        return PRINT_RETAIL_PRICE_IND;
    }

    public void setPRINT_RETAIL_PRICE_IND(String PRINT_RETAIL_PRICE_IND) {
        this.PRINT_RETAIL_PRICE_IND = PRINT_RETAIL_PRICE_IND;
    }

    public String getSTORE_STAMP_REQ_TICKET() {
        return STORE_STAMP_REQ_TICKET;
    }

    public void setSTORE_STAMP_REQ_TICKET(String STORE_STAMP_REQ_TICKET) {
        this.STORE_STAMP_REQ_TICKET = STORE_STAMP_REQ_TICKET;
    }

    public String getTICKET_FORMAT() {
        return TICKET_FORMAT;
    }

    public void setTICKET_FORMAT(String TICKET_FORMAT) {
        this.TICKET_FORMAT = TICKET_FORMAT;
    }

    public String getAUTH_LIST_ID() {
        return AUTH_LIST_ID;
    }

    public void setAUTH_LIST_ID(String AUTH_LIST_ID) {
        this.AUTH_LIST_ID = AUTH_LIST_ID;
    }

    public String getLOCK_IND() {
        return LOCK_IND;
    }

    public void setLOCK_IND(String LOCK_IND) {
        this.LOCK_IND = LOCK_IND;
    }

    public String getROUTE_STORE_IND() {
        return ROUTE_STORE_IND;
    }

    public void setROUTE_STORE_IND(String ROUTE_STORE_IND) {
        this.ROUTE_STORE_IND = ROUTE_STORE_IND;
    }

    public String getSTD_ORDER_ALLOW_IND() {
        return STD_ORDER_ALLOW_IND;
    }

    public void setSTD_ORDER_ALLOW_IND(String STD_ORDER_ALLOW_IND) {
        this.STD_ORDER_ALLOW_IND = STD_ORDER_ALLOW_IND;
    }

    public String getINVOICE_SORT_CODE() {
        return INVOICE_SORT_CODE;
    }

    public void setINVOICE_SORT_CODE(String INVOICE_SORT_CODE) {
        this.INVOICE_SORT_CODE = INVOICE_SORT_CODE;
    }

    public String getCARRY_OVER_DAY() {
        return CARRY_OVER_DAY;
    }

    public void setCARRY_OVER_DAY(String CARRY_OVER_DAY) {
        this.CARRY_OVER_DAY = CARRY_OVER_DAY;
    }

    public String getAMDUTCH_IND() {
        return AMDUTCH_IND;
    }

    public void setAMDUTCH_IND(String AMDUTCH_IND) {
        this.AMDUTCH_IND = AMDUTCH_IND;
    }

    public String getORDERS_ONLY_IND() {
        return ORDERS_ONLY_IND;
    }

    public void setORDERS_ONLY_IND(String ORDERS_ONLY_IND) {
        this.ORDERS_ONLY_IND = ORDERS_ONLY_IND;
    }

    public String getSUPPLIER_COMM_ID() {
        return SUPPLIER_COMM_ID;
    }

    public void setSUPPLIER_COMM_ID(String SUPPLIER_COMM_ID) {
        this.SUPPLIER_COMM_ID = SUPPLIER_COMM_ID;
    }

    public String getSUPPLIER_DUNS_NO() {
        return SUPPLIER_DUNS_NO;
    }

    public void setSUPPLIER_DUNS_NO(String SUPPLIER_DUNS_NO) {
        this.SUPPLIER_DUNS_NO = SUPPLIER_DUNS_NO;
    }

    public String getSUPPLIER_LOCATION_NO() {
        return SUPPLIER_LOCATION_NO;
    }

    public void setSUPPLIER_LOCATION_NO(String SUPPLIER_LOCATION_NO) {
        this.SUPPLIER_LOCATION_NO = SUPPLIER_LOCATION_NO;
    }

    public String getRECEIVER_COMM_ID() {
        return RECEIVER_COMM_ID;
    }

    public void setRECEIVER_COMM_ID(String RECEIVER_COMM_ID) {
        this.RECEIVER_COMM_ID = RECEIVER_COMM_ID;
    }

    public String getRECEIVER_DUNS_NO() {
        return RECEIVER_DUNS_NO;
    }

    public void setRECEIVER_DUNS_NO(String RECEIVER_DUNS_NO) {
        this.RECEIVER_DUNS_NO = RECEIVER_DUNS_NO;
    }

    public String getRECEIVER_LOCATION_NO() {
        return RECEIVER_LOCATION_NO;
    }

    public void setRECEIVER_LOCATION_NO(String RECEIVER_LOCATION_NO) {
        this.RECEIVER_LOCATION_NO = RECEIVER_LOCATION_NO;
    }

    public String getDEX_VERSION() {
        return DEX_VERSION;
    }

    public void setDEX_VERSION(String DEX_VERSION) {
        this.DEX_VERSION = DEX_VERSION;
    }

    public String getGENERATE_G72_IND() {
        return GENERATE_G72_IND;
    }

    public void setGENERATE_G72_IND(String GENERATE_G72_IND) {
        this.GENERATE_G72_IND = GENERATE_G72_IND;
    }

    public String getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }

    public String getSTORE_ADDRESS_1() {
        return STORE_ADDRESS_1;
    }

    public void setSTORE_ADDRESS_1(String STORE_ADDRESS_1) {
        this.STORE_ADDRESS_1 = STORE_ADDRESS_1;
    }

    public String getSTORE_ADDRESS_2() {
        return STORE_ADDRESS_2;
    }

    public void setSTORE_ADDRESS_2(String STORE_ADDRESS_2) {
        this.STORE_ADDRESS_2 = STORE_ADDRESS_2;
    }

    public String getSTORE_ADDRESS_3() {
        return STORE_ADDRESS_3;
    }

    public void setSTORE_ADDRESS_3(String STORE_ADDRESS_3) {
        this.STORE_ADDRESS_3 = STORE_ADDRESS_3;
    }

    public String getSTORE_CITY_NAME() {
        return STORE_CITY_NAME;
    }

    public void setSTORE_CITY_NAME(String STORE_CITY_NAME) {
        this.STORE_CITY_NAME = STORE_CITY_NAME;
    }

    public String getSTORE_STATE_CODE() {
        return STORE_STATE_CODE;
    }

    public void setSTORE_STATE_CODE(String STORE_STATE_CODE) {
        this.STORE_STATE_CODE = STORE_STATE_CODE;
    }

    public String getSTORE_ZIP_CODE() {
        return STORE_ZIP_CODE;
    }

    public void setSTORE_ZIP_CODE(String STORE_ZIP_CODE) {
        this.STORE_ZIP_CODE = STORE_ZIP_CODE;
    }

    public String getSTORE_PHONE_NO() {
        return STORE_PHONE_NO;
    }

    public void setSTORE_PHONE_NO(String STORE_PHONE_NO) {
        this.STORE_PHONE_NO = STORE_PHONE_NO;
    }

    public String getSTORE_CONTACT() {
        return STORE_CONTACT;
    }

    public void setSTORE_CONTACT(String STORE_CONTACT) {
        this.STORE_CONTACT = STORE_CONTACT;
    }

    public String getSTORE_REF_NO() {
        return STORE_REF_NO;
    }

    public void setSTORE_REF_NO(String STORE_REF_NO) {
        this.STORE_REF_NO = STORE_REF_NO;
    }

    public double getMAXIMUM_DUE_BILL() {
        return MAXIMUM_DUE_BILL;
    }

    public void setMAXIMUM_DUE_BILL(double MAXIMUM_DUE_BILL) {
        this.MAXIMUM_DUE_BILL = MAXIMUM_DUE_BILL;
    }

    public String getSTORE_CHANGE_IND() {
        return STORE_CHANGE_IND;
    }

    public void setSTORE_CHANGE_IND(String STORE_CHANGE_IND) {
        this.STORE_CHANGE_IND = STORE_CHANGE_IND;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public int getSERVICED() {
        return SERVICED;
    }

    public void setSERVICED(int SERVICED) {
        this.SERVICED = SERVICED;
    }

    public String getNAME_MODIFIED_IND() {
        return NAME_MODIFIED_IND;
    }

    public void setNAME_MODIFIED_IND(String NAME_MODIFIED_IND) {
        this.NAME_MODIFIED_IND = NAME_MODIFIED_IND;
    }

    public double getBALANCE_AMT() {
        return BALANCE_AMT;
    }

    public void setBALANCE_AMT(double BALANCE_AMT) {
        this.BALANCE_AMT = BALANCE_AMT;
    }

    public String getSELECTED_STOP() {
        return SELECTED_STOP;
    }

    public void setSELECTED_STOP(String SELECTED_STOP) {
        this.SELECTED_STOP = SELECTED_STOP;
    }

    public String getTICKET_SURCHARGE_AMT() {
        return TICKET_SURCHARGE_AMT;
    }

    public void setTICKET_SURCHARGE_AMT(String TICKET_SURCHARGE_AMT) {
        this.TICKET_SURCHARGE_AMT = TICKET_SURCHARGE_AMT;
    }

    public String getDELIVERY_MESSAGE() {
        return DELIVERY_MESSAGE;
    }

    public void setDELIVERY_MESSAGE(String DELIVERY_MESSAGE) {
        this.DELIVERY_MESSAGE = DELIVERY_MESSAGE;
    }

    public String getCALLBACK_PROMPT_IND() {
        return CALLBACK_PROMPT_IND;
    }

    public void setCALLBACK_PROMPT_IND(String CALLBACK_PROMPT_IND) {
        this.CALLBACK_PROMPT_IND = CALLBACK_PROMPT_IND;
    }

    public String getCALLBACK_TODAY_CODE() {
        return CALLBACK_TODAY_CODE;
    }

    public void setCALLBACK_TODAY_CODE(String CALLBACK_TODAY_CODE) {
        this.CALLBACK_TODAY_CODE = CALLBACK_TODAY_CODE;
    }

    public String getWEB_ORDER_IND() {
        return WEB_ORDER_IND;
    }

    public void setWEB_ORDER_IND(String WEB_ORDER_IND) {
        this.WEB_ORDER_IND = WEB_ORDER_IND;
    }

    public double getSALES_TAX_RATE() {
        return SALES_TAX_RATE;
    }

    public void setSALES_TAX_RATE(double SALES_TAX_RATE) {
        this.SALES_TAX_RATE = SALES_TAX_RATE;
    }
}
