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

        updateProgressBar()

        increaseButton!!.setOnClickListener {
            if (prog <= 90) {
                prog += 10
                updateProgressBar()
            }
        }

        decreaseButton!!.setOnClickListener {
            if (prog >= 10) {
                prog -= 10
                updateProgressBar()
            }
        }
    }

    private fun updateProgressBar() {
        progressBar!!.progress = prog
        progressTextView!!.text = "$prog%"
    }
}