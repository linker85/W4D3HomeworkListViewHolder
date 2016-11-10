package com.example.com.w4d3homeworklistviewviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raul on 09/11/2016.
 *
 * ViewHolder is a pattern used to avoid calling “findViewById” every time the getView() method is called.
 * Imagine that you have a list with hundreds of rows, the “findViewById” will be called hundreds of times
 * and it’s not necessary, just bad for performance. So to increase the performance try to use the
 * ViewHolder pattern as much as possible.
 */
public class MyCustomAdapter extends BaseAdapter {
    private ArrayList<String> mListItems;
    private LayoutInflater mLayoutInflater;

    public MyCustomAdapter(Context context, ArrayList<String> arrayList){

        mListItems = arrayList;

        //get the layout inflater
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /*
    * This method represents how many items are in the list. It returns the number of the items.
    * */
    @Override
    public int getCount() {
        //getCount() represents how many items are in the list
        return mListItems.size();
    }

    @Override
    //get the data of an item from a specific position
    //i represents the position of the item in the list
    public Object getItem(int i) {
        return null;
    }

    @Override
    //get the position id of the item from the list
    public long getItemId(int i) {
        return 0;
    }

    /*
    * Here we handle the cells views.
    * This method is called when the ListView wants to display an item on the screen and not less than getCount().
    * For example we have 20 items, so getCount() will return the number 20 and only 3 items can be visible at a time
    * on the ListView because there is no more room then, getView will get called at first only 3-4 times and if the
    * user starts to scroll the list, getView is called again all the time the ListView needs to display a new item
    * on the screen.
    * */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // create a ViewHolder reference
        ViewHolder holder;

        //check to see if the reused view is null or not, if is not null then reuse it
        if (view == null) {
            holder = new ViewHolder();

            view = mLayoutInflater.inflate(R.layout.list_item, viewGroup, false);

            // get all views you need to handle from the cell and save them in the view holder
            holder.itemName = (TextView) view.findViewById(R.id.list_item_text_view);

            // save the view holder on the cell view to get it back latter
            view.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)view.getTag();
        }

        //get the string item from the position "position" from array list to put it on the TextView
        String stringItem = mListItems.get(position);
        if (stringItem != null) {
            //set the item name on the TextView
            holder.itemName.setText(stringItem);
        } else {
            // make sure that when you have an if statement that alters the UI, you always have an else that sets a default value back, otherwise you will find that the recycled items will have the same UI changes
            holder.itemName.setText("Unknown");
        }

        //this method must return the view corresponding to the data at the specified position.
        return view;

    }

    /**
     * Used to avoid calling "findViewById" every time the getView() method is called,
     * because this can impact to your application performance when your list is large
     */
    private class ViewHolder {

        protected TextView itemName;

    }
}