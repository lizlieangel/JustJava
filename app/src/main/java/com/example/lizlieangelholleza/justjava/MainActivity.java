package com.example.lizlieangelholleza.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    private int calculatePrice() {
      return quantity * 5;
    }

    public String createOrderSummary(int price) {
        return "Name: Kaptain Kunal \n" +
                "Quantity: " + quantity + "\n" +
                "Total: " + price + "\n" +
                "Thank you!";
    }

    public void displayQuantity(int q) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + q);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }


    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
