package com.example.buggyapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val feedBackButton: Button = findViewById(R.id.sendFeedbackButton)
        feedBackButton.setOnClickListener {
            val intent = Intent(this, FeedbackActivity::class.java)
            Toast.makeText(applicationContext, "Feedback has been sent Successfully!!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}