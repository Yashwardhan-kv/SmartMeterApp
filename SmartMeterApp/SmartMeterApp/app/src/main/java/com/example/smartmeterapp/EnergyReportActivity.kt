package com.example.smartmeterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class EnergyReportActivity : AppCompatActivity() {

    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy_report)

        lineChart = findViewById(R.id.lineChart)

        // Fetch data from Firebase Realtime Database
        val energyRef = FirebaseDatabase.getInstance().getReference("energy_usage")
        energyRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val energyData = mutableListOf<Entry>()

                for (data in snapshot.children) {
                    val energy = data.getValue<EnergyUsage>()
                    energy?.let {
                        val timestamp = it.timestamp.toFloat()  // Ensure timestamp is a float
                        val energyConsumed = it.energyConsumed.toFloat()  // Ensure energyConsumed is a float
                        energyData.add(Entry(timestamp, energyConsumed))
                    }
                }

                val dataSet = LineDataSet(energyData, "Energy Consumption")
                dataSet.color = getColor(R.color.purple_200)  // Set color for the line
                dataSet.valueTextSize = 12f  // Set text size for values
                dataSet.setDrawCircles(true)  // Show points on the line

                lineChart.data = LineData(dataSet)
                lineChart.invalidate()  // Refresh the chart
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error
                error.message?.let { message ->
                    println("Firebase Database Error: $message")
                }
            }
        })
    }
}

// Define the EnergyUsage data model
data class EnergyUsage(
    val timestamp: Long = 0L,  // Use Long to store timestamps
    val energyConsumed: Double = 0.0  // Use Double for precise energy data
)
