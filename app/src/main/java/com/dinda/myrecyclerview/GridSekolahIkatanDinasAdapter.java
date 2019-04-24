package com.dinda.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridSekolahIkatanDinasAdapter extends RecyclerView.Adapter<GridSekolahIkatanDinasAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas;

    private ArrayList<SekolahIkatanDinas> getListSekolahIkatanDinas() {
        return listSekolahIkatanDinas;
    }

    public void setListSekolahIkatanDinas(ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas) {
        this.listSekolahIkatanDinas = listSekolahIkatanDinas;
    }

    public GridSekolahIkatanDinasAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_sekolahikatandinas, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListSekolahIkatanDinas().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.mContainer.setTag(position);
        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                Bundle extras = new Bundle();
                extras.putString("title",getListSekolahIkatanDinas().get(position).getName());
                extras.putString("subtitle",getListSekolahIkatanDinas().get(position).getRemarks());
                extras.putString("penjelasan",getListSekolahIkatanDinas().get(position).getPenjelasan());
                extras.putString("image",getListSekolahIkatanDinas().get(position).getPhoto());

                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListSekolahIkatanDinas().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        LinearLayout mContainer;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.itemcontainer);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}