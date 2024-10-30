package com.example.hotmeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hotmeals.screens.GetStartedScreen
import com.example.hotmeals.screens.RegisterScreen
import com.example.hotmeals.ui.theme.HotmealsTheme
import com.example.hotmeals.viewmodels.RegisterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HotmealsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    RegisterScreen(registerViewModel = RegisterViewModel())
//    GetStartedScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HotmealsTheme {
        Greeting("Android")
    }
}