package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final Button button = (Button) findViewById(R.id.specialistBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(User.this, Specialist.class);
                User.this.startActivity(currentActivity);
            }
        });

        final Button button1 = (Button) findViewById(R.id.loginBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(User.this, SignIn.class);
                User.this.startActivity(currentActivity);
            }
        });

    }
}