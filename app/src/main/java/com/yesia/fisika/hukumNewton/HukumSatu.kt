package com.yesia.fisika.hukumNewton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yesia.fisika.R
import com.yesia.fisika.hukumNewton.latihanSoalHkSatu.LatihanSoalHkSatu
import kotlinx.android.synthetic.main.activity_hukum_satu.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class HukumSatu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hukum_satu)

        btn_practice_hk_satu.onClick {
            startActivity<LatihanSoalHkSatu>()
        }
    }
}
