package com.example.welcome.egrocers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WELCOME on 2/5/2019.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

public TextView txtv;
public ImageView imgv;

private  ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);


        imgv=(ImageView)itemView.findViewById(R.id.imgmenu);
        txtv=(TextView)itemView.findViewById(R.id.namemenu);
itemView.setOnClickListener(this);


    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {


        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
