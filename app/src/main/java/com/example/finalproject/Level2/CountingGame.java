package com.example.finalproject.Level2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

public class CountingGame extends AppCompatActivity {

    private int score = 0;
    private int level = 1;
    private int correctAnswer;

    private TextView questionTextView;
    private EditText userAnswerEditText;
    private Button checkAnswerButton;
    private TextView resultTextView;
    private TextView scoreTextView;
    private TextView levelTextView;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_game);

        questionTextView = findViewById(R.id.questionTextView);
        userAnswerEditText = findViewById(R.id.userAnswerEditText);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        levelTextView = findViewById(R.id.levelTextView);
//        timer = findViewById(R.id.timer);

        // Set initial question
        setQuestion();

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void setQuestion() {
        int operand1 = (int) (Math.random() * 10 * level);
        int operand2 = (int) (Math.random() * 10 * level);

        correctAnswer = operand1 + operand2;

        questionTextView.setText(operand1 + " + " + operand2 + " = ?");
        resultTextView.setText("");
        userAnswerEditText.getText().clear();
//        startTimer();
    }

    private void checkAnswer() {
        String userAnswerString = userAnswerEditText.getText().toString().trim();

        if (!userAnswerString.isEmpty()) {
            int userAnswer = Integer.parseInt(userAnswerString);

            if (userAnswer == correctAnswer) {
                resultTextView.setText("Correct!");
                score += 10;
                scoreTextView.setText("Score: " + score);
                level++;
                levelTextView.setText("Level " + level);
            } else {
                resultTextView.setText("Incorrect. Try again!");
            }

            setQuestion();
        } else {
            resultTextView.setText("Please enter an answer.");
        }
    }

//    private void startTimer() {
//        timer.start();
//    }

    // You may need to override onPause() or onDestroy() to cancel the timer and release resources

    // Other methods as needed...

}