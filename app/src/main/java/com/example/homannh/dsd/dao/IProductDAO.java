package com.example.homannh.dsd.dao;

import android.content.Context;

import com.example.homannh.dsd.dto.ProductDTO;

import java.util.List;

/**
 * Created by HOH on 2/24/2017.
 */
public interface IProductDAO {
    void initProduct(Context context);

    void insert(ProductDTO productDTO) throws Exception;

    void isProductTable();

    int countProducts();

    List<ProductDTO> fetchProducts(String searchTerm);

    List<ProductDTO> getProductsByYourSQL(String yourSQL);

    List<ProductDTO> getProductsByUPC(String companyCode, String upcCode);

    List<ProductDTO> getProductsByItemNo(String itemNo);
}
