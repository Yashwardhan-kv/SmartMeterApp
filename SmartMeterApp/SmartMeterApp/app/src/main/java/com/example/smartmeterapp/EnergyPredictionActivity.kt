package com.example.smartmeterapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class EnergyPredictionActivity : AppCompatActivity() {

    private lateinit var model: EnergyPredictionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy_prediction)

        model = EnergyPredictionModel(this)

        val hourInput = findViewById<TextInputEditText>(R.id.hourInput)
        val dayInput = findViewById<TextInputEditText>(R.id.dayInput)
        val predictButton = findViewById<MaterialButton>(R.id.predictButton)
        val predictionResult = findViewById<TextView>(R.id.predictionResult)

        predictButton.setOnClickListener {
            val hourText = hourInput.text.toString()
            val dayText = dayInput.text.toString()

            if (hourText.isEmpty() || dayText.isEmpty()) {
                Toast.makeText(this, "Please fill in both inputs", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hour = hourText.toFloatOrNull()
            val day = dayText.toFloatOrNull()

            if (hour == null || day == null || hour !in 0..23 || day !in 1..31) {
                Toast.makeText(this, "Invalid input values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputFeatures = floatArrayOf(hour, day)
            val predictedEnergy = model.predict(inputFeatures)
            predictionResult.text = "Predicted Energy Consumption: %.2f kWh".format(predictedEnergy * 100)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        model.close()
    }
}
