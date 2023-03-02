package ru.palyanaff.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allow the user to roll a dice and
 * view the result on the screen
 */
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        /** Do a dice roll when the app starts */
        rollDice()

        rollButton.setOnClickListener { rollDice() }

    }

    /**
     * This function roll the dice and update the screen witt the result
     */
    private fun rollDice() {
        // Create new dice with 6 sides and rol the dice
        val dice = Dice()
        val randomDiceNumber = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Use image for each result of the roll
        val drawableResource = when (randomDiceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update image on ImageView with new result of rolling dice
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = randomDiceNumber.toString()

    }
}

class Dice(private val numberSides: Int = 6) {
    fun roll(): Int {
        return (1..numberSides).random()
    }
}