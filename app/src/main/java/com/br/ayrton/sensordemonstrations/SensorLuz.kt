package com.br.ayrton.sensordemonstrations

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sensor_luz.*

class SensorLuz : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_luz)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
            SensorManager.SENSOR_DELAY_NORMAL
        )

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null){
            Toast.makeText(this,"O dispositivo não possui sensor de luz", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    //var sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)


    //var maximoValor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT).maximumRange

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


    override fun onSensorChanged(event: SensorEvent?) {
        var vl = event!!.values[0]

        supportActionBar!!.setTitle("Luminosidade: " + vl + " lx")

        //var novoValor = (255f * vl / maximoValor) as Int
        //relative.setBackgroundColor(Color.rgb(novoValor,novoValor,novoValor))

    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}
