package com.rahmanaulia.latihanintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pindah_dengan_result.*

class PindahDenganResultActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
    }

    private val resultIntent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_result)

        btnSukabumi.setOnClickListener {
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, "Sukabumi")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnBandung.setOnClickListener {
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, "Bandung")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnCirebon.setOnClickListener {
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, "Cirebon")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnTangerang.setOnClickListener {
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, "Tangerang")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
