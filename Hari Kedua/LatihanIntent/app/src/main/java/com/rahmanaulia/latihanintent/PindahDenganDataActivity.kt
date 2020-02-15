package com.rahmanaulia.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pindah_dengan_data.*

class PindahDenganDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAMA = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)

        getData()
    }

    private fun getData() {
        if (intent != null){
            val nama = intent.getStringExtra(EXTRA_NAMA)
            tvNama.text = nama
        }
    }
}
