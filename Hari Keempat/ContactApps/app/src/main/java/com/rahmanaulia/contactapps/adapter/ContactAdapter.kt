package com.rahmanaulia.contactapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.rahmanaulia.contactapps.R
import com.rahmanaulia.contactapps.db.DatabaseHelper
import com.rahmanaulia.contactapps.model.Contact
import kotlinx.android.synthetic.main.contact_dialog.view.*
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val context: Context, private val contacts: ArrayList<Contact>)
    :RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    private val db = DatabaseHelper(context)

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.itemView.tvName.text = contact.name
        holder.itemView.tvPhone.text = contact.phone

        holder.itemView.setOnClickListener {
            updateData(contact, position)
        }

        holder.itemView.btnRemove.setOnClickListener {
            deleteData(contact, position)
        }
    }

    private fun deleteData(contact: Contact, position: Int) {
        val result = db.deleteContact(contact.id.toString())
        if (result > 0){
            contacts.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "Data has been remove", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Data failed to remove", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateData(contact: Contact, position: Int){
        val view = LayoutInflater.from(context).inflate(R.layout.contact_dialog, null)

        view.etNameContact.setText(contact.name)
        view.etPhoneContact.setText(contact.phone)

        AlertDialog.Builder(context)
            .setTitle("New Data")
            .setView(view)
            .setCancelable(false)
            .setPositiveButton("Input"){ dialog,_ ->
                val name = view.etNameContact.text.toString().trim()
                val phone = view.etPhoneContact.text.toString().trim()

                if (name.isEmpty()){
                    Toast.makeText(context, "Please  field your name", Toast.LENGTH_SHORT).show()
                }else if (phone.isEmpty()){
                    Toast.makeText(context, "Please  field your phone", Toast.LENGTH_SHORT).show()
                }else{
                    contact.name = name
                    contact.phone = phone
                    val result = db.updateContact(contact)
                    if (result > 0){
                        contacts[position] = contact
                        notifyDataSetChanged()
                        Toast.makeText(context, "Data has been update", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
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