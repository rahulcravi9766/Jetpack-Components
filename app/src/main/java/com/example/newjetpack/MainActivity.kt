package com.example.newjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.newjetpack.data.CenterAlignedAppBar
import com.example.newjetpack.data.LargeAppBar
import com.example.newjetpack.data.MediumAppBar
import com.example.newjetpack.ui.theme.NewJetpackTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewJetpackTheme {
                CenterAlignedAppBar()
            }
        }
    }
}




