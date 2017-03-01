package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.homannh.dsd.dto.InvenadjDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOH on 2/27/2017.
 */

public class IvenadjDAO extends WinHHDAO implements IIvenadjDAO {

    public IvenadjDAO(Context context) {
        super(context);
    }

    @Override
    public void initInvenadj(Context context) {
        super.reCreateInvenadjTable();
    }

    @Override
    public void insert(InvenadjDTO invenadjDTO) throws  Exception{
        ContentValues cv = new ContentValues();
        cv.put(INVENADJ_ID, invenadjDTO.getINVENADJ_ID());
        cv.put(RECORD_TYPE, invenadjDTO.getRECORD_TYPE());
        cv.put(ITEM_NO, invenadjDTO.getITEM_NO());
        cv.put(STORE_DELIVERY_DATE, invenadjDTO.getSTORE_DELIVERY_DATE());
        cv.put(TRANSACTION_DATE, invenadjDTO.getTRANSACTION_DATE());
        cv.put(TRANSACTION_HOUR, invenadjDTO.getTRANSACTION_HOUR());
        cv.put(TRANSACTION_MINUTE, invenadjDTO.getTRANSACTION_MINUTE());
        cv.put(DOCUMENT_NUMBER, invenadjDTO.getDOCUMENT_NUMBER());
        cv.put(ADJUST_INVENTORY, invenadjDTO.getADJUST_INVENTORY());
        cv.put(ADJUST_TYPE, invenadjDTO.getADJUST_TYPE());
        cv.put(THRIFT_STORE, invenadjDTO.getTHRIFT_STORE());
        cv.put(ADJUST_QTY, invenadjDTO.getADJUST_QTY());
        cv.put(ROUTE_PRICE, invenadjDTO.getROUTE_PRICE());
        cv.put(UPLOAD_IND, invenadjDTO.getUPLOAD_IND());
        cv.put(PRODUCT_ID, invenadjDTO.getPRODUCT_ID());
    }

    @Override
    public void isInvenadjTable(){

        String sql = "CREATE TABLE IF NOT EXISTS "
                + INVENADJ_TABLE + "(" + _ID_INVENADJ + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INVENADJ_ID + " TEXT, " + RECORD_TYPE + " TEXT, " + ITEM_NO + " TEXT, "
                + STORE_DELIVERY_DATE + " TEXT, "  + TRANSACTION_DATE + " TEXT, "  + TRANSACTION_HOUR + " TEXT, " + TRANSACTION_MINUTE + " TEXT, "
                + DOCUMENT_NUMBER + " TEXT, "  + ADJUST_INVENTORY + " TEXT, "  + ADJUST_TYPE + " TEXT, " + THRIFT_STORE + " TEXT, "
                + ADJUST_QTY + " INTEGER, " + ROUTE_PRICE + " DOUBLE, " + UPLOAD_IND + " TEXT, " + PRODUCT_ID + " TEXT "
                + ");";

        getWritableDatabase().rawQuery(sql, null);
    }

    @Override
    public int countInvenadj(){
        int noOfRow = 0;
        String sql = "SELECT COUNT (*) FROM " + INVENADJ_TABLE;
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
    public List<InvenadjDTO> getInvenadjByDate(String startDate) {

        List<InvenadjDTO> someInvenadj = new ArrayList<InvenadjDTO>();

        String sql = "SELECT * FROM " + INVENADJ_TABLE + " WHERE " + STORE_DELIVERY_DATE + " = '" + startDate + "'";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                InvenadjDTO invenadjDTO = new InvenadjDTO();

                invenadjDTO.setINVENADJ_ID(cursor.getLong(cursor.getColumnIndex(INVENADJ_ID)));
                invenadjDTO.setRECORD_TYPE(cursor.getString(cursor.getColumnIndex(RECORD_TYPE)));
                invenadjDTO.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                invenadjDTO.setITEM_NO(cursor.getString(cursor.getColumnIndex(ITEM_NO)));
                invenadjDTO.setSTORE_DELIVERY_DATE(cursor.getString(cursor.getColumnIndex(STORE_DELIVERY_DATE)));
                invenadjDTO.setTRANSACTION_DATE(cursor.getString(cursor.getColumnIndex(TRANSACTION_DATE)));
                invenadjDTO.setTRANSACTION_HOUR(cursor.getString(cursor.getColumnIndex(TRANSACTION_HOUR)));
                invenadjDTO.setTRANSACTION_MINUTE(cursor.getString(cursor.getColumnIndex(TRANSACTION_MINUTE)));
                invenadjDTO.setDOCUMENT_NUMBER(cursor.getString(cursor.getColumnIndex(DOCUMENT_NUMBER)));
                invenadjDTO.setADJUST_INVENTORY(cursor.getString(cursor.getColumnIndex(ADJUST_INVENTORY)));
                invenadjDTO.setADJUST_TYPE(cursor.getString(cursor.getColumnIndex(ADJUST_TYPE)));
                invenadjDTO.setTHRIFT_STORE(cursor.getString(cursor.getColumnIndex(THRIFT_STORE)));
                invenadjDTO.setADJUST_QTY(cursor.getInt(cursor.getColumnIndex(ADJUST_QTY)));
                invenadjDTO.setUPLOAD_IND(cursor.getString(cursor.getColumnIndex(UPLOAD_IND)));
                invenadjDTO.setROUTE_PRICE(cursor.getDouble(cursor.getColumnIndex(ROUTE_PRICE)));
                someInvenadj.add(invenadjDTO);

                cursor.moveToNext();
            }
        }
        cursor.close();
        return someInvenadj;
    }

}
