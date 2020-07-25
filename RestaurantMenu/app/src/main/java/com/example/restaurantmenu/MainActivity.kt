package com.example.restaurantmenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFoods = ArrayList<Food>()
    var adapter: FoodAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load foods
        listOfFoods.add(Food("Coffee", "Some description for Coffee", R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso", "Some description for Espresso", R.drawable.espresso))
        listOfFoods.add(Food("French Fries", "Some description for French Fries", R.drawable.french_fries))
        listOfFoods.add(Food("Honey", "Some description for Honey", R.drawable.honey))
        listOfFoods.add(Food("Strawberry", "Some description for Strawberry Icecream", R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes", "Some description for Sugar Cubes", R.drawable.sugar_cubes))

        adapter = FoodAdapter(this, listOfFoods)
        gvListView.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {

        var listOfFood = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context, listOfFood: ArrayList<Food>): super() {
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket, null)

            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.tvName.text = food.name

            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}
