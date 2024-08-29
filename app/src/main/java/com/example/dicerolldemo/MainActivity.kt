package com.example.dicerolldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dicerolldemo.ui.theme.DiceRollDemoTheme
// Don't change anything here
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollDemoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DiceScreen()
                }
            }
        }
    }
}
// This is where the app elements will go
@Composable
fun DiceScreen(modifier: Modifier = Modifier) {
    // Initialize variables here
    var roll by remember { mutableIntStateOf(1) }
    val diceImage = when (roll) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        6 -> R.drawable.dice6
        else -> R.drawable.dice1
    }

    // Container to hold our UI elements
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = diceImage),
            contentDescription = "dice image"
        )

        Button(onClick = { roll = (1..6).random() }) {
            Text(text = "Roll the dice!")
        }

        Text(text = "You rolled a $roll", fontSize = 24.sp)
    }
}

// This is used to preview the app in Android Studio
// Note: you are able to have multiple previews at the same time
@Preview(showBackground = true)
@Composable
fun DiceScreenPreview() {
    DiceRollDemoTheme {
        DiceScreen()
    }
}