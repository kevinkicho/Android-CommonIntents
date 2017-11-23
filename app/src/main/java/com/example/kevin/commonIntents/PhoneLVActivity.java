package com.example.kevin.commonIntents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class PhoneLVActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        final ListView listview = (ListView) findViewById(R.id.list_view_phone);
        String[] values = getResources().getStringArray(R.array.phoneActivities);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final PhoneLVArrayAdapter adapter = new PhoneLVArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String arrayItem = values[position];

                switch (position) {
                    case 0:
                        phoneDial();
                        break;
                    case 1:
                        phoneDialNumber("111111111");
                        break;
                    case 2:
                        smsSend("sample message",Uri.parse(""));
                        break;
                }
            }
        });
    }
    /* ACTION_DIAL */
    public void phoneDial(){
        Intent i = new Intent(Intent.ACTION_DIAL);
        startActivity(i);
    }
    /* ACTION_DIAL */
    public void phoneDialNumber(String number){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + number));
        if(i.resolveActivity(getPackageManager()) != null)
            startActivity(i);
    }
    /* ACTION_SEND */
    public void smsSend(String message, Uri attachment){
        // Compose an SMS/MMS message with attachment
        // ACTION_SENDTO, ACTION_SEND, ACTION_SEND_MULTIPLE
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("smsto:"));
        i.putExtra("sms_body",message);
        i.putExtra(Intent.EXTRA_STREAM, attachment);
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}
