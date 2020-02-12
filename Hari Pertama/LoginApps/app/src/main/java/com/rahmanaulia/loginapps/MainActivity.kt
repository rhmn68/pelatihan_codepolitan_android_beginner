package com.rahmanaulia.loginapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginProcess()
    }

    private fun loginProcess() {
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                email.isEmpty() -> {
                    etEmail.error = "Please field your email"
                    return@setOnClickListener
                }
                !(Patterns.EMAIL_ADDRESS).matcher(email).matches() -> {
                    etEmail.error = "Your email is not valid"
                    return@setOnClickListener
                }
                password.isEmpty() -> {
                    etPassword.error = "Please field your password"
                    return@setOnClickListener
                }
                else -> {
                    val result = "email: $email\n pass: $password"
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
