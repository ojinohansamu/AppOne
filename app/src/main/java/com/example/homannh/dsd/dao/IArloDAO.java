package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.ArloDTO;

import java.util.List;

/**
 * Created by HOH on 2/20/2017.
 */
public interface IArloDAO {
    List<ArloDTO> fetchArlos(String searchTerm);
}