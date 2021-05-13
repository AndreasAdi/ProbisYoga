package com.example.yogafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androchef.happytimer.countdowntimer.CircularCountDownView;
import com.androchef.happytimer.countdowntimer.HappyTimer;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yogafitnessapp.model.ProfileModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class VideoActivity extends AppCompatActivity {

    String nama,video;
    TextView tv_judul;
    int waktu,index;
    ImageButton btn_next,btn_prev,btn_play;
    ArrayList<ProfileModel> profileModelArrayList;
    boolean play = false;
    CircularCountDownView circularCountDownView;
    YouTubePlayerTracker tracker;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("nama");
            video = bundle.getString("video");
            waktu = Integer.parseInt(bundle.getString("waktu"))*60;
            profileModelArrayList = bundle.getParcelableArrayList("list_video");
            index = bundle.getInt("index");
        }

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        circularCountDownView = findViewById(R.id.circularCountDownView);
        tv_judul = findViewById(R.id.tv_judul);
        btn_prev = findViewById(R.id.btn_prev);
        btn_next = findViewById(R.id.btn_next);
        btn_play= findViewById(R.id.btn_play);



        getLifecycle().addObserver(youTubePlayerView);
        tv_judul.setText(nama);
        circularCountDownView.initTimer(waktu);

         tracker = new YouTubePlayerTracker();


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull final YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(video, 0);
                youTubePlayer.addListener(tracker);
            }


           public void  onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state){
                if (state == PlayerConstants.PlayerState.PAUSED){
                    circularCountDownView.pauseTimer();
                    System.out.println("pause");
                    play=false;
                    btn_play.setImageResource(R.drawable.ic_play);

                }
                 if (state== PlayerConstants.PlayerState.PLAYING){
                     System.out.println("Play");
                    circularCountDownView.resumeTimer();
                     play=true;
                     btn_play.setImageResource(R.drawable.ic_pause);

                }
            }


        });




        circularCountDownView.setOnTickListener(new HappyTimer.OnTickListener() {
            @Override
            public void onTick(int i, int i1) {

            }

            @Override
            public void onTimeUp() {
                tambah_poin();

            }
        });

        circularCountDownView.setStateChangeListener(new HappyTimer.OnStateChangeListener() {
            @Override
            public void onStateChange(HappyTimer.State state, int i, int i1) {

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<profileModelArrayList.size()){
                    index++;
                    youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
                        @Override
                        public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                            youTubePlayer.loadVideo(profileModelArrayList.get(index).getVideo(),0);
                            waktu = Integer.parseInt(profileModelArrayList.get(index).getWaktu())*60;
                            circularCountDownView.stopTimer();
                            circularCountDownView.initTimer(waktu);
                        }
                    });
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index>0){
                    index--;
                    youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
                        @Override
                        public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                            youTubePlayer.loadVideo(profileModelArrayList.get(index).getVideo(),0);
                            waktu = Integer.parseInt(profileModelArrayList.get(index).getWaktu())*60;
                            circularCountDownView.stopTimer();
                            circularCountDownView.initTimer(waktu);
                        }
                    });
                }
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
                    @Override
                    public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                          if (play){
                              youTubePlayer.pause();

                          }
                          else if (!play){
                              youTubePlayer.play();

                          }
                    }
                });
            }
        });

    }

    private void tambah_poin(){
        StringRequest strReq= new StringRequest(
                Request.Method.POST,
                getResources().getString(R.string.url),//ini masih pakai IP ku
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            int code=jsonObject.getInt("code");

                            if(code==1){
                                System.out.println("tidak ada error");
                                Toasty.success(
                                        VideoActivity.this,
                                        "+ 10 Points",
                                        Toast.LENGTH_SHORT,
                                        true
                                ).show();
                            }
                            else{
                                System.out.println("Ada error");
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
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("function","tambah_poin");
                params.put("id_user",Home.id_user);
                params.put("poin","10");
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(VideoActivity.this);
        requestQueue.add(strReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }


}