package com.example.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load animals
        listOfAnimals.add(Animal("Babon", "Babon live in big place with tree", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bulldog", "Bulldog live in big place with tree", R.drawable.bulldog, true))
        listOfAnimals.add(Animal("Panda", "Panda live in big place with tree", R.drawable.panda, false))
        listOfAnimals.add(Animal("Swallow", "Swallow live in big place with tree", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("Tiger", "Tiger live in big place with tree", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra", "Zebra live in big place with tree", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, listOfAnimals)
        animalListView.adapter = adapter

        println("animals are: $listOfAnimals")
        println("On create method called")
    }

    class AnimalsAdapter: BaseAdapter {

        var listOfAnimals = ArrayList<Animal>()
        var context: Context? = null

        constructor(context: Context, listOfAnimals: ArrayList<Animal>): super() {
            this.listOfAnimals = listOfAnimals
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]

            if (animal.isKiller) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.textViewName.text = animal.name
                myView.textViewDes.text = animal.des
                myView.imageViewAnimalImage.setImageResource(animal.image!!)
                myView.imageViewAnimalImage.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.textViewName.text = animal.name
                myView.textViewDes.text = animal.des
                myView.imageViewAnimalImage.setImageResource(animal.image!!)
                myView.imageViewAnimalImage.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            println("getItem method called")
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            println("getItemId method called")
            return p0.toLong()
        }

        override fun getCount(): Int {
            println("getCount method called and number is: $listOfAnimals.size")
            return listOfAnimals.size
        }
    }
}