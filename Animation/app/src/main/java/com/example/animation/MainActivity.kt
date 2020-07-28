package com.example.animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var image = findViewById<ImageView>(R.id.animation_image)
        var overlay = findViewById<LinearLayout>(R.id.overlay_background)


        var backgroundAnimation = image.background as AnimationDrawable
        backgroundAnimation.setEnterFadeDuration(3000)
        backgroundAnimation.setExitFadeDuration(1000)
        backgroundAnimation.start()

        var overLay = overlay.background as AnimationDrawable
        overLay.setEnterFadeDuration(3000)
        overLay.setExitFadeDuration(1000)
        overLay.start()

    }
}