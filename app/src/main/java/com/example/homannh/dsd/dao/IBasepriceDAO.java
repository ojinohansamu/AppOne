package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.BasepriceDTO;

import java.util.List;

/**
 * Created by HOH on 2/26/2017.
 */
public interface IBasepriceDAO {
    void insert (BasepriceDTO basepriceDTO) throws Exception;

    void IsBasepriceExist();

    int countBaseprice();

    List<BasepriceDTO> getBasepricesByItemNo(String itemNo);

    List<BasepriceDTO> getBasepricesByProductID(String productID);
}
