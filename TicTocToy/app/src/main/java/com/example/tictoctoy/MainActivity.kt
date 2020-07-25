package com.example.tictoctoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0

        when (buSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        playGame(cellId, buSelected)
    }

    fun playGame(cellId: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            playerOne.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.BLUE)
            playerTwo.add(cellId)
            activePlayer = 1
        }

        buSelected.isEnabled = false
        checkWiner()
    }

    fun autoPlay() {

        var emptyCells = ArrayList<Int>()

        for (cellId in 1..9) {
            if (!(playerOne.contains(cellId) || playerTwo.contains(cellId))) {
                emptyCells.add(cellId)
            }
        }

        var random = java.util.Random()
        var randomIndex = random.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells[randomIndex]

        var buSelected: Button?

        when (cellId) {

            1-> buSelected = button1
            2-> buSelected = button2
            3-> buSelected = button3
            4-> buSelected = button4
            5-> buSelected = button5
            6-> buSelected = button6
            7-> buSelected = button7
            8-> buSelected = button8
            9-> buSelected = button9

            else -> {
                buSelected = button1
            }
        }
        playGame(cellId, buSelected)
    }

    fun checkWiner() {
        var winner = -1

        //
        if (playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)) {
            winner = 1
        }
        if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)) {
            winner = 1
        }
        if (playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)) {
            winner = 1
        }

        //
        if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)) {
            winner = 1
        }
        if (playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)) {
            winner = 1
        }
        if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)) {
            winner = 1
        }

        //
        if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)) {
            winner = 1
        }
        if (playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)) {
            winner = 1
        }


        //
        if (playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)) {
            winner = 2
        }
        if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)) {
            winner = 2
        }
        if (playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)) {
            winner = 2
        }

        //
        if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)) {
            winner = 2
        }
        if (playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)) {
            winner = 2
        }
        if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)) {
            winner = 2
        }

        //
        if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)) {
            winner = 2
        }
        if (playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_SHORT).show()
            }
        }
    }
}