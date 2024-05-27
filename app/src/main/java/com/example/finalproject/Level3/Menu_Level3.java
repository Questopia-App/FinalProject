package com.example.finalproject.Level3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject.Level1.AlphabetMatchGame;
import com.example.finalproject.Level1.Menu_Level1;
import com.example.finalproject.Level2.Animal_Quiz;
import com.example.finalproject.Level2.Menu_Level2;
import com.example.finalproject.R;

public class Menu_Level3 extends AppCompatActivity {

    ImageView game1,game2,game3,game4,game5,game6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_level3);



        game1=findViewById(R.id.game3);



        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Level3.this, AlphabetMatchGame.class);
                startActivity(intent);
            }
        });
    }
}