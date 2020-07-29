package com.example.listview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, i, l ->
            val alert = Dialog(this)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.alert_title)
            val desc = alert.findViewById<TextView>(R.id.alert_desc)
            val image = alert.findViewById<ImageView>(R.id.alert_image)
            val dismiss = alert.findViewById<Button>(R.id.alert_dismiss)

            val item = adapter.getItem(i)
            title.text = item!!.title
            desc.text = item!!.desc
            image.setImageResource(item!!.image)

            alert.show()

            dismiss.setOnClickListener {
                alert.dismiss()
            }
        }
    }
}