package com.example.homannh.dsd.dto;

/**
 * Created by HOH on 2/26/2017.
 */

public class InvenadjDTO {

    long _ID_INVENADJ;
    long INVENADJ_ID;
    String RECORD_TYPE;
    String ITEM_NO;
    String STORE_DELIVERY_DATE;
    String TRANSACTION_DATE;
    String TRANSACTION_HOUR;
    String TRANSACTION_MINUTE;
    String DOCUMENT_NUMBER;
    String ADJUST_INVENTORY;
    String ADJUST_TYPE;
    String THRIFT_STORE;
    int ADJUST_QTY;
    double ROUTE_PRICE;
    String UPLOAD_IND;
    String PRODUCT_ID;

    public  String toString(){
        return INVENADJ_ID + " " + RECORD_TYPE + " " + PRODUCT_ID + " " + ITEM_NO + " " + ADJUST_QTY;
    }


    public long get_ID_INVENADJ() {
        return _ID_INVENADJ;
    }

    public void set_ID_INVENADJ(long _ID_INVENADJ) {
        this._ID_INVENADJ = _ID_INVENADJ;
    }

    public long getINVENADJ_ID() {
        return INVENADJ_ID;
    }

    public void setINVENADJ_ID(long INVENADJ_ID) {
        this.INVENADJ_ID = INVENADJ_ID;
    }

    public String getRECORD_TYPE() {
        return RECORD_TYPE;
    }

    public void setRECORD_TYPE(String RECORD_TYPE) {
        this.RECORD_TYPE = RECORD_TYPE;
    }

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public String getSTORE_DELIVERY_DATE() {
        return STORE_DELIVERY_DATE;
    }

    public void setSTORE_DELIVERY_DATE(String STORE_DELIVERY_DATE) {
        this.STORE_DELIVERY_DATE = STORE_DELIVERY_DATE;
    }

    public String getTRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }

    public void setTRANSACTION_DATE(String TRANSACTION_DATE) {
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }

    public String getTRANSACTION_HOUR() {
        return TRANSACTION_HOUR;
    }

    public void setTRANSACTION_HOUR(String TRANSACTION_HOUR) {
        this.TRANSACTION_HOUR = TRANSACTION_HOUR;
    }

    public String getTRANSACTION_MINUTE() {
        return TRANSACTION_MINUTE;
    }

    public void setTRANSACTION_MINUTE(String TRANSACTION_MINUTE) {
        this.TRANSACTION_MINUTE = TRANSACTION_MINUTE;
    }

    public String getDOCUMENT_NUMBER() {
        return DOCUMENT_NUMBER;
    }

    public void setDOCUMENT_NUMBER(String DOCUMENT_NUMBER) {
        this.DOCUMENT_NUMBER = DOCUMENT_NUMBER;
    }

    public String getADJUST_INVENTORY() {
        return ADJUST_INVENTORY;
    }

    public void setADJUST_INVENTORY(String ADJUST_INVENTORY) {
        this.ADJUST_INVENTORY = ADJUST_INVENTORY;
    }

    public String getADJUST_TYPE() {
        return ADJUST_TYPE;
    }

    public void setADJUST_TYPE(String ADJUST_TYPE) {
        this.ADJUST_TYPE = ADJUST_TYPE;
    }

    public String getTHRIFT_STORE() {
        return THRIFT_STORE;
    }

    public void setTHRIFT_STORE(String THRIFT_STORE) {
        this.THRIFT_STORE = THRIFT_STORE;
    }

    public int getADJUST_QTY() {
        return ADJUST_QTY;
    }

    public void setADJUST_QTY(int ADJUST_QTY) {
        this.ADJUST_QTY = ADJUST_QTY;
    }

    public double getROUTE_PRICE() {
        return ROUTE_PRICE;
    }

    public void setROUTE_PRICE(double ROUTE_PRICE) {
        this.ROUTE_PRICE = ROUTE_PRICE;
    }

    public String getUPLOAD_IND() {
        return UPLOAD_IND;
    }

    public void setUPLOAD_IND(String UPLOAD_IND) {
        this.UPLOAD_IND = UPLOAD_IND;
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }
}
