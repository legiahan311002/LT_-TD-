package com.example.calculateyourbmi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ketqua_bmi extends AppCompatActivity {
    TextView ketqua;
    Button ok_btn;
    Double BMI;

    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua_bim);
        ketqua = (TextView) findViewById(R.id.Ketqua);
        ok_btn = (Button) findViewById(R.id.ok_btn);
    }
    protected void onResume(){
        super.onResume();
        Intent caller = getIntent();
        Bundle dulieunhan = caller.getBundleExtra("dulieu");
        Double  chieucao = dulieunhan.getDouble("chieucao");
        Double cannang = dulieunhan.getDouble("cannang");
        BMI = cannang/(chieucao*chieucao);
        BMI = (double) Math.round(BMI*100)/100;
        String kq ;
        if(BMI <16 ){kq = "Bạn chỉ còn da bọc xương ";}
        else if(BMI < 17 ){kq = "Bạn suy dinh dưỡng cấp độ 2";}
        else if(BMI < 18.5 ){kq = "Bạn suy dinh dưỡng cấp độ 1";}
        else if(BMI < 24.9 ){kq = "Bạn Bình thường";}
        else if(BMI < 29 ){kq = "Bạn suy dinh dưỡng cấp độ 2";}
        else if(BMI < 35 ){kq = "Bạn suy dinh dưỡng cấp độ 2";}



    }
}
