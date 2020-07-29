package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<CustomItemClass>()
        items.add(CustomItemClass("Android Developments", "Learn Android From Scratch", R.drawable.background_one))
        items.add(CustomItemClass("iOS Development", "Learn iOS From Scratch", R.drawable.background_two))
        items.add(CustomItemClass("WeTV Development", "Develop WeTV For Scratch For Android", R.drawable.background_three))
        items.add(CustomItemClass("WeMovie Development", "Develop WeMovie For Scratch For Android", R.drawable.background_four))

        val adapter = CustomAdapter(this, items)
        val list = findViewById<ListView>(R.id.list_view)
        list.adapter = adapter
    }
}