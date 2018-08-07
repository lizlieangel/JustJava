package com.example.lizlieangelholleza.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private boolean hasWhippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        boolean whippedCream = isCheckboxClicked();
        displayMessage(createOrderSummary(price, whippedCream));
    }

    private int calculatePrice() {
      return quantity * 5;
    }

    private boolean isCheckboxClicked() {
        CheckBox wc = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = wc.isChecked();
        return hasWhippedCream;
    }
    public String createOrderSummary(int price, boolean whippedCream) {
        return "Name: Kaptain Kunal \n" +
                "Quantity: " + quantity + "\n" +
                "Has Whipped Cream: " + whippedCream + "\n" +
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
