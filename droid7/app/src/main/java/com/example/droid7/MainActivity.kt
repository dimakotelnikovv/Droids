package com.example.droid7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droid7.ui.theme.Droid7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Droid7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColumnPart(
                       // name = "Android",
                        //modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextPart() {
    Text(
        text = "Имя: Евгений \n Отчество: Адреевич \n Фамилия: Лукашин \n Мобильный телефон: +79998882211\n Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
        modifier = Modifier
            .width(250.dp),
        textAlign = TextAlign.Center,
        color = Color.White
    )
}
@Composable
fun ImagePart() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "justAnImage"
    )
}

@Composable
fun BoxPart() {
    Box(
        modifier = Modifier
            .background(color = Color.Gray)
            .height(150.dp)
            .width(300.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            TextPart()
            ImagePart()
        }
    }
}


@Composable
fun ColumnPart() {
        Column (
            modifier = Modifier,
           // horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            BoxPart()
            BoxPart()
            BoxPart()
        }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    widthDp = 390,
    heightDp = 700
)
@Composable
fun previewThing() {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ColumnPart()
    }
}

//column
//  box
//      row
//          text, image
//  box