package com.rahmanaulia.mynotesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahmanaulia.mynotesapp.R
import com.rahmanaulia.mynotesapp.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(private val context: Context,
                  private val notes: ArrayList<Note>)
    :RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.itemView.tvTitleNote.text = note.title
        holder.itemView.tvDescNote.text = note.desc
        holder.itemView.tvDateNote.text = note.date
    }
}