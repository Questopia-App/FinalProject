package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;

;


public class LearnInstruments extends AppCompatActivity {


    int currentInstrument = -1;
    HashMap<String,Integer> mapInstrument = new HashMap<>();

    protected void MapInstrument(){
        mapInstrument.put("piano",1);
        mapInstrument.put("flute",2);
        mapInstrument.put("guitar",3);
    }

    HashMap<Integer,MediaPlayer> musicMap = new HashMap<>();





    private ImageView pianoImg,fluteImg,guitarImg,violinImg,harpImg,xyloImg,drumsImg;
    private LottieAnimationView musicwaveAnim_piano,musicwaveAnim_flute,musicwaveAnim_guitar;

    private MediaPlayer pianoMusic,fluteMusic,guitarMusic,harpMusic,xyloMusic,drumsMusic;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_learn_instruments);

        MapInstrument();

        pianoImg = findViewById(R.id.pianoImg);
        fluteImg = findViewById(R.id.fluteImg);






        musicwaveAnim_piano = findViewById(R.id.musicwaveAnim_piano);
        musicwaveAnim_flute = findViewById(R.id.musicwaveAnim_flute);




        pianoMusic = MediaPlayer.create(this,R.raw.music_piano);
        fluteMusic = MediaPlayer.create(this,R.raw.music_flute);
        guitarMusic = MediaPlayer.create(this,R.raw.music_guitar);
        xyloMusic = MediaPlayer.create(this,R.raw.music_xylophone);



        pianoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "piano";
                currentInstrument=mapInstrument.get(name);

                musicwaveAnim_piano.setVisibility(View.VISIBLE);
                musicwaveAnim_piano.playAnimation();

                if(pianoMusic!=null && !pianoMusic.isPlaying()){
                    pianoMusic.start();
                }
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        musicwaveAnim_piano.cancelAnimation();
                        musicwaveAnim_piano.setVisibility(View.INVISIBLE);
                        pianoMusic.stop();
                        pianoMusic.prepareAsync();
                    }
                }, 10000);
            }
        });

        fluteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeCurrent(currentInstrument);

                String name = "flute";
                currentInstrument=mapInstrument.get(name);

                musicwaveAnim_flute.setVisibility(View.VISIBLE);
                musicwaveAnim_flute.playAnimation();

                if(fluteMusic!=null && !fluteMusic.isPlaying()){
                    fluteMusic.start();
                }
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        musicwaveAnim_flute.cancelAnimation();
                        musicwaveAnim_flute.setVisibility(View.INVISIBLE);
                        fluteMusic.stop();
                        fluteMusic.prepareAsync();
                    }
                }, 10000);
            }
        });





    }

//    protected void turnOff(){
//        musicwaveAnim_piano.cancelAnimation();
//        musicwaveAnim_piano.setVisibility(View.INVISIBLE);
//        pianoMusic.stop();
//        pianoMusic.prepareAsync();
//    }

    protected void closeCurrent(int current){

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pianoMusic != null) {
            pianoMusic.release(); // Release resources when activity is destroyed
            pianoMusic = null;
        }
        if (fluteMusic != null) {
            fluteMusic.release(); // Release resources when activity is destroyed
            fluteMusic = null;
        }
    }
}