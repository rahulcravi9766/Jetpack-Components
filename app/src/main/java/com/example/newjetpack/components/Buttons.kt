package com.example.newjetpack.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Buttons() {
    var numberCount by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = numberCount.toString(), fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            numberCount++
        }) {
            Text("Normal")
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = { numberCount++ }) {
            Text("OutLined")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(onClick = { numberCount++ }) {
            Text("Text Button")
        }
        Button(onClick = { numberCount++ }) {
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
        IconButton(onClick = { numberCount++ }) {
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
            val tint: Color
            if (checked) {
                numberCount = 0
                tint = Color(0xFFEC407A)
            } else {
                tint = Color(0xFFB0BEC5)
            }
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Localized description",
                tint = tint
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            FloatingActionButtons()
        }
    }
}