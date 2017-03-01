package com.example.homannh.dsd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOH on 2/24/2017.
 */

public class ProductDAO extends WinHHDAO implements IProductDAO {
    public ProductDAO(Context context) {
        super(context);
    }

    @Override
    public void initProduct(Context context) {
        super.reCreateProductTable();
    }

    @Override
    public void insert(ProductDTO productDTO) throws Exception{
        ContentValues cv = new ContentValues();
        cv.put(PRODUCT_ID, productDTO.getPRODUCT_ID());
        cv.put(ITEM_NO, productDTO.getITEM_NO());
        cv.put(COMPANY_CODE, productDTO.getCOMPANY_CODE());
        cv.put(UPC_CODE, productDTO.getUPC_CODE().toString());
        cv.put(SUB_UPC_CODE, productDTO.getSUB_UPC_CODE());
        cv.put(PRODUCT_GROUP_CODE, productDTO.getPRODUCT_GROUP_CODE());
        cv.put(PRODUCT_CAT_CODE, productDTO.getPRODUCT_CAT_CODE());
        cv.put(FINANCIAL_CAT_CODE, productDTO.getFINANCIAL_CAT_CODE());
        cv.put(PRODUCT_DESC, productDTO.getPRODUCT_DESC());
        cv.put(SHELF_LIFE_DAY_1, productDTO.getSHELF_LIFE_DAY_1());
        cv.put(SHELF_LIFE_DAY_2, productDTO.getSHELF_LIFE_DAY_2());
        cv.put(SHELF_LIFE_DAY_3, productDTO.getSHELF_LIFE_DAY_3());
        cv.put(SHELF_LIFE_DAY_4, productDTO.getSHELF_LIFE_DAY_4());
        cv.put(SHELF_LIFE_DAY_5, productDTO.getSHELF_LIFE_DAY_5());
        cv.put(SHELF_LIFE_DAY_6, productDTO.getSHELF_LIFE_DAY_6());
        cv.put(SHELF_LIFE_DAY_7, productDTO.getSHELF_LIFE_DAY_7());
        cv.put(FORECAST_TYPE, productDTO.getFORECAST_TYPE());
        cv.put(RETURNS_ALLOWED_IND, productDTO.getRETURNS_ALLOWED_IND());
        cv.put(SPREAD_GROUP, productDTO.getSPREAD_GROUP());
        cv.put(SALES_ALLOWED_IND, productDTO.getSALES_ALLOWED_IND());
        cv.put(FRESH_RETURNS_ALLOWED_IND, productDTO.getFRESH_RETURNS_ALLOWED_IND());
        cv.put(DEX_COUNTRY_CODE, productDTO.getDEX_COUNTRY_CODE());
        cv.put(DEX_PRODUCT_TYPE, productDTO.getDEX_PRODUCT_TYPE());
        cv.put(PACK_SIZE_QTY, productDTO.getPACK_SIZE_QTY());
        cv.put(NO_DNL_DATE, productDTO.getNO_DNL_DATE());

        getWritableDatabase().insert(PRODUCT_TABLE, PRODUCT_ID, cv);

    }

    @Override
    public void isProductTable(){
        String sql = "CREATE TABLE IF NOT EXISTS "
                + PRODUCT_TABLE + "(" + _ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUCT_ID + " TEXT, " + ITEM_NO + " TEXT, " + COMPANY_CODE + " TEXT, " + UPC_CODE + " TEXT, "
                + SUB_UPC_CODE + " TEXT, " + PRODUCT_GROUP_CODE + " TEXT, " + PRODUCT_CAT_CODE + " TEXT, " + FINANCIAL_CAT_CODE + " TEXT, " + PRODUCT_DESC + " TEXT, "
                + SHELF_LIFE_DAY_1 + " INTEGER, " + SHELF_LIFE_DAY_2 + " INTEGER, " + SHELF_LIFE_DAY_3 + " INTEGER, " + SHELF_LIFE_DAY_4 + " INTEGER, " + SHELF_LIFE_DAY_5 + " INTEGER, "
                + SHELF_LIFE_DAY_6 + " INTEGER, " + SHELF_LIFE_DAY_7 + " INTEGER, "
                + FORECAST_TYPE + " TEXT, " + RETURNS_ALLOWED_IND + " TEXT, " + SPREAD_GROUP + " TEXT, " + SALES_ALLOWED_IND + " TEXT, " + FRESH_RETURNS_ALLOWED_IND + " TEXT, "
                + DEX_COUNTRY_CODE + " TEXT, " + DEX_PRODUCT_TYPE + " TEXT, " + PACK_SIZE_QTY + " TEXT, " + NO_DNL_DATE + " TEXT"
                + ");";
        getWritableDatabase().rawQuery(sql, null);
    }

