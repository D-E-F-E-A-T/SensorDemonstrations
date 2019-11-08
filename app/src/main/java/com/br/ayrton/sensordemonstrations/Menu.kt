package com.br.ayrton.sensordemonstrations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btProximidade.setOnClickListener {
            startActivity(Intent(this,SensorProximidade::class.java))
        }

        btAcelerometro.setOnClickListener {
            startActivity(Intent(this,SensorAcelerometro::class.java))
        }

        btLuz.setOnClickListener {
            startActivity(Intent(this,SensorLuz::class.java))
        }

        btGiroscopio.setOnClickListener {
            startActivity(Intent(this,SensorGiroscopio::class.java))
        }
    }
}
