# Proyecto Juego de Frases en Android con Kotlin y Corutinas

Este proyecto es una aplicación de Android utilizando **Jetpack Compose** y **Kotlin Coroutines**. La aplicación consiste en un juego en el que el usuario tiene que adivinar si una frase es verdadera o falsa. El jugador recibe un puntaje según la cantidad de respuestas correctas, y el juego tiene un temporizador de 20 segundos. El código utiliza corutinas para manejar la cuenta regresiva del tiempo.

## Descripción

El juego muestra una frase al jugador, y el jugador debe decidir si la frase es verdadera o falsa. Si la respuesta es correcta, se suma un punto a la puntuación. El juego termina cuando el tiempo se agota y muestra el puntaje final del jugador.

### Características principales:
- **Temporizador**: Un temporizador de 20 segundos que cuenta hacia atrás mientras el jugador responde.
- **Frases aleatorias**: Se muestran frases aleatorias al jugador, y debe decidir si la frase es verdadera o falsa.
- **Puntuación**: La puntuación del jugador se actualiza en tiempo real, sumando un punto por cada respuesta correcta.
- **Fin del juego**: Cuando el temporizador llega a cero, el juego se termina y muestra el puntaje final.

## Estructura del Proyecto

- **MainActivity.kt**:
Esta clase contiene la lógica principal del juego, incluyendo la inicialización del temporizador, la puntuación, la generación de frases aleatorias, y la lógica para comprobar si las respuestas del usuario son correctas.

- **Funciones auxiliares**:
- aux(): Inicializa la lista de frases con frases predefinidas. Se invoca al inicio de la actividad para llenar la lista de frases.

- fraseAleatoria(): Devuelve una frase aleatoria de la lista de frases y la asigna como la frase actual.

- comprobadorFrase(acierto: Boolean, respuesta: Boolean): Compara si la respuesta del jugador es correcta y devuelve un valor entero para reflejar si la respuesta fue correcta (1) o incorrecta (0).

## Interfaz de Usuario:
La interfaz se construye utilizando Jetpack Compose. Incluye botones para responder si una frase es "Verdadera" o "Falsa", un temporizador que cuenta hacia atrás y muestra la puntuación actual.

La puntuación se muestra en la parte superior de la pantalla, alineada a la derecha.

## Funcionalidad
- **Inicio del juego**: 
Al presionar el botón "Start", se inicializan la puntuación y el temporizador. Se asigna una nueva frase aleatoria, y el temporizador comienza a contar hacia atrás.

- **Respuestas del jugador**:

El jugador puede hacer clic en los botones "V" (Verdadero) o "F" (Falso) para responder a la frase.

Si la respuesta es correcta, se suma un punto; si es incorrecta, la puntuación se reinicia a cero.

- **Temporizador**:

El temporizador cuenta hacia atrás desde 20 segundos. Cuando llega a cero, el juego termina y muestra el puntaje final.

- **Fin del juego**: Cuando el tiempo se agota, la interfaz muestra el mensaje "Juego Terminado" y el puntaje final.

## Diseño y UI
- **Temporizador**: 
Muestra el tiempo restante en la parte superior de la pantalla.

- **Frase**: 
La frase actual se muestra en el centro de la pantalla.

- **Respuestas**: 
Los botones "V" y "F" permiten al jugador elegir si la frase es verdadera o falsa.

- **Puntuación**: Se muestra al final del juego, alineada a la derecha de la pantalla.
