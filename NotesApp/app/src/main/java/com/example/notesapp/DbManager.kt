package com.example.notesapp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {

    val dbName: String = "MyNotes"
    val dbTable: String = "Notes"
    val colId: String = "ID"
    val colTitle: String = "Title"
    val colDes: String = "Description"
    val dbVersion: Int = 1
    val sqlCreatTable: String = "CREATE TABLE IF NOT EXISTS $dbName ($colId INTEGER PRIMARY KEY, $colTitle TEXT, $colDes TEXT);"
    var sqlDb: SQLiteDatabase? = null

    constructor(context: Context) {
        val db = DatabaseHelperNotes(context)
        sqlDb = db.writableDatabase
    }

    inner class DatabaseHelperNotes: SQLiteOpenHelper {

        var context: Context? = null

        constructor(context: Context):super(context, dbName, null, dbVersion) {
            this.context = context
        }

        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreatTable)
            Toast.makeText(this.context, "Database is created", Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("Drop table IF EXISTS $dbTable")
        }
    }

    fun insert(values: ContentValues): Long {

        val id = sqlDb!!.insert(dbTable, "", values)

        return id
    }
}