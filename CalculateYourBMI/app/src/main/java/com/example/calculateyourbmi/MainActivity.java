package com.example.calculateyourbmi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button caculateBtn = (Button) findViewById(R.id.tieptuc);
        caculateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
            EditText edtHeight = (EditText) findViewById(R.id.edtHeight);

            String sWeight = edtWeight.getText().toString();
            String sHeight = edtHeight.getText().toString();

            float fWeight =  Float.valueOf(sWeight);
            float fHeight =  Float.valueOf(sHeight);

            float fBMI = fWeight / (fHeight * fHeight);

            EditText edtResult = (EditText) findViewById(R.id.editTextTextPersonName);
            edtResult.setText(String.valueOf(fBMI));

            EditText edtEvaluate = (EditText) findViewById(R.id.editTextTextPersonName2);

            if (fBMI < 18) {
                edtEvaluate.setText("Người gầy");
            } else if(fBMI > 18 && fBMI <24.9) {
                edtEvaluate.setText("Người bình thường");
            } else if (fBMI > 25 && fBMI <29.9) {
                edtEvaluate.setText("Người béo phì độ I");
            } else if (fBMI > 30 && fBMI <34.9) {
                edtEvaluate.setText("Người béo phì độ II");
            } else {
                edtEvaluate.setText("Người béo phì độ III");
            }

        } catch (Exception e) {
            Toast.makeText(v.getContext(), "Error during calculating BMI"+e.toString(), Toast.LENGTH_SHORT);
        }
    }
}
