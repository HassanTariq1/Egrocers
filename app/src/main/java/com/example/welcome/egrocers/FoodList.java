package com.example.welcome.egrocers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {


    RecyclerView recy;
    RecyclerView.LayoutManager lay;
    FirebaseDatabase databasee;
    DatabaseReference reference;
    FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter;

String cateid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

databasee= FirebaseDatabase.getInstance();
reference=databasee.getReference("Food");
recy=(RecyclerView) findViewById(R.id.recycle);

lay= new LinearLayoutManager(this);
recy.setLayoutManager(lay);


if(getIntent()!=null){

cateid= getIntent().getStringExtra("CategaryId");
if(!cateid.isEmpty() && cateid !=null){




        loadListfood(cateid);


}


}

    }

    private void loadListfood(String cateid) {


        final  FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter=new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,R.layout.food_item,FoodViewHolder.class,
        reference.orderByChild("MenuId").equalTo(cateid)) {
    @Override
    protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
       viewHolder.food.setText(model.getName());
        Picasso.get().load(model.getImage())
                .into(viewHolder.foodimg);

final Food local= model;

viewHolder.setItemClickListener(new ItemClickListener() {
    @Override
    public void onClick(View view, int position, boolean isLongClick) {


        Intent i = new Intent(FoodList.this, FoodDetail.class);
        i.putExtra("FoodId",getRef(position).getKey());
startActivity(i);

    }
});

    }
};
      //  if(adapter != null) adapter.startListening();
recy.setAdapter(adapter);

    }

}
