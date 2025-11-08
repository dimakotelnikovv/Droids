package com.example.droid9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droid9.ui.theme.Droid9Theme
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Droid9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShoppingCartScreen(
                        //name = "Android",
                        //modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)
@Composable
fun ShoppingCartScreen() {
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }
    val productSize = products.size

    val context = LocalContext.current

    Column {
        products.forEach { product ->
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection(
            totalSum = totalSum,
            onAdd = {
                val newProduct = Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(1, 100)
                )
                products = products + newProduct

                if (totalSum + newProduct.price > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        )

        RemoveProductSection(
            productSize = productSize,
            onRemove = {
                products = products.dropLast(1)
            }
        )
    }
}

@Composable
fun AddProductSection(
    totalSum: Int,
    onAdd: () -> Unit
) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    productSize: Int,
    onRemove: () -> Unit
) {
    if (productSize > 0) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Droid9Theme {
        ShoppingCartScreen()
    }
}