package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXacNhan;
    EditText edtUserName,edtPassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtUserName.setText(sharedPreferences.getString("taikhoan",""));
        edtPassword.setText(sharedPreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked",false));


        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  username = edtUserName.getText().toString().trim();
                String  password = edtPassword.getText().toString().trim();

                if(username.equals("giahan") && password.equals("3110")){
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();

                    }
                }else{
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void AnhXa(){
        btnXacNhan = (Button) findViewById(R.id.button);
        edtPassword = (EditText) findViewById(R.id.editTextTextPassword);
        edtUserName = (EditText) findViewById(R.id.editTextTextPersonName);
        cbRemember = (CheckBox) findViewById(R.id.checkBox);
     }
}