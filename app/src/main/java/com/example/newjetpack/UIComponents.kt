package com.example.newjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newjetpack.ui.theme.NewJetpackTheme
import kotlinx.coroutines.launch

class UIComponents : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        WaterCounter()
                    }
                }
            }
        }
    }

    @Composable
    fun Counter(count: MutableState<Int>) {
        Text("Count: $count")
        Button(onClick = { count.value++ }) {
            Text("Increment")
        }
    }

    @Composable
    fun WaterCounter(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {

            var count by rememberSaveable {
                mutableStateOf(0)
            }
            if (count <5){
                Text(text = "You've had ${count} glasses.")
            }
            Log.d("count", "is ${count}")

            Button(onClick = {
                count++

            }, modifier = modifier.padding(top = 8.dp),
                enabled = count != 10
            ) {
                Text(text = "Add one")
            }
        }
    }

    @Composable
    fun MyScreen() {
        var textCount by remember { mutableStateOf(0) }

        Text(text = textCount.toString(), fontSize = 50.sp)
        Spacer(modifier = Modifier.height(150.dp))

        Column {
            Button(onClick = {
                textCount += 1
            }) {
                Text("Increase")
            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(onClick = {
                textCount -= 1
            }) {
                Text("Decrease")
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = {}) {
                Text("Text Button")
            }
            Button(onClick = { }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.White
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    "Like",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            var checked by remember { mutableStateOf(false) }
            IconToggleButton(checked = checked, onCheckedChange = {
                checked = it
            }) {
//                val tint by animateColorAsState(
                val tint = if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5)
//                )
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = tint
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen() {
        Scaffold(
            Modifier
                .navigationBarsPadding()
                .imePadding()
                .statusBarsPadding()
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {

            }
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//
//        Greeting("Rahul")
//
//}