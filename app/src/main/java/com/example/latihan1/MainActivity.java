package com.example.latihan1;

import static com.example.latihan1.R.id.btn_bagi;
import static com.example.latihan1.R.id.btn_kali;
import static com.example.latihan1.R.id.btn_kurang;
import static com.example.latihan1.R.id.btn_tambah;
import static com.example.latihan1.R.id.result;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonadd, buttonsub, buttonmul, buttondiv;
    EditText editText1, editText2;
    TextView textView;
    int value1, value2;
    double dbvalue1, dbvalue2, hasildb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd = findViewById(btn_tambah);
        buttonsub = findViewById(R.id.btn_kurang);
        buttonmul = findViewById(R.id.btn_kali);
        buttondiv = findViewById(R.id.btn_bagi);
        editText1 = findViewById(R.id.num1);
        editText2 = findViewById(R.id.num2);
        textView  = findViewById(R.id.result);

        buttonadd.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttonmul.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View v) {
        value1 = getIntFromEditText(editText1);
        value2 = getIntFromEditText(editText2);
        int id = v.getId();

        if(id == btn_tambah){
            textView.setText("Hasil = " + (String.valueOf(result = value1 + value2)));
        } else if(id == btn_kurang) {
            textView.setText("Hasil = " + (String.valueOf(result = value1 - value2)));
        } else if(id == btn_kali) {
            textView.setText("Hasil = " + (String.valueOf(result = value1 * value2)));
        } else if(id == btn_bagi) {
            if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_SHORT).show();
                textView.setText("Hasil = 0");
            } else {
                dbvalue1 = Integer.parseInt(editText1.getText().toString());
                dbvalue2 = Integer.parseInt(editText2.getText().toString());
                hasildb = dbvalue1 / dbvalue2;
                textView.setText("Hasil = " + (String.valueOf(hasildb)));
            }
        }
    }
}