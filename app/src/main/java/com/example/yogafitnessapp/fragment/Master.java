package com.example.yogafitnessapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.adapter.CoursesAdapter;
import com.example.yogafitnessapp.adapter.ProgramAdapter;
import com.example.yogafitnessapp.adapter.WeightlossAdapter;
import com.example.yogafitnessapp.model.WeightlossModel;

import java.util.ArrayList;


public class Master extends Fragment {

    private CoursesAdapter coursesAdapter;
    private ArrayList<WeightlossModel> weightlossModelArrayList;
    private RecyclerView recyclerView;

    Integer[] iv_weightloss={R.drawable.yoga_poses,R.drawable.yoga_poses
            ,R.drawable.yoga_poses};

    private RecyclerView recyclerView1;
    private ProgramAdapter programAdapter;

    Integer[] iv_weightloss1={R.drawable.program_master,R.drawable.program_master1};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_master, container, false);

        recyclerView =view.findViewById(R.id.rv_courses);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        weightlossModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_weightloss.length; i++) {
            WeightlossModel view1 = new WeightlossModel(iv_weightloss[i]);
            weightlossModelArrayList.add(view1);
        }
        coursesAdapter = new CoursesAdapter(getContext(),weightlossModelArrayList);
        recyclerView.setAdapter(coursesAdapter);


        recyclerView1 =view.findViewById(R.id.rv_program);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        weightlossModelArrayList = new ArrayList<>();

        for (int i = 0; i < iv_weightloss1.length; i++) {
            WeightlossModel view1 = new WeightlossModel(iv_weightloss1[i]);
            weightlossModelArrayList.add(view1);
        }

        programAdapter  = new ProgramAdapter(getContext(),weightlossModelArrayList);
        recyclerView1.setAdapter(programAdapter);

        return view;
    }
}
