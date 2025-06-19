package com.example.musicapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        val playlist = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title") ?: "Unknown Title"
        val category = intent.getStringExtra("category") ?: "Unknown Category"
        val artist = intent.getStringExtra("artist") ?: "Unknown Artist"

        findViewById<TextView>(R.id.titleText).text = "Title: $title"
        findViewById<TextView>(R.id.categoryText).text = "Genre: $category"
        findViewById<TextView>(R.id.artistText).text = "Artist: $artist"

        // Initialize EditTexts (optional, for future use)
        findViewById<EditText>(R.id.commentBox)
        findViewById<EditText>(R.id.artistInfoBox)

        val playlistButton = findViewById<Button>(R.id.addToPlaylist)
        playlistButton.setOnClickListener {
            val songInfo = "$title by $artist"
            playlist.add(songInfo)
            Toast.makeText(this, "Added to playlist! (${playlist.size} songs)", Toast.LENGTH_SHORT).show()
        }
    }
}
