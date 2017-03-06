package com.example.homannh.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.example.homannh.appone.R;

import java.io.File;
import java.util.ArrayList;

public class VideoPlayerActivity extends AppCompatActivity {
    public static final String VAR_POSITION = "Var_Position";
    public static final String VAR_MY_MEDIA_LIBRARY = "Var_myMediaLibrary";
    private MediaController myVideoController;

    ArrayList<File> myVideoLibrary;
    int position = 0;
    Uri videoLocation;
    private SeekBar seekBar;
    private VideoView myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        myPlayer = (VideoView) findViewById(R.id.vvPlayer);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        myVideoLibrary = (ArrayList) bundle.getParcelableArrayList(VAR_MY_MEDIA_LIBRARY);
        position = bundle.getInt(VAR_POSITION, 0);

        videoLocation = Uri.parse(myVideoLibrary.get(position).toString());
        myVideoController = new MediaController(this);
        setupMedia();
    }

    private void setupMedia() {
        myPlayer.setMediaController(myVideoController);
        myPlayer.setVideoURI(videoLocation);
        myPlayer.start();
    }

}
