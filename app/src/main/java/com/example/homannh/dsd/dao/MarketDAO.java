package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.homannh.dsd.dto.MarketDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the attributes taht describe a Market
 * Created by homannh on 2/23/2017.
 */

//public class MarketDAO extends SQLiteOpenHelper{
public class MarketDAO extends WinHHDAO implements IMarketDAO{

    public MarketDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "winhh.db", factory, 1);
    }

    @Override
    public void save(MarketDTO marketDTO) throws Exception {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MARKET_ID, marketDTO.getMARKET_ID());
        contentValues.put(MARKET_DESCRIPTION, marketDTO.getMARKET_DESCRIPTION());
        getWritableDatabase().insert(MARKET_TABLE, MARKET_ID, contentValues);
    }

    @Override
    public void IsMarketExist() {

        //SELECT name FROM sqlite_master WHERE type='table' AND name='table_name';
        String sqlStmt = "CREATE TABLE IF NOT EXISTS " + MARKET_TABLE + " ( " + _ID_MARKET + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MARKET_ID + " TEXT, " + MARKET_DESCRIPTION + " TEXT " + ");";
        getWritableDatabase().execSQL(sqlStmt);

        return;
    }

    @Override
    public int countsMarkets() {
        int noOfMarkets = 0;
        String sqlStmt = "SELECT (*) FROM " + MARKET_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sqlStmt, null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            noOfMarkets = cursor.getInt(0);
        }

        cursor.close();
        return noOfMarkets;
    }

}
