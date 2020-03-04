package com.yesia.fisika.hukumNewton.latihanSoalHkDua;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yesia.fisika.R;
import com.yesia.fisika.hukumNewton.HukumDua;
import com.yesia.fisika.hukumNewton.HukumSatu;

public class HasilHkDua extends AppCompatActivity {

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


        tvHasil.setText("Jawaban Benar : " + LatihanSoalHkDua.benar + "\n Jawaban Salah : " + LatihanSoalHkDua.salah);
        tvNilai.setText("" + LatihanSoalHkDua.hasil);

        btnUlangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(), LatihanSoalHkDua.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HasilHkDua.this, HukumDua.class);
                startActivity(intent);
            }
        });

    }
}