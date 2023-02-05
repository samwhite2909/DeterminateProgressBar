package com.swhite.determinateprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var prog = 0

    private var increaseButton: Button? = null
    private var decreaseButton: Button? = null
    private var progressTextView: TextView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        increaseButton = findViewById(R.id.button_increase)
        decreaseButton = findViewById(R.id.button_decrease)
        progressTextView = findViewById(R.id.text_view_progress)
        progressBar = findViewById(R.id.progress_bar)

        //Initially set the progress bar to zero.
        updateProgressBar()

        //Increase progress by 10% on button click, if less than 100%.
        increaseButton!!.setOnClickListener {
            if (prog <= 90) {
                prog += 10
                updateProgressBar()
            }
        }

        //Decrease progress by 10% on button click, if more than 0%.
        decreaseButton!!.setOnClickListener {
            if (prog >= 10) {
                prog -= 10
                updateProgressBar()
            }
        }
    }

    //Update the progress value and the text accordingly.
    private fun updateProgressBar() {
        progressBar!!.progress = prog
        progressTextView!!.text = "$prog%"
    }
}