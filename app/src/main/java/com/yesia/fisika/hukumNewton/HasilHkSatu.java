package com.yesia.fisika.hukumNewton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yesia.fisika.MainActivity;
import com.yesia.fisika.R;

public class HasilHkSatu extends AppCompatActivity {

    TextView tvHasil, tvNilai;
    Button btnUlangi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_hk_satu);

        tvHasil = findViewById(R.id.tv_hasil);
        tvNilai = findViewById(R.id.tv_nilai);
        btnUlangi = findViewById(R.id.btn_ulangi);


        tvHasil.setText("Jawaban Benar : " + LatihanSoalHkSatu.benar + "\n Jawaban Salah : " + LatihanSoalHkSatu.salah);
        tvNilai.setText("" + LatihanSoalHkSatu.hasil);

        btnUlangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(), LatihanSoalHkSatu.class);
                startActivity(i);
            }
        });

    }
}