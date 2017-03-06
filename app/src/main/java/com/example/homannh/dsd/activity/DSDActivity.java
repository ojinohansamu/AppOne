package com.example.homannh.dsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homannh.appone.MainActivity;
import com.example.homannh.appone.R;
import com.example.homannh.dsd.bll.RouteInfoSER;
import com.example.homannh.dsd.dao.IRouteDAO;
import com.example.homannh.dsd.dao.RouteDAO;
import com.example.homannh.dsd.dto.RouteDTO;

import java.util.ArrayList;
import java.util.List;

public class DSDActivity extends AppCompatActivity {

    public static final String _VAR_RouteinfoTag = "VAR_Routeinfo";
    private TextView lblUserValue;
    private TextView txtUserPassword;
    private String marketRouteID = "";
    private String routeID = "";
    private Toolbar toolBar;
    private RouteDTO _route;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsd);
        lblUserValue = (TextView) findViewById(R.id.lblUserValue);
        txtUserPassword = (TextView) findViewById(R.id.txtPassword);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        toolBar.setTitle("D.S.D. xlPlus");
        HouseKeeping();
        lblUserValue.setText(marketRouteID);

    }

    private void HouseKeeping() {
        if(CheckRouteTable())
        {
            Intent prepareDB = new Intent(this, HHActivity.class);
            prepareDB.putExtra("VAR_From", 1);
            startActivity(prepareDB);
        }
    }

    public void btnExitOnClicked(View view){
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

    public void btnLoginOnClicked(View view){
        if(password.equals(txtUserPassword.getText().toString())) {
            Intent dsdMainMenuActivity = new Intent(this, DSDMainMenuActivity.class);
            RouteInfoSER _routeInfo = new RouteInfoSER();
            _routeInfo.setMARKET_ID( _route.getMARKET_ID());
            _routeInfo.setROUTE_ID(_route.getROUTE_ID());
            _routeInfo.setROUTE_TYPE(_route.getROUTE_TYPE());
            _routeInfo.setROUTE_NAME(_route.getROUTE_NAME());
            _routeInfo.setDNL_DATE(_route.getDNL_DATE());
            dsdMainMenuActivity.putExtra(_VAR_RouteinfoTag, _routeInfo);
            startActivity(dsdMainMenuActivity);
        }
        else
        {
            Toast.makeText(this, "Invalid Password!", Toast.LENGTH_SHORT).show();
            txtUserPassword.setText("");
        }
    }

    public boolean CheckRouteTable(){
        //Read Route
        boolean needDB = false;
        List<RouteDTO> allroutes = new ArrayList<RouteDTO>();
        IRouteDAO routeDAO = new RouteDAO(DSDActivity.this);

        //routeDAO.initRoute(DSDActivity.this);
        routeDAO.isRouteTable();
        if(routeDAO.countRoute()>0)
        {
            allroutes = routeDAO.fetchRoutes("");
            for (RouteDTO aRoute : allroutes)
            {
                marketRouteID = aRoute.getMARKET_ID().toString() + aRoute.getROUTE_ID();
                routeID = aRoute.getROUTE_ID();
                _route = aRoute;
                break;
            }
            password = new StringBuilder(routeID).reverse().toString();
            needDB = false;
        }
        else
        {
            needDB = true;
        }


        return needDB;
     }

}
