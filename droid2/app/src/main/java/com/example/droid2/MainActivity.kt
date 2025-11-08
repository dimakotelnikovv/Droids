package com.example.droid2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droid2.ui.theme.Droid2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Droid2Theme {
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
@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun HelloPreviewPortrait() {
    Droid2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Hello(name = "Android Portrait")
                Hello(name = null)
            }
        }
    }
}
@Preview(
    showBackground = true,
    widthDp = 640,
    heightDp = 360
)
@Composable
fun HelloPreviewLandscape() {
    Droid2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                Hello(name = "Android Landscape")
                Hello(name = null)
            }
        }
    }
}
@Preview(
    showBackground = true,
    widthDp = 200,
    heightDp = 200
)
@Composable
fun HelloPreviewRound() {
    Droid2Theme {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Hello(name = "Round")
                Hello(name = null)
            }
        }
    }
}