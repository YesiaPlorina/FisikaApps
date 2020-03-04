package com.yesia.fisika.hukumNewton.latihanSoalHkSatu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yesia.fisika.R;

import java.util.Locale;

public class LatihanSoalHkSatu extends AppCompatActivity {


    ImageView imageSoal,imagePenjelasan;
    TextView tvSoal, tvPenjelasan, tvTimer;
    RadioButton rbPilihanA, rbPilihanB, rbPilihanC, rbPilihanD;
    RadioGroup rgPilihan;
    Button btnNext;

    int nomor = 0;
    public static int hasil, benar, salah;
    public static MediaPlayer mediaPlayer;

    private static final long START_TIME_IN_MILLIS = 600000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    String[] pertanyaan_kuis = new String[]{
            "1. Bila resultan gaya yang bekerja pada sebuah benda sama dengan nol, maka pernyataan di bawah ini yang benar adalah….",
            "2. Satuan gaya adalah Newton. Satu newton setara dengan… .",
            "3. Gaya sebesar 24 N dengan arah ke kanan bekerja ke objek yang berada di atas lantai kasar. Jika objek tersebut dalam keadaan tidak bergerak. Hitung besar gaya gesek antara objek dengan lantai",
            "4. Sebuah benda ditarik oleh 3 tali yang satu diantaranya berlawanan arah. Jika benda tersebut tetap diam di tempat meski ditarik oleh tiga gaya. Berapa nilai F3 jika nilai F1 = 14 N dan F2 = 20 N ?",
            "5. Hitunglah gaya normal yang bekerja pada benda tersebut!"
    };

    String[] jawaban_kuis = new String[]{
            "A. Kecepatan selalu tetap meski waktunya berubah-ubah", "B. Percepatannya selalu tetap meski waktunya berubah-ubah", "C. Kecepatannya selalu berubah-ubah meski waktunya tetap", "D. Percepatannya selalu berubah-ubah meski waktunya tetap ",
            "A. kg.m.s", "B. kg.m/s", "C. N.s", "D.kg.m/s2",
            "A. 0 N", "B. 24 N", "C. 2,4 N", "D. 240 N",
            "A. 6 N", "B. 34 N", "C. 24 N", "D. 14 N",
            "A. 0.6 N ", "B. 6 N ", "C. 60 N", "D. 600 N ",
    };

    String[] jawaban_benar = new String[]{
            "A. Kecepatan selalu tetap meski waktunya berubah-ubah",
            "D.kg.m/s2",
            "B. 24 N",
            "B. 34 N",
            "C. 60 N",
    };
    String[] penjelasan_jawaban = new String[]{
            "ƩF = 0\n" +
                    "Kondisi ini berlaku pada benda diam atau benda bergerak lurus beraturan dengan kecepatan tetap.",
            "Satuan gaya diturunkan dari satuan massa dan percepatan, yaitu F=m.a = Kg.m/s2",
            "Gaya gesek selalu berlawanan dengan arah gerak atau arah kecenderungan gerak benda, sehingga dapat digambarkan sebagai berikut.Karena benda dalam keadaan diam maka\n" +
                    "∑F = 0\n" +
                    "F−fs = 0\n" +
                    "fs=F=24 N",
            "Oleh karena benda tidak bergerak, maka kita menggunakan prinsip Hukum Newton 1.\n" +
                    "\n" +
                    "∑FX = 0\n" +
                    "\n" +
                    "F1 + F2 – F3 = 0\n" +
                    "\n" +
                    "F3 = F1 + F2\n" +
                    "\n" +
                    "F3 = 14 + 20\n" +
                    "\n" +
                    "F3 = 34 N",
            "Pembahasan:\n" +
                    "\n" +
                    "m = 6 kg\n" +
                    "\n" +
                    "g = 10 m/s2\n" +
                    "\n" +
                    "W = m . g\n" +
                    "\n" +
                    "    = 6 x 10\n" +
                    "\n" +
                    "    = 60 N\n" +
                    "\n" +
                    "Dari contoh soal, kita dapat mengetahui bahwa berat (W) berat dipengaruhi oleh gaya gravitasi dan gaya normal (N) selalu tegak lurus ke permukaan yang bersentuhan dengan benda. Perhatikan gambar berikut.\n" +
                    "\nSehingga,\n" +
                    "\n" +
                    "N – W = 0\n" +
                    "\n" +
                    "N – 60 = 0\n" +
                    "\n" +
                    "       N = 60 N",
    };
    int[] gambarSoal = new int[]{
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.soal_hk_satu_no_empat,
            R.drawable.soal_hk_satu

    };
    int[] gambarPenjelesan = new int[]{
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.penjelelasan_hk_satu_no_tiga,
            R.drawable.soal_hk_satu_no_empat,
            R.drawable.penjelasan_soal_hk_satu

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_satu);

