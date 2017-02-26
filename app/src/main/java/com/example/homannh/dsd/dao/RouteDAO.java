package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homannh.dsd.dto.RouteDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOH on 2/24/2017.
 */

public class RouteDAO extends WinHHDAO implements IRouteDAO {
    public RouteDAO(Context context) {
        super(context);
    }

    @Override
    public void insert(RouteDTO routeDTO) throws Exception{

        ContentValues contentValues = new ContentValues();
        contentValues.put(MARKET_ID, routeDTO.getMARKET_ID());
        contentValues.put(ROUTE_ID, routeDTO.getROUTE_ID());
        contentValues.put(ROUTE_NAME, routeDTO.getROUTE_NAME());
        contentValues.put(ROUTE_TYPE, routeDTO.getROUTE_TYPE());
        contentValues.put(DISPLAY_PRICE_IND, routeDTO.getDISPLAY_PRICE_IND());
        contentValues.put(DEX_SIGNATURE_CODE, routeDTO.getDEX_SIGNATURE_CODE());
        contentValues.put(LOAD_SECURITY_CODE, routeDTO.getLOAD_SECURITY_CODE());
        contentValues.put(RETURN_SECURITY_CODE, routeDTO.getRETURN_SECURITY_CODE());
        contentValues.put(COMMUNICATION_SECURITY_CODE, routeDTO.getCOMMUNICATION_SECURITY_CODE());
        contentValues.put(DNL_DATE, routeDTO.getDNL_DATE());
        contentValues.put(INVOICE_MARKET_ID, routeDTO.getINVOICE_MARKET_ID());
        contentValues.put(SLF_PLUS_IND, routeDTO.getSLF_PLUS_IND());
        contentValues.put(STD_ORD_CONTROL_CODE, routeDTO.getSTD_ORD_CONTROL_CODE());
        contentValues.put(OVERSELL_LOAD_IND, routeDTO.getOVERSELL_LOAD_IND());
        contentValues.put(DEPOT_NAME, routeDTO.getDEPOT_NAME());
        contentValues.put(UNLOCK_STOPS_IND, routeDTO.getUNLOCK_STOPS_IND());
        contentValues.put(PRESET_ORDER_IND, routeDTO.getPRESET_ORDER_IND());
        contentValues.put(ORDER_CHANGE_CODE, routeDTO.getORDER_CHANGE_CODE());
        contentValues.put(ROUTE_LEVEL_ORDER_IND, routeDTO.getROUTE_LEVEL_ORDER_IND());
        contentValues.put(SCREEN_SECURITY_CODE, routeDTO.getSCREEN_SECURITY_CODE());
        contentValues.put(COMM_TIME, routeDTO.getCOMM_TIME());
        contentValues.put(DISABLE_ADD_CO_IND, routeDTO.getDISABLE_ADD_CO_IND());
        contentValues.put(ADDITIONAL_CONTROLS_IND, routeDTO.getADDITIONAL_CONTROLS_IND());
        contentValues.put(ZERO_DISTRIBUTION_IND, routeDTO.getZERO_DISTRIBUTION_IND());
        contentValues.put(DELAYED_CASH_IND, routeDTO.getDELAYED_CASH_IND());
        contentValues.put(DEF_RET_LOCATION, routeDTO.getDEF_RET_LOCATION());

        getWritableDatabase().insert(ROUTE_TABLE, ROUTE_ID, contentValues);

    }

    @Override
    public void IsRouteExist(){
        String sql = "CREATE TABLE IF NOT EXISTS " + ROUTE_TABLE + "(" + _ID_ROUTE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARKET_ID + " TEXT, " + ROUTE_ID + " TEXT, " + ROUTE_NAME + " TEXT, " + ROUTE_TYPE + " TEXT, "
                + DISPLAY_PRICE_IND + " TEXT, " + DEX_SIGNATURE_CODE + " TEXT, " + LOAD_SECURITY_CODE + " TEXT, " + RETURN_SECURITY_CODE + " TEXT, " + COMMUNICATION_SECURITY_CODE + " TEXT, "
                + DNL_DATE + " TEXT, " + INVOICE_MARKET_ID + " TEXT, " + SLF_PLUS_IND + " TEXT, " + STD_ORD_CONTROL_CODE + " TEXT, " + OVERSELL_LOAD_IND + " TEXT, "
                + DEPOT_NAME + " TEXT, " + UNLOCK_STOPS_IND + " TEXT, " + PRESET_ORDER_IND + " TEXT, " + ORDER_CHANGE_CODE + " TEXT, " + ROUTE_LEVEL_ORDER_IND + " TEXT, "
                + SCREEN_SECURITY_CODE + " TEXT, " + COMM_TIME + " TEXT, " + DISABLE_ADD_CO_IND + " TEXT, " + ADDITIONAL_CONTROLS_IND + " TEXT, " + ZERO_DISTRIBUTION_IND + " TEXT, "
                + DELAYED_CASH_IND + " TEXT, "+ DEF_RET_LOCATION + " TEXT"
                + ");";
        getWritableDatabase().rawQuery(sql, null);
    }

