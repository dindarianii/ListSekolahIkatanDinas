package com.dinda.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    TextView mTitle, mSubtitle, mPenjelasan;
    CircleImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        String subtitle = extras.getString("subtitle");
        String penjelasan = extras.getString("penjelasan");
        String image = extras.getString("image");

        mImage = findViewById(R.id.detail_image);
        mTitle = findViewById(R.id.detail_title);
        mSubtitle = findViewById(R.id.detail_subtitle);
        mPenjelasan = findViewById(R.id.detail_penjelasan);

        mTitle.setText(title);
        mSubtitle.setText(subtitle);
        mPenjelasan.setText(penjelasan);

        Glide.with(this)
                .load(image)
                .into(mImage);

    }
}
