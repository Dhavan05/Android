package com.shadow.recyclercarousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> allItems = new ArrayList<>();

//        allItems.add(-1);

        allItems.add(R.mipmap.one_f);
        allItems.add(R.mipmap.two_f);
        allItems.add(R.mipmap.three_f);

//        allItems.add(-1);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        final ItemAdapter itemAdapter = new ItemAdapter(allItems);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                // Call smooth scroll
                recyclerView.smoothScrollToPosition(2);
            }
        });
    }
}
