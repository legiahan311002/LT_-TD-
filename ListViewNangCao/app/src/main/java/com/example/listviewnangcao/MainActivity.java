package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AnhXa();

        adapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }
    private void  AnhXa(){
        lvTraiCay = (ListView) findViewById(R.id.listViewTraiCay);
        arrayTraiCay = new ArrayList<>();
        arrayTraiCay.add(new TraiCay("Cơm Chiên","Cơm Chiên Dương Châu",R.drawable.comchien));
        arrayTraiCay.add(new TraiCay("Gà Rán","Gà Rán vị sốt hàn quốc",R.drawable.garan));
        arrayTraiCay.add(new TraiCay("Ca Viên Chiên","Cơm Viên Chiên Nước Mắm",R.drawable.cavienchien));
        arrayTraiCay.add(new TraiCay("Mỳ Cay","Mỳ Cay Hàn Quốc Cấp Độ 7",R.drawable.micay));
        arrayTraiCay.add(new TraiCay("Mỳ Xào","Mỳ Xào Hải Sản",R.drawable.mixao));
    }
}