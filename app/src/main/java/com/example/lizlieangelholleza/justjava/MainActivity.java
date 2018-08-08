package com.example.lizlieangelholleza.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ChoiceFormat;
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
        boolean whippedCream = hasCream();
        boolean chocolate = hasChocolate();
        String name = getUsername();
        displayMessage(createOrderSummary(price, whippedCream, chocolate, name));
    }

    private int calculatePrice() {
      return quantity * 5;
    }

    private boolean hasCream() {
        CheckBox wc = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = wc.isChecked();
        return hasWhippedCream;
    }

    private boolean hasChocolate() {
        CheckBox choco = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChoco = choco.isChecked();
        return hasChoco;
    }

    private String getUsername() {
        EditText name = (EditText) findViewById(R.id.name);
        String username = name.getText().toString();
        return username;
    }

    public String createOrderSummary(int price, boolean whippedCream, boolean chocolate,String name) {
        return "Name: " + name + "\n" +
                "Add Whipped Cream? " + whippedCream + "\n" +
                "Add Chocolate? " + chocolate + "\n" +
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
