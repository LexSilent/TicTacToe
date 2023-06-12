package com.example.gatoenkotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DosJugadores : AppCompatActivity() {
    var turno=true
    lateinit var Btn1 : Button
    lateinit var Btn2 : Button
    lateinit var Btn3 : Button
    lateinit var Btn4 : Button
    lateinit var Btn5 : Button
    lateinit var Btn6 : Button
    lateinit var Btn7 : Button
    lateinit var Btn8 : Button
    lateinit var Btn9 : Button
    lateinit var lblTurno:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_jugadores)
        lblTurno=findViewById(R.id.textView)


        val label=findViewById<TextView>(R.id.labelJugador)
        label.setText("Dos Jugadores")

        Btn1=findViewById(R.id.button1) as Button
        Btn1.setOnClickListener{
            XO(Btn1)
        }
        Btn2=findViewById(R.id.button2) as Button
        Btn2.setOnClickListener{
            XO(Btn2)          }
        Btn3=findViewById(R.id.button3) as Button
        Btn3.setOnClickListener{
            XO(Btn3)
        }
        Btn4=findViewById(R.id.button4) as Button
        Btn4.setOnClickListener{
            XO(Btn4)
        }
        Btn5=findViewById(R.id.button5) as Button
        Btn5.setOnClickListener{
            XO(Btn5)
        }
        Btn6=findViewById(R.id.button6) as Button
        Btn6.setOnClickListener{
            XO(Btn6)
        }
        Btn7=findViewById(R.id.button7) as Button
        Btn7.setOnClickListener{
            XO(Btn7)
        }
        Btn8=findViewById(R.id.button8) as Button
        Btn8.setOnClickListener{
            XO(Btn8)
        }
        Btn9=findViewById(R.id.button9) as Button
        Btn9.setOnClickListener{
            XO(Btn9)
        }

        val botonVolver=findViewById<Button>(R.id.buttonRegresar)
        botonVolver.setOnClickListener {
            val cambioPantalla = Intent(this, MainActivity::class.java)
            startActivity(cambioPantalla)
        }

    }
    fun XO(boton:Button){
            if(turno){

                boton.setTextColor(Color.parseColor("#ea1750"))
                boton.setText("X")
            }else{
                boton.setTextColor(Color.parseColor("#ffd032"))
                boton.setText("O")
            }
            boton.setEnabled(false)
            checarGanador(turno)
            turno=!turno

    }

    fun checarGanador(turno: Boolean){
        var c:String
        if(turno){
            lblTurno.setText("Turno de: O")
            c="X"
        }else{
            lblTurno.setText("Turno de: X")
            c="O"
        }

        if(Btn1.text.equals(c)&& Btn2.text.equals(c)&&Btn3.text.equals(c)){
            reiniciar(c)
        }
        else if(Btn4.getText().equals(c)&&Btn5.getText().equals(c)&&Btn6.getText().equals(c)){
            reiniciar(c)
        }else if(Btn7.getText().equals(c)&&Btn8.getText().equals(c)&&Btn9.getText().equals(c)){
            reiniciar(c)
        }else if(Btn1.getText().equals(c)&&Btn4.getText().equals(c)&&Btn7.getText().equals(c)){
            reiniciar(c)
        }else if(Btn2.getText().equals(c)&&Btn5.getText().equals(c)&&Btn8.getText().equals(c)){
            reiniciar(c)
        }else if(Btn3.getText().equals(c)&&Btn6.getText().equals(c)&&Btn9.getText().equals(c)){
            reiniciar(c)
        }else if(Btn1.getText().equals(c)&&Btn5.getText().equals(c)&&Btn9.getText().equals(c)){
            reiniciar(c)
        }else if(Btn3.getText().equals(c)&&Btn5.getText().equals(c)&&Btn7.getText().equals(c)){
            reiniciar(c)
        }


        if(!Btn1.isEnabled&&!Btn2.isEnabled&&!Btn3.isEnabled&&!Btn4.isEnabled&&!Btn5.isEnabled&&!Btn6.isEnabled&&!Btn7.isEnabled&&!Btn8.isEnabled&&!Btn9.isEnabled){
            reiniciar("empate");
        }

    }

    fun reiniciar(c: String){
        lblTurno.setText("Ganador anterior: ${c}")
        Btn1.setText("")
        Btn2.setText("")
        Btn3.setText("")
        Btn4.setText("")
        Btn5.setText("")
        Btn6.setText("")
        Btn7.setText("")
        Btn8.setText("")
        Btn9.setText("")

        Btn1.setEnabled(true)
        Btn2.setEnabled(true)
        Btn3.setEnabled(true)
        Btn4.setEnabled(true)
        Btn5.setEnabled(true)
        Btn6.setEnabled(true)
        Btn7.setEnabled(true)
        Btn8.setEnabled(true)
        Btn9.setEnabled(true)

    }


}
