package com.example.tuan3_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

        ListView lvMonHoc;
        ArrayList<String> arrayCourse;
        EditText edtMonHoc;
        Button btnThem,btnCapNhat;
        int vitri = -1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listview);
            lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
            btnThem=(Button) findViewById(R.id.buttonThem);
            btnCapNhat = (Button)findViewById(R.id.buttonCapNhat) ;
            edtMonHoc = (EditText) findViewById(R.id.editTextMonHoc);
            arrayCourse = new ArrayList<>();
            arrayCourse.add("Android");
            arrayCourse.add("PHP");
            arrayCourse.add("IOS");
            arrayCourse.add("ASP.NET");
            arrayCourse.add("Web");
            ArrayAdapter adapter = new ArrayAdapter(ListViewActivity.this,android.R.layout.simple_list_item_1,arrayCourse);
            lvMonHoc.setAdapter(adapter);

            btnThem.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    String monhoc = edtMonHoc.getText().toString();
                    arrayCourse.add(monhoc);
                    adapter.notifyDataSetChanged();
                }
            });
            lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    edtMonHoc.setText(arrayCourse.get(position));

                    vitri = position;
                }
            });
            btnCapNhat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayCourse.set(vitri,edtMonHoc.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            });
            lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    arrayCourse.remove(position);
                    adapter.notifyDataSetChanged();
                    return false;
                }
            });
        }

    }


