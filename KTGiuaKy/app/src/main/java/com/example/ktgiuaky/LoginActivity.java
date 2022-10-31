package com.example.ktgiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button backBtn, signBtn;
    EditText username, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backBtn = (Button) findViewById(R.id.button4);
        signBtn = (Button) findViewById(R.id.button2);
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        String passUname = getIntent().getStringExtra("username");
        String passPword = getIntent().getStringExtra("password");

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                        || (username.getText().toString().equals(passUname) && password.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



}
