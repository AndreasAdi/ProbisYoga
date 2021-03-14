package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText txt_Email,txt_Pass;
    TextView btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_Email=findViewById(R.id.Txt_LogEmail);
        txt_Pass=findViewById(R.id.Txt_LogPass);
        btn_Login=findViewById(R.id.tv_login);
    }
    public void Login(View v){
        String email=txt_Email.getText().toString();
        String pass=txt_Pass.getText().toString();

        if(!email.isEmpty()&&!pass.isEmpty()){
            LoginProcess(email,pass);
        }else {
            Toast.makeText(Login.this, "Email And Password Field Is Required!", Toast.LENGTH_SHORT).show();
        }
    }
    public void LoginProcess(final String email,final String Pass){
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
                            if(code==1){
                                Intent i= new Intent(Login.this,Home.class);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(Login.this,message,Toast.LENGTH_SHORT).show();
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
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params=new HashMap<>();
                params.put("function","login");
                params.put("email",email);
                params.put("password",Pass);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}