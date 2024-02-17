package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;



public class LearnInstruments extends AppCompatActivity {

    private ImageView pianoImg,fluteImg;
    private LottieAnimationView musicwaveAnim;

    private MediaPlayer pianoMusic;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_learn_instruments);

        pianoImg = findViewById(R.id.pianoImg);
        musicwaveAnim = findViewById(R.id.musicwaveAnim_piano);
        pianoMusic = MediaPlayer.create(this,R.raw.music_piano);

        pianoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicwaveAnim.setVisibility(View.VISIBLE);
                musicwaveAnim.playAnimation();

                if(pianoMusic!=null && !pianoMusic.isPlaying()){
                    pianoMusic.start();
                }
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        musicwaveAnim.cancelAnimation();
                        musicwaveAnim.setVisibility(View.INVISIBLE);
                        pianoMusic.stop();
                        pianoMusic.prepareAsync();
                    }
                }, 10000);
            }
        });





    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pianoMusic != null) {
            pianoMusic.release(); // Release resources when activity is destroyed
            pianoMusic = null;
        }
    }
}