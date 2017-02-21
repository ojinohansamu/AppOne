package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.ArloDTO;

import java.util.Set;

/**
 * Created by homannh on 2/21/2017.
 */
public interface IOfflineArloDAO extends IArloDAO {
    void insert(ArloDTO arlo);

    int countArlos();

    Set<Integer> fetchAllArloGuids();
}
