package com.example.gatoenkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton1=findViewById<Button>(R.id.buttonDosJugadores)
        boton1.setOnClickListener {
            val cambioPantalla = Intent(this, DosJugadores::class.java)
            startActivity(cambioPantalla)
        }
        val boton2=findViewById<Button>(R.id.buttonUnJugador)
        boton2.setOnClickListener {
            val cambioPantalla = Intent(this, UnJugador::class.java)
            startActivity(cambioPantalla)
        }

    }
}