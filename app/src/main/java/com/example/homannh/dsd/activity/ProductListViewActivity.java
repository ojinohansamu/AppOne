package com.example.homannh.dsd.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.homannh.appone.R;
import com.example.homannh.dsd.dao.IProductDAO;
import com.example.homannh.dsd.dao.ProductDAO;
import com.example.homannh.dsd.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        listViewProducts.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DialogBoxActivity.class);

        ViewHolder holder = (ViewHolder) view.getTag();
        SingleRowProduct singleRowProduct = (SingleRowProduct) holder.lblItemNoValue.getTag();

        intent.putExtra("VAR_ItemNo",singleRowProduct.productItemNo);

        startActivity(intent);
        //Toast.makeText(this, "Pos = " + position, Toast.LENGTH_LONG).show();

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
        ArrayList<SingleRowProduct> myList;
        Context ctx;

        MyCustomAdapter(Context context)
        {
            ctx = context;
            myList = new ArrayList<SingleRowProduct>();
            List<ProductDTO> someProducts = new ArrayList<ProductDTO>();
            IProductDAO productDAO = new ProductDAO(ctx);
            String sql = "SELECT * FROM PRODUCT ORDER BY ITEM_NO ";
            someProducts = productDAO.getProductsByYourSQL(sql);

            for (ProductDTO aProduct : someProducts) {
                SingleRowProduct singleRowAdapter = new SingleRowProduct(aProduct.getPRODUCT_DESC(),aProduct.getCOMPANY_CODE() + aProduct.getUPC_CODE(), aProduct.getITEM_NO());
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
            ViewHolder viewHolder = null;
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
