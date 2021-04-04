package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    ImageView iv_close;
    TextView tv_friend;
    EditText txt_Email,txt_Pass,txt_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        iv_close = findViewById(R.id.iv_close);
       /* iv_close.setImageResource(R.drawable.ic_close);*/
        txt_Email=findViewById(R.id.TxtEmail);
        txt_Pass=findViewById(R.id.TxtPass);
        txt_username = findViewById(R.id.TxtUsername);
        /*
        tv_friend = findViewById(R.id.tv_friend);
        tv_friend.setVisibility(View.GONE);*/

/*        iv_close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, Createacount.class);
                startActivity(i);
            }
        });*/
    }
    public void confirmReg(View v){
        String email= txt_Email.getText().toString();
        String pass=txt_Pass.getText().toString();
        String username=txt_username.getText().toString();
        User u=new User(username,email,pass);
        registerUser(u);

    }
    private void registerUser(final User user){
        StringRequest strReq= new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),//ini masih pakai IP ku
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");
                            String message=jsonObject.getString("message");
                            if(code==1){
                                Toast.makeText(Signup.this,message,Toast.LENGTH_SHORT).show();
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
                params.put("function","adduser");
                params.put("username",String.valueOf(user.getUsername()));
                params.put("email",String.valueOf(user.getEmail()));
                params.put("password",user.getPassword());
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(Signup.this);
        requestQueue.add(strReq);

    }
}
