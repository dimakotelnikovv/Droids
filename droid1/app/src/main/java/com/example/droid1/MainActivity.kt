package com.example.droid1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.droid1.ui.theme.Droid1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Droid1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Hello(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Hello(
                            name = null,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Hello(
    name: String?,
    modifier: Modifier = Modifier
) {
    Text(name ?: "Имя не задано" )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Droid1Theme {
        Column {
            Hello(
                name = "Android",
            )
            Hello(
                name = null,
            )
        }
    }
}