package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.finalproject.Level1.Menu_Level1;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

public class MenuMusicPlace extends AppCompatActivity {


    private TextView learnInstruments,playMusic,quizTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_music_place);

        learnInstruments = findViewById(R.id.learnInstruments);
//        playMusic = findViewById(R.id.playMusic);
        quizTime = findViewById(R.id.identifyInstruments);

        learnInstruments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMusicPlace.this, LearnInstruments.class);
                startActivity(intent);

            }
        });
//        playMusic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MenuMusicPlace.this, PlayMusic.class);
//                startActivity(intent);
//
//            }
//        });
        quizTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMusicPlace.this, QuizTime.class);
                startActivity(intent);

            }
        });


    }
}