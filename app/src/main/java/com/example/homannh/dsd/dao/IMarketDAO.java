package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.MarketDTO;

/**
 * Created by homannh on 2/23/2017.
 */

public interface IMarketDAO {

    public void save(MarketDTO marketDTO) throws Exception;
    public void IsMarketExist();
    public int countsMarkets();

}