    @Override
    public int countProducts(){
        int noOfRow = 0;
        String sql = "SELECT COUNT (*) FROM " + PRODUCT_TABLE;
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
    public List<ProductDTO> fetchProducts(String searchTerm){
        List<ProductDTO> someProducts = new ArrayList<ProductDTO>();

        String sql = "SELECT * FROM " + PRODUCT_TABLE;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ProductDTO aProduct = new ProductDTO();
                aProduct.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                aProduct.setITEM_NO (cursor.getString(cursor.getColumnIndex(ITEM_NO )));
                aProduct.setCOMPANY_CODE (cursor.getString(cursor.getColumnIndex(COMPANY_CODE )));
                aProduct.setUPC_CODE (cursor.getString(cursor.getColumnIndex(UPC_CODE )));
                aProduct.setSUB_UPC_CODE (cursor.getString(cursor.getColumnIndex(SUB_UPC_CODE )));
                aProduct.setPRODUCT_GROUP_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_GROUP_CODE )));
                aProduct.setPRODUCT_CAT_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_CAT_CODE )));
                aProduct.setFINANCIAL_CAT_CODE (cursor.getString(cursor.getColumnIndex( FINANCIAL_CAT_CODE)));
                aProduct.setPRODUCT_DESC (cursor.getString(cursor.getColumnIndex(PRODUCT_DESC )));
                aProduct.setSHELF_LIFE_DAY_1 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_1)));
                aProduct.setSHELF_LIFE_DAY_2 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_2)));
                aProduct.setSHELF_LIFE_DAY_3 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_3)));
                aProduct.setSHELF_LIFE_DAY_4 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_4)));
                aProduct.setSHELF_LIFE_DAY_5 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_5)));
                aProduct.setSHELF_LIFE_DAY_6 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_6)));
                aProduct.setSHELF_LIFE_DAY_7 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_7)));
                aProduct.setFORECAST_TYPE (cursor.getString(cursor.getColumnIndex(FORECAST_TYPE)));
                aProduct.setRETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(RETURNS_ALLOWED_IND )));
                aProduct.setSPREAD_GROUP (cursor.getString(cursor.getColumnIndex(SPREAD_GROUP)));
                aProduct.setSALES_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(SALES_ALLOWED_IND )));
                aProduct.setFRESH_RETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(FRESH_RETURNS_ALLOWED_IND)));
                aProduct.setDEX_COUNTRY_CODE (cursor.getString(cursor.getColumnIndex(DEX_COUNTRY_CODE)));
                aProduct.setDEX_PRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(DEX_PRODUCT_TYPE)));
                aProduct.setPACK_SIZE_QTY (cursor.getString(cursor.getColumnIndex(PACK_SIZE_QTY)));
                aProduct.setNO_DNL_DATE (cursor.getString(cursor.getColumnIndex(NO_DNL_DATE)));

                someProducts.add(aProduct);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return someProducts;
    }


    @Override
    public List<ProductDTO> getProductsByYourSQL(String yourSQL){
        List<ProductDTO> someProducts = new ArrayList<ProductDTO>();

        Cursor cursor = getReadableDatabase().rawQuery(yourSQL, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ProductDTO aProduct = new ProductDTO();
                aProduct.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                aProduct.setITEM_NO (cursor.getString(cursor.getColumnIndex(ITEM_NO )));
                aProduct.setCOMPANY_CODE (cursor.getString(cursor.getColumnIndex(COMPANY_CODE )));
                aProduct.setUPC_CODE (cursor.getString(cursor.getColumnIndex(UPC_CODE )));
                aProduct.setSUB_UPC_CODE (cursor.getString(cursor.getColumnIndex(SUB_UPC_CODE )));
                aProduct.setPRODUCT_GROUP_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_GROUP_CODE )));
                aProduct.setPRODUCT_CAT_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_CAT_CODE )));
                aProduct.setFINANCIAL_CAT_CODE (cursor.getString(cursor.getColumnIndex( FINANCIAL_CAT_CODE)));
                aProduct.setPRODUCT_DESC (cursor.getString(cursor.getColumnIndex(PRODUCT_DESC )));
                aProduct.setSHELF_LIFE_DAY_1 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_1)));
                aProduct.setSHELF_LIFE_DAY_2 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_2)));
                aProduct.setSHELF_LIFE_DAY_3 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_3)));
                aProduct.setSHELF_LIFE_DAY_4 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_4)));
                aProduct.setSHELF_LIFE_DAY_5 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_5)));
                aProduct.setSHELF_LIFE_DAY_6 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_6)));
                aProduct.setSHELF_LIFE_DAY_7 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_7)));
                aProduct.setFORECAST_TYPE (cursor.getString(cursor.getColumnIndex(FORECAST_TYPE)));
                aProduct.setRETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(RETURNS_ALLOWED_IND )));
                aProduct.setSPREAD_GROUP (cursor.getString(cursor.getColumnIndex(SPREAD_GROUP)));
                aProduct.setSALES_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(SALES_ALLOWED_IND )));
                aProduct.setFRESH_RETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(FRESH_RETURNS_ALLOWED_IND)));
                aProduct.setDEX_COUNTRY_CODE (cursor.getString(cursor.getColumnIndex(DEX_COUNTRY_CODE)));
                aProduct.setDEX_PRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(DEX_PRODUCT_TYPE)));
                aProduct.setPACK_SIZE_QTY (cursor.getString(cursor.getColumnIndex(PACK_SIZE_QTY)));
                aProduct.setNO_DNL_DATE (cursor.getString(cursor.getColumnIndex(NO_DNL_DATE)));

                someProducts.add(aProduct);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return someProducts;
    }


    @Override
    public List<ProductDTO> getProductsByUPC(String companyCode, String upcCode){
        List<ProductDTO> someProducts = new ArrayList<ProductDTO>();

        if(companyCode.equals(null))
            companyCode = "";
        if(upcCode.equals(null ))
            upcCode = "";

        String sql = "SELECT * FROM " + PRODUCT_TABLE + " WHERE " +  COMPANY_CODE + " = '" + companyCode + "' AND " + UPC_CODE + " = '" + upcCode + "'";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ProductDTO aProduct = new ProductDTO();
                aProduct.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                aProduct.setITEM_NO (cursor.getString(cursor.getColumnIndex(ITEM_NO )));
                aProduct.setCOMPANY_CODE (cursor.getString(cursor.getColumnIndex(COMPANY_CODE )));
                aProduct.setUPC_CODE (cursor.getString(cursor.getColumnIndex(UPC_CODE )));
                aProduct.setSUB_UPC_CODE (cursor.getString(cursor.getColumnIndex(SUB_UPC_CODE )));
                aProduct.setPRODUCT_GROUP_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_GROUP_CODE )));
                aProduct.setPRODUCT_CAT_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_CAT_CODE )));
                aProduct.setFINANCIAL_CAT_CODE (cursor.getString(cursor.getColumnIndex( FINANCIAL_CAT_CODE)));
                aProduct.setPRODUCT_DESC (cursor.getString(cursor.getColumnIndex(PRODUCT_DESC )));
                aProduct.setSHELF_LIFE_DAY_1 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_1)));
                aProduct.setSHELF_LIFE_DAY_2 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_2)));
                aProduct.setSHELF_LIFE_DAY_3 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_3)));
                aProduct.setSHELF_LIFE_DAY_4 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_4)));
                aProduct.setSHELF_LIFE_DAY_5 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_5)));
                aProduct.setSHELF_LIFE_DAY_6 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_6)));
                aProduct.setSHELF_LIFE_DAY_7 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_7)));
                aProduct.setFORECAST_TYPE (cursor.getString(cursor.getColumnIndex(FORECAST_TYPE)));
                aProduct.setRETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(RETURNS_ALLOWED_IND )));
                aProduct.setSPREAD_GROUP (cursor.getString(cursor.getColumnIndex(SPREAD_GROUP)));
                aProduct.setSALES_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(SALES_ALLOWED_IND )));
                aProduct.setFRESH_RETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(FRESH_RETURNS_ALLOWED_IND)));
                aProduct.setDEX_COUNTRY_CODE (cursor.getString(cursor.getColumnIndex(DEX_COUNTRY_CODE)));
                aProduct.setDEX_PRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(DEX_PRODUCT_TYPE)));
                aProduct.setPACK_SIZE_QTY (cursor.getString(cursor.getColumnIndex(PACK_SIZE_QTY)));
                aProduct.setNO_DNL_DATE (cursor.getString(cursor.getColumnIndex(NO_DNL_DATE)));

                someProducts.add(aProduct);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return someProducts;
    }

    @Override
    public List<ProductDTO> getProductsByItemNo(String itemNo){
        List<ProductDTO> someProducts = new ArrayList<ProductDTO>();

        if(itemNo.equals(null))
            itemNo = "";

        String sql = "SELECT * FROM " + PRODUCT_TABLE + " WHERE " +  ITEM_NO + " = '" + itemNo + "'";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ProductDTO aProduct = new ProductDTO();
                aProduct.setPRODUCT_ID(cursor.getString(cursor.getColumnIndex(PRODUCT_ID)));
                aProduct.setITEM_NO (cursor.getString(cursor.getColumnIndex(ITEM_NO )));
                aProduct.setCOMPANY_CODE (cursor.getString(cursor.getColumnIndex(COMPANY_CODE )));
                aProduct.setUPC_CODE (cursor.getString(cursor.getColumnIndex(UPC_CODE )));
                aProduct.setSUB_UPC_CODE (cursor.getString(cursor.getColumnIndex(SUB_UPC_CODE )));
                aProduct.setPRODUCT_GROUP_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_GROUP_CODE )));
                aProduct.setPRODUCT_CAT_CODE (cursor.getString(cursor.getColumnIndex(PRODUCT_CAT_CODE )));
                aProduct.setFINANCIAL_CAT_CODE (cursor.getString(cursor.getColumnIndex( FINANCIAL_CAT_CODE)));
                aProduct.setPRODUCT_DESC (cursor.getString(cursor.getColumnIndex(PRODUCT_DESC )));
                aProduct.setSHELF_LIFE_DAY_1 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_1)));
                aProduct.setSHELF_LIFE_DAY_2 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_2)));
                aProduct.setSHELF_LIFE_DAY_3 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_3)));
                aProduct.setSHELF_LIFE_DAY_4 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_4)));
                aProduct.setSHELF_LIFE_DAY_5 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_5)));
                aProduct.setSHELF_LIFE_DAY_6 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_6)));
                aProduct.setSHELF_LIFE_DAY_7 (cursor.getInt(cursor.getColumnIndex(SHELF_LIFE_DAY_7)));
                aProduct.setFORECAST_TYPE (cursor.getString(cursor.getColumnIndex(FORECAST_TYPE)));
                aProduct.setRETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(RETURNS_ALLOWED_IND )));
                aProduct.setSPREAD_GROUP (cursor.getString(cursor.getColumnIndex(SPREAD_GROUP)));
                aProduct.setSALES_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(SALES_ALLOWED_IND )));
                aProduct.setFRESH_RETURNS_ALLOWED_IND (cursor.getString(cursor.getColumnIndex(FRESH_RETURNS_ALLOWED_IND)));
                aProduct.setDEX_COUNTRY_CODE (cursor.getString(cursor.getColumnIndex(DEX_COUNTRY_CODE)));
                aProduct.setDEX_PRODUCT_TYPE (cursor.getString(cursor.getColumnIndex(DEX_PRODUCT_TYPE)));
                aProduct.setPACK_SIZE_QTY (cursor.getString(cursor.getColumnIndex(PACK_SIZE_QTY)));
                aProduct.setNO_DNL_DATE (cursor.getString(cursor.getColumnIndex(NO_DNL_DATE)));

                someProducts.add(aProduct);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return someProducts;
    }
}
