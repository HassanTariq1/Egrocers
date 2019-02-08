package com.example.welcome.egrocers;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by WELCOME on 2/6/2019.
 */
class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

public TextView txtcart, txtprice;
public ImageView cartimagee;

private ItemClickListener item;

    public void setTxtcart(TextView txtcart) {
        this.txtcart = txtcart;
    }

    public CartViewHolder(View itemView) {
        super(itemView);

        txtcart=(TextView)itemView.findViewById(R.id.cartitem);
        txtprice=(TextView)itemView.findViewById(R.id.cartprice);
        cartimagee=(ImageView)itemView.findViewById(R.id.cartimage);

    }

    @Override
    public void onClick(View view) {

    }
}
public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Order> listdata= new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View itemv=inflater.inflate(R.layout.cart_layout,parent,false);
return new CartViewHolder(itemv);


    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {

        TextDrawable drawable =TextDrawable.builder()
                .buildRound(""+listdata.get(position).getQuantity(), Color.RED);
        holder.cartimagee.setImageDrawable(drawable);



       // int price=(Integer.parseInt(listdata.get(position).getPrice()))*(Integer.parseInt(listdata.get(position).getQuantity()));


        holder.txtcart.setText(listdata.get(position).getProductName());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
