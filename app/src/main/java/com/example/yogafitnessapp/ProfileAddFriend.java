package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;

public class ProfileAddFriend extends AppCompatActivity {

    private ProfileAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.profile,R.drawable.profile
    ,R.drawable.profile,R.drawable.profile
            ,R.drawable.profile,R.drawable.profile,
            R.drawable.profile};

    String[] tv_name={"LeDae Anderson","Priscilla","Dextrad"
            ,"Elaineelaine","Vincent","Carrycarrie","Melissa"};

    String[] tv_city={"Becrlin, Germany","Chicago, USA","Chicago, USA"
            ,"Augsburg, Germany","Bordeaux , France","Chicago, USA","Augsburg, Germany"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_add_friend);

        recyclerView = findViewById(R.id.rv_profile);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProfileAddFriend.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

//        for (int i = 0; i < iv_profile.length; i++) {
//            ProfileModel view1 = new ProfileModel(iv_profile[i],tv_name[i],tv_city[i]);
//            profileModelArrayList.add(view1);
//        }
//        profileAdapter = new ProfileAdapter(ProfileAddFriend.this,profileModelArrayList);
//        recyclerView.setAdapter(profileAdapter);
    }
}
