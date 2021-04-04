package com.example.yogafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        YouTubePlayer y = findViewById(R.id.youtube_player_view);

        y.loadVideo("dQw4w9WgXcQ",0);
        YouTubePlayerTracker tracker = new YouTubePlayerTracker();
        y.addListener(tracker);

        tracker.getState();
        tracker.getCurrentSecond();
        float durasi = tracker.getVideoDuration();
        tracker.getVideoId();

    }
}