package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
        btnHigher.setOnClickListener { onHigherClick() }
        btnEqual.setOnClickListener { onEqualClick() }
        btnLower.setOnClickListener { onLowerClick() }


    }

    private var currentThrow = 1
    private var lastThrow = 1
    private fun initViews() {
        updateUi()

    }

    private fun updateUi() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)
        imgDice.setImageResource(when(currentThrow){
            1 -> (R.drawable.dice1)
            2 -> (R.drawable.dice2)
            3 -> (R.drawable.dice3)
            4 -> (R.drawable.dice4)
            5 -> (R.drawable.dice5)
            else -> (R.drawable.dice6 )
        })

    }
        private fun rollDice() {
            lastThrow = currentThrow
            currentThrow = (1..6).random()

            updateUi()
        }



        private fun onAnswerCorrect() {
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
        }

        private fun onAnswerIncorrect() {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
        }

        private fun onHigherClick() {
            rollDice()
            if (currentThrow > lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerIncorrect()
            }
        }

        private fun onLowerClick() {
            rollDice()
            if (currentThrow < lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerIncorrect()
            }
        }

        private fun onEqualClick() {
            if (currentThrow == lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerIncorrect()
            }
        }

    }
