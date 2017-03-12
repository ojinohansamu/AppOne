package com.example.homannh.appone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.homannh.mediaplayer.PlayerListActivity;

public class MainMediaActivity extends AppCompatActivity {

    public static final String VAR_MEDIA_TYPE = "Var_MediaType";
    public static final String MP3 = ".mp3";
    public static final String VIDEO = ".mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_media);
    }


    public void btnOneClicked(View view){
        Intent playerListActivity = new Intent(MainMediaActivity.this, PlayerListActivity.class);
        playerListActivity.putExtra(VAR_MEDIA_TYPE, MP3);
        startActivity(playerListActivity);

    }

    public void btnTwoClicked(View view){
        Intent playerListActivity = new Intent(MainMediaActivity.this, PlayerListActivity.class);
        playerListActivity.putExtra(VAR_MEDIA_TYPE, VIDEO);
        startActivity(playerListActivity);
    }

    public void btnThreeClicked(View view){
        //Intent intent = new Intent(MainMediaActivity.this, MP3PlayerActivity.class);
        //startActivity(intent);
        notReadyMessage();

    }

    public void btnFourClicked(View view){
        notReadyMessage();

    }

    public void btnFiveClicked(View view){
        notReadyMessage();

    }

    public void btnSixClicked(View view){
        notReadyMessage();

    }

    public void notReadyMessage(){
        new MessagesDisplay(MainMediaActivity.this, "Not ready ..");
        MessagesDisplay.showMessage();
        //Toast.makeText(this, "Not ready yet!", Toast.LENGTH_LONG).show();
    }
}
