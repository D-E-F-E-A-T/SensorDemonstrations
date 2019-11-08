package com.br.ayrton.sensordemonstrations

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SensorGiroscopio : AppCompatActivity() {

    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_giroscopio)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


    }
}
