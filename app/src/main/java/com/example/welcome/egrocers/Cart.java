package com.example.welcome.egrocers;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {

    RecyclerView recy;
    RecyclerView.LayoutManager managerr;
FirebaseDatabase data;
DatabaseReference ref;

TextView text;
FButton btno;


List<Order> cart= new ArrayList<>();

CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);




recy=(RecyclerView)findViewById(R.id.listcart);
recy.setHasFixedSize(true);
managerr= new LinearLayoutManager(this);
recy.setLayoutManager(managerr);

text=(TextView)findViewById(R.id.total);
btno=(FButton)findViewById(R.id.place);

btno.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent i = new Intent(Cart.this,Confirm.class);
startActivity(i);

    }
});


listfood();
    }




    private void listfood() {

        cart = new Database(this).getCarts();
        cartAdapter = new CartAdapter(cart, this);
        recy.setAdapter(cartAdapter);

        int total = 0;

        for (Order order : cart) {

            total = total + (Integer.parseInt(order.getPrice())) * (Integer.parseInt(order.getQuantity()));
            Locale locale = new Locale("en", "US");
            NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

            text.setText(fmt.format(total));


        }
    }
    }

