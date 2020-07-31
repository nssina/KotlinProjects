package com.example.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(data: ArrayList<CustomClass>, internal var context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data: List<CustomClass> = data

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        internal var title: TextView = itemView.findViewById(R.id.item_title)
        internal var image: ImageView = itemView.findViewById(R.id.item_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
    }
}