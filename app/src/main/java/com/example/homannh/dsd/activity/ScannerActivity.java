package com.example.homannh.dsd.activity;
/*
HOH 02-26-2017
Added scanner Class, it works on my Samsung. Based on the video
https://www.youtube.com/watch?v=Fe7F4Jx7rwo
 */
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.BasepriceDAO;
import com.example.homannh.dsd.dao.IBasepriceDAO;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dto.BasepriceDTO;
import com.example.homannh.dsd.dto.ProductDTO;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class ScannerActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private Button btnScanner;

    private String lblScannerValue;
    private TextView lblScannedUPCValue;
    private TextView lblItemNoValue;
    private TextView lblDescription1;
    private TextView lblDescription2;
    private TextView lblDescription3;
    private TextView lblDescription4;
    private EditText txtUPC;
    private String oldUPC;
    private int startx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        btnScanner = (Button) findViewById(R.id.btnScan);
       // lblScannerValue = (TextView) findViewById(R.id.lblScannerValue);
        lblScannedUPCValue = (TextView) findViewById(R.id.lblScannedUPCValue);
        lblItemNoValue = (TextView) findViewById(R.id.lblItemNoValue);
        lblDescription1 = (TextView) findViewById(R.id.lblDescription1);
        lblDescription2 = (TextView) findViewById(R.id.lblDescription2);
        lblDescription3 = (TextView) findViewById(R.id.lblDescription3);
        lblDescription4 = (TextView) findViewById(R.id.lblDescription4);
        txtUPC = (EditText) findViewById(R.id.txtUPC);
        txtUPC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startx  = start + count;

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(startx>9) {
                    int i;
                    if(startx>10)
                        i = 0;
                    else
                     i = 1;
                    String myUPC = txtUPC.getText().toString();
                    String companyCode = myUPC.substring(1 - i, 6 - i);
                    String upcCode = myUPC.substring(6 - i, 11-i);
                    GetProduct(companyCode, upcCode);
                    startx = 0;
                    txtUPC.setText("");
                }
            }
        });

        final Activity activity = this;

        toolBar.setTitle("Scanner");
        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
                intentIntegrator.setPrompt("Scan");
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult != null){
            if(intentResult.getContents() == null){
                Toast.makeText(this, "Cancelled!", Toast.LENGTH_LONG).show();
            }
            else {
                lblScannerValue = "";
                lblScannerValue=intentResult.getContents();
                String companyCode = lblScannerValue.substring(1,6);
                String upcCode = lblScannerValue.substring(6,11);
                GetProduct(companyCode, upcCode);
            }
        }
        else
           super.onActivityResult(requestCode, resultCode, data);
    }

    private void GetProduct(String companyCode, String upcCode) {
        boolean productFound = false;
        boolean priceFound = false;
        lblDescription1.setText("");
        lblDescription2.setText("");
        lblDescription3.setText("");
        lblDescription4.setText("");
        List<ProductDTO> anyProducts = new ArrayList<ProductDTO>();
        IProductDAO productDAO = new ProductDAO(ScannerActivity.this);
        ProductDTO scannedProduct = new ProductDTO();
        BasepriceDTO productBaseprice = new BasepriceDTO();
        anyProducts=productDAO.getProductsByUPC(companyCode,upcCode);
        if(anyProducts.isEmpty())
            Toast.makeText(this, companyCode + upcCode + " not found!", Toast.LENGTH_SHORT).show();
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
            IBasepriceDAO basepriceDAO = new BasepriceDAO(ScannerActivity.this);
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
            lblScannedUPCValue.setText(scannedProduct.getCOMPANY_CODE() + scannedProduct.getUPC_CODE());
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
            lblScannedUPCValue.setText("Invalid product!");
            lblItemNoValue.setText("Invalid product!");
            lblDescription1.setText("Invalid product!");

        }
    }

}
