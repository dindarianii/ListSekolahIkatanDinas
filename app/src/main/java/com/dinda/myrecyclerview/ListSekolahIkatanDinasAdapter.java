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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSekolahIkatanDinasAdapter extends RecyclerView.Adapter<ListSekolahIkatanDinasAdapter.CategoryViewHolder> {
    public ListSekolahIkatanDinasAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<SekolahIkatanDinas> getListSekolahIkatanDinas() {
        return listSekolahIkatanDinas;
    }

    public void setListSekolahIkatanDinas(ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas) {
        this.listSekolahIkatanDinas = listSekolahIkatanDinas;
    }

    private ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_sekolahikatandinas, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListSekolahIkatanDinas().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListSekolahIkatanDinas().get(position).getRemarks());
        Glide.with(context)
                .load(getListSekolahIkatanDinas().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.mContainer.setTag(position);
        categoryViewHolder.mContainer.setOnClickListener(new View.OnClickListener() {
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout mContainer;
        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            mContainer = itemView.findViewById(R.id.itemcontainer);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
