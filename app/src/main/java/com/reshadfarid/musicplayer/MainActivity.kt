package com.reshadfarid.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var musicListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicListView = findViewById(R.id.music_list_view)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOf("test1", "test2"))
        musicListView.adapter = adapter

        musicListView.setOnItemClickListener { parent, view, position, id ->
            val song = adapter.getItem(position)
            if (song != null) {
              val musicPlayer = MusicPlayerFragment.newInstance(song, "test")
              val transaction = supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container_view, musicPlayer)
              transaction.addToBackStack(null)
              transaction.commitAllowingStateLoss()
            }
        }

    }
}
