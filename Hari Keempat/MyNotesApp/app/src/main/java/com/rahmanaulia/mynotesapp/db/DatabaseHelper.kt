package com.rahmanaulia.mynotesapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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

//    fun insertNotes(values: ContentValues) : Long{
//        return
//    }
}