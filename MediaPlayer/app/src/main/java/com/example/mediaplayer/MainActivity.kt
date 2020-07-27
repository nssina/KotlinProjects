package com.example.mediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.song_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listSongs = ArrayList<SongInfo>()
    var adapter: MySongAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadURLOnline()
    }

    fun loadURLOnline() {
        listSongs.add(SongInfo("Somebody's Me","Enrique Iglesias", "http://46.101.244.46/Enrique-Iglesias-Somebody's-Me-320.mp3"))
        listSongs.add(SongInfo("Take You Down","Illenium", "http://46.101.244.46/Illenium-Take-You-Down-320.mp3"))
        listSongs.add(SongInfo("One More Light","Linkin Park", "http://46.101.244.46/Linkin-Park-One-More-Light-320.mp3"))

        adapter = MySongAdapter(listSongs)
        lsListSongs.adapter = adapter
    }

    inner class MySongAdapter: BaseAdapter {

        var myListSong = ArrayList<SongInfo>()

        constructor(myListSong: ArrayList<SongInfo>):super() {
            this.myListSong = myListSong
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView = layoutInflater.inflate(R.layout.song_ticket, null)
            val song = this.myListSong[p0]

            myView.tvSongName.text = song.title
            myView.tvAuthor.text = song.authorName
            myView.buPlay.setOnClickListener {

                //TODO: play song


            }

            return myView
        }

        override fun getItem(p0: Int): Any {
            return this.myListSong[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return this.myListSong.size
        }

    }
}