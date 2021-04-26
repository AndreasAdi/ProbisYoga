package com.example.yogafitnessapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.model.WeightlossModel;
import com.example.yogafitnessapp.adapter.TopicAdapter;
import com.example.yogafitnessapp.adapter.WeightlossAdapter;
import com.example.yogafitnessapp.model.SettingsModel;

import java.util.ArrayList;


public class HealthTips extends Fragment {

    private WeightlossAdapter weightlossAdapter;
    private ArrayList<WeightlossModel> weightlossModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_weightloss={R.drawable.weightlose,R.drawable.weightlose
            ,R.drawable.weightlose,R.drawable.weightlose
            ,R.drawable.weightlose,R.drawable.weightlose};

    private TopicAdapter topicAdapter;
    private ArrayList<SettingsModel> settingsModelArrayList;
    private RecyclerView recyclerView1;

    Integer[] iv_profile={R.drawable.salad,R.drawable.salad
            ,R.drawable.salad,R.drawable.salad};

    String[] tv_account={"5 Easy Weeknight Dinners","15 Minute Yoga For Beginners 30 Day",
            "5 Easy Weeknight Dinners","15 Minute Yoga For Beginners 30 Day"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_healthtips, container, false);

        recyclerView =view.findViewById(R.id.rv_weightloss);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        weightlossModelArrayList = new ArrayList<>();
/*
        for (int i = 0; i < iv_weightloss.length; i++) {
            WeightlossModel view1 = new WeightlossModel(iv_weightloss[i]);
            weightlossModelArrayList.add(view1);
        }
        weightlossAdapter = new WeightlossAdapter(getContext(),weightlossModelArrayList);
        recyclerView.setAdapter(weightlossAdapter);


        recyclerView1 =view.findViewById(R.id.rv_topics);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getActivity(),2);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        settingsModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {

            SettingsModel view1 = new SettingsModel(iv_profile[i],tv_account[i]);
            settingsModelArrayList.add(view1);
        }
        topicAdapter = new TopicAdapter(getContext(),settingsModelArrayList);
        recyclerView1.setAdapter(topicAdapter);*/

        return view;
    }
}
