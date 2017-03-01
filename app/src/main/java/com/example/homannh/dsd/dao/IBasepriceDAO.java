package com.example.homannh.dsd.dao;

import android.content.Context;

import com.example.homannh.dsd.dto.BasepriceDTO;

import java.util.List;

/**
 * Created by HOH on 2/26/2017.
 */
public interface IBasepriceDAO {
    void initBaseprice(Context context);

    void insert (BasepriceDTO basepriceDTO) throws Exception;

    void isBasepriceTable();

    int countBaseprice();

    List<BasepriceDTO> getBasepricesByItemNo(String itemNo);

    List<BasepriceDTO> getBasepricesByProductID(String productID);
}