        imageSoal = findViewById(R.id.iv_soal_main);
        imagePenjelasan = findViewById(R.id.gambar_penjelasan);
        tvSoal = findViewById(R.id.tv_soal_main);
        tvPenjelasan = findViewById(R.id.tv_penjelasan_main);
        tvTimer = findViewById(R.id.tv_timer_main);
        rgPilihan = findViewById(R.id.rg_pilihan_main);
        rbPilihanA = findViewById(R.id.rb_pilihan_a_main);
        rbPilihanB = findViewById(R.id.rb_pilihan_b_main);
        rbPilihanC = findViewById(R.id.rb_pilihan_c_main);
        rbPilihanD = findViewById(R.id.rb_pilihan_d_main);
        btnNext = findViewById(R.id.btn_next_main);


        tvSoal.setText(pertanyaan_kuis[nomor]);
        imageSoal.setImageResource(gambarSoal[nomor]);
        rbPilihanA.setText(jawaban_kuis[0]);
        rbPilihanB.setText(jawaban_kuis[1]);
        rbPilihanC.setText(jawaban_kuis[2]);
        rbPilihanD.setText(jawaban_kuis[3]);

//        reset nilai ketika mengulang soal

        rgPilihan.check(0);
        benar = 0;
        salah = 0;
        startTimer();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
                tvPenjelasan.setText("");
                imagePenjelasan.setImageResource(R.drawable.ic_launcher_foreground);
                PilihanJawabanShow();
            }
        });

        rbPilihanA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penjelasan();
                hideA();
            }
        });

        rbPilihanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penjelasan();
                hideB();
            }
        });
        rbPilihanC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penjelasan();
                hideC();
            }
        });
        rbPilihanD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penjelasan();
                hideD();
            }
        });

    }


    @SuppressLint("SetTextI18n")
    public void next() {

        if (rbPilihanA.isChecked() || rbPilihanB.isChecked() || rbPilihanC.isChecked() || rbPilihanD.isChecked()) {
            RadioButton jawabanUser = (RadioButton) findViewById(rgPilihan.getCheckedRadioButtonId());
            String ambilJawabanUser = jawabanUser.getText().toString();

            //reset jawaban pilihan pada radioButton
            rgPilihan.check(0);

            if (ambilJawabanUser.equalsIgnoreCase(jawaban_benar[nomor])) {
                benar++;
            } else {
                salah++;
            }
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                tvSoal.setText(pertanyaan_kuis[nomor]);
                imageSoal.setImageResource(gambarSoal[nomor]);
                rbPilihanA.setText(jawaban_kuis[(nomor * 4) + 0]);
                rbPilihanB.setText(jawaban_kuis[(nomor * 4) + 1]);
                rbPilihanC.setText(jawaban_kuis[(nomor * 4) + 2]);
                rbPilihanD.setText(jawaban_kuis[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent hasil = new Intent(getApplicationContext(), HasilHkSatu.class);
                startActivity(hasil);
            }

        } else {

            Toast.makeText(this, "Pilih Jawaban", Toast.LENGTH_LONG).show();
        }

    }

    private void PilihanJawabanShow() {
        rbPilihanA.setEnabled(true);
        rbPilihanB.setEnabled(true);
        rbPilihanC.setEnabled(true);
        rbPilihanD.setEnabled(true);
    }

    private void hideD() {
        rbPilihanA.setEnabled(false);
        rbPilihanB.setEnabled(false);
        rbPilihanC.setEnabled(false);
        rbPilihanD.setEnabled(true);
    }

    private void hideC() {
        rbPilihanA.setEnabled(false);
        rbPilihanB.setEnabled(false);
        rbPilihanC.setEnabled(true);
        rbPilihanD.setEnabled(false);
    }

    private void hideB() {
        rbPilihanA.setEnabled(false);
        rbPilihanB.setEnabled(true);
        rbPilihanC.setEnabled(false);
        rbPilihanD.setEnabled(false);
    }

    private void hideA() {
        rbPilihanA.setEnabled(true);
        rbPilihanB.setEnabled(false);
        rbPilihanC.setEnabled(false);
        rbPilihanD.setEnabled(false);
    }

    private void penjelasan() {
        RadioButton jawabanUser = (RadioButton) findViewById(rgPilihan.getCheckedRadioButtonId());
        String ambilJawabanUser = jawabanUser.getText().toString();

        if (ambilJawabanUser.equalsIgnoreCase(jawaban_benar[nomor])) {
            tvPenjelasan.setText("BENAR\n karena : \n" + penjelasan_jawaban[nomor]);
            imagePenjelasan.setImageResource(gambarPenjelesan[nomor]);
        } else {
            tvPenjelasan.setText("SALAH\n jawaban benar adalah : \n"
                    + jawaban_benar[nomor]
                    + "\nkarena\t"
                    + penjelasan_jawaban[nomor]);
            imagePenjelasan.setImageResource(gambarPenjelesan[nomor]);
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                tvTimer.setText("Time's Up!");
                countDownTimer.cancel();
                hasil = benar * 20;
                Intent hasil = new Intent(getApplicationContext(), HasilHkSatu.class);
                startActivity(hasil);
            }
        }.start();
        mTimerRunning = true;
    }


    private void updateCountDownText() {
        int minute = (int) mTimeLeftInMillis / 1000 / 60;
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minute, seconds);

        tvTimer.setText(timeLeftFormatted);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
