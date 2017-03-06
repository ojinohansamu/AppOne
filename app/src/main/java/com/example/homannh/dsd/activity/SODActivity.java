package com.example.homannh.dsd.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.bll.AdjItemSER;
import com.example.homannh.dsd.bll.AdjustmentBLL;
import com.example.homannh.dsd.bll.RouteInfoSER;
import com.example.homannh.dsd.dao.IInvenadjDAO;
import com.example.homannh.dsd.dao.InvenadjDAO;

import java.util.ArrayList;
import java.util.List;

public class SODActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final int UPC_DIGIT = 10;
    public static final String _VAR_RouteinfoTag = "VAR_Routeinfo";
    private Toolbar toolBar;
    private RouteInfoSER _routeInfo;
    private ListView listviewAdjustments;
    private TextView txtUPC;
    private int noDigits = 0;
    private int productsCount;

    private List<AdjustmentBLL> someAdjustments = new ArrayList<AdjustmentBLL>();
    AdjustmentBLL adjustmentBLLSelected = new AdjustmentBLL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sod);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            _routeInfo = new RouteInfoSER();
            _routeInfo = (RouteInfoSER) bundle.getSerializable(_VAR_RouteinfoTag);
            if (_routeInfo != null) {
                toolBar.setTitle(_routeInfo.getMARKET_ID() + _routeInfo.getROUTE_ID() + "  Load Adjustments");
            }
        }

        txtUPC = (TextView) findViewById(R.id.txtUPC);
        //txtUPC.requestFocus();

        listviewAdjustments = (ListView) findViewById(R.id.listviewAdjustments);
        listviewAdjustments.setAdapter(new MyCustomAdapter(this));
        listviewAdjustments.setOnItemClickListener(this);

        txtUPC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                noDigits = start + count;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(noDigits > (UPC_DIGIT -1)) {
                    if(validUpc())
                    {
                        txtUPC.setText("");
                    }

                }
            }
        });

    }

    public boolean validUpc(){
        boolean result = false;
        int i;
        if(noDigits >UPC_DIGIT)
            i = 0;
        else
            i = 1;

        String myUPC = txtUPC.getText().toString();
        String companyCode = myUPC.substring(1 - i, 6 - i);
        String upcCode = myUPC.substring(6 - i, 11-i);
        if(GetProduct(companyCode, upcCode)) {
            nextScreen(SODActivity.this);
            result = true;
        }
        return result;
    }


    public void nextScreen(Context ctx)
    {
        Intent adjustmentActivity = new Intent(this, AdjustmentActivity.class);

        AdjItemSER adjustmentBLL = new AdjItemSER();

        adjustmentBLL.setCOMPANY_CODE(adjustmentBLLSelected.getCOMPANY_CODE());
        adjustmentBLL.setUPC_CODE(adjustmentBLLSelected.getUPC_CODE());
        adjustmentBLL.setSUB_UPC_CODE(adjustmentBLLSelected.getSUB_UPC_CODE());
        adjustmentBLL.setITEM_NO(adjustmentBLLSelected.getITEM_NO());
        adjustmentBLL.setPRODUCT_DESC(adjustmentBLLSelected.getPRODUCT_DESC());
        adjustmentBLL.setADJUST_QTY(adjustmentBLLSelected.getADJUST_QTY());
        adjustmentActivity.putExtra("VAR_Adjustment",adjustmentBLL);

        startActivity(adjustmentActivity);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AdjustmentActivity.class);

        SODActivity.ViewHolder holder = (SODActivity.ViewHolder) view.getTag();
        SODActivity.SingleRowProduct singleRowProduct = (SODActivity.SingleRowProduct) holder.lblItemNoValue.getTag();

        AdjItemSER adjustmentBLL = new AdjItemSER();
        adjustmentBLL.setCOMPANY_CODE(singleRowProduct.productUPC.substring(0,5));
        adjustmentBLL.setUPC_CODE(singleRowProduct.productUPC.substring(5,10));
        adjustmentBLL.setSUB_UPC_CODE(singleRowProduct.productUPC.substring(10));
        adjustmentBLL.setITEM_NO(singleRowProduct.productItemNo);
        adjustmentBLL.setPRODUCT_DESC(singleRowProduct.productDescription);
        adjustmentBLL.setADJUST_QTY(singleRowProduct.productQty);
        intent.putExtra("VAR_Adjustment",adjustmentBLL);

        startActivity(intent);

        txtUPC.setText("");
        //Toast.makeText(this, "Pos = " + position, Toast.LENGTH_LONG).show();

    }


    private boolean GetProduct(String companyCode, String upcCode) {
        boolean productFound = false;
        adjustmentBLLSelected = null;

        for (AdjustmentBLL oneAdjustment : someAdjustments) {
            if(oneAdjustment.getCOMPANY_CODE().equals(companyCode) && oneAdjustment.getUPC_CODE().equals(upcCode))
            {
                productFound = true;
                adjustmentBLLSelected = oneAdjustment;
                break;

            }
        }

        if(!productFound)
            Toast.makeText(this, companyCode + upcCode +  " not found!", Toast.LENGTH_SHORT).show();

        return productFound;
    }


    class SingleRowProduct
    {
        String productDescription;
        String productUPC;
        String productItemNo;
        int productQty;
        SingleRowProduct(String productDescription, String productUPC, String productItemNo, int productQty)
        {
            this.productDescription = productDescription;
            this.productUPC = productUPC;
            this.productItemNo = productItemNo;
            this.productQty = productQty;
        }
    }
    class ViewHolder
    {
        TextView lblProdNameValue;
        TextView lblUPCValue;
        TextView lblItemNoValue;
        TextView txtQty;
        ViewHolder(View view)
        {
            lblProdNameValue = (TextView) view.findViewById(R.id.lblProdNameValue);
            lblUPCValue = (TextView) view.findViewById(R.id.lblUPCValue);
            lblItemNoValue = (TextView) view.findViewById(R.id.lblItemNoValue);
            txtQty = (TextView) view.findViewById(R.id.txtQty);
        }

    }

    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<SODActivity.SingleRowProduct> myList;
        Context ctx;

        MyCustomAdapter(Context context)
        {
            ctx = context;
            myList = new ArrayList<SODActivity.SingleRowProduct>();

            // Move this one on top  List<AdjustmentBLL> someAdjustments = new ArrayList<AdjustmentBLL>();
            IInvenadjDAO invenadjDAO = new InvenadjDAO(ctx);

            someAdjustments = invenadjDAO.createInvenadjBLLByDate("2017-03-03");
            productsCount = someAdjustments.size();
            for (AdjustmentBLL oneAdjustmentBLL : someAdjustments) {
                SingleRowProduct singleRowProduct = new SingleRowProduct(oneAdjustmentBLL.getPRODUCT_DESC(), oneAdjustmentBLL.getCOMPANY_CODE()+ oneAdjustmentBLL.getUPC_CODE() + oneAdjustmentBLL.getSUB_UPC_CODE(),
                        oneAdjustmentBLL.getITEM_NO(), oneAdjustmentBLL.getADJUST_QTY());
                myList.add(singleRowProduct);
            }
        }

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            SODActivity.ViewHolder viewHolder = null;
            if(row == null) { //This if is to optimize the speed. if it is null, it means row was not created otherwise don't keep recreating it.
                LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
                row = layoutInflater.inflate(R.layout.single_row_adjustment, parent, false);
                viewHolder = new ViewHolder(row);
                row.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder) row.getTag();
            }
            SingleRowProduct singleRow = myList.get(position);
            viewHolder.lblProdNameValue.setText(singleRow.productDescription);
            viewHolder.lblUPCValue.setText(singleRow.productUPC);
            viewHolder.lblItemNoValue.setText(singleRow.productItemNo);
            viewHolder.txtQty.setText(String.valueOf(singleRow.productQty));
            viewHolder.lblItemNoValue.setTag(singleRow);
            /*
            lblProdNameValue.setText(singleRow.productDescription);
            lblUPCValue.setText(singleRow.productUPC);
            lblItemNoValue.setText(singleRow.productItemNo);
            */
            return row;
        }
    }
}
