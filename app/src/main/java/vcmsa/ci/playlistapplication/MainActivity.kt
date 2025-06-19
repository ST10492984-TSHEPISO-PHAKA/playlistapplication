package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

data class Song(val title: String, val category: String, val artist: String)

class MainActivity : AppCompatActivity() {

    private val songs = listOf(
        Song("Rap God", "Rap", "Eminem"),
        Song("Dance Fever", "Dance", "Dua Lipa"),
        Song("Endless Love", "Love", "Lionel Richie"),
        Song("Golden Memories", "Memory", "ABBA")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.songList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songs.map { it.title })
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSong = songs[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", selectedSong.title)
                putExtra("category", selectedSong.category)
                putExtra("artist", selectedSong.artist)
            }
            startActivity(intent)
        }
    }
}
