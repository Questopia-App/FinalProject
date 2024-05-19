package com.example.finalproject.MusicPlace;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class GuessInstrumentQuiz extends AppCompatActivity {

    private TextView questionText, scoreText;
    private Button option1, option2, nextButton;
    private int currentQuestion = 0;
    private int score = 0;

    private LottieAnimationView musicwave2;

    private MediaPlayer questionPlayer, correctSound, wrongSound;

    String heading = "IDENTIFY THE INSTRUMENT";

    private String[][] options = {{"DRUMS", "TAMBOURINE"},
            {"MANDOLIN", "HARP"},
            {"PIANO", "ACCORDION"},
            {"CLARINET", "FLUTE"},
            {"UKULELE","GUITAR"}};
    private int[] correctAnswers = {0, 1, 0, 1, 1}; // Index of correct answer for each question
    private int[] audioFiles = {R.raw.music_drums, R.raw.music_harp, R.raw.music_piano, R.raw.music_flute,R.raw.music_guitar};

    private ArrayList<Integer> questionOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_guess_instrument_quiz);

        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        nextButton = findViewById(R.id.nextButton);
        musicwave2 = findViewById(R.id.wave);

        correctSound = MediaPlayer.create(this, R.raw.correct_answer);
        wrongSound = MediaPlayer.create(this, R.raw.wrong_answer);

        musicwave2.playAnimation();

        // Initialize and shuffle question order
        questionOrder = new ArrayList<>();
        for (int i = 0; i < options.length; i++) {
            questionOrder.add(i);
        }
        Collections.shuffle(questionOrder);

        loadQuestion();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                if (questionPlayer != null) {
                    questionPlayer.stop();
                    questionPlayer.release();
                    questionPlayer = null;
                }
                finish(); // Close the activity
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void loadQuestion() {
        if (currentQuestion < options.length) {
            int questionIndex = questionOrder.get(currentQuestion);
            questionText.setText(heading);
            option1.setText(options[questionIndex][0]);
            option2.setText(options[questionIndex][1]);

            option1.setBackgroundColor(Color.parseColor("#ADD8E6")); // Light blue color
            option2.setBackgroundColor(Color.parseColor("#ADD8E6")); // Light blue color

            questionPlayer = MediaPlayer.create(this, audioFiles[questionIndex]);
            questionPlayer.start();
        } else {
            showScore();
        }
    }

    private void checkAnswer(int selectedOption) {
        questionPlayer.stop();

        int questionIndex = questionOrder.get(currentQuestion);
        if (selectedOption == correctAnswers[questionIndex]) {
            score += 10;
            correctSound.start();
            scoreText.setText("Score: " + score);
        } else {
            wrongSound.start();
        }

        // Highlight the correct and incorrect options
        if (correctAnswers[questionIndex] == 0) {
            option1.setBackgroundColor(Color.GREEN);
            option2.setBackgroundColor(Color.RED);
        } else {
            option2.setBackgroundColor(Color.GREEN);
            option1.setBackgroundColor(Color.RED);
        }

        // Make the next button visible
        nextButton.setVisibility(View.VISIBLE);
    }

    private void nextQuestion() {
        currentQuestion++;
        nextButton.setVisibility(View.GONE);
        loadQuestion();
    }

    private void showScore() {
        questionText.setText("Well Played!");
        scoreText.setText("Your Score: " + score);
        nextButton.setText("Return to MenuPage");
        nextButton.setVisibility(View.VISIBLE);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to home screen
                finish();
            }
        });
    }
}
