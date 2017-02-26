package com.example.homannh.dsd.dto;

/**
 * Created by HOH on 2/24/2017.
 */

public class RouteDTO {
    long _ID_ROUTE;
    String MARKET_ID;
    String ROUTE_ID;
    String ROUTE_NAME;
    String ROUTE_TYPE;
    String DISPLAY_PRICE_IND;
    String DEX_SIGNATURE_CODE;
    String LOAD_SECURITY_CODE;
    String RETURN_SECURITY_CODE;
    String COMMUNICATION_SECURITY_CODE;
    String DNL_DATE;
    String INVOICE_MARKET_ID;
    String SLF_PLUS_IND;
    String STD_ORD_CONTROL_CODE;
    String OVERSELL_LOAD_IND;
    String DEPOT_NAME;
    String UNLOCK_STOPS_IND;
    String PRESET_ORDER_IND;
    String ORDER_CHANGE_CODE;
    String ROUTE_LEVEL_ORDER_IND;
    String SCREEN_SECURITY_CODE;
    String COMM_TIME;
    String DISABLE_ADD_CO_IND;
    String ADDITIONAL_CONTROLS_IND;
    String ZERO_DISTRIBUTION_IND;
    String DELAYED_CASH_IND;
    String DEF_RET_LOCATION;

    public String toString(){
        return ROUTE_ID + " " + ROUTE_NAME;
    }



    public long get_ID_ROUTE() {
        return _ID_ROUTE;
    }

    public void set_ID_ROUTE(long _ID_ROUTE) {
        this._ID_ROUTE = _ID_ROUTE;
    }

    public String getMARKET_ID() {
        return MARKET_ID;
    }

    public void setMARKET_ID(String MARKET_ID) {
        this.MARKET_ID = MARKET_ID;
    }

    public String getROUTE_ID() {
        return ROUTE_ID;
    }

    public void setROUTE_ID(String ROUTE_ID) {
        this.ROUTE_ID = ROUTE_ID;
    }

    public String getROUTE_NAME() {
        return ROUTE_NAME;
    }

    public void setROUTE_NAME(String ROUTE_NAME) {
        this.ROUTE_NAME = ROUTE_NAME;
    }

    public String getROUTE_TYPE() {
        return ROUTE_TYPE;
    }

    public void setROUTE_TYPE(String ROUTE_TYPE) {
        this.ROUTE_TYPE = ROUTE_TYPE;
    }

    public String getDISPLAY_PRICE_IND() {
        return DISPLAY_PRICE_IND;
    }

    public void setDISPLAY_PRICE_IND(String DISPLAY_PRICE_IND) {
        this.DISPLAY_PRICE_IND = DISPLAY_PRICE_IND;
    }

    public String getDEX_SIGNATURE_CODE() {
        return DEX_SIGNATURE_CODE;
    }

    public void setDEX_SIGNATURE_CODE(String DEX_SIGNATURE_CODE) {
        this.DEX_SIGNATURE_CODE = DEX_SIGNATURE_CODE;
    }

    public String getLOAD_SECURITY_CODE() {
        return LOAD_SECURITY_CODE;
    }

    public void setLOAD_SECURITY_CODE(String LOAD_SECURITY_CODE) {
        this.LOAD_SECURITY_CODE = LOAD_SECURITY_CODE;
    }

    public String getRETURN_SECURITY_CODE() {
        return RETURN_SECURITY_CODE;
    }

    public void setRETURN_SECURITY_CODE(String RETURN_SECURITY_CODE) {
        this.RETURN_SECURITY_CODE = RETURN_SECURITY_CODE;
    }

    public String getCOMMUNICATION_SECURITY_CODE() {
        return COMMUNICATION_SECURITY_CODE;
    }

    public void setCOMMUNICATION_SECURITY_CODE(String COMMUNICATION_SECURITY_CODE) {
        this.COMMUNICATION_SECURITY_CODE = COMMUNICATION_SECURITY_CODE;
    }

    public String getDNL_DATE() {
        return DNL_DATE;
    }

    public void setDNL_DATE(String DNL_DATE) {
        this.DNL_DATE = DNL_DATE;
    }

    public String getINVOICE_MARKET_ID() {
        return INVOICE_MARKET_ID;
    }

    public void setINVOICE_MARKET_ID(String INVOICE_MARKET_ID) {
        this.INVOICE_MARKET_ID = INVOICE_MARKET_ID;
    }

