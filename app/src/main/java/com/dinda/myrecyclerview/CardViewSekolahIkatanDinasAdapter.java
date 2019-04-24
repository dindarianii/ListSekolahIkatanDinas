package com.dinda.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewSekolahIkatanDinasAdapter extends RecyclerView.Adapter<CardViewSekolahIkatanDinasAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas;
    private ArrayList<SekolahIkatanDinas> getListSekolahIkatanDinas() {
        return listSekolahIkatanDinas;
    }
    public void setListSekolahIkatanDinas(ArrayList<SekolahIkatanDinas> listSekolahIkatanDinas) {
        this.listSekolahIkatanDinas = listSekolahIkatanDinas;
    }
    public CardViewSekolahIkatanDinasAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_sekolahikatandinas, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        SekolahIkatanDinas p = getListSekolahIkatanDinas().get(i);

        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(p.getName());
        cardViewViewHolder.tvRemarks.setText(p.getRemarks());

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Rate "+getListSekolahIkatanDinas().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListSekolahIkatanDinas().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.mContainer.setTag(i);
        cardViewViewHolder.mContainer.setOnClickListener(new View.OnClickListener() {
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

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        CardView mContainer;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            mContainer = itemView.findViewById(R.id.itemcontainer);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}