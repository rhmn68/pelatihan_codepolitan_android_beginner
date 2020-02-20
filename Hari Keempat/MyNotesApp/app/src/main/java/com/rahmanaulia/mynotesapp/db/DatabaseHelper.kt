package com.rahmanaulia.mynotesapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.rahmanaulia.mynotesapp.model.Note

class DatabaseHelper(context: Context)
    :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "notes_db"

        private const val TABLE_NOTES  = "notes"
        private const val COLUMN_ID  = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_DESC = "desc"
        private const val COLUMN_DATE = "date"

        private const val SQL_CREATE_TABLE_NOTES = "CREATE TABLE $TABLE_NOTES " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $COLUMN_TITLE TEXT NOT NULL, $COLUMN_DESC TEXT NOT NULL," +
                " $COLUMN_DATE TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_NOTES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NOTES")
        onCreate(db)
    }

    fun insertNotes(note: Note) : Long{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITLE, note.title)
        values.put(COLUMN_DESC, note.desc)
        values.put(COLUMN_DATE, note.date)

        val feedBack = db.insert(TABLE_NOTES, null, values)
        db.close()
        return feedBack
    }

    fun getAllNotes(): ArrayList<Note>{
        val notes = arrayListOf<Note>()
        val database = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NOTES"
        val cursor = database.rawQuery(query, null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
            val desc = cursor.getString(cursor.getColumnIndex(COLUMN_DESC))
            val date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE))

            notes.add(
                Note(
                    id,
                    title,
                    desc,
                    date
                )
            )
        }
        database.close()
        return notes
    }

    fun updateNote(note: Note): Int{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITLE, note.title)
        values.put(COLUMN_DESC, note.desc)
        values.put(COLUMN_DATE, note.date)

        val feedBack = db.update(TABLE_NOTES, values, "$COLUMN_ID = ${note.id}", null)
        db.close()
        return feedBack
    }

    fun deleteNote(id: String): Int{
        val db = this.writableDatabase
        val feedBack = db.delete(TABLE_NOTES, "$COLUMN_ID = ?", arrayOf(id))
        db.close()
        return feedBack
    }
}