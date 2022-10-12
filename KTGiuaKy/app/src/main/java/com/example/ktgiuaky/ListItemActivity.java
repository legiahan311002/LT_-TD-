package com.example.ktgiuaky;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListItemActivity extends AppCompatActivity {
    ListView lvSubject;
    ArrayList<Course> arrayCourse;
    CourseAdapter adapter;
    private ImageView imagehome,imageprofile,imagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcourse);

        mapping();

        adapter = new CourseAdapter(this, R.layout.activity_item,arrayCourse);
        lvSubject.setAdapter(adapter);

        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = arrayCourse.get(position);
                Intent intent = new Intent(ListItemActivity.this,DetailActivity.class);

                intent.putExtra("img", course.getImage());
                intent.putExtra("courseName", course.getName());
                intent.putExtra("detail", course.getDetail());

                startActivity(intent);
            }
        });
        imagehome = (ImageView) findViewById(R.id.imagehome);
        imageprofile = (ImageView) findViewById(R.id.imageprofile);
        imagelist = (ImageView) findViewById(R.id.imagelist);

        imagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        imageprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        imagelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItemActivity.this, ListItemActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        lvSubject = (ListView) findViewById(R.id.lvCourse);
        arrayCourse = new ArrayList<>();

        arrayCourse.add(new Course("Cơm Chiên", "Cơm Chiên Dương Châu", R.drawable.comchien, "Cơm Chiên Dương Châu full topping siêu cấp vip pro đến từ Eat Food."));
        arrayCourse.add(new Course("Cá Viên Chiên", "Cá Viên Chiên Mắm", R.drawable.cavienchien, "Cá Viên Chiên Nước Mắm đậm đà siêu ngon đến từ nhà Eat Food. "));
        arrayCourse.add(new Course("Mỳ Xào ", "Mỳ Xào Hải Sản", R.drawable.mixao, "Mỳ Xào Hải Sản thơm ngon mời bạn ăn nghen đến từ nhà ăn Eat Food ."));
        arrayCourse.add(new Course("Mỳ Cay", "Mỳ Cay Hàn Quốc", R.drawable.micay, "Mỳ Cay Hàn Quốc cấp độ từ 1-7 , tuỳ chọn theo mức độ ăn cay của bạn và chuẩn hương vị Hàn Quốc đến từ nhà ăn Eat Food. "));
        arrayCourse.add(new Course("Gà Rán","Gà Rán Hàn Quốc",R.drawable.garan,"Gà Rán Hàn Quốc Thơm 7 vị đạt cấp độ 5* cho bạn thoải mái lựa chọn đến từ nhà ăn Eat Food . "));
    }
}
