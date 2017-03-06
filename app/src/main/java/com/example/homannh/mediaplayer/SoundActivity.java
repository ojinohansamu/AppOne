package com.example.homannh.mediaplayer;
/*
HOH 3-4-2017
This mp3 and video player based on this video
https://www.youtube.com/watch?v=whFVhvM-J0U

 */
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.homannh.appone.R;

public class SoundActivity extends AppCompatActivity implements Runnable{

    private Button btnStart;
    private Button btnPause;
    private Button btnStop;
    private Button btnVideo;
    private SeekBar soundSeekBar;
    private MediaPlayer soundPlayer;
    private Thread soundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        btnStart = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        soundSeekBar = (SeekBar) findViewById(R.id.soundSeekBar);
        btnVideo = (Button) findViewById(R.id.btnVideo);
        //soundPlayer = MediaPlayer.create(this.getBaseContext(), R.raw.sanfrancisco);

        setupListerners();

        soundThread = new Thread(this);
        soundThread.start();



    }

    private void setupListerners() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stop();
                //soundPlayer = MediaPlayer.create(getBaseContext(), R.raw.sanfrancisco);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View currentView) {
                Intent videoIntent = new Intent(currentView.getContext(), VideoActivity.class);
                startActivityForResult(videoIntent, 0);
            }
        });

        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    soundPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void run() {

        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();
        soundSeekBar.setMax(soundTotal);

        while (soundPlayer != null && currentPosition < soundTotal) {
            try {
                Thread.sleep(300);
                currentPosition = soundPlayer.getCurrentPosition();
            } catch (InterruptedException soundException) {
                return;
            } catch (Exception otherException) {
                return;
            }
            soundSeekBar.setProgress(currentPosition);
        }

    }
}








