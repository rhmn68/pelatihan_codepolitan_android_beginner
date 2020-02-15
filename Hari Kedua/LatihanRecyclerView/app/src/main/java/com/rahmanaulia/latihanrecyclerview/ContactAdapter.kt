package com.rahmanaulia.latihanrecyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ContactAdapter(private val context: Context, private val contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
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
        contact.image?.let {
            holder.itemView.ivAvatar.setImageResource(it)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailContactActivity::class.java)
            intent.putExtra(DetailContactActivity.EXTRA_CONTACT, contact)
            context.startActivity(intent)
        }
    }
}