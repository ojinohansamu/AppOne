package com.example.homannh.mediaplayer;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.homannh.appone.R;

import java.io.File;
import java.util.ArrayList;


public class Gallery extends AppCompatActivity {

    private GridView gridView;
    ArrayList<File> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String FilePath = Environment.getExternalStorageState() + "/picture";
        File file = Environment.getExternalStoragePublicDirectory("pictures");
        list = imageReader(file);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter());

    }

    class GridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.single_grid, parent, false);
            ImageView imageView = (ImageView) findViewById(R.id.imageView);

            imageView.setImageURI(Uri.parse(getItem(position).toString()));
            return convertView;
        }
    }

    ArrayList<File> imageReader(File root){
        ArrayList<File> allImages = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if(singleFile.isDirectory() && !singleFile.isHidden())
            {
                allImages.addAll( imageReader(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(".jpg")){
                    allImages.add(singleFile);
                }
            }
        }


        return allImages;
    }
}
