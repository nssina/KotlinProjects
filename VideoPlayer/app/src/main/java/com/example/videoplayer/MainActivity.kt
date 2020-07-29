package com.example.videoplayer

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playVideo(view: View) {
        val buttonClicked = findViewById<Button>(view.id)

        val alert = Dialog(this)
        alert.setContentView(R.layout.custom_video)

        val playButton = alert.findViewById<Button>(R.id.play_button)
        val pauseButton = alert.findViewById<Button>(R.id.pause_button)
        val cancelButton = alert.findViewById<Button>(R.id.cancel_button)
        val videoPlayer = alert.findViewById<VideoView>(R.id.video_player)

        when (buttonClicked.id) {
            R.id.video_one -> {
                val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_one)
                videoPlayer.setVideoURI(videoUri)
                alert.show()
            }

            R.id.video_two -> {
                val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_two)
                videoPlayer.setVideoURI(videoUri)
                alert.show()
            }

            R.id.video_three -> {
                val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_three)
                videoPlayer.setVideoURI(videoUri)
                alert.show()
            }
        }

        playButton.setOnClickListener {
            videoPlayer.start()
        }

        pauseButton.setOnClickListener {
            videoPlayer.pause()
        }

        cancelButton.setOnClickListener {
            alert.dismiss()
        }
    }
}