    public String getSLF_PLUS_IND() {
        return SLF_PLUS_IND;
    }

    public void setSLF_PLUS_IND(String SLF_PLUS_IND) {
        this.SLF_PLUS_IND = SLF_PLUS_IND;
    }

    public String getSTD_ORD_CONTROL_CODE() {
        return STD_ORD_CONTROL_CODE;
    }

    public void setSTD_ORD_CONTROL_CODE(String STD_ORD_CONTROL_CODE) {
        this.STD_ORD_CONTROL_CODE = STD_ORD_CONTROL_CODE;
    }

    public String getOVERSELL_LOAD_IND() {
        return OVERSELL_LOAD_IND;
    }

    public void setOVERSELL_LOAD_IND(String OVERSELL_LOAD_IND) {
        this.OVERSELL_LOAD_IND = OVERSELL_LOAD_IND;
    }

    public String getDEPOT_NAME() {
        return DEPOT_NAME;
    }

    public void setDEPOT_NAME(String DEPOT_NAME) {
        this.DEPOT_NAME = DEPOT_NAME;
    }

    public String getUNLOCK_STOPS_IND() {
        return UNLOCK_STOPS_IND;
    }

    public void setUNLOCK_STOPS_IND(String UNLOCK_STOPS_IND) {
        this.UNLOCK_STOPS_IND = UNLOCK_STOPS_IND;
    }

    public String getPRESET_ORDER_IND() {
        return PRESET_ORDER_IND;
    }

    public void setPRESET_ORDER_IND(String PRESET_ORDER_IND) {
        this.PRESET_ORDER_IND = PRESET_ORDER_IND;
    }

    public String getORDER_CHANGE_CODE() {
        return ORDER_CHANGE_CODE;
    }

    public void setORDER_CHANGE_CODE(String ORDER_CHANGE_CODE) {
        this.ORDER_CHANGE_CODE = ORDER_CHANGE_CODE;
    }

    public String getROUTE_LEVEL_ORDER_IND() {
        return ROUTE_LEVEL_ORDER_IND;
    }

    public void setROUTE_LEVEL_ORDER_IND(String ROUTE_LEVEL_ORDER_IND) {
        this.ROUTE_LEVEL_ORDER_IND = ROUTE_LEVEL_ORDER_IND;
    }

    public String getSCREEN_SECURITY_CODE() {
        return SCREEN_SECURITY_CODE;
    }

    public void setSCREEN_SECURITY_CODE(String SCREEN_SECURITY_CODE) {
        this.SCREEN_SECURITY_CODE = SCREEN_SECURITY_CODE;
    }

    public String getCOMM_TIME() {
        return COMM_TIME;
    }

    public void setCOMM_TIME(String COMM_TIME) {
        this.COMM_TIME = COMM_TIME;
    }

    public String getDISABLE_ADD_CO_IND() {
        return DISABLE_ADD_CO_IND;
    }

    public void setDISABLE_ADD_CO_IND(String DISABLE_ADD_CO_IND) {
        this.DISABLE_ADD_CO_IND = DISABLE_ADD_CO_IND;
    }

    public String getADDITIONAL_CONTROLS_IND() {
        return ADDITIONAL_CONTROLS_IND;
    }

    public void setADDITIONAL_CONTROLS_IND(String ADDITIONAL_CONTROLS_IND) {
        this.ADDITIONAL_CONTROLS_IND = ADDITIONAL_CONTROLS_IND;
    }

    public String getZERO_DISTRIBUTION_IND() {
        return ZERO_DISTRIBUTION_IND;
    }

    public void setZERO_DISTRIBUTION_IND(String ZERO_DISTRIBUTION_IND) {
        this.ZERO_DISTRIBUTION_IND = ZERO_DISTRIBUTION_IND;
    }

    public String getDELAYED_CASH_IND() {
        return DELAYED_CASH_IND;
    }

    public void setDELAYED_CASH_IND(String DELAYED_CASH_IND) {
        this.DELAYED_CASH_IND = DELAYED_CASH_IND;
    }

    public String getDEF_RET_LOCATION() {
        return DEF_RET_LOCATION;
    }

    public void setDEF_RET_LOCATION(String DEF_RET_LOCATION) {
        this.DEF_RET_LOCATION = DEF_RET_LOCATION;
    }
}
