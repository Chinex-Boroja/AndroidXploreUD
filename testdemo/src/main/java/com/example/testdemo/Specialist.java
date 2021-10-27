package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Specialist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);

        final Button button = (Button) findViewById(R.id.userBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(Specialist.this, User.class);
                Specialist.this.startActivity(currentActivity);
            }
        });

        final Button button1 = (Button) findViewById(R.id.loginBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentActivity = new Intent(Specialist.this, SignIn.class);
                Specialist.this.startActivity(currentActivity);
            }
        });
    }
}