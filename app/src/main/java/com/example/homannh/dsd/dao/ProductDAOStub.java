package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOH on 2/20/2017.
 */

public class ProductDAOStub {
    public List<ProductDTO> fetchProducts(String searchTerm)
    {
        List<ProductDTO> allProducts = new ArrayList<ProductDTO>();

        //This class is to create dummy product as a test;
        // for now how about we loop to the raw data that I have from our production database;


        return allProducts;
    }
}
