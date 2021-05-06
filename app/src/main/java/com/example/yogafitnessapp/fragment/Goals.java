package com.example.yogafitnessapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.CategoriesDetailSub2;
import com.example.yogafitnessapp.Home;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.ProfileModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Goals extends Fragment {


    private SubCategoryAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    ArrayList<String> listnama;
    ArrayList<String> listwaktu;
    ArrayList<String> listgambar;
    ArrayList<String> listid;
    ArrayList<String> listvideo;

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

        listgambar = new ArrayList<>();
        listnama =new ArrayList<>();
        listwaktu = new ArrayList<>();
        listid = new ArrayList<>();
        listvideo = new ArrayList<>();

        load_data();



        profileAdapter = new SubCategoryAdapter(getContext(),profileModelArrayList);
        recyclerView.setAdapter(profileAdapter);

        return view;
    }

    private void load_data(){
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
                            JSONArray gambar = jsonObject.getJSONArray("gambar");
                            JSONArray waktu = jsonObject.getJSONArray("waktu");
                            JSONArray id = jsonObject.getJSONArray("id");
                            JSONArray video = jsonObject.getJSONArray("video");
                            String message=jsonObject.getString("message");

                            if(code==1){
                                for (int i = 0; i <nama.length(); i++) {
                                    listnama.add(nama.getString(i));
                                    listwaktu.add(waktu.getString(i));
                                    listgambar.add(getResources().getString(R.string.folder_gambar)+"/"+gambar.getString(i));
                                    listid.add(id.getString(i));
                                    listvideo.add(video.getString(i));
                                }
                                load_view();
                                System.out.println("tidak ada Ada error training");

                            }
                            else{
                                System.out.println("Ada error training");
                            }

                        } catch (JSONException e) {
                            System.out.println("query salah");
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
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("function","load_training");
                params.put("email", Home.email);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(strReq);

    }

    private void load_view(){
        for (int i = 0; i < listgambar.size(); i++) {
            ProfileModel view1 = new ProfileModel(listgambar.get(i),listwaktu.get(i),listnama.get(i),listid.get(i),listvideo.get(i));
            profileModelArrayList.add(view1);
        }

        profileAdapter.notifyDataSetChanged();
    }
}
