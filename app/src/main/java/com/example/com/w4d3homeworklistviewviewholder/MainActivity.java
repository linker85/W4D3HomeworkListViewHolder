package com.example.com.w4d3homeworklistviewviewholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList();

        //for simplicity we will add the same name for 20 times to populate the list view
        for (int i = 0; i < 200; i++) {
            list.add("Diana" + i);
        }

        //relate the listView from java to the one created in xml
        myList = (ListView) findViewById(R.id.list);

        //show the ListView on the screen
        // The adapter MyCustomAdapter is responsible for maintaining the data backing this list and for producing
        // a view to represent an item in that data set.
        myList.setAdapter(new MyCustomAdapter(MainActivity.this, list));

    }

}
