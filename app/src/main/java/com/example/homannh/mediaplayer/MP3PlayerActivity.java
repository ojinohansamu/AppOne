package com.example.homannh.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.homannh.appone.R;

import java.io.File;
import java.util.ArrayList;

public class MP3PlayerActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String VAR_POSITION = "Var_Position";
    public static final String VAR_MY_MEDIA_LIBRARY = "Var_myMediaLibrary";
    static MediaPlayer mp;
    ArrayList<File> mySongLibrary;
    int position = 0;
    Uri uri;
    //Thread updateSeekBar;
    static seekUpdater su;

    private SeekBar seekBar;
    private Button btnPlay;
    private Button btnFB;
    private Button btnFF;
    private Button btnLast;
    private Button btnNext;
    private TextView tvSongName;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3player);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        toolBar.setTitle(R.string.lblMP3Player);

        tvSongName = (TextView) findViewById(R.id.tvSongName);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnFB = (Button) findViewById(R.id.btnFB);
        btnFF = (Button) findViewById(R.id.btnFF);
        btnLast = (Button) findViewById(R.id.btnLast);
        btnNext = (Button) findViewById(R.id.btnNext);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        btnPlay.setOnClickListener(this);
        btnFB.setOnClickListener(this);
        btnFF.setOnClickListener(this);
        btnLast.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        if(mp !=null){
            if(su!=null){
                su.endthread();
                su.interrupt();
                su=null;
            }
            mp.stop();
            mp.release();
        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        mySongLibrary = (ArrayList) bundle.getParcelableArrayList(VAR_MY_MEDIA_LIBRARY);
        position = bundle.getInt(VAR_POSITION, 0);

        uri = Uri.parse(mySongLibrary.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(), uri);
        mp.start();

        tvSongName.setText(mySongLibrary.get(position).getName());
        seekBar.setMax(mp.getDuration());

        su = new seekUpdater(true);
        su.start();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });
    }

    @Override
    public void onClick(View v) {
        int btnID = v.getId();
        switch (btnID) {
            case R.id.btnPlay:
                if (mp.isPlaying()) {
                    btnPlay.setText(R.string.lblPlay);
                    mp.pause();
                } else {
                    btnPlay.setText(R.string.lblPause);
                    mp.start();
                }
                break;
            case R.id.btnFF:
                mp.seekTo(mp.getCurrentPosition() + 5000);
                break;
            case R.id.btnFB:
                mp.seekTo(mp.getCurrentPosition() - 5000);
                break;
            case R.id.btnNext:
                if(su!=null)
                {
                    su.endthread();
                    su.interrupt();
                    su=null;
                }
                mp.stop();
                mp.release();
                    //updateSeekBar.interrupt();

                position++;
                if (position >= mySongLibrary.size())
                    position = 0;
                uri = Uri.parse(mySongLibrary.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), uri);
                mp.start();
                tvSongName.setText(mySongLibrary.get(position).getName());
                seekBar.setMax(mp.getDuration());
                seekBar.setProgress(mp.getCurrentPosition());
                su = new seekUpdater(true);
                su.start();

                break;
            case R.id.btnLast:
                if (su != null) {

                    su.endthread();
                    su.interrupt();
                    su = null;
                }
                mp.stop();
                mp.release();
                position--;
                if (position < 0)
                    position = mySongLibrary.size() - 1;
                uri = Uri.parse(mySongLibrary.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), uri);
                mp.start();
                tvSongName.setText(mySongLibrary.get(position).getName());
                seekBar.setMax(mp.getDuration());
                seekBar.setProgress(mp.getCurrentPosition());
                su = new seekUpdater(true);
                su.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(su!= null)
        {
            su.endthread();
            su.interrupt();
            su = null;
        }
        super.onBackPressed();
    }

    class seekUpdater extends Thread{
        private boolean running;
        seekUpdater(boolean status){
            running=status;
        }

        public void endthread(){
            running = false;
        }

        @Override
        public void run() {
            try {
                while (running==true) {
                    int dur = mp.getDuration();
                    int cur = mp.getCurrentPosition();
                    while (cur < dur) {
                        sleep(500);
                        cur = mp.getCurrentPosition();
                        seekBar.setProgress(cur);
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
                running=false;
            }
            //super.run();
        }
    }
}
