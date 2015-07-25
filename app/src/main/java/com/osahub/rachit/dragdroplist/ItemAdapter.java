package com.osahub.rachit.dragdroplist;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rachit on 21-07-2015.
 */
public class ItemAdapter extends ArrayAdapter<ItemPojo> {

    final int INVALID_ID = -1;

    HashMap<ItemPojo, Integer> mIdMap = new HashMap<ItemPojo, Integer>();

    LayoutInflater inflater;

    List<ItemPojo> itemPojoList = new ArrayList<>();

    public ItemAdapter(Activity activity, List<ItemPojo> objects) {
        super(activity, R.layout.item_layout, objects);
        itemPojoList = objects;
        inflater = activity.getWindow().getLayoutInflater();
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= mIdMap.size()) {
            return INVALID_ID;
        }
        ItemPojo item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public void remove(ItemPojo item) {
        super.remove(item);
        mIdMap.clear();
        itemPojoList.remove(item);
        for (int i = 0; i < itemPojoList.size(); ++i) {
            mIdMap.put(itemPojoList.get(i), i);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rootView = inflater.inflate(R.layout.item_layout, parent, false);
        TextView title = (TextView) rootView.findViewById(R.id.title);
        title.setText(itemPojoList.get(position).getTitle());
        TextView number = (TextView) rootView.findViewById(R.id.number);
        number.setText(String.valueOf(itemPojoList.get(position).getNum()));
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView);
        image.setImageBitmap(itemPojoList.get(position).getImage());
        return rootView;
    }
}
