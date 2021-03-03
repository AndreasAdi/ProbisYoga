package com.example.yogafitnessapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.Settings;
import com.example.yogafitnessapp.adapter.Seetings1Adapter;
import com.example.yogafitnessapp.adapter.SeetingsAdapter;
import com.example.yogafitnessapp.model.SettingsModel;

import java.util.ArrayList;


public class Profile extends Fragment {

    private Seetings1Adapter seetings1Adapter;
    private ArrayList<SettingsModel> settingsModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.ic_group_15,
            R.drawable.ic_ability_test,R.drawable.ic_my_topics,
            R.drawable.ic_downloads_management};

    String[] tv_account={"Invite Friends","Ability Test","My Topics","Downloads Management"};


    private RecyclerView recyclerView1;
    Integer[] iv_profile1={R.drawable.ic_coupons,
            R.drawable.ic_faq_feedback,R.drawable.ic_give_the_gift_of_daily_yoga};

    String[] tv_account1={"Coupons","FAQ & Feedback","Give the Gift of Daily Yoga"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerView = view.findViewById(R.id.rv_settings);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        settingsModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {
            SettingsModel view1 = new SettingsModel(iv_profile[i],tv_account[i]);
            settingsModelArrayList.add(view1);
        }
        seetings1Adapter = new Seetings1Adapter(getContext(),settingsModelArrayList);
        recyclerView.setAdapter(seetings1Adapter);


        recyclerView1 = view.findViewById(R.id.rv_settings1);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(layoutManager1);

        settingsModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile1.length; i++) {
            SettingsModel view1 = new SettingsModel(iv_profile1[i],tv_account1[i]);
            settingsModelArrayList.add(view1);
        }
        seetings1Adapter = new Seetings1Adapter(getContext(),settingsModelArrayList);
        recyclerView1.setAdapter(seetings1Adapter);

        return view;
    }
}
