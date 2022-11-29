package com.example.ktra3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSubject;
    ArrayList<Course> arrayCourse;
    CourseAdapter adapter;
    private ImageView imagehome,imageprofile,imagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        adapter = new CourseAdapter(this, R.layout.activity_item,arrayCourse);
        lvSubject.setAdapter(adapter);

        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = arrayCourse.get(position);
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);

                intent.putExtra("img", course.getImage());
                intent.putExtra("courseName", course.getName());
                intent.putExtra("detail", course.getDetail());

                startActivity(intent);
            }
        });

    }

    private void mapping() {
        lvSubject = (ListView) findViewById(R.id.lvCourse);
        arrayCourse = new ArrayList<>();

        arrayCourse.add(new Course("Tiếng Anh", "English", R.drawable.tienganh, "Vietnamese is the most difficult language to learn in the world"));
        arrayCourse.add(new Course("Tiếng Việt", "Vietnamese", R.drawable.tiengviet, "Tiếng Việt là ngôn ngữ thuộc dạng khó học nhất thế giới"));
        arrayCourse.add(new Course("Tiếng Pháp", "French", R.drawable.tiengphap, "Le vietnamien est la langue la plus difficile à apprendre au monde"));
        arrayCourse.add(new Course("Tiếng Đức", "German", R.drawable.tiengduc, "Vietnamesisch ist die am schwierigsten zu lernende Sprache der Welt"));

    }
}
