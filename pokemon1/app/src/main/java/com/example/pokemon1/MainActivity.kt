package com.example.pokemon1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.pokemon1.ui.theme.Pokemon1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokemon1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Toast.makeText(
                        LocalContext.current,
                        "Gotta catch them all!!",
                        Toast.LENGTH_LONG).show()
                    Pantalla()
                }
            }
        }
    }
}

@Composable
fun Pantalla() {
    val pokemonsCargados = mutableListOf<Int>()
    val pokemon: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    Column(Modifier.fillMaxWidth()) {
        for (i in 0 until 3) {
            Row(Modifier.weight(0.75f)) {
                for (j in 0 until 3) {
                   pokemonsCargados.add(division(modifier = Modifier.weight(1f)))
                }
            }
        }
    }
    if (pokemonsCargados.containsAll(pokemon)){
        Toast.makeText(
            LocalContext.current,
            "You won!!",
            Toast.LENGTH_LONG).show()
    }
}

@Composable
private fun division ( modifier: Modifier = Modifier):Int {
    var pokemonCelda by remember { mutableStateOf((1..9).random()) }
    if (pokemonCelda > 9) {pokemonCelda = 1}
    Column (
        modifier = modifier
            .fillMaxHeight()
            .background(colorResource(pokemonCelda))
            .clickable {pokemonCelda++},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(id = imageResource(pokemonCelda)),
            contentDescription = null
        )
    }
    return pokemonCelda
}
private fun imageResource(valor:Int): Int{
    return when (valor){
        1 -> R.drawable.pikachu
        2 -> R.drawable.charmander
        3 -> R.drawable.bulbasaur
        4 -> R.drawable.squirtle
        5 -> R.drawable.sandshrew
        6 -> R.drawable.exeggutor
        7 -> R.drawable.clefairy
        8 -> R.drawable.magikarp
        else -> R.drawable.snorlax
    }
}
private fun colorResource(valor:Int): Color {
    return when (valor){
        1 -> Color(0xFFFFEB3B)
        2 -> Color(0xFFE92222)
        3 -> Color(0xFF61D347)
        4 -> Color(0xFF21DAF3)
        5 -> Color(0xFFC7AE54)
        6 -> Color(0xFFAD6A2F)
        7 -> Color(0xFFEC8EAE)
        8 -> Color(0xFFEB463B)
        else -> Color(0xFFF0EFAB)
    }
}
