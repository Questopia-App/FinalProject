package com.example.finalproject.Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;

import android.media.MediaPlayer;

import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class DragShape extends AppCompatActivity {

    int count = 0;

    private MediaPlayer correct,wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drag_shape);




        ImageView questionImageView1 = findViewById(R.id.questionImageView1);
        ImageView questionImageView2 = findViewById(R.id.questionImageView2);
        ImageView questionImageView3 = findViewById(R.id.questionImageView3);
        ImageView questionImageView4 = findViewById(R.id.questionImageView4);
        ImageView answerImageView1 = findViewById(R.id.answerImageView1);
        ImageView answerImageView2 = findViewById(R.id.answerImageView2);
        ImageView answerImageView3 = findViewById(R.id.answerImageView3);
        ImageView answerImageView4 = findViewById(R.id.answerImageView4);

        correct = MediaPlayer.create(this, R.raw.correct_answer);
        wrong = MediaPlayer.create(this, R.raw.wrong_answer);

        /*
        Mapping:

        questionImageView1 -> answerImageView4
        questionImageView2 -> answerImageView3
        questionImageView3 -> answerImageView2
        questionImageView4 -> answerImageView1

         */

        // Implementing questionImageView1 -> answerImageView4

        questionImageView1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getAction() == DragEvent.ACTION_DROP) {
                    ImageView droppedImage = (ImageView) event.getLocalState();
                    if (isMatch(questionImageView1, droppedImage)) {
                        droppedImage.setImageResource(R.drawable.tick_mark);
                        if (correct != null) {
                            correct.start();
                        }
                        //Toast.makeText(DragShape.this, "This is Correct!", Toast.LENGTH_SHORT).show();
                        count++;
                        if(isEnd(count)){
                            goBack();
                        }
                    } else {
                        Toast.makeText(DragShape.this, "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }
                    }
                }
                return true;
            }
        });

        answerImageView4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(null, shadowBuilder, v, 0);
                return true;
            }
        });

        questionImageView2.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                if (action == DragEvent.ACTION_DROP) {
                    ImageView droppedImage = (ImageView) event.getLocalState();
                    if (isMatch(answerImageView3, droppedImage)) {
                        droppedImage.setImageResource(R.drawable.tick_mark);
                        if (correct != null) {
                            correct.start();
                        }
                        //Toast.makeText(DragShape.this, "This is Correct!", Toast.LENGTH_SHORT).show();
                        count++;
                        if(isEnd(count)){
                            goBack();
                        }
                    } else {
                        Toast.makeText(DragShape.this, "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }
                    }
                }
                return true;
            }
        });

        answerImageView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(null, shadowBuilder, v, 0);
                return true;
            }
        });



        questionImageView3.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                if (action == DragEvent.ACTION_DROP) {
                    ImageView droppedImage = (ImageView) event.getLocalState();
                    if (isMatch(answerImageView2, droppedImage)) {
                        droppedImage.setImageResource(R.drawable.tick_mark);
                        if (correct != null) {
                            correct.start();
                        }
                        //Toast.makeText(DragShape.this, "This is Correct!", Toast.LENGTH_SHORT).show();
                        count++;
                        if(isEnd(count)){
                            goBack();
                        }
                    } else {
                        Toast.makeText(DragShape.this, "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }
                    }
                }
                return true;
            }
        });

        answerImageView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(null, shadowBuilder, v, 0);
                return true;
            }
        });


        questionImageView4.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                if (action == DragEvent.ACTION_DROP) {
                    ImageView droppedImage = (ImageView) event.getLocalState();
                    if (isMatch(answerImageView1, droppedImage)) {
                        droppedImage.setImageResource(R.drawable.tick_mark);
                        if (correct != null) {
                            correct.start();
                        }
                        //Toast.makeText(DragShape.this, "This is Correct!", Toast.LENGTH_SHORT).show();
                        count++;
                        if(isEnd(count)){
                            goBack();
                        }
                    } else {
                        Toast.makeText(DragShape.this, "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        if (wrong != null) {
                            wrong.start();
                        }
                    }
                }
                return true;
            }
        });

        answerImageView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(null, shadowBuilder, v, 0);
                return true;
            }
        });


    }

    private boolean isMatch(ImageView targetImage, ImageView droppedImage) {
        String droppedTag = (String) droppedImage.getTag();
        String targetTag = (String) targetImage.getTag();
//        if(droppedTag.equals(targetTag)){
//            count++;
//        }

        return droppedTag.equals(targetTag);

    }




    private boolean isEnd(int value){
        return value >= 4;
    }

    private void goBack(){
        Intent intent = new Intent(DragShape.this, Animation_done.class);
        startActivity(intent);
        onBackPressed();
    }


}