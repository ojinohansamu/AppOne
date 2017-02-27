package com.example.homannh.dsd.dto;

/**
 * Created by HOH on 2/26/2017.
 */

public class ZoneprcDTO {

    long _ID_ZONEPRC;
    String PRICE_ZONE;
    String PRODUCT_ID;
    String ITEM_NO;
    String PRICE_EXCEPTION_CODE;
    double WHOLESALE_PRICE;

    public  String toString(){
        return PRICE_ZONE + " " + PRODUCT_ID + " " + ITEM_NO + " " + WHOLESALE_PRICE;
    }

    public long get_ID_ZONEPRC() {
        return _ID_ZONEPRC;
    }

    public void set_ID_ZONEPRC(long _ID_ZONEPRC) {
        this._ID_ZONEPRC = _ID_ZONEPRC;
    }

    public String getPRICE_ZONE() {
        return PRICE_ZONE;
    }

    public void setPRICE_ZONE(String PRICE_ZONE) {
        this.PRICE_ZONE = PRICE_ZONE;
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public String getPRICE_EXCEPTION_CODE() {
        return PRICE_EXCEPTION_CODE;
    }

    public void setPRICE_EXCEPTION_CODE(String PRICE_EXCEPTION_CODE) {
        this.PRICE_EXCEPTION_CODE = PRICE_EXCEPTION_CODE;
    }

    public double getWHOLESALE_PRICE() {
        return WHOLESALE_PRICE;
    }

    public void setWHOLESALE_PRICE(double WHOLESALE_PRICE) {
        this.WHOLESALE_PRICE = WHOLESALE_PRICE;
    }
}
