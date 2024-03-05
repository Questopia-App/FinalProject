package com.example.finalproject.Level1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

import java.util.Random;

public class AlphabetMatchGame extends AppCompatActivity {

    private TextView targetLetterTextView;
    private TextView scoreTextView;
    private EditText userInputEditText;
    private Button resetButton,checkButton;
    private int score = 0;

    private char randomChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_match_game);

        targetLetterTextView = findViewById(R.id.targetLetterTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        userInputEditText = findViewById(R.id.userInputEditText);
        resetButton = findViewById(R.id.resetButton);
        checkButton = findViewById(R.id.checkButton);

        // Set the initial target letter
        startGame();

        // Set onClick listener for reset button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                scoreTextView.setText("SCORE : 0");
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLetter(v);
            }
        });
    }


    private void startGame(){
        generateRandomChar();
        targetLetterTextView.setText(String.valueOf(randomChar));
    }



    private void generateRandomChar() {
        Random random = new Random();
        randomChar = (char) (random.nextInt(26) + 'A');
    }


    public void checkLetter(View view) {
        String userInput = userInputEditText.getText().toString().toUpperCase();
        if (!userInput.isEmpty() && userInput.charAt(0) == randomChar) {
            score += 10;
            updateScore();
        }else{
            Toast.makeText(getApplicationContext(), "Incorrect answer", Toast.LENGTH_SHORT).show();;
        }
        startGame();
    }

    private void updateScore(){
        scoreTextView.setText("SCORE : "+score);
    }

}
