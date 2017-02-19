package com.example.homannh.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.homannh.appone.R;

public class CameraActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 10;
    private ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imgPicture = (ImageView) findViewById(R.id.imgPicture);
    }

    public void btnTakePhotoOnClicked(View view)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the user press ok after taking picture
        if(resultCode == RESULT_OK) {
            // if the result is from camera request
            if (requestCode == CAMERA_REQUEST) {

                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                imgPicture.setImageBitmap(cameraImage);
            }
        }
    }
}
