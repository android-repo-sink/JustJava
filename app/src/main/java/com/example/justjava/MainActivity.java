package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int price = -1;
    public boolean p = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPrice(5);
        display(quantity = 2);
    }

    /**
     * This method is called when the order button is called
     */
    public int submitOrder(View view) {
//        display(quantity);
//        displayPrice(quantity * price);
//        String priceMessage = "Free";
        if (quantity != 0) {
            if (p)
                displayMessage("$" + quantity * price + "\nThank You!\n\n\n");
            else
                displayMessage("$" + quantity * price + "\nThank You!");
            p = !p;
        } else
            displayMessage("Sure?");
        return 0;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void setPrice(int price) {
        this.price = price;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        // get the current price
//        int number = 1 + Integer.parseInt((String) ((TextView) findViewById(R.id.quantity_text_view)).getText());
        // no need of checking here, we can order as many coffees as we want
        display(++quantity);     // add another cup
    }

    public void decrement(View view) {
//    TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//    int number = Integer.parseInt((String) quantityTextView.getText());
        if (quantity > 0)
            display(--quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}