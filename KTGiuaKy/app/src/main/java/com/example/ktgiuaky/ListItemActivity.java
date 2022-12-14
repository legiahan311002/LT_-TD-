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

        arrayCourse.add(new Course("C??m Chi??n", "C??m Chi??n D????ng Ch??u", R.drawable.comchien, "C??m Chi??n D????ng Ch??u full topping si??u c???p vip pro ?????n t??? Eat Food."));
        arrayCourse.add(new Course("C?? Vi??n Chi??n", "C?? Vi??n Chi??n M???m", R.drawable.cavienchien, "C?? Vi??n Chi??n N?????c M???m ?????m ???? si??u ngon ?????n t??? nh?? Eat Food. "));
        arrayCourse.add(new Course("M??? X??o ", "M??? X??o H???i S???n", R.drawable.mixao, "M??? X??o H???i S???n th??m ngon m???i b???n ??n nghen ?????n t??? nh?? ??n Eat Food ."));
        arrayCourse.add(new Course("M??? Cay", "M??? Cay H??n Qu???c", R.drawable.micay, "M??? Cay H??n Qu???c c???p ????? t??? 1-7 , tu??? ch???n theo m???c ????? ??n cay c???a b???n v?? chu???n h????ng v??? H??n Qu???c ?????n t??? nh?? ??n Eat Food. "));
        arrayCourse.add(new Course("G?? R??n","G?? R??n H??n Qu???c",R.drawable.garan,"G?? R??n H??n Qu???c Th??m 7 v??? ?????t c???p ????? 5* cho b???n tho???i m??i l???a ch???n ?????n t??? nh?? ??n Eat Food . "));
    }
}
