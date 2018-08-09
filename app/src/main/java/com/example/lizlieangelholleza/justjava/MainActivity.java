package com.example.lizlieangelholleza.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ChoiceFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int quantity = 1;
    private int basePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        boolean whippedCream = hasCream();
        boolean chocolate = hasChocolate();
        int price = calculatePrice();
        String name = getUsername();
        String order = createOrderSummary(price, whippedCream, chocolate, name);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, ""+ order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        basePrice = 5;
    }

    private boolean hasCream() {
        CheckBox wc = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = wc.isChecked();
        if(hasWhippedCream) {
            basePrice = basePrice + 1;
        }
        return hasWhippedCream;
    }

    private boolean hasChocolate() {
        CheckBox choco = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChoco = choco.isChecked();
        if(hasChoco) {
            basePrice = basePrice + 2;
        }
        return hasChoco;
    }

    private int calculatePrice() {
        int total = quantity * basePrice;
        return total;
    }

    private String getUsername() {
        EditText name = (EditText) findViewById(R.id.name);
        String username = name.getText().toString();
        return username;
    }

    public String createOrderSummary(int price, boolean whippedCream, boolean chocolate,String name) {
        String orderSummary = getString(R.string.order_summary_name, name) + "\n";
        orderSummary += getString(R.string.order_summary_whipped_cream, whippedCream) + "\n";
        orderSummary += getString(R.string.order_summary_chocolate, chocolate)+ "\n";
        orderSummary += getString(R.string.order_summary_quantity, quantity) + "\n";
        orderSummary += getString(R.string.order_summary_total, price)+ "\n";
        orderSummary += getString(R.string.thank_you);
        return  orderSummary;
    }

    public void displayQuantity(int q) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + q);
    }

    public void increment(View view) {
        if(quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffees.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }


    public void decrement(View view) {
        if(quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
