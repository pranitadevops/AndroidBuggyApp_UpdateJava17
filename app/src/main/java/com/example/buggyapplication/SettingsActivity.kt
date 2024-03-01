package com.example.buggyapplication

import android.app.AlertDialog
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val enableFingerPrintSwitchButton: Switch = findViewById(R.id.useFingerprint)
        enableFingerPrintSwitchButton.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
                .setMessage("Fingerprint Enabled Successfully!!")
                .setPositiveButton("OK") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        val enableDarkModeRadioButton: RadioButton = findViewById(R.id.darkMode)
        enableDarkModeRadioButton.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
                .setMessage("Fingerprint Enabled Successfully!!")
                .setPositiveButton("OK") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        val enableLightModeRadioButton: RadioButton = findViewById(R.id.lightMode)
        enableLightModeRadioButton.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
                .setMessage("Light Mode Disabled Successfully!!")
                .setPositiveButton("OK") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        val enableShowTimeSwitchButton: Switch = findViewById(R.id.showEuropeanTime)
        enableShowTimeSwitchButton.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
                .setMessage("Error Message: Subscript out of range")
                .setPositiveButton("") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }

}