package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class OnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        final Button button = (Button) findViewById(R.id.onBoardingBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(OnBoarding.this, WelcomePage.class);
                OnBoarding.this.startActivity(currentActivity);
            }
        });

    }
}