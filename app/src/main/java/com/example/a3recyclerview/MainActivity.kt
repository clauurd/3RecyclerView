package com.example.a3recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a3recyclerview.ui.theme._3RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _3RecyclerViewTheme {
                SeccionDeContactos()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeccionDeContactos() {
    val contactos = listOf(
        "Ani", "Angela","Claudio", "Claudia", "Jimmy","Lorena",
        "Luka","Marijose", "Monica", "Nuria","Salves","Zorrorífico"
    ).groupBy { it.first() }


    LazyColumn(modifier = Modifier.fillMaxSize() .padding(top = 30.dp)) {
        contactos.forEach { (inicial, nombres) ->
            stickyHeader {
                Text(
                    text = inicial.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            items(nombres) { nombre ->
                ContactoItem(nombre)
            }
        }
    }
}

@Composable
fun ContactoItem(nombre: String) {
    Text(
        text = nombre,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun SeccionDeContactosPreview() {
    SeccionDeContactos()
}
