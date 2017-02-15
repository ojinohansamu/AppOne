package com.example.homannh.appone;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by homannh on 2/14/2017.
 */

public class MessagesDisplay {

    private  static Context context;
    private  static String message;
    public MessagesDisplay(Context context1, String msg){
        context = context1;
        message = msg;

    }
    public  static void  showMessage(){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


}
