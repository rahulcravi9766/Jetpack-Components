package com.example.newjetpack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(){

    val items = listOf(
        NavigationItems(
            title = "BottomSheet"
        ),
        NavigationItems(
            title = "AppBars"
        ),
        NavigationItems(
            title = "NavigationBars"
        )
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    var selectedItemTitle by rememberSaveable {
        mutableStateOf("BottomSheet")
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
                "AppBars" -> CenterAlignedAppBar()
                "NavigationBars" -> NavigationBars()
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