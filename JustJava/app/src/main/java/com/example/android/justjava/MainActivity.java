package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked. (submitOrder 1.0)
     */
//    public void submitOrder(View view) {
//
//        CheckBox WhippedBox = (CheckBox) findViewById(R.id.notify_me_checkbox);
//        CheckBox ChocdBox = (CheckBox) findViewById(R.id.notify_me_checkbox_choc);
//        EditText clientName = (EditText) findViewById(R.id.EditText_String);
//
//        int numberOfCoffees = quantity;
////        String priceTextView = "Total: $";
//
////        displayMessage(priceTextView);
//        display(numberOfCoffees);
//
//        int finalValue = calculatePrice( WhippedBox.isChecked(), ChocdBox.isChecked());
//        int price = (quantity * finalValue);
//
//        createOrderSummary(price, WhippedBox.isChecked(), ChocdBox.isChecked(), String.valueOf(clientName.getText()));
//        //displayPrice(numberOfCoffees * 5);
//    }

    /**
     * This method is called when the order button is clicked. (submitOrder 2.0)
     */
    public void submitOrder(View view) {
        CheckBox WhippedBox = (CheckBox) findViewById(R.id.notify_me_checkbox);
        CheckBox ChocdBox = (CheckBox) findViewById(R.id.notify_me_checkbox_choc);
        EditText clientName = (EditText) findViewById(R.id.EditText_String);
        int finalValue = calculatePrice( WhippedBox.isChecked(), ChocdBox.isChecked());
        int price = (quantity * finalValue);


        String emailContent = (" Name: " + clientName
                + "\n Quantity: "
                + quantity
                + "\nAdd whipped Cream: "
                + WhippedBox.isChecked()
                + "\nAdd chocolate: "
                + ChocdBox.isChecked()
                + "\n Total: "
                + price
                + "\n Thank you!" );
        String subject = "Just Java App for " + clientName;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(intent.EXTRA_TEXT, emailContent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     *  This method increments quantity
     */
    public void increment(View view){
        if (quantity <= 100){
        quantity++;
        display(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Maximum quantity achived!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     *  This method decrements quantity
     */
    public void decrement(View view){

        if(quantity > 1){
            quantity--;
            display(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Minimum quantity achived!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    /**
     *  This method decrements quantity
     */
    public void createOrderSummary (int price, boolean whippedCream, boolean choc, String client){

        displayMessage(" Name: " + client
                + "\n Quantity: "
                + quantity
                + "\nAdd whipped Cream: "
                + whippedCream
                + "\nAdd chocolate: "
                + choc
                + "\n Total: "
                + price
                + "\n Thank you!");
    }

    /**
     *  This method calculates de final price of the coffee
     */
    private int calculatePrice (boolean addWhippedCream, boolean addChocolate){
        int basePrice = 5;

        if(addWhippedCream)
            basePrice = basePrice + 1;
        if (addChocolate)
            basePrice = basePrice + 2;

        return basePrice;
    }

    /**
     *  This method confirms if the client wants whippedcream
     */
//    public boolean checkBoxState (View view){
////        Boolean Whipped = (Boolean) findViewById(R.id.notify_me_checkbox);
//        CheckBox WhippedBox = (CheckBox) findViewById(R.id.notify_me_checkbox);
//        return WhippedBox.isChecked();
//    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView quantityTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        quantityTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
}