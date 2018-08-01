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
        int price = quantity * 5;
        String message = "Total: $ " + price + "\n Thank you";
        displayMessage(message);
    }

    public void display(int q) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + q);
    }

    public void displayPrice(int p) {
        TextView price = (TextView) findViewById(R.id.price_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(p));
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    public void displayMessage(String message) {
        TextView pricetext = (TextView) findViewById(R.id.price_text_view);
        pricetext.setText(message);
    }
}
