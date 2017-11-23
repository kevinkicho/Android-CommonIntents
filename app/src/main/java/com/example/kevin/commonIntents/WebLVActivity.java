package com.example.kevin.commonIntents;

import android.app.SearchManager;
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

public class WebLVActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        EditText editText = (EditText) findViewById(R.id.edit_text_web_search);

        final ListView listview = (ListView) findViewById(R.id.list_View_web);
        String[] values = getResources().getStringArray(R.array.webActivities);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final WebLVArrayAdapter adapter = new WebLVArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // ACTION_WEB_SEARCH
                        String q = editText.getText().toString();
                        webSearch(q);
                        break;
                    case 1:
                        // ACTION_VIEW
                        openWebPage("cfmvw.com");
                        break;
                    case 2:
                        // ACTION_SENDTO || ACTION_SEND || ACTION_SEND_MULTIPLE (0,1,multiple attachments, respectively)
                        String[] addresses = {"sampleEmail@sample.com"};
                        Uri attachment = null;
                        composeEmail(addresses,"subject",null);
                        break;
                }
            }
        });
    }
    /* ACTION_SEND */
    public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /* ACTION_WEB_SEARCH */
    public void webSearch(String query){
        Intent web_search_i = new Intent(Intent.ACTION_WEB_SEARCH);
        web_search_i.putExtra(SearchManager.QUERY, query);
        startActivity(web_search_i);
    }
    /* ACTION_VIEW */
    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, webpage);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }
}
