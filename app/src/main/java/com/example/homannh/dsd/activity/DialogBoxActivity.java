package com.example.homannh.dsd.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.BasepriceDAO;
import com.example.homannh.dsd.dao.IBasepriceDAO;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dto.BasepriceDTO;
import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class DialogBoxActivity extends AppCompatActivity {

    private TextView lblItemNoValue;
    private TextView lblscannedUPCValue;
    private TextView lblDescription1;
    private TextView lblDescription2;
    private TextView lblDescription3;
    private TextView lblDescription4;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);

        lblItemNoValue = (TextView) findViewById(R.id.lblItemNoValue);
        lblscannedUPCValue = (TextView) findViewById(R.id.lblScannedUPCValue);
        lblDescription1 = (TextView) findViewById(R.id.lblDescription1);
        lblDescription2 = (TextView) findViewById(R.id.lblDescription2);
        lblDescription3 = (TextView) findViewById(R.id.lblDescription3);
        lblDescription4 = (TextView) findViewById(R.id.lblDescription4);
        Intent intent = getIntent();
        if(intent!=null)
        {
            String itemNo = intent.getStringExtra("VAR_ItemNo");
            GetProduct(itemNo);
            toolBar.setTitle("UPC:" + lblscannedUPCValue.getText());
        }
    }

    public void btnOkClicked(View view)
    {
        finish();
    }

    private void GetProduct(String itemNo) {
        boolean productFound = false;
        boolean priceFound = false;
        List<ProductDTO> anyProducts = new ArrayList<ProductDTO>();
        IProductDAO productDAO = new ProductDAO(DialogBoxActivity.this);
        ProductDTO scannedProduct = new ProductDTO();
        BasepriceDTO productBaseprice = new BasepriceDTO();
        anyProducts=productDAO.getProductsByItemNo(itemNo);
        if(anyProducts.isEmpty())
            Toast.makeText(this, itemNo + " not found!", Toast.LENGTH_SHORT).show();
        else
        {
            for (ProductDTO product : anyProducts) {
                scannedProduct = product;
                productFound = true;
                break;
            }
        }
        if(productFound)
        {
            //now get the baseprice from the baseprice table using itemno
            List<BasepriceDTO> someprices = new ArrayList<BasepriceDTO>();
            IBasepriceDAO basepriceDAO = new BasepriceDAO(DialogBoxActivity.this);
            someprices = basepriceDAO.getBasepricesByItemNo(scannedProduct.getITEM_NO());
            if(!someprices.isEmpty())
            {
                for (BasepriceDTO aBaseprice : someprices) {
                    productBaseprice = aBaseprice;
                    priceFound = true;
                    break;
                }
            }
        }
        if(productFound)
        {
            lblscannedUPCValue.setText(scannedProduct.getCOMPANY_CODE() + scannedProduct.getUPC_CODE());
            lblItemNoValue.setText(scannedProduct.getITEM_NO());
            lblDescription1.setText(scannedProduct.getPRODUCT_DESC());
            if(priceFound)
            {
                lblDescription2.setText("Whole sale : " + productBaseprice.getWHOLESALE_PRICE());
                lblDescription3.setText("Dist Price : " + productBaseprice.getDISTRIBUTOR_PRICE());
                lblDescription4.setText("    Retail : " + productBaseprice.getRETAIL_PRICE());
            }
            else
            {
                lblDescription2.setText("No Price found!");
                lblDescription3.setText("No Price found!");
                lblDescription4.setText("No Price found!");
            }
        }
        else
        {
            lblscannedUPCValue.setText("Invalid product!");
            lblItemNoValue.setText("Invalid product!");
            lblDescription1.setText("Invalid product!");

        }
    }
}
