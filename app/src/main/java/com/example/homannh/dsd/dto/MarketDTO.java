package com.example.homannh.dsd.dto;

/**
 * Created by homannh on 2/23/2017.
 */

public class MarketDTO {
    long _ID_MARKET;
    String MARKET_ID;
    String MARKET_DESCRIPTION;

    public String toString (){
        return MARKET_ID + " " + MARKET_DESCRIPTION;
    }

    public long get_ID_MARKET() {
        return _ID_MARKET;
    }

    public void set_ID_MARKET(long _ID_MARKET) {
        this._ID_MARKET = _ID_MARKET;
    }

    public String getMARKET_ID() {
        return MARKET_ID;
    }

    public void setMARKET_ID(String MARKET_ID) {
        this.MARKET_ID = MARKET_ID;
    }

    public String getMARKET_DESCRIPTION() {
        return MARKET_DESCRIPTION;
    }

    public void setMARKET_DESCRIPTION(String MARKET_DESCRIPTION) {
        this.MARKET_DESCRIPTION = MARKET_DESCRIPTION;
    }
}
