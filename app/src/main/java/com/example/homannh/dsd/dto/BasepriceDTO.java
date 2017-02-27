package com.example.homannh.dsd.dto;

/**
 * Created by HOH on 2/26/2017.
 */

public class BasepriceDTO {

    long _ID_BASEPRICE;
    String EFFECTIVE_DATE;
    String PRODUCT_ID;
    String ITEM_NO;
    double WHOLESALE_PRICE;
    double RETAIL_PRICE;
    double DISTRIBUTOR_PRICE;
    double DISTRIBUTOR_SPREAD_PER;
    String DISTRIBUTOR_PROMO_PART_IND;

    public  String toString(){
        return PRODUCT_ID + " " + ITEM_NO + " " + WHOLESALE_PRICE + " " + RETAIL_PRICE + " " + DISTRIBUTOR_PRICE + " " + EFFECTIVE_DATE;
    }

    public long get_ID_BASEPRICE() {
        return _ID_BASEPRICE;
    }

    public void set_ID_BASEPRICE(long _ID_BASEPRICE) {
        this._ID_BASEPRICE = _ID_BASEPRICE;
    }

    public String getEFFECTIVE_DATE() {
        return EFFECTIVE_DATE;
    }

    public void setEFFECTIVE_DATE(String EFFECTIVE_DATE) {
        this.EFFECTIVE_DATE = EFFECTIVE_DATE;
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

    public double getWHOLESALE_PRICE() {
        return WHOLESALE_PRICE;
    }

    public void setWHOLESALE_PRICE(double WHOLESALE_PRICE) {
        this.WHOLESALE_PRICE = WHOLESALE_PRICE;
    }

    public double getRETAIL_PRICE() {
        return RETAIL_PRICE;
    }

    public void setRETAIL_PRICE(double RETAIL_PRICE) {
        this.RETAIL_PRICE = RETAIL_PRICE;
    }

    public double getDISTRIBUTOR_PRICE() {
        return DISTRIBUTOR_PRICE;
    }

    public void setDISTRIBUTOR_PRICE(double DISTRIBUTOR_PRICE) {
        this.DISTRIBUTOR_PRICE = DISTRIBUTOR_PRICE;
    }

    public double getDISTRIBUTOR_SPREAD_PER() {
        return DISTRIBUTOR_SPREAD_PER;
    }

    public void setDISTRIBUTOR_SPREAD_PER(double DISTRIBUTOR_SPREAD_PER) {
        this.DISTRIBUTOR_SPREAD_PER = DISTRIBUTOR_SPREAD_PER;
    }

    public String getDISTRIBUTOR_PROMO_PART_IND() {
        return DISTRIBUTOR_PROMO_PART_IND;
    }

    public void setDISTRIBUTOR_PROMO_PART_IND(String DISTRIBUTOR_PROMO_PART_IND) {
        this.DISTRIBUTOR_PROMO_PART_IND = DISTRIBUTOR_PROMO_PART_IND;
    }
}
