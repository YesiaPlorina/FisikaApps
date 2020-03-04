package com.yesia.fisika.hukumNewton.latihanSoalHkDua;

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
import com.yesia.fisika.hukumNewton.latihanSoalHkSatu.HasilHkSatu;

import java.util.Locale;

public class LatihanSoalHkDua extends AppCompatActivity {



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
            "1. Berapakah percepatan benda?",
            "2. Berapa tegangan tali?",
            "3. Sebuah bola besi memiliki massa 100 kg.  Kemudian, bola besi tersebut menggelinding sehingga memperoleh gaya percepatan 9,8 m/s2. Berapa besar gaya yang diperlukan untuk menggelindingkan bola tersebut?",
            "4. Sebuah benda yang semula diam bergerak dengan percepatan tetap selama 10 sekon. Jika jarak yang ditempuh 50 m dan massa benda 5 kg, maka besar gaya yang bekerja adalah…",
            "5. Sebuah mobil mula-mula melaju dengan kecepatan 72 km/jam di atas jalan raya. Jika koefisien gesek antara ban dengan jalan 0,8, jarak temuh mobil sejak direm hingga berhenti adalah …… (g = 10 m/s2)"
    };

    String[] jawaban_kuis = new String[]{
            "A. 0.5 m/s2 ", "B. 5 m/s2 ", "C. 50 m/s2 ", "D. 500 m/s2 ",
            "A. 35 N", "B. 45 N", "C. 15 N", "D. 25 N",
            "A. 0,098 N", "B. 980 N", "C. 98 N", "D. 0,98 N",
            "A. 10 N", "B. 200 N", "C. 50 N", "D. 550 N",
            "A. 15 N", "B. 20 N", "C. 25 N", "D. 40 N",
    };

    String[] jawaban_benar = new String[]{
            "B. 5 m/s2 ",
            "A. 35 N",
            "B. 980 N",
            "A. 10 N",
            "C. 25 N",
    };
    String[] penjelasan_jawaban = new String[]{
            "ma = 7 kg\n" +
                    "\n" +
                    "mb = 3 kg\n" +
                    "\n" +
                    "  F  = 50 N\n" +
                    "\n" +
                    "Pada benda A, terdapat gaya tegangan tali (T) ke kanan.\n" +
                    "\n" +
                    "Karena\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "  T = 7 . a    ….(i)\n" +
                    "\n" +
                    "Pada benda B, terdapat gaya tegangan tali (T) ke kiri dan F = 50 N ke kanan\n" +
                    "\n" +
                    "Sehingga,\n" +
                    "\n" +
                    "50 – T = 3 . a    ….(ii)\n" +
                    "\n" +
                    "Dari persamaan I dan ii, kita eliminasi untuk mendapatkan nilai a\n" +
                    "\n" +
                    "        T = 7a\n" +
                    "\n" +
                    "50 – T = 3a\n" +
                    "\n" +
                    "       50 = 10a\n" +
                    "\n" +
                    "         a = 5 m/s2",
            "ma = 7 kg\n" +
                    "\n" +
                    "mb = 3 kg\n" +
                    "\n" +
                    "  F  = 50 N\n" +
                    "\n" +
                    "Pada benda A, terdapat gaya tegangan tali (T) ke kanan.\n" +
                    "\n" +
                    "Karena\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "  T = 7 . a    ….(i)\n" +
                    "\n" +
                    "Pada benda B, terdapat gaya tegangan tali (T) ke kiri dan F = 50 N ke kanan\n" +
                    "\n" +
                    "Sehingga,\n" +
                    "\n" +
                    "50 – T = 3 . a    ….(ii)\n" +
                    "\n" +
                    "Dari persamaan I dan ii, kita eliminasi untuk mendapatkan nilai a\n" +
                    "\n" +
                    "        T = 7a\n" +
                    "\n" +
                    "50 – T = 3a\n" +
                    "\n" +
                    "       50 = 10a\n" +
                    "\n" +
                    "         a = 5 m/s2\n" +
                    "\n" +
                    "Selanjutnya, substitusi nilai ke salah satu persamaan untuk mendapatkan nilai T\n" +
                    "\n" +
                    "T = 7a\n" +
                    "\n" +
                    "   = 7 . 5\n" +
                    "\n" +
                    "   = 35 N",
            "Diketahui:\n" +
                    "m = 100 kg\n" +
                    "a = 9,8 m/s2\n" +
                    "\n" +
                    "Ditanya: F = … ?\n" +
                    "\n" +
                    "Jawab:\n" +
                    "F = m a\n" +
                    "= 100 kg x 9,8 m/s2\n" +
                    "= 980 kg m/s2\n" +
                    "= 980 N\n" +
                    "Jadi, gaya yang diperlukan adalah 980 N.",
            " ",
            " "

    };
    int[] gambarSoal = new int[]{
            R.drawable.soal_hk_dua_no_satu,
            R.drawable.soal_hk_dua_no_satu,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground

    };
    int[] gambarPenjelesan = new int[]{
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.penjelasan_soal_hk_dua_no_empat,
            R.drawable.penjelasan_soal_hk_dua_no_lima

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
                Intent hasil = new Intent(getApplicationContext(), HasilHkDua.class);
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
                Intent hasil = new Intent(getApplicationContext(), HasilHkDua.class);
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
