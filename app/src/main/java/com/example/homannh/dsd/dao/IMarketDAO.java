package com.example.homannh.dsd.dao;

import android.content.Context;

import com.example.homannh.dsd.dto.MarketDTO;

import java.util.List;

/**
 * Created by homannh on 2/23/2017.
 */

public interface IMarketDAO {
    void initMarket(Context context);

    void insert(MarketDTO marketDTO) throws Exception;

    void isMarketTable();

    int countsMarkets();

    List<MarketDTO> fetchMarkets(String searchTerm);

}
