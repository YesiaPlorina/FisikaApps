package com.yesia.fisika.hukumNewton;

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


    ImageView imageSoal;
    TextView tvSoal, tvPenjelasan, tvTimer;
    RadioButton rbPilihanA,rbPilihanB,rbPilihanC,rbPilihanD;
    RadioGroup rgPilihan;
    Button btnNext;

    int nomor = 0;
    public static int hasil, benar, salah;
    public static MediaPlayer mediaPlayer;

    private static final long START_TIME_IN_MILLIS = 120000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    String[] pertanyaan_kuis = new String[]{
            "1. Satuan momentum adalah . . . .",
            "2. Satuan momentum adalah . . . .",
            "3. Tekanan hidrostatis dipengaruhi oleh . . . .",
            "4. Sifat benda yang memungkinkan benda kembali kebentuk semula setelah gaya yang bekerja pada benda dihilangkan disebut . . . .",
            "5. Hasil kali gaya dengan perpindahan disebut . . . ."
    };

    String[] jawaban_kuis = new String[]{
            "A. Chaeyeon ", "B. Sakura ", "C.Yena ", "D. Hitomi ",
            "A. Kg.m/s", "B.  Kg.m/s2", "C. N.s", "D.m/s2",
            "A. Percepatan", "B. Massa jenis zat cair", "C.  Massa benda", "D. Kecepatan",
            "A. Plastisitas", "B. Emisivitas", "C. Elastisitas", "D. Strain",
            "A. Daya", "B. Usaha", "C. Energy", "D. Upaya",
    };

    String[] jawaban_benar = new String[]{
            "A. ",
            "A. Kg.m/s",
            "B. Massa jenis zat cair",
            "C. Elastisitas",
            "B. Usaha",
    };
    String[] penjelasan_jawaban = new String[]{
            "Perbandingan tegangan terhadap regangan disebut Modulus elastisitas",
            "Satuan momentum adalah Kg.m/s",
            "Besarnya tekanan hidrostatik dipengaruhi oleh kedalaman, gravitasi dan massa jenis zat cair (fluida)",
            "Sifat benda yang memungkinkan benda kembali kebentuk semula setelah gaya yang bekerja pada benda dihilangkan disebut Elastisitas",
            "Hasil kali gaya dengan perpindahan disebut Usaha",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_satu);

        imageSoal = findViewById(R.id.iv_soal_main);
        tvSoal = findViewById(R.id.tv_soal_main);
        tvPenjelasan =findViewById(R.id.tv_penjelasan_main);
        tvTimer = findViewById(R.id.tv_timer_main);
        rgPilihan = findViewById(R.id.rg_pilihan_main);
        rbPilihanA = findViewById(R.id.rb_pilihan_a_main);
        rbPilihanB = findViewById(R.id.rb_pilihan_b_main);
        rbPilihanC = findViewById(R.id.rb_pilihan_c_main);
        rbPilihanD = findViewById(R.id.rb_pilihan_d_main);
        btnNext = findViewById(R.id.btn_next_main);


        tvSoal.setText(pertanyaan_kuis[nomor]);
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


//    @OnClick({R.id.rb_pilihan_a_main, R.id.rb_pilihan_b_main, R.id.rb_pilihan_c_main, R.id.rb_pilihan_d_main, R.id.rg_pilihan_main, R.id.btn_next_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rb_pilihan_a_main:
                penjelasan();
                hideA();
                break;
            case R.id.rb_pilihan_b_main:
                penjelasan();
                hideB();
                break;
            case R.id.rb_pilihan_c_main:
                penjelasan();
                hideC();
                break;
            case R.id.rb_pilihan_d_main:
                penjelasan();
                hideD();
                break;
            case R.id.rg_pilihan_main:
                break;
            case R.id.btn_next_main:
                next();
                PilihanJawabanShow();
                tvPenjelasan.setText("");
                break;

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
        } else {
            tvPenjelasan.setText("SALAH\n jawaban benar adalah : \n"
                    + jawaban_benar[nomor]
                    + "\nkarena\t"
                    + penjelasan_jawaban[nomor]);
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
