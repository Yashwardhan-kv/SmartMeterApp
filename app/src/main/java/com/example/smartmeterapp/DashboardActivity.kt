package com.example.smartmeterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val energyReportButton = findViewById<Button>(R.id.energyReportButton)
        val deviceControlButton = findViewById<Button>(R.id.deviceControlButton)

        energyReportButton.setOnClickListener {
            startActivity(Intent(this, EnergyReportActivity::class.java))
        }

        deviceControlButton.setOnClickListener {
            startActivity(Intent(this, DeviceControlActivity::class.java))
        }
    }
}
