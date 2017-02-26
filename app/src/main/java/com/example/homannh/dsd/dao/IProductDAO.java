package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.ProductDTO;

import java.util.List;

/**
 * Created by HOH on 2/24/2017.
 */
public interface IProductDAO {
    void insert(ProductDTO productDTO) throws Exception;

    void IsPoductExist();

    int countProducts();

    List<ProductDTO> fetchProducts(String searchTerm);

    List<ProductDTO> getProductsByYourSQL(String yourSQL);

    List<ProductDTO> getProductsByUPC(String companyCode, String upcCode);
}
