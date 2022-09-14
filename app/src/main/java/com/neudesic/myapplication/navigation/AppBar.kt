package com.neudesic.myapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.neudesic.myapplication.R


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick,
                ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        }
    )
}