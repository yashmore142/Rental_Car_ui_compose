package com.example.rental_car_ui_compose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItems(
    val title : String,
    val icon : ImageVector,
    val isSelected : Boolean
)

val bottomBarItems = listOf(
    BottomBarItems(
        title = "Home",
        icon = Icons.Rounded.Home,
        isSelected = true
    ),
    BottomBarItems(
        title = "Account",
        icon = Icons.Rounded.AccountBox,
        isSelected = false
    ),
    BottomBarItems(
        title = "Analytics",
        icon = Icons.Rounded.LibraryBooks,
        isSelected = false
    ),
    BottomBarItems(
        title = "Setting",
        icon = Icons.Rounded.Settings,
        isSelected = false
    )
)
