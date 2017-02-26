package com.example.homannh.dsd.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductListView extends AppCompatActivity {

    private ListView listViewProducts;
    private Toolbar tooBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        tooBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        tooBar.setTitle("Products");

        listViewProducts.setAdapter(new MyCustomAdapter(this));
    }


    class SingleRow
    {
        String name;
        String address;
        SingleRow(String name, String address)
        {
            this.name = name;
            this.address = address;
        }

    }
    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<SingleRow> myList;
        Context ctx;

        MyCustomAdapter(Context context)
        {
            ctx = context;
            myList = new ArrayList<SingleRow>();
            List<ProductDTO> someProducts = new ArrayList<ProductDTO>();
            IProductDAO productDAO = new ProductDAO(ctx);
            String sql = "SELECT * FROM PRODUCT ORDER BY ITEM_NO ";
            someProducts = productDAO.getProductsByYourSQL(sql);

            for (ProductDTO aProduct : someProducts) {
                SingleRow singleRowAdapter = new SingleRow("UPC: " + aProduct.getCOMPANY_CODE() + aProduct.getUPC_CODE() + "   " + aProduct.getPRODUCT_DESC(),
                        "ITEM: " + aProduct.getITEM_NO());
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

            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.single_row, parent, false);
            TextView lblName = (TextView) row.findViewById(R.id.lblName);
            TextView lblAddress = (TextView) row.findViewById(R.id.lblAddress);

            SingleRow singleRow = myList.get(position);
            lblName.setText(singleRow.name);
            lblAddress.setText(singleRow.address);
            return row;
        }
    }
}
