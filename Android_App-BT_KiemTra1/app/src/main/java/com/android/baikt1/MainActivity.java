package com.android.baikt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView singleRV;
    private List<Single> singleList;
    private SingleAdapter singleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        singleRV = (RecyclerView) findViewById(R.id.singleRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        singleRV.setLayoutManager(layoutManager);
        singleRV.setHasFixedSize(true);
        singleAdapter = new SingleAdapter(singleList,this);
        singleRV.setAdapter(singleAdapter);
    }

    private void getData() {
        singleList = new ArrayList<>();

        singleList.add(new Single("Kim Jisoo", "Jisoo", "Korea", R.drawable.jisoo, R.drawable.five));
        singleList.add(new Single("Kim Jennie", "Jennie", "Korea", R.drawable.jennie, R.drawable.five));
        singleList.add(new Single("Park Chaeyoung", "Róse", "Australia", R.drawable.rose, R.drawable.five));
        singleList.add(new Single("Lalisa Manobal", "Lisa", "ThaiLand", R.drawable.lisa, R.drawable.five));
    }
}