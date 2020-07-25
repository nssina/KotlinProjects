package com.example.kotlindemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateYear(view: View) {
        val dobDate = dobTextField.text.toString().toInt()

        if (dobDate.toInt() == 0) {
            textViewShowAge.text = "Invalid Year!!"
        } else {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val myAge = currentYear - dobDate
            textViewShowAge.text = "Your age is: $myAge"
        }
    }
}