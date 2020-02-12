package com.rahmanaulia.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlus.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            val result = number1.toDouble() + number2.toDouble()
            tvResult.text = result.toString()
        }

        btnMinus.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            val result = number1.toDouble() - number2.toDouble()
            tvResult.text = result.toString()
        }

        btnMultiple.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            val result = number1.toDouble() * number2.toDouble()
            tvResult.text = result.toString()
        }

        btnDivive.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            val result = number1.toDouble() / number2.toDouble()
            tvResult.text = result.toString()
        }
    }
}
