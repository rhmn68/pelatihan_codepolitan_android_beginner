package com.rahmanaulia.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_RESULT = "extra_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        getData()
    }

    private fun getData() {
        if (intent != null){
            val title = intent.getStringExtra(EXTRA_TITLE)
            val result = intent.getDoubleExtra(EXTRA_RESULT, 0.0)

            tvTitleResult.text = title
            tvResult.text = result.toString()
        }
    }
}
