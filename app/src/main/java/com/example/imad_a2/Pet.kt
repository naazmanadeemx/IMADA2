package com.example.imad_a2

class Pet {
    // declare properties/variables for pet status
    var hunger: Int = 50
    var cleanliness: Int = 50
    var play: Int = 100

    // function to feed the pet
    fun feed() {
        hunger -= 15
        if (hunger < 0) hunger = 0
    }
    // function to clean the pet
    fun clean() {
        cleanliness -= 10
        if (cleanliness < 0) cleanliness = 0
    }
    // function to play with the pet
    fun play() {
        play -= 10
        if(play < 0) play = 0
    }
    // function to decrease play time
    fun decreasePlay() {
        play -= 10
        if (play < 0) play = 0
    }
    // function to increase hunger
    fun increaseHunger() {
        hunger += 10
        if (hunger > 100) hunger = 100
    }
    // function to increase cleanliness
    fun increaseCleanliness() {
        cleanliness += 10
        if (cleanliness > 100) cleanliness = 100
    }
}