package com.yesia.fisika.hukumNewton.latihanSoalHkTiga;

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

public class LatihanSoalHkTiga extends AppCompatActivity {


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
            "1. Tama memiliki massa sebesar 40 kg, kemudian Tama mendorong tembok dengan gaya 200 N. Maka, gaya reaksi yang dilakukan oleh tembok terhadap Tama adalah sebesar?",
            "2. Anggap lereng bukit rata dan memiliki koefisien gesek 0,125. Percepatan gravitasi bumi 10 m/s2 dan sin 53o = 0,8, cos 53o = 0,6. Tentukan nilai dari : Gaya normal pada balok",
            "3. Anggap lereng bukit rata dan memiliki koefisien gesek 0,125. Percepatan gravitasi bumi 10 m/s2 dan sin 53o = 0,8, cos 53o = 0,6. Tentukan nilai dari : Gaya gesek antara lereng dan balok",
            "4. Anggap lereng bukit rata dan memiliki koefisien gesek 0,125. Percepatan gravitasi bumi 10 m/s2 dan sin 53o = 0,8, cos 53o = 0,6. Tentukan nilai dari : Percepatan gerak balok",
            "5. Jika benda ini diam, carilah besar dan arah gaya gesek !"
    };

    String[] jawaban_kuis = new String[]{
            "A. 200 N ", "B. -200 N ", "C. 400 N ", "D. -400 N ",
            "A. 300 N", "B. 400 N", "C. 500 N", "D. 600 N",
            "A. 75 newton", "B.65 newton", "C.15 newton", "D. 55 newton",
            "A. 7,5 m/s2", "B. 725 m/s2", "C. 7,25 m/s2", "D. 75 m/s2",
            "A. 10 N ke kiri", "B. 10 N ke kanan", "C. 20 N ke kiri", "D. 20 N ke kiri",
    };

    String[] jawaban_benar = new String[]{
            "B. -200 N ",
            "D. 600 N",
            "A. 75 newton",
            "C. 7,25 m/s2",
            "A. 10 N ke kiri",
    };
    String[] penjelasan_jawaban = new String[]{
            "Diketahui : m           = 40 kg\n" +
                    "\n" +
                    "                       F(aksi) = 200N(+)\n" +
                    "\n" +
                    "Ditanya    : F(reaksi) ?\n" +
                    "\n" +
                    "Jawaban : B\n" +
                    "\n" +
                    "F(aksi)      =     -F(reaksi)\n" +
                    "\n" +
                    "200            =     -F(reaksi)\n" +
                    "\n" +
                    "F(reaksi) =      -200N",
            "Gaya-gaya pada balok diperlihatkan gambar berikut: a) Gaya normal pada balok\n" +
                    "\n" +
                    "Σ Fy = 0\n" +
                    "\n" +
                    "N − W cos θ = 0\n" +
                    "\n" +
                    "N − mg cos 53o = 0\n" +
                    "\n" +
                    "N − (100)(10)(0,6) = 0\n" +
                    "\n" +
                    "N = 600 Newton",
            "b) Gaya gesek antara lereng dan balok\n" +
                    "\n" +
                    "fges = μk N\n" +
                    "\n" +
                    "fges = (0,125)(600) = 75 newton",
            "c) Percepatan gerak balok\n" +
                    "\n" +
                    "Σ Fx = ma\n" +
                    "\n" +
                    "W sin θ − fges = ma\n" +
                    "\n" +
                    "mg sin 53o − fges = ma\n" +
                    "\n" +
                    "(100)(10)(0,8) − 75 = 100a\n" +
                    "\n" +
                    "a = 725/100 = 7,25 m/s2",
            "Pembahasan:\n" +
                    "\n" +
                    "mA = 4 kg\n" +
                    "\n" +
                    "mB = 5 kg\n" +
                    "\n" +
                    "WA = m . g\n" +
                    "\n" +
                    "    = 4 x 10\n" +
                    "\n" +
                    "    = 40 N\n" +
                    "\n" +
                    "WB = m . g\n" +
                    "\n" +
                    "    = 5 x 10\n" +
                    "\n" +
                    "    = 50 N\n" +
                    "\n" +
                    "Pada contoh soal, kita anggap katrolnya licin maka katrolnya tidak bergerak dan tali tidak bergesekan dengan katrol sehingga tegangan tali dianggap sama (T). Asumsikan gaya gesek (f) ke kiri . Perhatikan gambar berikut.\n" +
                    "    Benda A\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "WA –  T = 0\n" +
                    "\n" +
                    "40 – T = 0\n" +
                    "\n" +
                    "       T = 40 N\n" +
                    "\n" +
                    "    Benda B\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "  T – WB . sin 37– f = 0\n" +
                    "\n" +
                    "40 –  50 . 3/5– f = 0\n" +
                    "\n" +
                    "       40 – 30 – f = 0\n" +
                    "\n" +
                    "              10 – f = 0\n" +
                    "\n" +
                    "                     f = 10 N (f bernilai positif maka asumsi gaya gesek ke kiri benar)\n" +
                    "\n" +
                    "Jadi, gaya gesek benda sebesar 10 N ke kiri.",
    };
    int[] gambarSoal = new int[]{
            R.drawable.ic_launcher_foreground,
            R.drawable.soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.soal_hk_tiga_no_lima

    };
    int[] gambarPenjelesan = new int[]{
            R.drawable.ic_launcher_foreground,
            R.drawable.penjelasan_soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.penjelasan_soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.penjelasan_soal_hk_tiga_no_dua_tiga_empat,
            R.drawable.penjelasan_soal_hk_tiga_no_lima

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
                Intent hasil = new Intent(getApplicationContext(), HasilHkTiga.class);
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
                Intent hasil = new Intent(getApplicationContext(), HasilHkTiga.class);
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
