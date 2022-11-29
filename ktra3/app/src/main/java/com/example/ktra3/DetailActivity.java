package com.example.ktra3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    Button button;
    ImageView image;
    TextView courseName, courseDetail;
    private ImageView imagehome,imageprofile,imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);



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

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(DetailActivity.this,"Lưu Thành Công",Toast.LENGTH_SHORT).show();
            }
        });

    }
}