package com.surabaya.start.cardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnTambah, btnKurang, btnHasil;
    TextView tvAngka, tvHasil;

    int a, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = (Button) findViewById(R.id.btnPlus);
        btnKurang = (Button) findViewById(R.id.btnMin);
        btnHasil= (Button) findViewById(R.id.btnCount);

        tvAngka = (TextView) findViewById(R.id.tvNumber);
        tvHasil = (TextView) findViewById(R.id.tvResult);

        String s = tvAngka.getText().toString();
        a = Integer.parseInt(s);
    }

    public void onClickBtnResult (View v) {
        result = a * 5;
        tvHasil.setText("$"+String.valueOf(result));
    }

    public void onClickBtnPlus (View v) {
        a++;
        tvAngka.setText(String.valueOf(a));
    }

    public void onClickBtnMin (View v) {
        a--;
        tvAngka.setText(String.valueOf(a));
    }
}
