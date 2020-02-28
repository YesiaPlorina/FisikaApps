package com.yesia.fisika.hukumNewton.LatihanSoal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yesia.fisika.R
import kotlinx.android.synthetic.main.activity_practice_satu.*

class PracticeSatu : AppCompatActivity() {


    internal var pertanyaan_kuis = arrayOf(
        "1. ",
        "2. Satuan momentum adalah . . . .",
        "3. Tekanan hidrostatis dipengaruhi oleh . . . .",
        "4. Sifat benda yang memungkinkan benda kembali kebentuk semula setelah gaya yang bekerja pada benda dihilangkan disebut . . . .",
        "5. Hasil kali gaya dengan perpindahan disebut . . . ."
    )

    internal var jawaban_kuis = arrayOf(
        "A. ",
        "B. ",
        "C. ",
        "D. ",
        "A. Kg.m/s",
        "B.  Kg.m/s2",
        "C. N.s",
        "D.m/s2",
        "A. Percepatan",
        "B. Massa jenis zat cair",
        "C.  Massa benda",
        "D. Kecepatan",
        "A. Plastisitas",
        "B. Emisivitas",
        "C. Elastisitas",
        "D. Strain",
        "A. Daya",
        "B. Usaha",
        "C. Energy",
        "D. Upaya"
    )

    internal var jawaban_benar =
        arrayOf("A. ", "A. Kg.m/s", "B. Massa jenis zat cair", "C. Elastisitas", "B. Usaha")
    internal var penjelasan_jawaban = arrayOf(
        "Perbandingan tegangan terhadap regangan disebut Modulus elastisitas",
        "Satuan momentum adalah Kg.m/s",
        "Besarnya tekanan hidrostatik dipengaruhi oleh kedalaman, gravitasi dan massa jenis zat cair (fluida)",
        "Sifat benda yang memungkinkan benda kembali kebentuk semula setelah gaya yang bekerja pada benda dihilangkan disebut Elastisitas",
        "Hasil kali gaya dengan perpindahan disebut Usaha"
    )

    internal var nomor = 0
    var hasil: Int = 0
    var benar:Int = 0
    var salah:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_satu)


        tv_soal_main.setText(pertanyaan_kuis[nomor])
        rb_pilihan_a_main.setText(jawaban_kuis[0])
        rb_pilihan_b_main.setText(jawaban_kuis[1])
        rb_pilihan_c_main.setText(jawaban_kuis[2])
        rb_pilihan_d_main.setText(jawaban_kuis[3])

        rg_pilihan_main.check(0)
        benar = 0
        salah = 0


    }
}
