package com.example.lizlieangelholleza.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int quantity = 2;
        display(quantity);
        displayPrice(quantity * 5);
    }

    public void display(int q) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + q);
    }

    public void displayPrice(int p) {
        TextView price = (TextView) findViewById(R.id.price_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(p));
    }
}
