 package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

 public class MainActivity extends AppCompatActivity {

     int quantity = 2; //Global variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the order button is clicked
     */
    public void submitOrder(View view) {
        //display(quantity);
        //displayPrice(quantity * 5);
        String priceMessage = "Free";
        displayMessage(priceMessage);
    }

     /**
      * This method displays the given quantity value on the screen
      */
     private void display(int number) {
         TextView quantityTextView = (TextView) findViewById(
                 R.id.quantity_text_view);
         quantityTextView.setText("" + number);
     }

     /**
      * This method displays the given price on the screen.
      */
     private void displayPrice(int number) {
         TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
         priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }

     /**
      * This method displays the given text on the screen
      */
     private void displayMessage(String message) {
         TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
         priceTextView.setText(message);
     }

     /**
      * this method is called when the order button is clicked
      */
     public void increment(View view) {
         quantity++;
         display(quantity);
     }

     /**
      * this method is called when the order button is clicked
      */
     public void decrement(View view) {
         quantity--;
         display(quantity);
     }
 }