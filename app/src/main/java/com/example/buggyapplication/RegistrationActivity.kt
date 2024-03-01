package com.example.buggyapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val createAccountButton: Button = findViewById(R.id.createAccount)
        val studentName: EditText = findViewById(R.id.name)
        val emailID : EditText = findViewById(R.id.email)

        createAccountButton.setOnClickListener {
            val studentName = studentName.text.toString()
            val emailID = emailID.text.toString()


            if(studentName.isEmpty()){
                Toast.makeText(applicationContext, "Name is required field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(emailID.isEmpty()){
                Toast.makeText(applicationContext, "Email is required field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(applicationContext, "Email is required field", Toast.LENGTH_SHORT).show()

            val create: Button = findViewById(R.id.createAccount)
            create.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(applicationContext, "Registration Successfully Done!!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

        }

    }
}