package com.example.homannh.dsd.dao;

import com.example.homannh.dsd.dto.RouteDTO;

import java.util.List;

/**
 * Created by HOH on 2/24/2017.
 */
public interface IRouteDAO {
    void insert(RouteDTO routeDTO) throws Exception;

    void IsRouteExist();

    int countRoute();

    List<RouteDTO> fetchRoutes(String searchTerm);
}
