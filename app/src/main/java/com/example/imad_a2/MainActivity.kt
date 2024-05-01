package com.example.imad_a2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the startButton from the layout
        val startButton: Button = findViewById(R.id.startButton)

        // set click listener for the startButton to navigate to GameActivity
        startButton.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
    }
}