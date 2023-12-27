package com.example.newjetpack.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Composable
fun SimpleCards() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
        ) {
            Text(text = "Filled", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.size(24.dp))

        ElevatedCard(
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            )

        ) {
            Text(
                text = "Elevated",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(24.dp))

        OutlinedCard(
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            ),
            border = BorderStroke(1.dp, Color.Black)

        ) {
            Text(
                text = "Outlined",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

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

@Composable
fun FloatingActionButtons() {
    Row {
        FloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        SmallFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        LargeFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }

    Spacer(modifier = Modifier.padding(16.dp))

    Row {
        ExtendedFloatingActionButton(
            text = { Text(text = "Extended") },
            icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add") },
            onClick = { })
    }
}

