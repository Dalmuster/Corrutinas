package com.example.corrutinas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * variable global
 */
// para crear los objetos de las frases
data class Frase(var texto: String, var verdadero: Boolean)
// lista para almacenar las frase
var frases: MutableList<Frase> = mutableListOf()
// la frase actual
var fraseActual: MutableState<Frase> = mutableStateOf(Frase("-",true))

/**
 * utilización dentro de un función composable cualquiera
 */
@Composable
fun aux(){
    // introducir frases en la lista
    frases.add(Frase("el torneo de rugby cinco naciones, ahora es seis naciones",true))
    frases.add(Frase("en el cielo hay cinco estrellas",false))
    frases.add(Frase("el dia cinco de diciembre del 2023 es martes",true))
    frases.add(Frase("cinco más cinco son diez",true))
    frases.add(Frase("dos mas dos son cinco",false))
    frases.add(Frase("los elefantes tienen cinco patas",false))
    frases.add(Frase("las estaciones climáticas son cinco",false))
    frases.add(Frase("tenemos cinco dedos los humanos",true))
    frases.add(Frase("cinco días tiene la semana sin el Domingo y el Sábado",true))
    frases.add(Frase("una gallina pesa menos que cinco toneladas",true))

}

fun fraseAleatoria(): Frase {
    fraseActual.value = frases.random()
    return fraseActual.value
}

fun comprobadorFrase(acierto: Boolean, respuesta: Boolean): Int{
    if (acierto==respuesta){
        return 1
    }
    else {
        return 0
    }
}