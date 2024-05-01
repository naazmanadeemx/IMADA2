// Author: Naazma Iqbal
// Date: 01/05/2024

package com.example.imad_a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    // declare lateinit variables for UI elements
    private lateinit var pet: Pet
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView
    private lateinit var playTextView: TextView
    private lateinit var petImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        Log.d("GameActivity", "Activity created") // log activity creation

        // initialize pet instance and UI elements
        pet = Pet()

        hungerTextView = findViewById(R.id.hungerTextView)
        cleanlinessTextView = findViewById(R.id.cleanlinessTextView)
        playTextView = findViewById(R.id.playTextView)
        petImageView = findViewById(R.id.petImageView)

        Log.i("GameActivity", "Pet and UI elements initialized") // log pet and UI initialization

        // update initial status on UI
        updateStatus()

        // set onClickListeners for buttons
        findViewById<Button>(R.id.feedButton).setOnClickListener {
            pet.feed(); updateStatus() // feed the pet and update status on UI
            petImageView.setImageResource(R.drawable.fooddog) // // display feeding image
            Log.d("GameActivity", "Pet fed") // log feeding action
        }

        findViewById<Button>(R.id.cleanButton).setOnClickListener {
            pet.clean(); updateStatus() // clean the pet and update status on UI
            petImageView.setImageResource(R.drawable.bathtwodog) // display cleaning image
            Log.d("GameActivity", "Pet cleaned") // log cleaning action
        }

        findViewById<Button>(R.id.playButton).setOnClickListener {
            pet.play(); updateStatus() // play with the pet and update status on UI
            petImageView.setImageResource(R.drawable.playdoggie) // display playing image
            Log.d("GameActivity", "Pet played") // log playing action
        }

        // start the timer for updating pet status
        startTimer()
    }
    // function to update pet status on UI
    private fun updateStatus() {
        with(pet){
            hungerTextView.text = "Hunger: $hunger"
            cleanlinessTextView.text = "Cleanliness: $cleanliness"
            playTextView.text = "Play: $play"
        }
    }
    // function to start a timer for periodic updates of pet status
    private fun startTimer() {
        GlobalScope.launch {
            while(true) {
                with(pet) {
                    decreasePlay()
                    increaseHunger()
                    increaseCleanliness()
                    updateStatus()
                }
                delay(300000) // 5 minutes, adjust the delay time as needed
            }
        }
    }
}