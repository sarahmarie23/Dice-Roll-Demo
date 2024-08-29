package com.example.dicerolldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

    // Container to hold our UI elements
    Text(text = "Hello Cal Poly Humboldt!!", fontSize = 24.sp)

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