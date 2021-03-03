package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.yogafitnessapp.adapter.ViewpagerAdapter;

import me.relex.circleindicator.CircleIndicator;

public class Walkthrough extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ViewpagerAdapter view_pager_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        circleIndicator = (CircleIndicator) findViewById(R.id.circleindicator);
        view_pager_adapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(view_pager_adapter);
        circleIndicator.setViewPager(viewPager);
        view_pager_adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());


    }
}
