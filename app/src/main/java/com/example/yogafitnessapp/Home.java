package com.example.yogafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.fragment.Goals;
import com.example.yogafitnessapp.fragment.HealthTips;
import com.example.yogafitnessapp.fragment.Master;
import com.example.yogafitnessapp.fragment.News;
import com.example.yogafitnessapp.fragment.Profile;
import com.example.yogafitnessapp.fragment.Training;
import com.example.yogafitnessapp.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Home extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN =0;
    public static String username;
    public  static  String id_user;
    public static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       /* loadFragment(new Training());*/

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        navigation.setSelectedItemId(R.id.bottomNavigationClockMenuId);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        confirmReg();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
            id_user = bundle.getString("id_user");
            email = bundle.getString("email");
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {

    /*        case R.id.bottomNavigationAlarmMenuId:
                fragment = new News();
                break;*/

            case R.id.bottomNavigationClockMenuId:
                fragment = new Master();
                break;

          /*  case R.id.bottomNavigationTimerMenuId:
                fragment = new HealthTips();
                break;*/

            case R.id.bottomNavigationStopWatchMenuId:
                fragment = new Goals();
                break;

            case R.id.bottomNavigationStopWatchProfileId:
                fragment = new Profile();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentLoad, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    public void confirmReg(){

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Home.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            User u=new User(personName,personEmail,"");
            registerUser(u);
        }



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
                            id_user = jsonObject.getString("id_user");


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
                params.put("function","addUserGoogle");
                params.put("email",String.valueOf(user.getEmail()));
                params.put("username",String.valueOf(user.getUsername()));
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(Home.this);
        requestQueue.add(strReq);

    }
}
