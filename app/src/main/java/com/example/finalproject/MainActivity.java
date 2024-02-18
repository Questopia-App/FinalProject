package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.Level1.Menu_Level1;
import com.example.finalproject.Level2.Menu_Level2;
import com.example.finalproject.Level3.Menu_Level3;
import com.example.finalproject.MusicPlace.MenuMusicPlace;

public class MainActivity extends AppCompatActivity {

    private ImageView level1;
    private ImageView level2;
    private ImageView level3;
    private ImageView music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        music = findViewById(R.id.music);

        level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Menu_Level1.class);
                startActivity(intent);
            }
        });
        level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Menu_Level2.class);
                startActivity(intent);
            }
        });
        level3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Menu_Level3.class);
                startActivity(intent);
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuMusicPlace.class);
                startActivity(intent);
            }
        });



//        private void exitApplication() {
//            finishAffinity(); // This will close all activities and exit the app
//        }





    }
}