package com.shadow.swipefeature;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                update();
            }
        });

        TextView helloText = findViewById(R.id.helloWorld);
        helloText.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                Snackbar.make(MainActivity.this.findViewById(R.id.swipeRefresh), "Left !!! ", Snackbar.LENGTH_SHORT).show();
                super.onSwipeLeft();

            }

            @Override
            public void onSwipeRight() {
                Snackbar.make(MainActivity.this.findViewById(R.id.swipeRefresh), "Right !!! ", Snackbar.LENGTH_SHORT).show();
                super.onSwipeRight();
            }

        });
    }

    private void update() {
        Snackbar.make(this.findViewById(R.id.swipeRefresh), "Refreshing !!! ", Snackbar.LENGTH_SHORT).show();

        swipeRefreshLayout.setRefreshing(false);

    }

}
