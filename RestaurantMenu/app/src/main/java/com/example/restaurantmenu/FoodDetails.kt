package com.example.restaurantmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle = intent.extras!!

        ivFoodImage.setImageResource(bundle.getInt("image"))
        tvDetail.text = bundle.getString("des")
        tvName.text = bundle.getString("name")

    }
}