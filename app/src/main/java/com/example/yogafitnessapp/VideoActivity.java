package com.example.yogafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androchef.happytimer.countdowntimer.CircularCountDownView;
import com.androchef.happytimer.countdowntimer.HappyTimer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.sql.SQLOutput;

public class VideoActivity extends AppCompatActivity {

    String nama,video;
    TextView tv_judul;
    int waktu;
    ImageView btn_play;
    boolean play = false;
    CircularCountDownView circularCountDownView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("nama");
            video = bundle.getString("video");
            waktu = Integer.parseInt(bundle.getString("waktu"))*60;

        }

        final YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        circularCountDownView = findViewById(R.id.circularCountDownView);
        tv_judul = findViewById(R.id.tv_judul);
        btn_play = findViewById(R.id.btn_play);


        getLifecycle().addObserver(youTubePlayerView);
        tv_judul.setText(nama);
        circularCountDownView.initTimer(waktu);





        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull final YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(video, 0);
            }


           public void  onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state){
                if (state == PlayerConstants.PlayerState.PAUSED){
                    circularCountDownView.pauseTimer();
                    System.out.println("pause");
                }
                 if (state== PlayerConstants.PlayerState.PLAYING){
                     System.out.println("Play");
                    circularCountDownView.resumeTimer();
                }
            }


        });

   /*     btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!play){
                    youTubePlayer.play();
                    circularCountDownView.startTimer();
                }
                if (play){
                    youTubePlayer.pause();
                    circularCountDownView.pauseTimer();
                }


            }
        });*/



        circularCountDownView.setOnTickListener(new HappyTimer.OnTickListener() {
            @Override
            public void onTick(int i, int i1) {

            }

            @Override
            public void onTimeUp() {

            }
        });

        circularCountDownView.setStateChangeListener(new HappyTimer.OnStateChangeListener() {
            @Override
            public void onStateChange(HappyTimer.State state, int i, int i1) {

            }
        });


    }
}