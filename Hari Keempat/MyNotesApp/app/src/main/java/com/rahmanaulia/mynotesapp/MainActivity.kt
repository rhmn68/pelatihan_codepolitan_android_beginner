package com.rahmanaulia.mynotesapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmanaulia.mynotesapp.adapter.NoteAdapter
import com.rahmanaulia.mynotesapp.db.DatabaseHelper
import com.rahmanaulia.mynotesapp.model.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_dialog.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NoteAdapter
    private lateinit var notes: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        fabNote.setOnClickListener {
            showDialog()
        }
    }

    private fun initAdapter() {
        val db = DatabaseHelper(this)
        notes = db.getAllNotes()
        adapter = NoteAdapter(this, notes)
        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = adapter
    }

    private fun showDialog(){
        val view = LayoutInflater.from(this).inflate(R.layout.note_dialog, null)
        AlertDialog.Builder(this)
            .setTitle("New Data")
            .setView(view)
            .setCancelable(false)
            .setPositiveButton("Add") { dialog, _ ->
                val note = Note()
                val title = view.etTitleNote.text.toString().trim()
                val desc = view.etDescNote.text.toString().trim()

                if (title.isEmpty()){
                    Toast.makeText(this, "Please field your title", Toast.LENGTH_SHORT).show()
                }else if (desc.isEmpty()){
                    Toast.makeText(this, "Please field your description", Toast.LENGTH_SHORT).show()
                }else{
                    note.title = title
                    note.desc = desc
                    note.date = getCurrentDate()

                    val db = DatabaseHelper(this)
                    val result = db.insertNotes(note)
                    Log.d("coba", "result(Input Database): $result")
                    if (result > 0){
                        note.id = result.toInt()
                        notes.add(note)
                        adapter.notifyDataSetChanged()
                        Toast.makeText(this, "Data has been added", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }else{
                        Toast.makeText(this, "Add database failed", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                }
            }
            .setNegativeButton("Cancel"){ dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun getCurrentDate(): String{
        val currentTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        return dateFormat.format(currentTime)
    }

}
