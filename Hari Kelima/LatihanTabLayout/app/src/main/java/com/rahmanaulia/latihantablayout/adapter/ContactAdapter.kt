package com.rahmanaulia.latihantablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahmanaulia.latihantablayout.R
import com.rahmanaulia.latihantablayout.model.Contact
import kotlinx.android.synthetic.main.item_row.view.*

class ContactAdapter (private val contacts: ArrayList<Contact>)
    :RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.itemView.tvName.text = contact.name
        holder.itemView.tvDesc.text = contact.desc
        contact.image?.let { holder.itemView.imageView.setImageResource(it) }
    }
}