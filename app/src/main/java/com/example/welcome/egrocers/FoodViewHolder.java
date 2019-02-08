package com.example.welcome.egrocers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WELCOME on 2/6/2019.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food;
    public ImageView foodimg;

    private  ItemClickListener itemclickk;

    public FoodViewHolder(View itemView) {
        super(itemView);


        food=(TextView) itemView.findViewById(R.id.namefood);
        foodimg=(ImageView) itemView.findViewById(R.id.imgfood);
        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemclickk = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemclickk.onClick(view,getAdapterPosition(),false);


    }
}
