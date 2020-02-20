package com.rahmanaulia.contactapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmanaulia.contactapps.adapter.ContactAdapter
import com.rahmanaulia.contactapps.db.DatabaseHelper
import com.rahmanaulia.contactapps.model.Contact
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private lateinit var contacts: ArrayList<Contact>
    private val db = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initContactAdapter()
        fabContact.setOnClickListener {
            showDialog()
        }
    }

    private fun initContactAdapter() {
        contacts = db.getAllContacts()
        adapter = ContactAdapter(this, contacts)
        adapter.notifyDataSetChanged()
        rvContact.layoutManager = LinearLayoutManager(this)
        rvContact.adapter = adapter
    }

    private fun showDialog(){
        val view = LayoutInflater.from(this).inflate(R.layout.contact_dialog, null)

        AlertDialog.Builder(this)
            .setTitle("New Data")
            .setView(view)
            .setCancelable(false)
            .setPositiveButton("Input"){ dialog, _ ->
                val contact = Contact()
                val name = view.etNameContact.text.toString().trim()
                val phone = view.etPhoneContact.text.toString().trim()

                if (name.isEmpty()){
                    Toast.makeText(this, "Please  field your name", Toast.LENGTH_SHORT).show()
                }else if (phone.isEmpty()){
                    Toast.makeText(this, "Please  field your phone", Toast.LENGTH_SHORT).show()
                }else{
                    contact.name = name
                    contact.phone = phone
                    val result = db.insertContact(contact)
                    if (result > 0){
                        contact.id = result.toInt()
                        contacts.add(contact)
                        adapter.notifyDataSetChanged()
                        Toast.makeText(this, "Data has been added", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Add database failed", Toast.LENGTH_SHORT).show()
                    }
                }
                dialog.dismiss()
            }
            .setNegativeButton("cancel"){ dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
