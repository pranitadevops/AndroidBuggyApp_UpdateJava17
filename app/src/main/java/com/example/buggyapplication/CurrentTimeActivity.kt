package com.example.buggyapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CurrentTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_time)

        val currentTimeShow: TextView = findViewById(R.id.currentTimeView)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy G 'at' HH:mm:ss z")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        currentTimeShow.text = currentDateAndTime
    }
}