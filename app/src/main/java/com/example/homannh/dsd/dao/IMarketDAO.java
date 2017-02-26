package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.MarketDTO;

import java.util.List;

/**
 * Created by homannh on 2/23/2017.
 */

public interface IMarketDAO {

    public void insert(MarketDTO marketDTO) throws Exception;
    public void IsMarketExist();
    public int countsMarkets();
    public List<MarketDTO> fetchMarkets(String searchTerm);

}
