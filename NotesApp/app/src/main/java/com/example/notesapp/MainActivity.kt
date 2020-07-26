package com.example.notesapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfNotes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add dummy data
        listOfNotes.add(Note(1, "Meet Sina", "Just testing the data and meeting Sina for Kotlin programming"))
        listOfNotes.add(Note(2, "Meet Me", "Just testing the data and meeting Me for Kotlin programming"))
        listOfNotes.add(Note(3, "Meet Developer", "Just testing the data and meeting Developer for Kotlin programming"))

        var myNotesAdapter = NoteAdapter(listOfNotes)
        lvNotes.adapter = myNotesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        var searchView = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val searchMenu = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchMenu.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Toast.makeText(applicationContext, p0, Toast.LENGTH_LONG).show()

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item != null) {
            when (item.itemId) {
                R.id.addNote -> {
                    // Go to add note activity
                    println("Button clicked")
                    var intent = Intent(this, AddNotes::class.java)
                    startActivity(intent)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class NoteAdapter: BaseAdapter {

        var listNoteAdapter = ArrayList<Note>()
        constructor(listNote: ArrayList<Note>):super() {
            this.listNoteAdapter = listNote
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = listNoteAdapter[p0]

            myView.tvTitle.text = myNote.noteDes
            myView.tvDes.text = myNote.noteName

            return myView
        }

        override fun getItem(p0: Int): Any {
            return listNoteAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listNoteAdapter.size
        }

    }
}