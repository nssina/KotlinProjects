package com.example.animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.animation_image)
        val overlay = findViewById<LinearLayout>(R.id.overlay_background)

        applyAnimation(image)
        applyAnimation(overlay)
    }

    fun applyAnimation(animationView: View) {
        val overLay = animationView.background as AnimationDrawable
        overLay.setEnterFadeDuration(3000)
        overLay.setExitFadeDuration(1000)
        overLay.start()
    }
}