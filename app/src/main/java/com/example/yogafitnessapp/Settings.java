package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yogafitnessapp.adapter.CategorydetailAdapter;
import com.example.yogafitnessapp.adapter.Seetings1Adapter;
import com.example.yogafitnessapp.adapter.SeetingsAdapter;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.SettingsModel;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    TextView tv_friend;
    private SeetingsAdapter seetingsAdapter;
    private ArrayList<SettingsModel> settingsModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.ic_g8,
            R.drawable.ic_group_9,R.drawable.ic_group_10,
            R.drawable.ic_group_11};

    String[] tv_account={"Account","Notifications","Privacy","Clear Cache"};

    private RecyclerView recyclerView1;
    private Seetings1Adapter seetings1Adapter;

    Integer[] iv_profile1={R.drawable.ic_group_12,
            R.drawable.ic_group_13,R.drawable.ic_group_14};

    String[] tv_account1={"Language","Rate Us","About"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        tv_friend=findViewById(R.id.tv_friend);
        tv_friend.setText("Settings");

        recyclerView = findViewById(R.id.rv_settings);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Settings.this);
        recyclerView.setLayoutManager(layoutManager);

        settingsModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {
            SettingsModel view1 = new SettingsModel(iv_profile[i],tv_account[i]);
            settingsModelArrayList.add(view1);
        }
        seetingsAdapter = new SeetingsAdapter(Settings.this,settingsModelArrayList);
        recyclerView.setAdapter(seetingsAdapter);


        recyclerView1 = findViewById(R.id.rv_settings1);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Settings.this);
        recyclerView1.setLayoutManager(layoutManager1);

        settingsModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile1.length; i++) {
            SettingsModel view1 = new SettingsModel(iv_profile1[i],tv_account1[i]);
            settingsModelArrayList.add(view1);
        }
        seetings1Adapter = new Seetings1Adapter(Settings.this,settingsModelArrayList);
        recyclerView1.setAdapter(seetings1Adapter);
    }
}
