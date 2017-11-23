package com.example.kevin.commonIntents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kevin on 2017-11-22.
 */

public class ContactsLVActivity extends AppCompatActivity {
    static final int REQUEST_SELECT_CONTACT = 1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        final ListView listview = (ListView) findViewById(R.id.list_view_contacts);
        String[] values = getResources().getStringArray(R.array.contactsActivities);

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
                        // ACTION_PICK
                        selectContact();
                        break;
                    case 1:
                        // ACTION_VIEW
                        //viewContact();
                        break;
                    case 2:
                        // ACTION_INSERT
                        insertContact("sample_name","sampleEmail@email.com");
                        break;
                }
            }
        });
    }
    /* Insert Contact */
    public void insertContact(String name, String email){
        Intent i = new Intent(Intent.ACTION_INSERT);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        i.putExtra(ContactsContract.Intents.Insert.NAME, name);
        i.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }
    /* View Contact */
    public void viewContact(Uri contactUri) {
        Intent i = new Intent(Intent.ACTION_VIEW, contactUri);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
    /* Select Contact */
    public void selectContact(){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK){
            Uri contactUri = data.getData();
        }
    }*/
}
