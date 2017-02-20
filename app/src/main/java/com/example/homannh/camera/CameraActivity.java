package com.example.homannh.camera;
/*
  H. Homann 02-20-2017
  update it to save the picture to the SD_Card intstead of display it to the screen as video below
  https://www.youtube.com/watch?v=IMomzqwTuKA

  02-20-2017
  Added this camera to take picture and display it on the screen - works as from this video below
  https://www.youtube.com/watch?v=QIbOBrO9OEA
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.homannh.appone.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 10;
    public static final String pictureFileType = ".jpg";
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

        //Note: Somehow this update below does not work, because it tries to save it in /storage/emulated/0/pictures
        //   but if I generate the release apk, it will not install to the device. So I commented those lines below for now, just display it to the screen.
      /*
        // Start H. Homann 02-20-2017 Save to SD card
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        String pictureName = getPictureName();

        //Toast.makeText(this, "Dir= " + pictureDirectory + "\nname= " + pictureName, Toast.LENGTH_LONG).show();
        File imageFile = new File(pictureDirectory + pictureName);
        // now we have to convert this file imageFile to Uri otherwise Android will not understand
        Uri pictureUri = Uri.fromFile(imageFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
        // End H. Homann 02-20-2017 Save to SD card

       */
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    /* // H. Homann 02-20-2017 Save to SD card
    this to generate the file name based on the time stamp and applicationName
     */
    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());

        return "HOH" + timestamp + pictureFileType;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the user press ok after taking picture
        if(resultCode == RESULT_OK) {
            // if the result is from camera request
            if (requestCode == CAMERA_REQUEST) {

                // Start H. Homann 02-20-2017 Save to SD card
                //Since we are storing the picture to the SD card, we have to comment two lines below.
                //The reason is. Android can only allow you either to display or to save, not both.
                //Otherwise this nex line below will get null pointer, after saving it to the SD card.
                /*
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                imgPicture.setImageBitmap(cameraImage);
                //End H. Homann 02-20-2017 Save to SD card
                */

                //Note I uncommented those two lines above as new lines below, since saving to sd has problem. see Note above
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                imgPicture.setImageBitmap(cameraImage);
            }
        }
    }
}
