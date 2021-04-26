package com.example.yogafitnessapp.fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.CategorieDetailSub1;
import com.example.yogafitnessapp.Home;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.adapter.CoursesAdapter;
import com.example.yogafitnessapp.adapter.ProgramAdapter;
import com.example.yogafitnessapp.adapter.WeightlossAdapter;
import com.example.yogafitnessapp.model.User;
import com.example.yogafitnessapp.model.WeightlossModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Master extends Fragment {

    private CoursesAdapter coursesAdapter;
    private ArrayList<WeightlossModel> weightlossModelArrayList;
    private RecyclerView recyclerView;
    private CoursesAdapter.RecyclerViewClickListener listener;


     TypedArray dataPhoto;

     ArrayList<String> list_nama = new ArrayList<>();
     ArrayList<String> list_id = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_master, container, false);

        recyclerView =view.findViewById(R.id.rv_courses);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        weightlossModelArrayList = new ArrayList<>();

        load_header();

        dataPhoto =getResources().obtainTypedArray(R.array.data_photo);

        setOnclickListener();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void setOnclickListener() {
        listener = new CoursesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(new Intent(getContext(), CategorieDetailSub1.class));
                i.putExtra("id",list_id.get(position));
                i.putExtra("gambar",dataPhoto.getResourceId(position,-1));
                startActivity(i);
            }
        };
    }


    private void load_view(){
        for (int i = 0; i < list_nama.size(); i++) {
            WeightlossModel view1 = new WeightlossModel(dataPhoto.getResourceId(i,-1),list_nama.get(i));
            weightlossModelArrayList.add(view1);
        }
        coursesAdapter = new CoursesAdapter(getContext(),weightlossModelArrayList,listener);
        recyclerView.setAdapter(coursesAdapter);

    }
    private void load_header(){
        StringRequest strReq= new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),//ini masih pakai IP ku
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");
                            JSONArray nama = jsonObject.getJSONArray("nama");
                            JSONArray id = jsonObject.getJSONArray("id");
                            String message=jsonObject.getString("message");
                            if(code==1){
                                for (int i = 0; i <nama.length(); i++) {
                                    list_nama.add(nama.getString(i));
                                    list_id.add(id.getString(i));
                                    System.out.println(nama.getString(i));
                                }

                                load_view();
                            }
                            else{

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String>params=new HashMap<>();
                params.put("function","LoadHeader");
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(strReq);


    }


}
