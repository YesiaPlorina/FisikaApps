package com.yesia.fisika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yesia.fisika.hukumNewton.HukumDua
import com.yesia.fisika.hukumNewton.HukumSatu
import com.yesia.fisika.hukumNewton.HukumTiga
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hk_satu.onClick {
            startActivity<HukumSatu>()
        }

        btn_hk_dua.onClick {
            startActivity<HukumDua>()
        }

        btn_hk_tiga.onClick {
            startActivity<HukumTiga>()
        }
    }
}
