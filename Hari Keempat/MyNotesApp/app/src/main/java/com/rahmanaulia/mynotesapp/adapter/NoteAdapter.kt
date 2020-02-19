package com.rahmanaulia.mynotesapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.rahmanaulia.mynotesapp.R
import com.rahmanaulia.mynotesapp.db.DatabaseHelper
import com.rahmanaulia.mynotesapp.model.Note
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.note_dialog.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

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

        holder.itemView.setOnClickListener {
            val viewDialog = LayoutInflater.from(context).inflate(R.layout.note_dialog, null)
            val db = DatabaseHelper(context)

            viewDialog.etTitleNote.setText(note.title)
            viewDialog.etDescNote.setText(note.desc)

            AlertDialog.Builder(context)
                .setView(viewDialog)
                .setTitle("Edit Data")
                .setCancelable(false)
                .setPositiveButton("Update") { dialog, _ ->
                    val title = viewDialog.etTitleNote.text.toString().trim()
                    val desc = viewDialog.etDescNote.text.toString().trim()
                    dialog.cancel()
                    when {
                        title.isEmpty() -> {
                            Toast.makeText(context, "Please field your title", Toast.LENGTH_SHORT).show()
                        }
                        desc.isEmpty() -> {
                            Toast.makeText(context, "Please field your description", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            note.title = title
                            note.desc = desc
                            note.date = getCurrentDate()

                            val result = db.updateNote(note)
                            Log.d("coba", "result(Update Database): $result")
                            if (result > 0){
                                notes[position] = note
                                notifyDataSetChanged()
                                Toast.makeText(context, "Data has been updated", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }else{
                                Toast.makeText(context, "Data failed to update", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                        }
                    }
                }
                .setNegativeButton("remove"){ dialog, _ ->
                    val result = db.deleteNote(note.id.toString())
                    Log.d("coba", "result(Remove Database): $result")
                    if (result > 0){
                        notes.removeAt(position)
                        notifyDataSetChanged()
                        Toast.makeText(context, "Data has been remove", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }else{
                        Toast.makeText(context, "Data failed to remove", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                }
                .show()
        }
    }

    private fun getCurrentDate(): String{
        val currentTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        return dateFormat.format(currentTime)
    }
}