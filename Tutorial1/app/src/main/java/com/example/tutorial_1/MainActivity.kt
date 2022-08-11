package com.example.tutorial_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial_1.ui.theme.Tutorial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tutorial1Theme {
                myApp()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun myApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(24.dp)) {
            val listOfNames = listOf<String>(
                "ROW - 1",
                "ROW - 12",
                "ROW - 123",
                "ROW - 1234",
                "ROW - 12345",
                "ROW - 123456"
            )
            for (i in listOfNames) {
                Greeting(name = i)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded = false
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = {
                    expanded = !expanded
                    /*TODO*/
                }
            ) {
                Text(text = if (expanded) "show less" else "show more")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    Tutorial1Theme {
        Greeting("Android")
    }
}