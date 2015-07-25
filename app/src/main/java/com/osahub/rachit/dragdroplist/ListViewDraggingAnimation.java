package com.osahub.rachit.dragdroplist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDraggingAnimation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<ItemPojo> mCheeseList = new ArrayList<>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            ItemPojo itemPojo = new ItemPojo(Cheeses.sCheeseStrings[i], (int) (Math.random() * 100));
            mCheeseList.add(itemPojo);
        }

        ItemAdapter adapter = new ItemAdapter(this, mCheeseList);
        DynamicListView listView = (DynamicListView) findViewById(R.id.listview);

        listView.setCheeseList(mCheeseList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
