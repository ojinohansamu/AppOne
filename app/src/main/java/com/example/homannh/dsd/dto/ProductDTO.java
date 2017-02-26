package com.example.homannh.dsd.dto;

/**
 * this class represents the attribute that describe a product
 * Created by HOH on 2/24/2017.
 */

public class ProductDTO {

    long _ID_PRODUCT;
    String PRODUCT_ID;
    String ITEM_NO;
    String COMPANY_CODE;
    String UPC_CODE;
    String SUB_UPC_CODE;
    String PRODUCT_GROUP_CODE;
    String PRODUCT_CAT_CODE;
    String FINANCIAL_CAT_CODE;
    String PRODUCT_DESC;
    int SHELF_LIFE_DAY_1;
    int SHELF_LIFE_DAY_2;
    int SHELF_LIFE_DAY_3;
    int SHELF_LIFE_DAY_4;
    int SHELF_LIFE_DAY_5;
    int SHELF_LIFE_DAY_6;
    int SHELF_LIFE_DAY_7;
    String FORECAST_TYPE;
    String RETURNS_ALLOWED_IND;
    String SPREAD_GROUP;
    String SALES_ALLOWED_IND;
    String FRESH_RETURNS_ALLOWED_IND;
    String DEX_COUNTRY_CODE;
    String DEX_PRODUCT_TYPE;
    String PACK_SIZE_QTY;
    String NO_DNL_DATE;

    public String toString() {
        return COMPANY_CODE + " " + UPC_CODE + " " + SUB_UPC_CODE + " " + PRODUCT_DESC;
    }

    public long get_ID_PRODUCT() {
        return _ID_PRODUCT;
    }

