package com.example.corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinas.ui.theme.CorrutinasTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CorrutinasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JuegoFrases(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun JuegoFrases(name: String, modifier: Modifier = Modifier) {
    var tiempo by remember { mutableStateOf(20) }
    val corrutina = rememberCoroutineScope()
    var puntuacion by remember { mutableStateOf(0) }
    var frase = fraseActual.value
    var juegoTerminado by remember { mutableStateOf(false) }
    aux()

    Column {
        Row {
            if (juegoTerminado==false){
            Button(
                onClick = {
                    puntuacion = 0
                    tiempo = 20
                    frase=fraseAleatoria()
                    fraseAleatoria()
                    corrutina.launch {
                        repeat(20) {
                            delay(1000)
                            tiempo -= 1
                        }
                        juegoTerminado=true
                    }
                }
            ) {
                Text("Start")
            }
            Text(
                text = "$tiempo",
                modifier = modifier
                    .border(
                        width = 2.dp,
                        color = Color.Black
                    )
                    .padding(horizontal = 20.dp)
            )
            Text(
                text = frase.texto,
                modifier = modifier
                    .border(
                        width = 2.dp,
                        color = Color.Black
                    )
                    .padding(horizontal = 20.dp)
            )
            Button(
                onClick = {
                    if (comprobadorFrase(frase.verdadero,true)!=0){
                        puntuacion++
                        frase=fraseAleatoria()
                    } else {
                        puntuacion = 0
                        frase=fraseAleatoria()
                    }
                }
            ) {
               Text("V")
            }
            Button(
                onClick = {
                    if (comprobadorFrase(frase.verdadero,false)!=0){
                        puntuacion++
                        frase=fraseAleatoria()
                    } else {
                        puntuacion = 0
                        frase=fraseAleatoria()
                    }
                }
            ) {
                Text("F")
            }
            Text(
                text = "$puntuacion",
                modifier = modifier
                    .border(
                        width = 2.dp,
                        color = Color.Black
                    )
                    .padding(horizontal = 20.dp)
            )
        }   else {
                Text(
                    text = "Juego Terminado"
                )
            }
    }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CorrutinasTheme {
        JuegoFrases("Android")
    }
}