package com.example.kevin.commonIntents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class MapLVActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        EditText mMapEntry = (EditText) findViewById(R.id.edit_text_map_entry);

        final ListView listview = (ListView) findViewById(R.id.list_view_map);
        String[] values = getResources().getStringArray(R.array.mapActivities);

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
                        // ACTION_VIEW
                        String loc = mMapEntry.getText().toString();
                        removeSpaces(loc);
                        mapIt(loc);
                        break;
                }
            }
        });
    }
    /* ACTION_VIEW */
    public void mapIt(String lat, String lon){
        Uri geo = Uri.parse("geo:" + lat + "," + lon);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(geo);
        startActivity(i);
    }
    public void mapIt(String address){
        Uri geo = Uri.parse("geo:0,0?q="+address);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(geo);
        startActivity(i);
    }
    public String removeSpaces(String s){
        s =s.replace(" ","+");
        s = s.trim();
        return s;
    }
}
