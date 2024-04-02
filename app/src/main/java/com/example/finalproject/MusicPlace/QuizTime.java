package com.example.finalproject.MusicPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.finalproject.R;

public class QuizTime extends AppCompatActivity {

    ImageView category1,category2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_quiz_time);


        category1 = findViewById(R.id.category1);
        category2 = findViewById(R.id.category2);

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTime.this,Quiz1.class);
                startActivity(intent);
            }
        });

//        category2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(QuizTime.this,Quiz2.class);
//                startActivity(intent);
//            }
//        });

    }
}