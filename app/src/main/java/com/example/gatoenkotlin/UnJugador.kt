package com.example.gatoenkotlin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UnJugador : AppCompatActivity() {

    var minimax = Minimax()
    lateinit var Btn1 : Button
    lateinit var Btn2 : Button
    lateinit var Btn3 : Button
    lateinit var Btn4 : Button
    lateinit var Btn5 : Button
    lateinit var Btn6 : Button
    lateinit var Btn7 : Button
    lateinit var Btn8 : Button
    lateinit var Btn9 : Button
    lateinit var lblTurno: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_jugadores)
        lblTurno=findViewById(R.id.textView)

        val label=findViewById<TextView>(R.id.labelJugador)
        label.setText("Un Jugador")

        Btn1=findViewById(R.id.button1) as Button
        Btn1.setOnClickListener{
            XO(Btn1,0)
        }
        Btn2=findViewById(R.id.button2) as Button
        Btn2.setOnClickListener{
            XO(Btn2,1)          }
        Btn3=findViewById(R.id.button3) as Button
        Btn3.setOnClickListener{
            XO(Btn3,2)
        }
        Btn4=findViewById(R.id.button4) as Button
        Btn4.setOnClickListener{
            XO(Btn4,3)
        }
        Btn5=findViewById(R.id.button5) as Button
        Btn5.setOnClickListener{
            XO(Btn5,4)
        }
        Btn6=findViewById(R.id.button6) as Button
        Btn6.setOnClickListener{
            XO(Btn6,5)
        }
        Btn7=findViewById(R.id.button7) as Button
        Btn7.setOnClickListener{
            XO(Btn7,6)
        }
        Btn8=findViewById(R.id.button8) as Button
        Btn8.setOnClickListener{
            XO(Btn8,7)
        }
        Btn9=findViewById(R.id.button9) as Button
        Btn9.setOnClickListener{
            XO(Btn9,8)
        }

        val botonVolver=findViewById<Button>(R.id.buttonRegresar)
        botonVolver.setOnClickListener {
            val cambioPantalla = Intent(this, MainActivity::class.java)
            startActivity(cambioPantalla)
        }

    }
    fun XO(boton: Button,coord : Int){
        boton.setTextColor(Color.parseColor("#ea1750"))
        boton.setText("X");
        boton.setEnabled(false);
        minimax.pulsaBoton(coord);
        ganar();

    }

    fun ganar(){
        val pos= minimax.getUltimoBoton()
        var boton:Button
        boton=Btn1
        if(pos==0){

        }else if(pos==1){
            boton=Btn2
        }else if(pos==2){
            boton=Btn3
        }else if(pos==3){
            boton=Btn4
        }else if(pos==4){
            boton=Btn5
        }else if(pos==5){
            boton=Btn6
        }else if(pos==6){
            boton=Btn7
        }else if(pos==7){
            boton=Btn8
        }else {
            boton=Btn9
        }
        boton.setText("0")
        boton.setEnabled(false)
        checarGanador(boton.text as String)
        boton.setTextColor(Color.parseColor("#ffd032"))

    }

    fun checarGanador(c: String){

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
        minimax.reiniciar()
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