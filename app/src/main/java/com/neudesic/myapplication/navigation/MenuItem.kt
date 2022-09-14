package com.neudesic.myapplication.navigation

import androidx.compose.ui.graphics.vector.ImageVector

//
data class MenuItem(
    val id: String,
    // text that will be shown on each menu item, ex: name of each dev on the team
    val title: String,
    // accessibility property to describe each menu item
    val contentDescription: String,
    // optional if you want an icon next to your menu item
    val icon: ImageVector
)
