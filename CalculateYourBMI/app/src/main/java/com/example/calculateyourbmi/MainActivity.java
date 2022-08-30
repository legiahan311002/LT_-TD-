package com.example.calculateyourbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText chieucao,cannang;
    Button  tieptuc;
    Double  w,h;
    Boolean a,b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chieucao = (EditText) findViewById(R.id.chieucao);
        cannang = (EditText) findViewById(R.id.cannang);
        tieptuc = (Button) findViewById(R.id.tieptuc);

    }
    protected void onResume(){
        super.onResume();
        tieptuc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(isEmpty(chieucao)){
                    Toast.makeText(MainActivity.this, "Hãy nhập chiều cao của bạn!",Toast.LENGTH_LONG).show();
                    a=false;
                }
                else{
                    h=Double.parseDouble(chieucao.getText().toString());
                    a=true;
                }
                if(isEmpty(cannang)) {
                    Toast.makeText(MainActivity.this,  "Hãy nhập chiều cao của bạn!", Toast.LENGTH_LONG).show();
                    b = false;
                }
                else{
                    w=Double.parseDouble(cannang.getText().toString());
                    b=true;
                }
                if(a&b){
                    Intent activity_ketqua = new Intent(MainActivity.this,ketqua_bmi.class);
                    Bundle thongso = new Bundle();
                    thongso.putDouble("cannang",w);
                    thongso.putDouble("chieucao",h);
                    activity_ketqua.putExtra("dulieu",thongso);
                    startActivity(activity_ketqua);
                }
            }
        });

    }
    protected void onPause(){super.onPause();}
    private boolean isEmpty(EditText exText){
        if(exText.getText().toString().trim().length()>0)
            return false;
        return true;
    }
}
