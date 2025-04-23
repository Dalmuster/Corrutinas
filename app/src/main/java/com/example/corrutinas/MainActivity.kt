package com.example.corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.corrutinas.ui.theme.CorrutinasTheme
import kotlinx.coroutines.delay
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
    Column {
        Row {
            Button(
                onClick = {
                    repeat {  }
                    runBlocking {
                        delay(1000)
                        tiempo -= 1
                    }
                },
            ) {
                Text(
                    text = "Start"
                )
            }
            Text(
                text = tiempo.toString()
            )
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