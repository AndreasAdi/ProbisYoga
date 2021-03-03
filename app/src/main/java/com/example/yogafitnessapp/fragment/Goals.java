package com.example.yogafitnessapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.CategoriesDetailSub2;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.ProfileModel;

import java.util.ArrayList;


public class Goals extends Fragment {


    private SubCategoryAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_profile={R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1
            ,R.drawable.yoga1,R.drawable.yoga1};

    String[] tv_name={"DAY 01","DAY 02","DAY 03"
            ,"DAY 04","DAY 05","DAY 06"};

    String[] tv_city={"Easy Yoga for Strength","Easy Yoga for Body Stretches","Easy Yoga for Neck & Back"
            ,"Easy Yoga for Strength","Easy Yoga for Body Stretches","Easy Yoga for Neck & Back"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_goals, container, false);

        recyclerView = view.findViewById(R.id.rv_schedule);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_profile.length; i++) {
            ProfileModel view1 = new ProfileModel(iv_profile[i],tv_name[i],tv_city[i]);
            profileModelArrayList.add(view1);
        }
        profileAdapter = new SubCategoryAdapter(getContext(),profileModelArrayList);
        recyclerView.setAdapter(profileAdapter);

        return view;
    }
}
