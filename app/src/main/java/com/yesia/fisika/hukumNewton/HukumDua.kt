package com.yesia.fisika.hukumNewton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yesia.fisika.R
import com.yesia.fisika.hukumNewton.latihanSoalHkDua.LatihanSoalHkDua
import kotlinx.android.synthetic.main.activity_hukum_dua.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class HukumDua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hukum_dua)

        btn_practice_hk_dua.onClick {
            startActivity<LatihanSoalHkDua>()
        }
    }
}
