package com.surabaya.start.cardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // mengambil data dari activity sebelumnya
        extra = getIntent().getExtras();
        if (extra != null){
            // cara mengakses objek view tanpa harus membuat variablenya
            ((TextView) findViewById(R.id.tvJumlKopi)).setText("- Jumlah Kopi : " + extra.getString("val"));
            String cream;
            if(extra.getBoolean("cream")) {
                cream = "Ya";
            } else {
                cream = "Tidak";
            }
            ((TextView) findViewById(R.id.tvCream)).setText("- Cream : " + cream);
            // satu baris code dibawah (baris ke-30) (begitu juga di baris ke-32) sama berarti dengan 6 baris code pada baris ke-21 smpai ke-26
            // lebih singkat bukan? ^_^ info lebih jelas cari di internet ya
            String coklat = extra.getBoolean("coklat") ? "Ya" : "Tidak";
            ((TextView) findViewById(R.id.tvCoklat)).setText("- Coklat : " + coklat);
            String oreo = extra.getBoolean("oreo") ? "Ya" : "Tidak";
            ((TextView) findViewById(R.id.tvOreo)).setText("- Oreo : " + oreo);
            ((TextView) findViewById(R.id.tvTotal)).setText("- Harga Total : " + extra.getString("res"));
        }

        (findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // untuk menutup activity
                finish();
            }
        });
    }
}
