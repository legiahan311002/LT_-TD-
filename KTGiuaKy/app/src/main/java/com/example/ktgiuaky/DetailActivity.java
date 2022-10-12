package com.example.ktgiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView image;
    TextView courseName, courseDetail;
    private ImageView imagehome,imageprofile,imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        imagehome = (ImageView) findViewById(R.id.imagehome);
        imageprofile = (ImageView) findViewById(R.id.imageprofile);
        imagelist = (ImageView) findViewById(R.id.imagelist);

        imagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        imageprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        imagelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ListItemActivity.class);
                startActivity(intent);
            }
        });

        image = (ImageView) findViewById(R.id.img);
        courseName = (TextView) findViewById(R.id.courseName);
        courseDetail = (TextView) findViewById(R.id.detail);

        String name = getIntent().getStringExtra("courseName");
        String detail = getIntent().getStringExtra("detail");
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("img");

        courseName.setText(name);
        courseDetail.setText(detail);
        image.setImageResource(img);


    }
}