package com.example.finalproject.Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;


public class MatchGame extends AppCompatActivity {


    int value=0;
    String chosen_alphabet = "";
    Button buttonA, buttonM,buttonO,buttonB,buttonG;
    ImageView imageA,imageM,imageB,imageO,imageG;
    boolean isButtonClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_match_game);


        buttonA = findViewById(R.id.buttonA);
        imageA = findViewById(R.id.imageA);
        buttonM = findViewById(R.id.buttonM);
        buttonB = findViewById(R.id.buttonB);
        buttonG = findViewById(R.id.buttonG);
        buttonO = findViewById(R.id.buttonO);
        imageM = findViewById(R.id.imageM);
        imageB = findViewById(R.id.imageB);
        imageO = findViewById(R.id.imageO);
        imageG = findViewById(R.id.imageG);

        MediaPlayer correct,wrong,match_heading;

        match_heading = MediaPlayer.create(this,R.raw.match_heading);

        if (match_heading != null) {
            match_heading.start();
        }


        correct = MediaPlayer.create(this, R.raw.correct_answer);
        wrong = MediaPlayer.create(this, R.raw.wrong_answer);
/*
        if (correct != null) {
            correct.start();
        }

        if (wrong != null) {
            wrong.start();
        }

*/


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonClicked = true;
                chosen_alphabet="A";
            }
        });

        imageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked) {
                    // Match verification
                    // For example, you might compare the tag or resource ID of the image
                    // with the button clicked to verify the match
                    if (isMatch(chosen_alphabet, view)) {
                        // Set both the button and the image to a tick mark or any indication of a correct match
                        buttonA.setText("✓");
                        imageA.setImageResource(R.drawable.tick_mark);

                        if (correct != null) {
                            correct.start();
                        }
                        value++;

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    } else {
                        // Show an error message because the match was incorrect
                        Toast.makeText(MatchGame.this, "Incorrect match!", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    }
                }

                if(isEnd(value)){
                    goBack();
                }
            }
        });

        // ******************E********************

        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonClicked = true;
                chosen_alphabet="M";
            }
        });

        imageM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked) {
                    // Match verification
                    // For example, you might compare the tag or resource ID of the image
                    // with the button clicked to verify the match
                    if (isMatch(chosen_alphabet, view)) {
                        // Set both the button and the image to a tick mark or any indication of a correct match
                        buttonM.setText("✓");
                        imageM.setImageResource(R.drawable.tick_mark);

                        if (correct != null) {
                            correct.start();
                        }
                        value++;

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    } else {
                        // Show an error message because the match was incorrect
                        Toast.makeText(MatchGame.this, "Incorrect match!", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    }
                }

                if(isEnd(value)){
                    goBack();
                }
            }
        });


        // *******************************I****************************


        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonClicked = true;
                chosen_alphabet="G";
            }
        });

        imageG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked) {
                    // Match verification
                    // For example, you might compare the tag or resource ID of the image
                    // with the button clicked to verify the match
                    if (isMatch(chosen_alphabet, view)) {
                        // Set both the button and the image to a tick mark or any indication of a correct match
                        buttonG.setText("✓");
                        imageG.setImageResource(R.drawable.tick_mark);

                        if (correct != null) {
                            correct.start();
                        }
                        value++;

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    } else {
                        // Show an error message because the match was incorrect
                        Toast.makeText(MatchGame.this, "Incorrect match!", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    }

                    if(isEnd(value)){
                        goBack();
                    }
                }
            }
        });


        // *********************************O***********************************

        buttonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonClicked = true;
                chosen_alphabet="O";
            }
        });

        imageO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked) {
                    // Match verification
                    // For example, you might compare the tag or resource ID of the image
                    // with the button clicked to verify the match
                    if (isMatch(chosen_alphabet, view)) {
                        // Set both the button and the image to a tick mark or any indication of a correct match
                        buttonO.setText("✓");
                        imageO.setImageResource(R.drawable.tick_mark);

                        if (correct != null) {
                            correct.start();
                        }
                        value++;

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    } else {
                        // Show an error message because the match was incorrect
                        Toast.makeText(MatchGame.this, "Incorrect match!", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    }

                    if(isEnd(value)){
                        goBack();
                    }
                }
            }
        });

        // *********************************U*******************************************


        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButtonClicked = true;
                chosen_alphabet="B";
            }
        });

        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked) {
                    // Match verification
                    // For example, you might compare the tag or resource ID of the image
                    // with the button clicked to verify the match
                    if (isMatch(chosen_alphabet, view)) {
                        // Set both the button and the image to a tick mark or any indication of a correct match
                        buttonB.setText("✓");
                        imageB.setImageResource(R.drawable.tick_mark);

                        if (correct != null) {
                            correct.start();
                        }
                        value++;

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    } else {
                        // Show an error message because the match was incorrect
                        Toast.makeText(MatchGame.this, "Incorrect match!", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }

                        // Reset the state of button click for the next round
                        isButtonClicked = false;
                    }
                    if(isEnd(value)){
                        goBack();
                    }
                }
            }
        });


    }




    // Method to check if the clicked image matches the alphabet
    private boolean isMatch(String alphabet, View view) {
        // For demonstration, let's assume a tag is set for the image
        // You might use tags or resource IDs to identify matches in your implementation
        String tag = (String) view.getTag(); // Assuming tag is set in XML or programmatically

        // Check if the tag of the image matches the alphabet
        return tag != null && tag.equals(alphabet);
    }

    private boolean isEnd(int value){
        if(value>=5){
           return true;
        }
        return false;
    }

    private void goBack(){
        Intent intent = new Intent(MatchGame.this, Animation_done.class);
        startActivity(intent);
        onBackPressed();
    }



}



