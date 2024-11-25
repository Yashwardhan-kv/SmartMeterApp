// DeviceControlActivity.kt

package com.example.smartmeterapp

import android.os.Bundle
import android.widget.Button
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import androidx.appcompat.app.AppCompatActivity

class DeviceControlActivity : AppCompatActivity() {

    private lateinit var mqttClient: MqttClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_control)

        val connectButton = findViewById<Button>(R.id.connectButton)
        val controlButton = findViewById<Button>(R.id.controlButton)

        connectButton.setOnClickListener {
            connectToMQTTBroker()
        }

        controlButton.setOnClickListener {
            sendControlMessage()
        }
    }

    private fun connectToMQTTBroker() {
        mqttClient = MqttClient("tcp://mqtt_broker_address:1883", MqttClient.generateClientId(), null)
        val options = MqttConnectOptions()
        mqttClient.connect(options)
    }

    private fun sendControlMessage() {
        val message = MqttMessage("turn_on".toByteArray())
        mqttClient.publish("home/device/control", message)
    }
}
