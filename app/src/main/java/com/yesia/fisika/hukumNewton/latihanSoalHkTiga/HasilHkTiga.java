package com.yesia.fisika.hukumNewton.latihanSoalHkTiga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yesia.fisika.R;
import com.yesia.fisika.hukumNewton.HukumSatu;
import com.yesia.fisika.hukumNewton.HukumTiga;

public class HasilHkTiga extends AppCompatActivity {

    TextView tvHasil, tvNilai;
    Button btnUlangi, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_hk_satu);

        tvHasil = findViewById(R.id.tv_hasil);
        tvNilai = findViewById(R.id.tv_nilai);
        btnUlangi = findViewById(R.id.btn_ulangi);
        btnBack = findViewById(R.id.btn_backto_hk_satu);


        tvHasil.setText("Jawaban Benar : " + LatihanSoalHkTiga.benar + "\n Jawaban Salah : " + LatihanSoalHkTiga.salah);
        tvNilai.setText("" + LatihanSoalHkTiga.hasil);

        btnUlangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(), LatihanSoalHkTiga.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HasilHkTiga.this, HukumTiga.class);
                startActivity(intent);
            }
        });

    }
}