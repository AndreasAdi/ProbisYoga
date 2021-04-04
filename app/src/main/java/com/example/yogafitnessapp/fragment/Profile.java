package com.example.yogafitnessapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yogafitnessapp.Home;
import com.example.yogafitnessapp.R;
import com.example.yogafitnessapp.Settings;
import com.example.yogafitnessapp.adapter.Seetings1Adapter;
import com.example.yogafitnessapp.adapter.SeetingsAdapter;
import com.example.yogafitnessapp.model.SettingsModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.concurrent.Executor;


public class Profile extends Fragment {

    private Seetings1Adapter seetings1Adapter;
    private ArrayList<SettingsModel> settingsModelArrayList;
    private RecyclerView recyclerView;
    GoogleSignInClient mGoogleSignInClient;

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

/*        recyclerView = view.findViewById(R.id.rv_settings);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);*/

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        TextView tv_nama = view.findViewById(R.id.txt_nama);
        ImageView img_profile = view.findViewById(R.id.img_profile);
        TextView tv_logout = view.findViewById(R.id.tv_logout);

        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            String personName = acct.getDisplayName();
/*            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();*/
            Uri personPhoto = acct.getPhotoUrl();

            /*tv_nama.setText(personName);*/
            Glide.with(this).load(personPhoto).into(img_profile);

        }
        tv_nama.setText(Home.username);

/*        settingsModelArrayList = new ArrayList<>();

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
        recyclerView1.setAdapter(seetings1Adapter);*/

        return view;
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener((Executor) this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                            getActivity().finish();
                    }
                });
    }
}
