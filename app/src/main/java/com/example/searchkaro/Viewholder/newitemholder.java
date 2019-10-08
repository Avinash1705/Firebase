package com.example.searchkaro.Viewholder;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchkaro.R;
import com.squareup.picasso.Picasso;

public class newitemholder extends RecyclerView.ViewHolder {
    View mview;

    public newitemholder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
    }
    //set details to recycler view row
    public void setDetails(Context context,String title,String description,String image){
        //view
        TextView mTile=mview.findViewById(R.id.newItem_title);
        TextView mDes=mview.findViewById(R.id.newItem_description);
        ImageView mImage=mview.findViewById(R.id.newItem_image);

        //set Data to views
        mTile.setText(title);
        mDes.setText(description);
        Picasso.get().load(image).into(mImage);

    }
}
