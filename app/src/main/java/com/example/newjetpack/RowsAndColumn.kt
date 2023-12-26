package com.example.newjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RowsAndColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fonts = FontFamily(
            Font(R.font.fuggles_regular, FontWeight.SemiBold),
            Font(R.font.martianmono_condensed_bold, FontWeight.W400)
        )
        setContent {


            TestColumn(Modifier, fonts)
        }
    }


    @Composable
    fun TestColumn(modifier: Modifier, fontss: FontFamily) {
        Column(
            modifier = modifier
                .background(Color.Cyan)
                .width(500.dp)
                .height(500.dp)
                .border(5.dp, Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hai Rahul C Ravi",
                fontFamily = fontss,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W400,
                fontSize = 30.sp,
                modifier = modifier.offset(x = 20.dp, y = 20.dp)
            )
            Spacer(modifier = modifier.height(80.dp))
            Text(
                text = "Hello World",
                fontFamily = fontss,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W400,
                fontSize = 30.sp,
                modifier = modifier.padding(50.dp).border(5.dp, Color.Red).clickable {
                },  textAlign = TextAlign.Center,
            )
            Box(
                modifier = modifier
                    .background(Color.Green)
                    .size(50.dp, 50.dp)
                    .border(2.dp, Color.Yellow)
            )
        }
    }

    @Composable
    fun ColumnUI(modifier: Modifier) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.SpaceBetween,
            // horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Boxes(height = 100, width = 100)
                Boxes(height = 100, width = 100)
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
                Boxes(height = 300, width = 150)
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Boxes(height = 100, width = 80)
                Boxes(height = 100, width = 80)
                Boxes(height = 100, width = 80)
            }

        }

    }

    @Composable
    fun Boxes(height: Int, width: Int) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .height(height.dp)
                .width(width.dp)
        )
    }

//    @Preview(showSystemUi = true)
//    @Composable
//    fun PreviewUI(){
//        ColumnUI(Modifier)
//    }
}

