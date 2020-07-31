package com.example.streamvideo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoURL = "http://dl2.subfdl.ir/Turkish/Sen.Cal.Kap%C4%B1mi/Sen%20Cal%20Kap%C4%B1mi%20E01%20480p%20HardSub%20%5BFilmDL%5D.mkv"
        val videoUri = Uri.parse(videoURL)
        val videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoURI(videoUri)
        videoView.start()
    }
}