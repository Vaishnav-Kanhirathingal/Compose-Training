package com.example.tutorial_1

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial_1.ui.theme.Tutorial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tutorial1Theme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyApp() {
    val shouldShowOnBoarding = rememberSaveable { mutableStateOf(true) }
    if (shouldShowOnBoarding.value) {
        OnBoardingScreen(onContinueClick = { shouldShowOnBoarding.value = false })
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(
    titleList: List<String> = List(30) { (it + 1).toString() }
) {
    LazyColumn {
        items(items = titleList) { name: String ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 64.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
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
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello, ")
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold)
                )
            }
            OutlinedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(text = if (expanded) "show less" else "show more")
            }
        }
    }
}

@Composable
fun OnBoardingScreen(onContinueClick: () -> Unit) {
    // TODO: This state should be hoisted
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Code lab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClick
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    Tutorial1Theme {
        Greeting("56")
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
    heightDp = 320
)
@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun OnBoardingPreview() {
    Tutorial1Theme {
        OnBoardingScreen {}
    }
}