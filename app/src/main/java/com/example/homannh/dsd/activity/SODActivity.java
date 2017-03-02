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
import com.example.homannh.dsd.dao.BasepriceDAO;
import com.example.homannh.dsd.dao.IBasepriceDAO;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dto.BasepriceDTO;
import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class SODActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Toolbar toolBar;
    private ListView listviewAdjustments;
    private TextView txtUPC;
    private int startx =0;
    private  int productsCount;
    private TextView lblAdjustmentTitle;
    private String _Routeinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sod);

        lblAdjustmentTitle = (TextView) findViewById(R.id.lblAdjustment);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            _Routeinfo  = bundle.getString("VAR_Routeinfo");
            lblAdjustmentTitle.setText(_Routeinfo + "  Adjustments");
        }

        listviewAdjustments = (ListView) findViewById(R.id.listviewAdjustments);
        listviewAdjustments.setAdapter(new MyCustomAdapter(this));
        listviewAdjustments.setOnItemClickListener(this);

        txtUPC = (TextView) findViewById(R.id.txtUPC);
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

    }

    public void nextScreen(View view)
    {
        Intent intent = new Intent(this, DialogBoxActivity.class);
        SODActivity.ViewHolder holder = (SODActivity.ViewHolder) view.getTag();
        SODActivity.SingleRowProduct singleRowProduct = (SODActivity.SingleRowProduct) holder.lblItemNoValue.getTag();
        intent.putExtra("VAR_ItemNo",singleRowProduct.productItemNo);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DialogBoxActivity.class);

        SODActivity.ViewHolder holder = (SODActivity.ViewHolder) view.getTag();
        SODActivity.SingleRowProduct singleRowProduct = (SODActivity.SingleRowProduct) holder.lblItemNoValue.getTag();

        intent.putExtra("VAR_ItemNo",singleRowProduct.productItemNo);

        startActivity(intent);
        //Toast.makeText(this, "Pos = " + position, Toast.LENGTH_LONG).show();

    }


    private void GetProduct(String companyCode, String upcCode) {
        boolean productFound = false;
        boolean priceFound = false;
        List<ProductDTO> anyProducts = new ArrayList<ProductDTO>();
        IProductDAO productDAO = new ProductDAO(SODActivity.this);
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
            IBasepriceDAO basepriceDAO = new BasepriceDAO(SODActivity.this);
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
        }
        else
        {
        }
    }


    class SingleRowProduct
    {
        String productDescription;
        String productUPC;
        String productItemNo;
        SingleRowProduct(String productDescription, String productUPC, String productItemNo)
        {
            this.productDescription = productDescription;
            this.productUPC = productUPC;
            this.productItemNo = productItemNo;
        }
    }
    class ViewHolder
    {
        TextView lblProdNameValue;
        TextView lblUPCValue;
        TextView lblItemNoValue;
        ViewHolder(View view)
        {
            lblProdNameValue = (TextView) view.findViewById(R.id.lblProdNameValue);
            lblUPCValue = (TextView) view.findViewById(R.id.lblUPCValue);
            lblItemNoValue = (TextView) view.findViewById(R.id.lblItemNoValue);
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
            List<ProductDTO> someProducts = new ArrayList<ProductDTO>();
            IProductDAO productDAO = new ProductDAO(ctx);
            String sql = "SELECT * FROM PRODUCT ORDER BY ITEM_NO ";
            someProducts = productDAO.getProductsByYourSQL(sql);
            productsCount = someProducts.size();

            for (ProductDTO aProduct : someProducts) {
                SingleRowProduct singleRowAdapter = new SingleRowProduct(aProduct.getPRODUCT_DESC(),aProduct.getCOMPANY_CODE()
                        + aProduct.getUPC_CODE(), aProduct.getITEM_NO());
                myList.add(singleRowAdapter);
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
                row = layoutInflater.inflate(R.layout.single_row_product, parent, false);
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