    @Override
    public int countRoute(){
        int noOfRow = 0;
        String sql = "SELECT COUNT (*) FROM " + ROUTE_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            noOfRow = cursor.getInt(0);
        }
        cursor.close();
        return noOfRow;
    }

    @Override
    public List<RouteDTO> fetchRoutes(String searchTerm){
        List<RouteDTO> allRoutes = new ArrayList<RouteDTO>();
        String sql = "SELECT * FROM " + ROUTE_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            RouteDTO routeDTO = new RouteDTO();
            routeDTO.setMARKET_ID(cursor.getString(cursor.getColumnIndex(MARKET_ID)));
            routeDTO.setROUTE_ID(cursor.getString(cursor.getColumnIndex(ROUTE_ID)));
            routeDTO.setROUTE_NAME(cursor.getString(cursor.getColumnIndex(ROUTE_NAME)));
            routeDTO.setROUTE_TYPE(cursor.getString(cursor.getColumnIndex(ROUTE_TYPE)));
            routeDTO.setDISPLAY_PRICE_IND(cursor.getString(cursor.getColumnIndex(DISPLAY_PRICE_IND)));
            routeDTO.setDEX_SIGNATURE_CODE(cursor.getString(cursor.getColumnIndex(DEX_SIGNATURE_CODE)));
            routeDTO.setLOAD_SECURITY_CODE(cursor.getString(cursor.getColumnIndex(LOAD_SECURITY_CODE)));
            routeDTO.setRETURN_SECURITY_CODE(cursor.getString(cursor.getColumnIndex(RETURN_SECURITY_CODE)));
            routeDTO.setCOMMUNICATION_SECURITY_CODE(cursor.getString(cursor.getColumnIndex(COMMUNICATION_SECURITY_CODE)));
            routeDTO.setDNL_DATE(cursor.getString(cursor.getColumnIndex(DNL_DATE)));
            routeDTO.setINVOICE_MARKET_ID(cursor.getString(cursor.getColumnIndex(INVOICE_MARKET_ID)));
            routeDTO.setSLF_PLUS_IND(cursor.getString(cursor.getColumnIndex(SLF_PLUS_IND)));
            routeDTO.setSTD_ORD_CONTROL_CODE(cursor.getString(cursor.getColumnIndex(STD_ORD_CONTROL_CODE)));
            routeDTO.setOVERSELL_LOAD_IND(cursor.getString(cursor.getColumnIndex(OVERSELL_LOAD_IND)));
            routeDTO.setDEPOT_NAME(cursor.getString(cursor.getColumnIndex(DEPOT_NAME)));
            routeDTO.setUNLOCK_STOPS_IND(cursor.getString(cursor.getColumnIndex(UNLOCK_STOPS_IND)));
            routeDTO.setPRESET_ORDER_IND(cursor.getString(cursor.getColumnIndex(PRESET_ORDER_IND)));
            routeDTO.setORDER_CHANGE_CODE(cursor.getString(cursor.getColumnIndex(ORDER_CHANGE_CODE)));
            routeDTO.setROUTE_LEVEL_ORDER_IND(cursor.getString(cursor.getColumnIndex(ROUTE_LEVEL_ORDER_IND)));
            routeDTO.setSCREEN_SECURITY_CODE(cursor.getString(cursor.getColumnIndex(SCREEN_SECURITY_CODE)));
            routeDTO.setCOMM_TIME(cursor.getString(cursor.getColumnIndex(COMM_TIME)));
            routeDTO.setDISABLE_ADD_CO_IND(cursor.getString(cursor.getColumnIndex(DISABLE_ADD_CO_IND)));
            routeDTO.setADDITIONAL_CONTROLS_IND(cursor.getString(cursor.getColumnIndex(ADDITIONAL_CONTROLS_IND)));
            routeDTO.setZERO_DISTRIBUTION_IND(cursor.getString(cursor.getColumnIndex(ZERO_DISTRIBUTION_IND)));
            routeDTO.setDELAYED_CASH_IND(cursor.getString(cursor.getColumnIndex(DELAYED_CASH_IND)));
            routeDTO.setDEF_RET_LOCATION(cursor.getString(cursor.getColumnIndex(DEF_RET_LOCATION)));

            allRoutes.add(routeDTO);
        }

        cursor.close();
        return allRoutes;
    }
}
