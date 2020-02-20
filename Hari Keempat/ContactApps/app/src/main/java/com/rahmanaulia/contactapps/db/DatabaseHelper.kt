package com.rahmanaulia.contactapps.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.rahmanaulia.contactapps.model.Contact

class DatabaseHelper(context: Context)
    :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contacts_db"

        private const val TABLE_CONTACTS = "contacts"
        private const val COLUMN_ID_CONTACT = "id_contact"
        private const val COLUMN_NAME_CONTACT = "name_contact"
        private const val COLUMN_PHONE_CONTACT = "phone_contact"

        private const val SQL_CREATE_TABLE_CONTACT = "CREATE TABLE $TABLE_CONTACTS " +
                "($COLUMN_ID_CONTACT INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $COLUMN_NAME_CONTACT TEXT NOT NULL," +
                " $COLUMN_PHONE_CONTACT TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_CONTACT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    fun insertContact(contact: Contact): Long{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME_CONTACT, contact.name)
        values.put(COLUMN_PHONE_CONTACT, contact.phone)
        val result = db.insert(TABLE_CONTACTS, null, values)
        db.close()
        return result
    }

    fun updateContact(contact: Contact): Int{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME_CONTACT, contact.name)
        values.put(COLUMN_PHONE_CONTACT, contact.phone)
        val result = db.update(TABLE_CONTACTS, values, "$COLUMN_ID_CONTACT = ${contact.id}", null)
        db.close()
        return result
    }

    fun deleteContact(id: String):Int{
        val db = this.writableDatabase
        val result = db.delete(TABLE_CONTACTS, "$COLUMN_ID_CONTACT = $id", null)
        db.close()
        return result
    }

    fun getAllContacts(): ArrayList<Contact>{
        val contacts = arrayListOf<Contact>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_CONTACTS"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_CONTACT))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_CONTACT))
            val phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_CONTACT))

            contacts.add(Contact(
                id, name, phone
            ))
        }

        db.close()
        return contacts
    }
}