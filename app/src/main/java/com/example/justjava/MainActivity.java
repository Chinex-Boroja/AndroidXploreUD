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
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
        //int price = quantity * 5;
        //display(quantity);
        //displayPrice(quantity * 5);
        //priceMessage = priceMessage + " Woohoo!";
        //String orderNumber = "Order number:" +
    }

     /**
      * Calculates the price of the order.
      * @return total price
      */
     private int calculatePrice() {
         int pricePerCup = 10;
         return quantity * pricePerCup;
     }

     /** create the summary of the order
      *
      * @param price of the order
      * @return the priceMessage
      */
     private String createOrderSummary(int price) {
         String priceMessage = "Name: Chinex Boroja";
         priceMessage += "\nQuantity: " + quantity;
         priceMessage += "\nTotal: $" + price + "\nThank you!";
         return priceMessage;

     }

     /**
      * This method displays the given quantity value on the screen
      */
     private void displayQuantity(int numberOfCoffees) {
         TextView quantityTextView = (TextView) findViewById(
                 R.id.quantity_text_view);
         quantityTextView.setText("" + numberOfCoffees);
     }

     /**
      * This method displays the given price on the screen.
      */
     private void displayPrice(int number) {
         TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
         priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }

     /**
      * This method displays the given text on the screen
      */
     private void displayMessage(String message) {
         TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
         orderSummaryTextView.setText(message);
     }

     /**
      * this method is called when the order button is clicked
      */
     public void increment(View view) {
         quantity++;
         displayQuantity(quantity);
     }

     /**
      * this method is called when the order button is clicked
      */
     public void decrement(View view) {
         quantity--;
         displayQuantity(quantity);
     }
 }