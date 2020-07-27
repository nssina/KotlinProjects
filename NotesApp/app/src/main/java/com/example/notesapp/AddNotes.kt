package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_notes.*

class AddNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
    }

    fun buAdd(view: View) {
        var dbManager = DbManager(this)

        var values = ContentValues()
        values.put("Title ", edTitle.text.toString())
        values.put("Description", editDes.text.toString())

        val id = dbManager.insert(values)

        println("id is: $id")

        if (id > 0) {
            Toast.makeText(this, "Note is added", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Cannot add note", Toast.LENGTH_LONG).show()
        }
    }
}