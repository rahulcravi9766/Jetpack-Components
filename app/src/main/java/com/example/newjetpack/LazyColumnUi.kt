package com.example.newjetpack

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


class LazyColumnUi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumnTest()
        }

    }

    @SuppressLint("NotConstructor")
    @Composable
    fun LazyColumnTest() {

        val moduless = listOf(
            "Rows", "Columns and basic sizing",
            "Modifiers",
            "Image Card creation",
            "Styling text",
            "State",
            "Textfield, button, snackbar",
            "Lists",
            "Constraint layout",
            "Side effects and effects handlers",
            "Simple animation",
            "App architecture",
            "StateFlow and UDF pattern",
            "Navigation component with Compose",
            "Navigation drawer in compose",
            "Responsive UI",
            "Coroutines in compose",
            "Load and display images/gif using Coil library",
            "Retrofit to make network calls",
            "Dependency injection",
            "Room Database and Datastore",
            "Add existing View-based UI components in a Compose app",
            "Clean architecture and MVI for Kotlin"
        )

        LazyColumn() {
            items(moduless) { item ->

                Text(text = item, fontSize = 25.sp, modifier = Modifier.background(Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(),)))
                Box(modifier = Modifier.height(5.dp))
            }
        }

//        LazyColumn {

//            modules(modules) { item ->
//                // Composable for each item
//                // Replace with your item layout and data
//            }
//        }
    }

 @Preview(showSystemUi = true)
 @Composable
 fun LazyColumPreview(){
     LazyColumnTest()
 }
}