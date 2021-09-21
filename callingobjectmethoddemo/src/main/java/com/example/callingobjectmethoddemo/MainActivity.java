package com.example.callingobjectmethoddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**TextView textView = new TextView(this); // referring to the current Activity
        textView.setText("We Back!!");
        textView.setTextColor(Color.RED);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(36);
        setContentView(textView);*/
    }
}