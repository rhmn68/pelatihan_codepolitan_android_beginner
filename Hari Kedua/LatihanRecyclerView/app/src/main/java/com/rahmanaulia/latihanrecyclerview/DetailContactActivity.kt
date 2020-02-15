package com.rahmanaulia.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_contact.*

class DetailContactActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CONTACT = "extra_contact"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_contact)

        getData()
    }

    private fun getData() {
        if (intent != null){
            val contact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)
            if (contact != null){
                contact.image?.let {
                    ivAvatarDetailContact.setImageResource(it)
                }
                tvNameDetailContact.text = contact.name
                tvPhone.text = contact.phone
            }
        }
    }
}
