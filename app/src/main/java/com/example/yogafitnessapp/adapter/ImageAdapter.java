package com.example.yogafitnessapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.yogafitnessapp.fragment.ImageViewpager;
import com.example.yogafitnessapp.fragment.Viewpager1;
import com.example.yogafitnessapp.fragment.Viewpager2;
import com.example.yogafitnessapp.fragment.Viewpager3;

public class ImageAdapter extends FragmentStatePagerAdapter {

    public ImageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ImageViewpager tab1 = new ImageViewpager();
                return tab1;
            case 1:
                ImageViewpager tab2 = new ImageViewpager();
                return tab2;

            case 2:
                ImageViewpager tab3 = new ImageViewpager();
                return tab3;

                default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}







