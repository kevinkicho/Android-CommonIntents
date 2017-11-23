package com.example.kevin.commonIntents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.list_view_main);
        String[] values = getResources().getStringArray(R.array.myStringArray);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final MainActivityAdapter adapter = new MainActivityAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Phone
                        startPhoneLV(view);
                        break;
                    case 1:
                        // Web
                        startWebLV(view);
                        break;
                    case 2:
                        // Setting
                        startSettingLV(view);
                        break;
                    case 3:
                        // Alarm, Note, Storage
                        startGeneralLV(view);
                        break;
                    case 4:
                        // Camera, Video
                        startCameraLV(view);
                        break;
                    case 5:
                        // Map
                        startMapLV(view);
                        break;
                    case 6:
                        // Contacts
                        startContactsLV(view);
                        break;
                    case 7:
                        // Calendar
                        startCalendarLV(view);
                        break;
                }
            }
        });
    }
    public void startPhoneLV(View view){
        Intent i = new Intent(this, PhoneLVActivity.class);
        startActivity(i);
    }
    public void startWebLV(View view){
        Intent i = new Intent(this, WebLVActivity.class);
        startActivity(i);
    }
    public void startSettingLV(View view){
        Intent i = new Intent(this, SettingLVActivity.class);
        startActivity(i);
    }
    public void startGeneralLV(View view){
        Intent i = new Intent(this, GeneralLVActivity.class);
        startActivity(i);
    }
    public void startCameraLV(View view){
        Intent i = new Intent(this, CameraLVActivity.class);
        startActivity(i);
    }
    public void startCalendarLV(View view){
        Intent i = new Intent(this, CalendarLVActivity.class);
        startActivity(i);
    }
    public void startMapLV(View view){
        Intent i = new Intent(this, MapLVActivity.class);
        startActivity(i);
    }
    public void startContactsLV(View view){
        Intent i = new Intent(this, ContactsLVActivity.class);
        startActivity(i);
    }
}
