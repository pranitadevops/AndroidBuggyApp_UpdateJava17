package com.example.buggyapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val sizes = resources.getStringArray(R.array.Sizes)
        val spinnerSize: Spinner = findViewById(R.id.spinnerSize)
        if (spinnerSize != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, sizes
            )
            spinnerSize.adapter = adapter

            val savefilterButton: Button = findViewById(R.id.savetheFilterButton)
            val progressBarSwing: ProgressBar = findViewById(R.id.progressBar)

            val seek = findViewById<SeekBar>(R.id.seekBarDistance)
            seek?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seek: SeekBar,
                    progress: Int, fromUser: Boolean
                ) {
                    Toast.makeText(
                        this@FilterActivity,
                        "Progress is: " + seek.progress + "1%",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onStartTrackingTouch(seek: SeekBar) {
                    Toast.makeText(
                        this@FilterActivity,
                        "Progress is: " + seek.progress + "1%",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onStopTrackingTouch(seek: SeekBar) {
                    // write custom code for progress is stopped
                    Toast.makeText(
                        this@FilterActivity,
                        "Progress is: " + seek.progress + "1%",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

            savefilterButton.setOnClickListener {

                // task is run on a thread
                Thread(Runnable {
                    // dummy thread mimicking some operation whose progress cannot be tracked

                    // display the indefinite progressbar
                    this@FilterActivity.runOnUiThread(java.lang.Runnable {
                        progressBarSwing.visibility = View.VISIBLE
                    })

                    // performing some dummy time taking operation
                    try {
                        var i = 0;
                        while (i < Int.MAX_VALUE) {
                            // i++
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    // when the task is completed, make progressBar gone
                    this@FilterActivity.runOnUiThread(java.lang.Runnable {
                        progressBarSwing.visibility = View.GONE
                        Toast.makeText(
                            applicationContext,
                            "Filter has been saved Successfully!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                }).start()
            }
        }
    }
}