package com.example.kevin.commonIntents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class SettingLVActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final ListView listview = (ListView) findViewById(R.id.list_view_setting);
        String[] values = getResources().getStringArray(R.array.settingActivities);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final SettingLVArrayAdapter adapter = new SettingLVArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String arrayItem = values[position];
                switch (position) {
                    case 0:
                        // ACTION_WIFI_SETTINGS
                        openWifiSettings();
                        break;
                    case 1:
                        // ACTION_WIRELESS_SETTINGS
                        openWirelessSettings();
                        break;
                    case 2:
                        // ACTION_AIRPLANE_MODE_SETTINGS
                        openAMSettings();
                        break;
                    case 3:
                        // ACTION_SETTINGS
                        openSettings();
                        break;
                    case 4:
                        // ACTION_APN_SETTINGS
                        openAPNSettings();
                        break;
                    case 5:
                        // ACTION_BLUETOOTH_SETTINGS
                        openBlueToothSettings();
                        break;
                    case 6:
                        // ACTION_DATE_SETTINGS
                        dateSettings();
                        break;
                    case 7:
                        // ACTION_LOCALE_SETTINGS
                        localeSettings();
                        break;
                    case 8:
                        // ACTION_INPUT_METHOD_SETTINGS
                        inputMethodSettings();
                        break;
                    case 9:
                        // ACTION_DISPLAY_SETTINGS
                        displaySettings();
                        break;
                    case 10:
                        // ACTION_SECURITY_SETTINGS
                        securitySettings();
                        break;
                    case 11:
                        // ACTION_LOCATION_SOURCE_SETTINGS
                        locationSourceSettings();
                        break;
                    case 12:
                        // ACTION_INTERNAL_STORAGE_SETTINGS
                        internalStorageSettings();
                        break;
                    case 13:
                        // ACTION_MEMORY_CARD_SETTINGS
                        memoryCardSettings();
                        break;
                }
            }
        });
    }
    /* ACTION_WIFI_SETTINGS */
    public void openWifiSettings(){
        Intent i = new Intent(Settings.ACTION_WIFI_SETTINGS);
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
    /* ACTION_SETTINGS */
    public void openSettings(){
        Intent i = new Intent(Settings.ACTION_SETTINGS);
        if(i.resolveActivity(getPackageManager())!= null){
            startActivity(i);
        }
    }
    /* ACTION_AIRPLANE_MODE_SETTINGS */
    public void openAMSettings(){
        Intent i = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_WIRELESS_SETTINGS */
    public void openWirelessSettings(){
        Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_APN_SETTINGS */
    public void openAPNSettings(){
        Intent i = new Intent(Settings.ACTION_APN_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_BLUETOOTH_SETTINGS */
    public void openBlueToothSettings(){
        Intent i = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_DATE_SETTINGS */
    public void dateSettings(){
        Intent i = new Intent(Settings.ACTION_DATE_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_LOCALE_SETTINGS */
    public void localeSettings(){
        Intent i = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_INPUT_METHOD_SETTINGS */
    public void inputMethodSettings(){
        Intent i = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_DISPLAY_SETTINGS */
    public void displaySettings(){
        Intent i = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_SECURITY_SETTINGS */
    public void securitySettings(){
        Intent i = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_LOCATION_SOURCE_SETTINGS */
    public void locationSourceSettings(){
        Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_INTERNAL_STORAGE_SETTINGS */
    public void internalStorageSettings(){
        Intent i = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
    /* ACTION_MEMORY_CARD_SETTINGS */
    public void memoryCardSettings(){
        Intent i = new Intent(Settings.ACTION_MEMORY_CARD_SETTINGS);
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
}
