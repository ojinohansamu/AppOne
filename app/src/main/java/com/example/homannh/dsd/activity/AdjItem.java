package com.example.homannh.dsd.activity;

import com.example.homannh.dsd.dto.ProductDTO;

import java.io.Serializable;

/**
 * Created by HOH on 3/3/2017.
 */

public class AdjItem implements Serializable{

    private static final long serialVersionUID = 1L;

    private String COMPANY_CODE;
    private String UPC_CODE;
    private String SUB_UPC_CODE;
    private String ITEM_NO;
    private String PRODUCT_DESC;
    private int ADJUST_QTY;

    @Override
    public String toString() {
        return "AdjItem{" +
                "COMPANY_CODE='" + COMPANY_CODE + '\'' +
                ", UPC_CODE='" + UPC_CODE + '\'' +
                ", SUB_UPC_CODE='" + SUB_UPC_CODE + '\'' +
                ", ITEM_NO='" + ITEM_NO + '\'' +
                ", PRODUCT_DESC='" + PRODUCT_DESC + '\'' +
                ", ADJUST_QTY=" + ADJUST_QTY +
                '}';
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

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public String getPRODUCT_DESC() {
        return PRODUCT_DESC;
    }

    public void setPRODUCT_DESC(String PRODUCT_DESC) {
        this.PRODUCT_DESC = PRODUCT_DESC;
    }

    public int getADJUST_QTY() {
        return ADJUST_QTY;
    }

    public void setADJUST_QTY(int ADJUST_QTY) {
        this.ADJUST_QTY = ADJUST_QTY;
    }
}
