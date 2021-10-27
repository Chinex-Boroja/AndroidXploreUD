package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int healthLevel;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void displayMessage(String text) {
        TextView message = (TextView) findViewById(R.id.display_message);
        message.setText(text);
    }

    public void checkResult(View view) {
        displayFinalResultText();
        displayCount(healthLevel);
    }

    public void yes(View view) {
        healthLevel++;
        message = "You answered yes, current health level is " + healthLevel;
        displayHealthLevelCount(healthLevel);
        displayMessage(message);
    }

    public void sometimes(View view) {
        healthLevel = healthLevel + 0;
        message = "You answered sometimes, current health level is " + healthLevel;
        displayHealthLevelCount(healthLevel);
        displayMessage(message);
    }

    public  void no(View view) {
        healthLevel--;
        message = "You answered no, current health level is " + healthLevel;
        displayHealthLevelCount(healthLevel);
        displayMessage(message);
    }

    private void displayHealthLevelCount(int score) {
        TextView currentScore = (TextView) findViewById(R.id.current_score);
        currentScore.setText("Your current score is: " + score);
    }

    private void displayFinalResultText() {
        TextView finalResultText = (TextView) findViewById(R.id.result_message);
        finalResultText.setText("Final Result is:");
    }

    private void displayCount(int scored) {
        TextView count = (TextView) findViewById(R.id.count_message);
        count.setText("You scored " + scored );
    }
}