package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<CustomClass>()

        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))
        items.add(CustomClass("Android App", R.drawable.one))

        var recycler = findViewById<RecyclerView>(R.id.recycler_data)
        val adapter = RecyclerAdapter(items, applicationContext)
        recycler.layoutManager = GridLayoutManager(applicationContext, 2)
        recycler.adapter = adapter
    }
}