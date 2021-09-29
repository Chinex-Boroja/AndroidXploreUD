 package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

 public class MainActivity extends AppCompatActivity {

     int quantity = 2 ; //Global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the order button is clicked
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        CheckBox addedChocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText addName = (EditText) findViewById(R.id.input_name);

        String showName = addName.getText().toString();
        //Log.v("MainActivity", "Name: " + showName);

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        boolean hasAddedChocolate = addedChocolateCheckbox.isChecked();
        //Log.v("MainActivity", "has whipped screen " + hasWhippedCream);
        int price = calculatePrice(hasWhippedCream, hasAddedChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasAddedChocolate, showName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order for " + showName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        startActivity(intent);
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        startActivity(intent);

//       displayMessage(priceMessage);
        //int price = quantity * 5;
        //display(quantity);
        //displayPrice(quantity * 5);
        //priceMessage = priceMessage + " Woohoo!";
        //String orderNumber = "Order number:" +
    }

     /**
      * Calculates the price of the order.
      *
      * @param addWhippedCream is whether or not the customer wants whipped cream topping
      * @param addChocolate is whether or not the customer wants chocolate topping
      * @return total price
      */
     private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

         //price of 1 cup of coffee
         int pricePerCup = 10;

         //add $1 if the user wants whipped cream
         if (addWhippedCream) {
             pricePerCup = pricePerCup + 1;
         }

         //add $2 if the customer wants chocolate
         if (addChocolate) {
             pricePerCup = pricePerCup + 2;
         }

         // Calculate the total order price by multiplying by quantity
         return quantity * pricePerCup;
     }

     /** create the summary of the order
      * @param addName of the customer
      * @param addChocolate shows whether a user wants chocolate or not
      * @param price of the order
      * @param addWhippedCream  shows whether a user wants whipped cream or not
      * @return the priceMessage
      */
     private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String addName) {
         String priceMessage = "Name: " + addName;
         priceMessage += "\nAdd whipped cream? " + addWhippedCream;
         priceMessage += "\nAdd chocolate? " + addChocolate;
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
//     private void displayPrice(int number) {
//         TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//         priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//     }

     /**
      * This method displays the given text on the screen
      */
//     private void displayMessage(String message) {
//         TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//         orderSummaryTextView.setText(message);
//     }

     /**
      * this method is called when the order button is clicked
      */
     public void increment(View view) {

         if (quantity == 100) {

             //display a message
             Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();

             //exit the method
             return;
         }
         quantity++;
         displayQuantity(quantity);
     }

     /**
      * this method is called when the order button is clicked
      */
     public void decrement(View view) {
         if (quantity == 1) {

             //display a message
             Toast.makeText(this, "Yo u cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();

             //exit the method when quantity is 1
             return;
         }
         quantity--;
         displayQuantity(quantity);

     }
 }