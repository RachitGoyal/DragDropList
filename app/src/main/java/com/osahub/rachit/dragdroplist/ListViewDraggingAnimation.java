package com.osahub.rachit.dragdroplist;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDraggingAnimation extends Activity {

    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<ItemPojo> itemList = new ArrayList<>();

        ItemPojo itemPojo1 = new ItemPojo("Name", (int) (Math.random() * 100), BitmapFactory.decodeResource(getResources(), R.drawable.test1));
        ItemPojo itemPojo2 = new ItemPojo("Name", (int) (Math.random() * 100), BitmapFactory.decodeResource(getResources(), R.drawable.test2));
        ItemPojo itemPojo3 = new ItemPojo("Name", (int) (Math.random() * 100), BitmapFactory.decodeResource(getResources(), R.drawable.test3));
        ItemPojo itemPojo4 = new ItemPojo("Name", (int) (Math.random() * 100), BitmapFactory.decodeResource(getResources(), R.drawable.test4));
        ItemPojo itemPojo5 = new ItemPojo("Name", (int) (Math.random() * 100), BitmapFactory.decodeResource(getResources(), R.drawable.test5));
        itemList.add(itemPojo1);
        itemList.add(itemPojo2);
        itemList.add(itemPojo3);
        itemList.add(itemPojo4);
        itemList.add(itemPojo5);

        adapter = new ItemAdapter(this, itemList);
        DynamicListView listView = (DynamicListView) findViewById(R.id.listview);

        listView.setCheeseList(itemList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        listView,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    adapter.remove(adapter.getItem(position));
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });
        listView.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        listView.setOnScrollListener(touchListener.makeScrollListener());
    }
}
