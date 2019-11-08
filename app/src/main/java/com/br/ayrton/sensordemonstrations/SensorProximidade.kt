package com.br.ayrton.sensordemonstrations

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor_proximidade.*

// Objetivo: Indicar presença de um objeto a uma distância pré-definida.

class SensorProximidade : AppCompatActivity(), SensorEventListener {
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        //proximidade.text = "resultado = ${event!!.values[0]}"

        //esse valor poderia ser mostrado em um TextView mas preferi fazer da forma abaixo

        var vl = event!!.values[0] //retorna apenas um valor

        if (vl<10){
            imageView.setImageResource(R.drawable.book)
        }else{
            imageView.setImageResource(R.drawable.book2)
        }

    }

    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_proximidade)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }
}
