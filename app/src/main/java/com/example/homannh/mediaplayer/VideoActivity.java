package com.example.homannh.mediaplayer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.homannh.appone.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView myPlayer;
    private Button btnHome;
    private MediaController myVideoController;
    private Uri videoLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        myPlayer = (VideoView) findViewById(R.id.videoView);
        btnHome = (Button) findViewById(R.id.btnHome);
        
        //videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.handimaui);
        myVideoController = new MediaController(this);
        
        setupMedia();
        setupListeners();

    }

    private void setupMedia() {
        myPlayer.setMediaController(myVideoController);
        myPlayer.setVideoURI(videoLocation);
    }


    private void setupListeners() {
        //btnHome.setOnClickListener(());
        //btnVideo.setOnClickListener(new View.OnClickListener()
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retunIntent = new Intent();
                setResult(RESULT_OK, retunIntent);
                finish();
            }
        });
    }









}
