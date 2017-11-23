package com.example.kevin.commonIntents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class CameraLVActivity extends AppCompatActivity {
    //static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final int REQUEST_VIDEO_CAPTURE = 1;
    //static final Uri mLocationForPhotos;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        final ListView listview = (ListView) findViewById(R.id.list_view_camera);
        String[] values = getResources().getStringArray(R.array.cameraActivities);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final GeneralLVArrayAdapter adapter = new GeneralLVArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String arrayItem = values[position];

                switch (position) {
                    case 0:
                        // ACTION_STILL_IMAGE_CAMERA
                        capturePhoto();
                        break;
                    case 1:
                        // ACTION_VIDEO_CAPTURE
                        recordVideo();
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
    /* INTENT_ACTION_STILL_IMAGE_CAMERA */
    public void capturePhoto() {
        Intent i = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
    /* INTENT_ACTION_VIDEO_CAMERA */
    public void recordVideo() {
        Intent i = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
    /*public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
    public void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(takeVideoIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK){
            Uri videoUri = intent.getData();
            mVideoView.setVideoURI(videoUri);
        }
    }*/
}
