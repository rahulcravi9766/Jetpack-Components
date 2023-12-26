package com.example.newjetpack.data

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenuItems(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val contentDescription: String
)

data class NavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)