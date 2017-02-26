package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.ArloDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by HOH on 2/20/2017.
 */
public interface IArloDAO {
    List<ArloDTO> fetchArlos(String searchTerm);
    List<ArloDTO> getArlosBySQL(String yourSQL);
    void insert(ArloDTO arlo);
    void IsArloExist();
    int countArlos();
    Set<Integer> fetchAllArloGuids();

}
