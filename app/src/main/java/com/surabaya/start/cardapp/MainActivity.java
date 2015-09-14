package com.surabaya.start.cardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvAngka, tvHasil;
    CheckBox cbCream, cbCoklat, cbOreo;

    int a;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // cara untuk berpindah activity
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                // mengisi nilai2 yang akan dibawa ke activity selanjutnya
                i.putExtra("val", tvAngka.getText().toString());
                i.putExtra("res", tvHasil.getText().toString());
                i.putExtra("cream", cbCream.isChecked());
                i.putExtra("coklat", cbCoklat.isChecked());
                i.putExtra("oreo", cbOreo.isChecked());
                // jangan lupa start itentnya
                startActivity(i);
            }
        });

        cbCream = (CheckBox) findViewById(R.id.cbCream);
        cbCoklat = (CheckBox) findViewById(R.id.cbCoklat);
        cbOreo = (CheckBox) findViewById(R.id.cbOreo);

        tvAngka = (TextView) findViewById(R.id.tvNumber);
        tvHasil = (TextView) findViewById(R.id.tvResult);

        if (savedInstanceState != null) {
            // mengecek apakah ada data di state sebelumnya
            if (savedInstanceState.getString("val") != null) {
                tvAngka.setText(savedInstanceState.getString("val"));
            }
            if (savedInstanceState.getString("res") != null) {
                tvHasil.setText(savedInstanceState.getString("res"));
            }
            cbCream.setChecked(savedInstanceState.getBoolean("cream"));
            cbCoklat.setChecked(savedInstanceState.getBoolean("coklat"));
            cbOreo.setChecked(savedInstanceState.getBoolean("oreo"));
        }

        String s = tvAngka.getText().toString();
        a = Integer.parseInt(s);
    }

    // menyimpan data sebelum berganti state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("val", tvAngka.getText().toString());
        outState.putString("res", tvHasil.getText().toString());
        outState.putBoolean("cream", cbCream.isChecked());
        outState.putBoolean("coklat", cbCoklat.isChecked());
        outState.putBoolean("oreo", cbOreo.isChecked());
    }

    public void onClickBtnResult(View v) {
        result = a * 5;
        if (cbCream.isChecked()) {
            result += a;
        }
        if (cbCoklat.isChecked()) {
            result += (a * 2);
        }
        if (cbOreo.isChecked()) {
            result += (float) (a * 1.5);
        }
        tvHasil.setText("$" + String.valueOf(result));
    }

    public void onClickBtnPlus(View v) {
        a++;
        tvAngka.setText(String.valueOf(a));
    }

    public void onClickBtnMin(View v) {
        a--;
        tvAngka.setText(String.valueOf(a));
    }
}














