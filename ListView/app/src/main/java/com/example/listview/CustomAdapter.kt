package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(context: Context, data: ArrayList<CustomItemClass>): ArrayAdapter<CustomItemClass>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)

        val item: CustomItemClass? = getItem(position)

        val title = itemView.findViewById<TextView>(R.id.item_title)
        title.text = item!!.title

        val desc = itemView.findViewById<TextView>(R.id.item_desc)
        title.text = item!!.desc

        val image = itemView.findViewById<ImageView>(R.id.item_image)
        image.setImageResource(item.image)

        return itemView
    }
}