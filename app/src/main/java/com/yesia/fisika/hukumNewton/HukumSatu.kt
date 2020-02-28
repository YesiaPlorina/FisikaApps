package com.yesia.fisika.hukumNewton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yesia.fisika.R
import com.yesia.fisika.hukumNewton.LatihanSoal.PracticeSatu
import kotlinx.android.synthetic.main.activity_hukum_dua.*
import org.jetbrains.anko.sdk27.coroutines.onLongClick
import org.jetbrains.anko.startActivity

class HukumSatu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hukum_satu)

        btn_practice_hk_satu.onLongClick {
            startActivity<PracticeSatu>()
        }
    }
}
