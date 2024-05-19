package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;

public class QuizTime extends AppCompatActivity {

    ImageView category1,category2;

    private LottieAnimationView trainanim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_quiz_time);


        category1 = findViewById(R.id.category1);
        category2 = findViewById(R.id.category2);

        trainanim = findViewById(R.id.trainanim);


        trainanim.playAnimation();

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTime.this,GuessRhymesQuiz.class);
                startActivity(intent);
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTime.this,GuessInstrumentQuiz.class);
                startActivity(intent);
            }
        });

    }
}