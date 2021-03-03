package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.yogafitnessapp.fragment.Discount;
import com.example.yogafitnessapp.fragment.Master;
import com.example.yogafitnessapp.fragment.Training;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Profile_Coupon_Voucher extends AppCompatActivity {


    private TabLayout tabLayout1;
    private Temp viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__coupon__voucher);

        viewPager = findViewById(R.id.viewpager1);
        setupViewPager(viewPager);

        tabLayout1 = findViewById(R.id.tablayout1);
        tabLayout1.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter1 adapter = new ViewPagerAdapter1(getSupportFragmentManager());
        adapter.addFragment(new Discount(), "Disscounts");
        adapter.addFragment(new Discount(), "Vouchers");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter1 extends FragmentPagerAdapter {
        private final java.util.List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter1(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
