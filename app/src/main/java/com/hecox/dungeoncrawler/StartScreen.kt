package com.hecox.dungeoncrawler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startscreen)

        var startButton: Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            val intent = Intent(this@Game, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}


/*

we need a "you died" screen

we need to finish the dungeon layout

if we can we want chests with extra health


 */