    public void set_ID_ROU_ID_PRODUCT(long _ID_PRODUCT) {
        this._ID_PRODUCT = _ID_PRODUCT;
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

    public String getCOMPANY_CODE() {
        return COMPANY_CODE;
    }

    public void setCOMPANY_CODE(String COMPANY_CODE) {
        this.COMPANY_CODE = COMPANY_CODE;
    }

    public String getUPC_CODE() {
        return UPC_CODE;
    }

    public void setUPC_CODE(String UPC_CODE) {
        this.UPC_CODE = UPC_CODE;
    }

    public String getSUB_UPC_CODE() {
        return SUB_UPC_CODE;
    }

    public void setSUB_UPC_CODE(String SUB_UPC_CODE) {
        this.SUB_UPC_CODE = SUB_UPC_CODE;
    }

    public String getPRODUCT_GROUP_CODE() {
        return PRODUCT_GROUP_CODE;
    }

    public void setPRODUCT_GROUP_CODE(String PRODUCT_GROUP_CODE) {
        this.PRODUCT_GROUP_CODE = PRODUCT_GROUP_CODE;
    }

    public String getPRODUCT_CAT_CODE() {
        return PRODUCT_CAT_CODE;
    }

    public void setPRODUCT_CAT_CODE(String PRODUCT_CAT_CODE) {
        this.PRODUCT_CAT_CODE = PRODUCT_CAT_CODE;
    }

    public String getFINANCIAL_CAT_CODE() {
        return FINANCIAL_CAT_CODE;
    }

    public void setFINANCIAL_CAT_CODE(String FINANCIAL_CAT_CODE) {
        this.FINANCIAL_CAT_CODE = FINANCIAL_CAT_CODE;
    }

    public String getPRODUCT_DESC() {
        return PRODUCT_DESC;
    }

    public void setPRODUCT_DESC(String PRODUCT_DESC) {
        this.PRODUCT_DESC = PRODUCT_DESC;
    }

    public int getSHELF_LIFE_DAY_1() {
        return SHELF_LIFE_DAY_1;
    }

    public void setSHELF_LIFE_DAY_1(int SHELF_LIFE_DAY_1) {
        this.SHELF_LIFE_DAY_1 = SHELF_LIFE_DAY_1;
    }

    public int getSHELF_LIFE_DAY_2() {
        return SHELF_LIFE_DAY_2;
    }

    public void setSHELF_LIFE_DAY_2(int SHELF_LIFE_DAY_2) {
        this.SHELF_LIFE_DAY_2 = SHELF_LIFE_DAY_2;
    }

    public int getSHELF_LIFE_DAY_3() {
        return SHELF_LIFE_DAY_3;
    }

    public void setSHELF_LIFE_DAY_3(int SHELF_LIFE_DAY_3) {
        this.SHELF_LIFE_DAY_3 = SHELF_LIFE_DAY_3;
    }

    public int getSHELF_LIFE_DAY_4() {
        return SHELF_LIFE_DAY_4;
    }

    public void setSHELF_LIFE_DAY_4(int SHELF_LIFE_DAY_4) {
        this.SHELF_LIFE_DAY_4 = SHELF_LIFE_DAY_4;
    }

    public int getSHELF_LIFE_DAY_5() {
        return SHELF_LIFE_DAY_5;
    }

    public void setSHELF_LIFE_DAY_5(int SHELF_LIFE_DAY_5) {
        this.SHELF_LIFE_DAY_5 = SHELF_LIFE_DAY_5;
    }

    public int getSHELF_LIFE_DAY_6() {
        return SHELF_LIFE_DAY_6;
    }

    public void setSHELF_LIFE_DAY_6(int SHELF_LIFE_DAY_6) {
        this.SHELF_LIFE_DAY_6 = SHELF_LIFE_DAY_6;
    }

    public int getSHELF_LIFE_DAY_7() {
        return SHELF_LIFE_DAY_7;
    }

    public void setSHELF_LIFE_DAY_7(int SHELF_LIFE_DAY_7) {
        this.SHELF_LIFE_DAY_7 = SHELF_LIFE_DAY_7;
    }

    public String getFORECAST_TYPE() {
        return FORECAST_TYPE;
    }

    public void setFORECAST_TYPE(String FORECAST_TYPE) {
        this.FORECAST_TYPE = FORECAST_TYPE;
    }

    public String getRETURNS_ALLOWED_IND() {
        return RETURNS_ALLOWED_IND;
    }

    public void setRETURNS_ALLOWED_IND(String RETURNS_ALLOWED_IND) {
        this.RETURNS_ALLOWED_IND = RETURNS_ALLOWED_IND;
    }

    public String getSPREAD_GROUP() {
        return SPREAD_GROUP;
    }

    public void setSPREAD_GROUP(String SPREAD_GROUP) {
        this.SPREAD_GROUP = SPREAD_GROUP;
    }

    public String getSALES_ALLOWED_IND() {
        return SALES_ALLOWED_IND;
    }

    public void setSALES_ALLOWED_IND(String SALES_ALLOWED_IND) {
        this.SALES_ALLOWED_IND = SALES_ALLOWED_IND;
    }

    public String getFRESH_RETURNS_ALLOWED_IND() {
        return FRESH_RETURNS_ALLOWED_IND;
    }

    public void setFRESH_RETURNS_ALLOWED_IND(String FRESH_RETURNS_ALLOWED_IND) {
        this.FRESH_RETURNS_ALLOWED_IND = FRESH_RETURNS_ALLOWED_IND;
    }

    public String getDEX_COUNTRY_CODE() {
        return DEX_COUNTRY_CODE;
    }

    public void setDEX_COUNTRY_CODE(String DEX_COUNTRY_CODE) {
        this.DEX_COUNTRY_CODE = DEX_COUNTRY_CODE;
    }

    public String getDEX_PRODUCT_TYPE() {
        return DEX_PRODUCT_TYPE;
    }

    public void setDEX_PRODUCT_TYPE(String DEX_PRODUCT_TYPE) {
        this.DEX_PRODUCT_TYPE = DEX_PRODUCT_TYPE;
    }

    public String getPACK_SIZE_QTY() {
        return PACK_SIZE_QTY;
    }

    public void setPACK_SIZE_QTY(String PACK_SIZE_QTY) {
        this.PACK_SIZE_QTY = PACK_SIZE_QTY;
    }

    public String getNO_DNL_DATE() {
        return NO_DNL_DATE;
    }

    public void setNO_DNL_DATE(String NO_DNL_DATE) {
        this.NO_DNL_DATE = NO_DNL_DATE;
    }
}