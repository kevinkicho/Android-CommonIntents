package com.example.kevin.commonIntents;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kevin on 2017-11-22.
 */

public class GeneralLVArrayAdapter extends ArrayAdapter<String>{
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public GeneralLVArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public GeneralLVArrayAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public GeneralLVArrayAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    public GeneralLVArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    /* Example */
    public GeneralLVArrayAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        for (int i = 0; i< objects.size(); ++i){
            mIdMap.put(objects.get(i), i);
        }
    }

    public GeneralLVArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
