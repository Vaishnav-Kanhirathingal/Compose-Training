package com.example.tutorial_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 64.dp else 32.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                Text(text = if (expanded.value) "show less" else "show more")
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

@Composable
fun OnboardingScreen() {
    // TODO: This state should be hoisted
    val shouldShowOnBoarding = remember {
        mutableStateOf(true)
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { shouldShowOnBoarding.value = false }
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Tutorial1Theme {
        OnboardingScreen()
    }
}