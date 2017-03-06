package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.bll.AdjItemSER;

public class AdjustmentActivity extends AppCompatActivity {

    private TextView lblDescription1;
    private TextView lblItemNoValue;
    private TextView lblscannedUPCValue;
    private Toolbar toolBar;
    private TextView lblTotalAdjustmentValue;
    private EditText txtAdjQtyValue;
    private RadioButton rdbtnShort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjustment);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);

        lblItemNoValue = (TextView) findViewById(R.id.lblItemNoValue);
        lblscannedUPCValue = (TextView) findViewById(R.id.lblScannedUPCValue);
        lblDescription1 = (TextView) findViewById(R.id.lblDescription1);
        lblTotalAdjustmentValue = (TextView) findViewById(R.id.lblTotalAdjustmentValue);
        txtAdjQtyValue = (EditText) findViewById(R.id.txtAdjQtyValue);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            Intent intent = getIntent();
            if(intent!=null) {
                AdjItemSER adjItem = new AdjItemSER();
                adjItem = (AdjItemSER) intent.getSerializableExtra("VAR_Adjustment");
                toolBar.setTitle("UPC:" + adjItem.getCOMPANY_CODE() + adjItem.getUPC_CODE() + adjItem.getSUB_UPC_CODE());

                lblDescription1.setText(adjItem.getPRODUCT_DESC());
                lblItemNoValue.setText(adjItem.getITEM_NO());
                lblscannedUPCValue.setText(adjItem.getCOMPANY_CODE() + adjItem.getUPC_CODE() + adjItem.getSUB_UPC_CODE());
                lblTotalAdjustmentValue.setText(String.valueOf(adjItem.getADJUST_QTY()));
                txtAdjQtyValue.setText("");
                rdbtnShort = (RadioButton) findViewById(R.id.rdbtnShort);
                rdbtnShort.toggle();
            }

        }


    }

    public void rdbtnOnClicked(View v)
    {

    }

    public void btnOkClicked(View view){
        finish();
    }
}
