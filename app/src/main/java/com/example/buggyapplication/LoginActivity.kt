package com.example.buggyapplication

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        checkInternetConnectivity()
        val loginButton: Button = findViewById(R.id.login)
        loginButton.setOnClickListener {
            val intent = Intent(this, BottomNavigation::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.registration)
        registerButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        val callUsButton: TextView = findViewById(R.id.callButton)
        callUsButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0123456789")
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkInternetConnectivity() {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val IsConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        if (IsConnected) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
                .setMessage("Check your Internet Connection")
                .setPositiveButton("OK") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}