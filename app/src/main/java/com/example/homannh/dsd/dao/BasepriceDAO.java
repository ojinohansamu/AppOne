package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;

import com.example.homannh.dsd.dto.BasepriceDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOH on 2/26/2017.
 */

public class BasepriceDAO extends WinHHDAO implements IBasepriceDAO {
    public BasepriceDAO(Context context) {
        super(context);
    }

    @Override
    public void initBaseprice(Context context) {
        super.reCreateBasepriceTable();
    }

    @Override
    public void insert(BasepriceDTO basepriceDTO) throws Exception{
        ContentValues cv = new ContentValues();

        cv.put(EFFECTIVE_DATE, basepriceDTO.getEFFECTIVE_DATE());
        cv.put(PRODUCT_ID, basepriceDTO.getPRODUCT_ID());
        cv.put(ITEM_NO, basepriceDTO.getITEM_NO());
        cv.put(WHOLESALE_PRICE, basepriceDTO.getWHOLESALE_PRICE());
        cv.put(RETAIL_PRICE, basepriceDTO.getRETAIL_PRICE());
        cv.put(DISTRIBUTOR_PRICE, basepriceDTO.getDISTRIBUTOR_PRICE());
        cv.put(DISTRIBUTOR_SPREAD_PER, basepriceDTO.getDISTRIBUTOR_SPREAD_PER());
        cv.put(DISTRIBUTOR_PROMO_PART_IND, basepriceDTO.getDISTRIBUTOR_PROMO_PART_IND());
        getWritableDatabase().insert(BASEPRICE_TABLE, PRODUCT_ID, cv);

    }

    @Override
    public void isBasepriceTable(){

        String sql = "CREATE TABLE IF NOT EXISTS "
                + BASEPRICE_TABLE + "(" + _ID_BASEPRICE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EFFECTIVE_DATE + " TEXT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, "
                + WHOLESALE_PRICE + " DOUBLE, "  + RETAIL_PRICE + " DOUBLE, "  + DISTRIBUTOR_PRICE + " DOUBLE, "
                + DISTRIBUTOR_SPREAD_PER + " DOUBLE, " + DISTRIBUTOR_PROMO_PART_IND + " TEXT "
                + ");";

        getWritableDatabase().rawQuery(sql, null);
    }

    @Override
    public int countBaseprice(){
        int noOfRow = 0;
        String sql = "SELECT COUNT (*) FROM " + BASEPRICE_TABLE;
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
    public List<BasepriceDTO> getBasepricesByItemNo(String itemNo){
        List<BasepriceDTO> someBaseprices = new ArrayList<BasepriceDTO>();

        String sql = "SELECT * FROM " + BASEPRICE_TABLE + " WHERE " + ITEM_NO + " = '" + itemNo + "'";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                BasepriceDTO basepriceDTO = new BasepriceDTO();
                basepriceDTO.setEFFECTIVE_DATE(cursor.getString(cursor.getColumnIndex(EFFECTIVE_DATE)));
                basepriceDTO.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                basepriceDTO.setITEM_NO(cursor.getString(cursor.getColumnIndex(ITEM_NO)));
                basepriceDTO.setWHOLESALE_PRICE(cursor.getDouble(cursor.getColumnIndex(WHOLESALE_PRICE)));
                basepriceDTO.setRETAIL_PRICE(cursor.getDouble(cursor.getColumnIndex(RETAIL_PRICE)));
                basepriceDTO.setDISTRIBUTOR_PRICE(cursor.getDouble(cursor.getColumnIndex(DISTRIBUTOR_PRICE)));
                basepriceDTO.setDISTRIBUTOR_SPREAD_PER(cursor.getDouble(cursor.getColumnIndex(DISTRIBUTOR_SPREAD_PER)));
                basepriceDTO.setDISTRIBUTOR_PROMO_PART_IND(cursor.getString(cursor.getColumnIndex(DISTRIBUTOR_PROMO_PART_IND)));
                someBaseprices.add(basepriceDTO);

                cursor.moveToNext();
            }
        }
        cursor.close();
        return someBaseprices;
    }

    @Override
    public List<BasepriceDTO> getBasepricesByProductID(String productID){
        List<BasepriceDTO> someBaseprices = new ArrayList<BasepriceDTO>();

        String sql = "SELECT * FROM " + BASEPRICE_TABLE + " WHERE " + PRODUCT_ID + " = '" + productID + "'";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                BasepriceDTO basepriceDTO = new BasepriceDTO();
                basepriceDTO.setEFFECTIVE_DATE(cursor.getString(cursor.getColumnIndex(EFFECTIVE_DATE)));
                basepriceDTO.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                basepriceDTO.setITEM_NO(cursor.getString(cursor.getColumnIndex(ITEM_NO)));
                basepriceDTO.setWHOLESALE_PRICE(cursor.getDouble(cursor.getColumnIndex(WHOLESALE_PRICE)));
                basepriceDTO.setRETAIL_PRICE(cursor.getDouble(cursor.getColumnIndex(RETAIL_PRICE)));
                basepriceDTO.setDISTRIBUTOR_PRICE(cursor.getDouble(cursor.getColumnIndex(DISTRIBUTOR_PRICE)));
                basepriceDTO.setDISTRIBUTOR_SPREAD_PER(cursor.getDouble(cursor.getColumnIndex(DISTRIBUTOR_SPREAD_PER)));
                basepriceDTO.setDISTRIBUTOR_PROMO_PART_IND(cursor.getString(cursor.getColumnIndex(DISTRIBUTOR_PROMO_PART_IND)));
                someBaseprices.add(basepriceDTO);

                cursor.moveToNext();
            }
        }
        cursor.close();
        return someBaseprices;
    }
}
