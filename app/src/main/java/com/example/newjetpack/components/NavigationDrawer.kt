package com.example.newjetpack.components

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newjetpack.data.DrawerMenuItems
import com.example.newjetpack.data.NavigationItems
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationDrawer(context: Context){

    val items = listOf(
        NavigationItems(
            title = "BottomSheet"
        ),
        NavigationItems(
            title = "AppBars"
        ),
        NavigationItems(
            title = "NavigationBars"
        ),
        NavigationItems(
            title = "Cards"
        ),
        NavigationItems(
            title = "Buttons"
        ),
        NavigationItems(
            title = "DatePicker"
        ),
        NavigationItems(
            title = "DialogBoxes"
        )
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    var selectedItemTitle by rememberSaveable {
        mutableStateOf("DialogBoxes")
    }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationHeader()
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemTitle = item.title
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
//                        icon = {
//                            Icon(
//                                imageVector = if (index == selectedItemIndex) {
//                                    item.selectedIcon
//                                } else item.unselectedIcon,
//                                contentDescription = item.title
//                            )
//                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBarOne(scope, drawerState)
            }) {
            it
            when(selectedItemTitle){
                "BottomSheet" -> BottomSheetScaffold()
                "AppBars" -> MediumAppBar()
                "NavigationBars" -> NavigationBars()
                "Cards" -> SimpleCards()
                "Buttons" -> Buttons()
                "DatePicker" -> DatePickers(context)
                "DialogBoxes" -> DialogBox()
            }

        }
    }
}
@Composable
fun NavigationHeader() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "This is Header", fontSize = 24.sp)
    }
}

//custom
@Composable
fun NavigationBody(
    menuItems: List<DrawerMenuItems>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 16.sp),
    onClick: (DrawerMenuItems) -> Unit
) {

    LazyColumn(modifier) {
        items(menuItems) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable {
                        onClick(item)
                    }
            ) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = item.name, style = itemTextStyle, modifier = Modifier.weight(1f))
            }
        }
    }
}