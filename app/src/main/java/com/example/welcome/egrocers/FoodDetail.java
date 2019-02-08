package com.example.welcome.egrocers;

import android.provider.ContactsContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {

    TextView foodname, foodprice, fooddes;
    ImageView foodimg;
    CollapsingToolbarLayout collapse;
    FloatingActionButton btncart;
    ElegantNumberButton numberButton;

    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foodd;

Food currentfood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

    database= FirebaseDatabase.getInstance();
    foodd= database.getReference("Food");


    numberButton=(ElegantNumberButton)findViewById(R.id.number);
    btncart=(FloatingActionButton) findViewById(R.id.btncart);


    btncart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            new Database(getBaseContext()).addtocart(new Order(

            foodId,
             currentfood.getName(),
                    numberButton.getNumber(),
                    currentfood.getPrice(),
                    currentfood.getDiscount()

            ));



            Toast.makeText(FoodDetail.this,"Add to cart ",Toast.LENGTH_SHORT).show();

        }
    });

    fooddes=(TextView)findViewById(R.id.food_deesc);
    foodname=(TextView)findViewById(R.id.foodnamee);
    foodprice=(TextView)findViewById(R.id.foodprice);
    foodimg=(ImageView)findViewById(R.id.imggfood);

collapse=(CollapsingToolbarLayout)findViewById(R.id.colapsee);

collapse.setExpandedTitleTextAppearance(R.style.Collapseee);
collapse.setCollapsedTitleTextAppearance(R.style.adapterCollapseee);


if(getIntent() !=null)
foodId=getIntent().getStringExtra("FoodId");
if(!foodId.isEmpty())

{




        getFood(foodId);



}



    }

    private void getFood(String foodId) {

        foodd.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                currentfood= dataSnapshot.getValue(Food.class);
                Picasso.get().load(currentfood.getImage())
                        .into(foodimg);

                collapse.setTitle(currentfood.getName());
                foodprice.setText(currentfood.getPrice());
                foodname.setText(currentfood.getName());
                fooddes.setText(currentfood.getDescription());



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
