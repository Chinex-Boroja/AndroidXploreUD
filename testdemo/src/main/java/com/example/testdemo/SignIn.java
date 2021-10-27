package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final Button button = (Button) findViewById(R.id.userBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(SignIn.this, User.class);
                SignIn.this.startActivity(currentActivity);
            }
        });

        final Button button1 = (Button) findViewById(R.id.specialistBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(SignIn.this, Specialist.class);
                SignIn.this.startActivity(currentActivity);
            }
        });

        final Button button2 = (Button) findViewById(R.id.signUpBtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(SignIn.this, User.class);
                SignIn.this.startActivity(currentActivity);
            }
        });
    }
}