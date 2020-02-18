package com.rahmanaulia.tvlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailTvActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvctivity)
    }
}
