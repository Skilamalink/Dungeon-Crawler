package com.hecox.dungeoncrawler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class YouDied : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_you_died)

        var reviveButton: Button = findViewById(R.id.reviveButton)

        reviveButton.setOnClickListener {
            val intent = Intent(this@YouDied, Game::class.java)
            startActivity(intent)
            finish()

        }
    }
}