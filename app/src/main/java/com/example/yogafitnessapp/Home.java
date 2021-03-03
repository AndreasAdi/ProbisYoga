package com.example.yogafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.yogafitnessapp.fragment.Goals;
import com.example.yogafitnessapp.fragment.HealthTips;
import com.example.yogafitnessapp.fragment.News;
import com.example.yogafitnessapp.fragment.Profile;
import com.example.yogafitnessapp.fragment.Training;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       /* loadFragment(new Training());*/

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        navigation.setSelectedItemId(R.id.bottomNavigationClockMenuId);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {

    /*        case R.id.bottomNavigationAlarmMenuId:
                fragment = new News();
                break;*/

            case R.id.bottomNavigationClockMenuId:
                fragment = new Training();
                break;

          /*  case R.id.bottomNavigationTimerMenuId:
                fragment = new HealthTips();
                break;*/

            case R.id.bottomNavigationStopWatchMenuId:
                fragment = new Goals();
                break;

            case R.id.bottomNavigationStopWatchProfileId:
                fragment = new Profile();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentLoad, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
