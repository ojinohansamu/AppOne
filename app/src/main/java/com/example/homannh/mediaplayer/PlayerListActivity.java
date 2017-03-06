package com.example.homannh.mediaplayer;

/*
Late 03-05-2017
Updated to search MP3 or MP4 files according to the calling Activity, whether the user wants to
see the videos or listening to mp3 music files.
it calls two seperates activity depending on the file types mp3 or mp4
Wooo hoo... it works on my Samsung phone and also on my Galaxy tablet.
HOH 03-05-2017
MP3 Player based on the video
https://www.youtube.com/watch?v=aZiRJCWpFhE&list=PLEGVJUAXnipZcblF5zZBFuqMxPhPhR9GQ&index=4
 */

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.homannh.appone.R;

import java.io.File;
import java.util.ArrayList;

public class PlayerListActivity extends AppCompatActivity {
    public static final String VAR_POSITION = "Var_Position";

    public static final String VAR_MY_MEDIA_LIBRARY = "Var_myMediaLibrary";
    public static final String VAR_MEDIA_TYPE = "Var_MediaType";
    public static final String MP3 = ".mp3";
    public static final String VIDEO = ".mp4";

    private ListView lv;
    private String[] items;
    private Toolbar toolBar;
    private String mediaType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerlist);

        toolBar = (Toolbar) findViewById(R.id.toolbarLogIn);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!= null) {
            mediaType = bundle.getString(VAR_MEDIA_TYPE);
        }
        else {
            mediaType = MP3;
        }

        if(mediaType.equals(MP3))
            toolBar.setTitle("hhSongList");
        else
            toolBar.setTitle("hhVideolist");

        lv = (ListView) findViewById(R.id.lvPlayList);
        final ArrayList<File> myMediaLibrary = findSongs(Environment.getExternalStorageDirectory());
        items = new String[myMediaLibrary.size()];
        for(int i = 0; i < myMediaLibrary.size(); i++)
            items[i] = myMediaLibrary.get(i).getName();

        ArrayAdapter<String> adp = new ArrayAdapter<String> (PlayerListActivity.this, R.layout.song_layout, R.id.tvSong, items);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerActivity;
                if(mediaType.equals(MP3)) {
                    playerActivity = new Intent(getApplicationContext(), MP3PlayerActivity.class);
                }
                else {
                    playerActivity = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                }

                playerActivity.putExtra(VAR_POSITION, position);
                playerActivity.putExtra(VAR_MY_MEDIA_LIBRARY, myMediaLibrary);
                startActivity(playerActivity);
            }
        });

    }

    private ArrayList<File> findSongs(File root) {
        ArrayList<File> allMediafiles = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if(singleFile.isDirectory() && !singleFile.isHidden())
            {
                allMediafiles.addAll( findSongs(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(mediaType)){
                    allMediafiles.add(singleFile);
                }
            }
        }


        return allMediafiles;
    }
}
