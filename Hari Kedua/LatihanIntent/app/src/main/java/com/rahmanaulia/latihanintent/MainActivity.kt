package com.rahmanaulia.latihanintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPindahActivity.setOnClickListener {
            val pindahIntent = Intent(this, PindahActivity::class.java)
            startActivity(pindahIntent)
        }

        btnPindahActivityDenganData.setOnClickListener {
            val pindahDenganData = Intent(this, PindahDenganDataActivity::class.java)
            pindahDenganData.putExtra(PindahDenganDataActivity.EXTRA_NAMA, "Aulia Rahman")
            startActivity(pindahDenganData)
        }

        btnPindahActivityDenganObject.setOnClickListener {
            val pindahDenganObject = Intent(this, PindahDenganObjectActivity::class.java)
            val user = User()
            user.name = "Aulia Rahman"
            user.email = "email@gmail.com"
            user.phone = "+62123445290"
            pindahDenganObject.putExtra(PindahDenganObjectActivity.EXTRA_USER, user)
            startActivity(pindahDenganObject)
        }

        btnPindahActivityDenganResult.setOnClickListener {
            val pindahResultIntent = Intent(this, PindahDenganResultActivity::class.java)
            startActivityForResult(pindahResultIntent, REQUEST_CODE)
        }

        btnDialNumber.setOnClickListener {
            val phoneNumber = "08123456789"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }

        btnMembukaALamatWeb.setOnClickListener {
            val alamatWeb = "https://www.codepolitan.com/"
            val alamatWebIntent = Intent(Intent.ACTION_VIEW, Uri.parse(alamatWeb))
            if (alamatWebIntent.resolveActivity(packageManager) != null){
                startActivity(alamatWebIntent)
            }else{
                Toast.makeText(this, "Intent tidak dapat di proses", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                val selectedData = data?.getStringExtra(PindahDenganResultActivity.EXTRA_SELECTED_VALUE)
                tvHasil.text = selectedData
            }
        }
    }
}
