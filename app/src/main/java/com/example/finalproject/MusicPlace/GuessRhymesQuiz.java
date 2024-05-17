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

        import androidx.appcompat.app.AppCompatActivity;

public class GuessRhymesQuiz extends AppCompatActivity {

    private TextView questionText, scoreText;
    private Button option1, option2, nextButton;
    private int currentQuestion = 0;
    private int score = 0;

    private LottieAnimationView musicwave2;

    private MediaPlayer questionPlayer, correctSound, wrongSound;

    String heading = "IDENTIFY THE RHYME";

    private String[][] options = {{"Baa Baa Black Sheep", "Hickory Dickory Dock"},
                                    {"Little Miss Muffet","Humpty Dumpty"},
                                    {"Mary Had a Little Lamb", "Old MacDonald Had a Farm"},
                                    {"Jack and Jill","Twinkle Twinkle Little Star"}};
    private int[] correctAnswers = {0, 1, 0, 1}; // Index of correct answer for each question
    private int[] audioFiles = {R.raw.music_blacksheep, R.raw.music_humpty, R.raw.music_marylamb, R.raw.music_twinkle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_guess_rhymes_quiz);

        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        nextButton = findViewById(R.id.nextButton);
        musicwave2 = findViewById(R.id.wave);

        correctSound = MediaPlayer.create(this, R.raw.correct_answer);
        wrongSound = MediaPlayer.create(this, R.raw.wrong_answer);

        musicwave2.playAnimation();

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
        if (currentQuestion < 4) {
            questionText.setText(heading);
            option1.setText(options[currentQuestion][0]);
            option2.setText(options[currentQuestion][1]);

            option1.setBackgroundColor(Color.parseColor("#ADD8E6")); // Light blue color
            option2.setBackgroundColor(Color.parseColor("#ADD8E6")); // Light blue color


            questionPlayer = MediaPlayer.create(this, audioFiles[currentQuestion]);
            questionPlayer.start();
        } else {
            showScore();
        }
    }

    private void checkAnswer(int selectedOption) {
        questionPlayer.stop();

        if (selectedOption == correctAnswers[currentQuestion]) {
            score+=10;
            correctSound.start();
            scoreText.setText("Score: "+score);
        } else {
            wrongSound.start();
        }

        // Highlight the correct and incorrect options
        if (correctAnswers[currentQuestion] == 0) {
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
