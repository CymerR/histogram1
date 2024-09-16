package ru.cmr.histogram1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.cmr.histogram1.ui.theme.HistogramTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            HistogramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                            .border(1.dp, MaterialTheme.colorScheme.primary),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyContent()
                    }
                }
            }
        }
    }
}

@Composable
fun MyContent() {
    var show by remember { mutableStateOf(false) }

    var inputText by remember { mutableStateOf("") }

    var list by remember { mutableStateOf(emptyList<Double>()) }

    Column(
        modifier = Modifier.widthIn(250.dp, 350.dp).padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            label = { Text(text = "Выборка") }
        )

        Button(onClick = {
            list = splitInput(inputText)
            show = true
        }) {
            Text(text = "Посчитать")
        }
        HorizontalDivider()

        if (show) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
            ) {
                for (row in createStatistics(list).calculate()) {
                    Text(text = row, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

}


fun splitInput(inputText: String): List<Double> {
    return inputText.split(" ")
        .map { it.toDouble() }
}

