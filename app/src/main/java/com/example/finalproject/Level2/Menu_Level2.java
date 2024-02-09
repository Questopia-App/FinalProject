package com.example.finalproject.Level2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.finalproject.Level1.DragShape;
import com.example.finalproject.Level1.MatchGame;
import com.example.finalproject.Level1.Menu_Level1;
import com.example.finalproject.R;

public class Menu_Level2 extends AppCompatActivity {

    ImageView game1,game2,game3,game4,game5,game6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_level2);


        game1=findViewById(R.id.game1);
        game2=findViewById(R.id.game2);
        game3=findViewById(R.id.game3);
        game4=findViewById(R.id.game4);
        game5=findViewById(R.id.game5);
        game6=findViewById(R.id.game6);


        // Literacy Games

//        game1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Menu_Level1.this,);
//                startActivity(intent);
//            }
//        });
//
//        game2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Menu_Level1.this,);
//                startActivity(intent);
//            }
//        });

        // Numeracy Games

//        game3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Menu_Level1.this, DragShape.class);
//                startActivity(intent);
//            }
//        });
//
//        game4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Menu_Level1.this,);
//                startActivity(intent);
//            }
//        });

        // EVS Games

        game5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Level2.this, Animal_Quiz.class);
                startActivity(intent);
            }
        });

//        game6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Menu_Level1.this,);
//                startActivity(intent);
//            }
//        });


    }
}