package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;

;


public class LearnInstruments extends AppCompatActivity {


    int currentInstrument = -1;

    HashMap<Integer,MediaPlayer> mapMedia = new HashMap<>();
    HashMap<Integer,LottieAnimationView> mapAnim = new HashMap<>();







    private ImageView pianoImg,fluteImg,guitarImg,violinImg,harpImg,xyloImg,drumsImg;
    private LottieAnimationView musicwaveAnim_piano,musicwaveAnim_flute,musicwaveAnim_guitar,musicwaveAnim_harp,musicwaveAnim_drums,musicwaveAnim_violin,musicwaveAnim_xylo;

    private MediaPlayer pianoMusic,fluteMusic,guitarMusic,harpMusic,xyloMusic,drumsMusic,violinMusic;


    protected void MapMedia(){
        mapMedia.put(1,pianoMusic);
        mapMedia.put(2,fluteMusic);
        mapMedia.put(3,guitarMusic);
        mapMedia.put(4,harpMusic);
        mapMedia.put(5,drumsMusic);
        mapMedia.put(6,violinMusic);
        mapMedia.put(7,xyloMusic);
    }

    protected void MapAnim(){
        mapAnim.put(1,musicwaveAnim_piano);
        mapAnim.put(2,musicwaveAnim_flute);
        mapAnim.put(3,musicwaveAnim_guitar);
        mapAnim.put(4,musicwaveAnim_harp);
        mapAnim.put(5,musicwaveAnim_drums);
        mapAnim.put(6,musicwaveAnim_violin);
        mapAnim.put(7,musicwaveAnim_xylo);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_learn_instruments);



        pianoImg = findViewById(R.id.pianoImg);
        fluteImg = findViewById(R.id.fluteImg);
        guitarImg=findViewById(R.id.guitarImg);
        violinImg=findViewById(R.id.violinImg);
        harpImg=findViewById(R.id.harpImg);
        xyloImg=findViewById(R.id.xylophoneImg);
        drumsImg=findViewById(R.id.drumsImg);






        musicwaveAnim_piano = findViewById(R.id.musicwaveAnim_piano);
        musicwaveAnim_flute = findViewById(R.id.musicwaveAnim_flute);
        musicwaveAnim_guitar = findViewById(R.id.musicwaveAnim_guitar);
        musicwaveAnim_harp = findViewById(R.id.musicwaveAnim_harp);
        musicwaveAnim_drums = findViewById(R.id.musicwaveAnim_drums);
        musicwaveAnim_violin = findViewById(R.id.musicwaveAnim_violin);
        musicwaveAnim_xylo = findViewById(R.id.musicwaveAnim_xylophone);




        pianoMusic = MediaPlayer.create(this,R.raw.music_piano);
        fluteMusic = MediaPlayer.create(this,R.raw.music_flute);
        guitarMusic = MediaPlayer.create(this,R.raw.music_guitar);
        xyloMusic = MediaPlayer.create(this,R.raw.music_xylophone);
        harpMusic = MediaPlayer.create(this,R.raw.music_harp);
        drumsMusic = MediaPlayer.create(this,R.raw.music_drums);
        violinMusic = MediaPlayer.create(this,R.raw.music_violin);



        MapMedia();
        MapAnim();


        pianoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=1;

                turnOn(currentInstrument);
            }
        });

        fluteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=2;

                turnOn(currentInstrument);
            }
        });
        guitarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=3;

                turnOn(currentInstrument);
            }
        });
        harpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=4;

                turnOn(currentInstrument);
            }
        });

        drumsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=5;

                turnOn(currentInstrument);
            }
        });

        violinImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=6;

                turnOn(currentInstrument);
            }
        });

        xyloImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turnOff(currentInstrument);

                currentInstrument=7;

                turnOn(currentInstrument);
            }
        });




    }


    protected void turnOn(int id){

        LottieAnimationView animation=mapAnim.get(id);
        MediaPlayer mediaPlayer = mapMedia.get(id);

        if(animation==null || mediaPlayer==null){
            return;
        }

        animation.setVisibility(View.VISIBLE);
        animation.playAnimation();

        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }


    }



    protected void turnOff(int id){

        LottieAnimationView animation=mapAnim.get(id);
        MediaPlayer mediaPlayer = mapMedia.get(id);

        if(animation==null || mediaPlayer==null){
            return;
        }

        animation.cancelAnimation();
        animation.setVisibility(View.INVISIBLE);

        mediaPlayer.stop();
        mediaPlayer.prepareAsync();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pianoMusic != null) {
            pianoMusic.release();
            pianoMusic = null;
        }
        if (fluteMusic != null) {
            fluteMusic.release();
            fluteMusic = null;
        }

        if (guitarMusic != null) {
            guitarMusic.release();
            guitarMusic = null;
        }

        if (harpMusic != null) {
            harpMusic.release();
            harpMusic = null;
        }

        if (xyloMusic != null) {
            xyloMusic.release();
            xyloMusic = null;
        }

        if (drumsMusic != null) {
            drumsMusic.release();
            drumsMusic = null;
        }
        if (violinMusic != null) {
            violinMusic.release();
            violinMusic = null;
        }

    }
}












