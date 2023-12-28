package com.example.newjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.newjetpack.components.BottomAppBars
import com.example.newjetpack.components.BottomSheetScaffold
import com.example.newjetpack.components.CenterAlignedAppBar
import com.example.newjetpack.components.NavigationBars
import com.example.newjetpack.components.NavigationDrawer
import com.example.newjetpack.components.SimpleBottomSheet
import com.example.newjetpack.ui.theme.NewJetpackTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewJetpackTheme {
                NavigationDrawer(this)
            }
        }
    }
}




