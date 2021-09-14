package com.example.practiceset2ud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PracticeSet2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_set2);

        /**int raspberryPrice = 5;

        display1("1 box: $" + raspberryPrice);

        raspberryPrice = 10;
        display2("2 boxes: $" + (raspberryPrice));
        display3("3 boxes: $" + (raspberryPrice * 3));*/

        String name = "Katherine";
        String name2 = "Kunal";
        String nameOnProfile = "Lyla";

        /**display1("This is Box 1.");
        display2("And this is Box 2.");
        display3("And Look! Box 3!");*/

        /* This program calculates the amount of sleep debt in a week. The user estimates how much
        they sleep on a weekday/ weekend day. The equation assumes you need 8 hours of sleep a night.
        The user in this case sleeps 5 hours on week day and 9 hours on a weekend.
         */

        int weekday = 5;
        int weekend = 9;
        int optimalHours = 8 * 7;
        int actualHours = weekday * 5 + weekend * 2;
        int solution = optimalHours - actualHours;
        display(solution);

    }

    public void display(int text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text + "");
    }

    /**public void display(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text);
    }

    public void display1(String text) {
        display(text);
    }

    public void display2(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view_2);
        t.setText(text);
    }

    public void display3(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view_3);
        t.setText(text);
    } */
}