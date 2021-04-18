package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.adapter.CategorydetailAdapter;
import com.example.yogafitnessapp.adapter.ProfileAdapter;
import com.example.yogafitnessapp.adapter.SubCategoryAdapter;
import com.example.yogafitnessapp.model.CategoryModel;
import com.example.yogafitnessapp.model.ProfileModel;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategorieDetailSub1 extends AppCompatActivity {

    private SubCategoryAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;
    private RecyclerView recyclerView;

    TextView tv_nama,tv_waktu,tv_desc;
    Toolbar toolbar;
    LinearLayout linear2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_detail_sub1);

        tv_waktu = findViewById(R.id.tv_waktu);
        tv_desc = findViewById(R.id.tv_desc);
        tv_nama = findViewById(R.id.tv_nama);


        load_detail("1");

    }

    public void load_detail(final String id){
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");
                            String message=jsonObject.getString("message");
                            String nama = jsonObject.getString("nama");
                            String waktu = jsonObject.getString("waktu");
                            String desc = jsonObject.getString("desc");
                            if(code==1){
                                tv_nama.setText(nama);
                                tv_waktu.setText(waktu);
                                tv_desc.setText(desc);
                            }else{

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
        ) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("function","LoadDetail");
                params.put("id_workout",id);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

