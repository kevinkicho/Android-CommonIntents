package com.example.kevin.commonIntents;

import android.app.SearchManager;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class GeneralLVActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        EditText mArtistName = (EditText) findViewById(R.id.edit_text_artist_name);

        final ListView listview = (ListView) findViewById(R.id.list_view_general);
        String[] values = getResources().getStringArray(R.array.generalActivities);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final GeneralLVArrayAdapter adapter = new GeneralLVArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        /* Intents */

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String arrayItem = values[position];

                switch (position) {
                    /*
                    <item>ACTION_SET_ALARM</item>
        <item>ACTION_SET_TIMER</item>
        <item>ACTION_SHOW_ALARMS</item>
        <item>ACTION_INSERT</item>
                    */
                    case 0:
                        // ACTION_SET_ALARM
                        createAlarm(9,0);
                        break;
                    case 1:
                        // ACTION_SET_TIMER
                        break;
                    case 2:
                        // ACTION_SHOW_ALARMS
                        showAlarms();
                        break;
                    case 3:
                        // ACTION_OPEN_DOCUMENT
                        selectImage();
                        break;
                    case 4:
                        // ACTION_VIEW
                        String s = mArtistName.getText().toString();
                        playSearchArtist(s);
                        break;
                }
            }
        });
    }
    /* PLAY_MEDIA_FROM_SEARCH */
    public void playSearchArtist(String artist) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
        intent.putExtra(SearchManager.QUERY, artist);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /* ACTION_OPEN_DOCUMENT */
    public void selectImage(){
        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        i.setType("image/*");
        i.addCategory(Intent.CATEGORY_OPENABLE);
        startActivity(i);
    }
    /* ACTION_SET_ALARM */
    public void createAlarm(int hour, int minutes) {
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
    /* ACTION_SET_TIMER */
    public void calendarIntent(String title, String loc, int year, int month, int date, int hour, int minute){
        Intent i = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();

        beginTime.set(year,month,date,hour,minute);
        endTime.set(year,month,date+1,0,0);
        i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        i.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        i.putExtra(CalendarContract.Events.TITLE,title);
        i.putExtra(CalendarContract.Events.EVENT_LOCATION, loc);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }
    public void startTimer(String message, int seconds){
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /* ACTION_SHOW_ALARM */
    public void showAlarms(){
        Intent i = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }
}
