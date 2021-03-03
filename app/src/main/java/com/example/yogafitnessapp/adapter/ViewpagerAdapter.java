package com.example.yogafitnessapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.yogafitnessapp.fragment.Viewpager1;
import com.example.yogafitnessapp.fragment.Viewpager2;
import com.example.yogafitnessapp.fragment.Viewpager3;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Viewpager1 tab1 = new Viewpager1();
                return tab1;
            case 1:
                Viewpager2 tab2 = new Viewpager2();
                return tab2;

            case 2:
                Viewpager3 tab3 = new Viewpager3();
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







